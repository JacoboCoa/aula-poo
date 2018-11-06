package com.magnani.aula.a03_listas;

import android.content.Context;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class AvaliacaoDao {

    private static ArrayList<Avaliacao> AL_CACHE = new ArrayList<>();

    private static final String NOME_ARQUIVO = "avaliacoes.txt";

    public static boolean salvar(Context c, Avaliacao aSerSalva){
        AL_CACHE.add(aSerSalva);

        String avEmString = "";
        avEmString += aSerSalva.getConteudo() + ";";
        avEmString += aSerSalva.getData() + ";";
        avEmString += aSerSalva.getMedia() + ";";
        avEmString += aSerSalva.getDisciplina() + "\n";

        File refArquivo = new File( c.getFilesDir().getPath() + NOME_ARQUIVO );
        try {
            FileWriter escritor = new FileWriter(refArquivo, true);
            escritor.write( avEmString );
            escritor.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static ArrayList<Avaliacao> getLista(Context c){
        AL_CACHE = new ArrayList<>();

        File refArquivo = new File( c.getFilesDir().getPath() + NOME_ARQUIVO );

        try {
            FileReader leitor = new FileReader(refArquivo);
            BufferedReader leitorDeLinha = new BufferedReader(leitor);

            String linhaAvaliacao = null;

            while((linhaAvaliacao = leitorDeLinha.readLine()) != null){

                String[] partesDaLinha = linhaAvaliacao.split(";");
                Avaliacao daVez = new Avaliacao();
                daVez.setConteudo( partesDaLinha[0] );
                daVez.setData( partesDaLinha[1] );
                daVez.setMedia( partesDaLinha[2] );
                daVez.setDisciplina( partesDaLinha[3] );
                AL_CACHE.add(daVez);
            }


        } catch (IOException e) {
            e.printStackTrace();

        }


        return AL_CACHE;
    }


}

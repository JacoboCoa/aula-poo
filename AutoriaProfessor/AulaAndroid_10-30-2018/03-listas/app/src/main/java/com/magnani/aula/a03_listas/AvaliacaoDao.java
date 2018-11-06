package com.magnani.aula.a03_listas;

import android.content.Context;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class AvaliacaoDao {

    private static ArrayList<Avaliacao> AL_CACHE = new ArrayList<>();

    private static final String NOME_ARQUIVO = "avaliacoes3.txt";

    private static boolean salvarNovo(Context c, Avaliacao aSerSalva){
        aSerSalva.setId( AL_CACHE.size() );
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



    private static boolean salvarEdicao(Context c, Avaliacao aSerSalva){
        AL_CACHE.set(aSerSalva.getId(), aSerSalva);

        File refArquivo = new File( c.getFilesDir().getPath() + NOME_ARQUIVO );

        try {
            FileReader leitor = new FileReader(refArquivo);
            BufferedReader leitorDeLinha = new BufferedReader(leitor);

            String linhaAvaliacao = null;

            String conteudoNovo = "";
            int numeroLinha = 0;
            while((linhaAvaliacao = leitorDeLinha.readLine()) != null) {
                if( aSerSalva.getId() == numeroLinha  ){
                    //essa linha tem que ser atualizada
                    String avEmString = "";
                    avEmString += aSerSalva.getConteudo() + ";";
                    avEmString += aSerSalva.getData() + ";";
                    avEmString += aSerSalva.getMedia() + ";";
                    avEmString += aSerSalva.getDisciplina() + "\n";
                    conteudoNovo += avEmString;
                }else{
                    //essa nao precisa fazer nada
                    conteudoNovo += linhaAvaliacao + "\n";
                }
                numeroLinha++;
            }
            leitor.close();

            FileWriter escritor = new FileWriter(refArquivo, false);
            escritor.write( conteudoNovo );
            escritor.close();

        }catch(IOException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }



    public static boolean salvar(Context c, Avaliacao aSerSalva){
        if(aSerSalva.getId() == -1){
            //eh uma avaliação nova.... então salvaNovo
            Toast.makeText(c, "SALVANDO!!!!", Toast.LENGTH_SHORT).show();
            return salvarNovo(c, aSerSalva);
        }else{
            //eh uma avaliacação velha, então edita...
            Toast.makeText(c, "EDITANDO!!!!", Toast.LENGTH_SHORT).show();
            return salvarEdicao(c, aSerSalva);
        }
    }

    public static boolean excluir(Context c, Avaliacao aSerExcluida){
        File refArquivo = new File( c.getFilesDir().getPath() + NOME_ARQUIVO );

        try {
            FileReader leitor = new FileReader(refArquivo);
            BufferedReader leitorDeLinha = new BufferedReader(leitor);

            String linhaAvaliacao = null;

            String conteudoNovo = "";
            int numeroLinha = 0;
            while((linhaAvaliacao = leitorDeLinha.readLine()) != null) {
                if( aSerExcluida.getId() != numeroLinha  ){
                    conteudoNovo += linhaAvaliacao + "\n";
                }
                numeroLinha++;
            }
            leitor.close();

            FileWriter escritor = new FileWriter(refArquivo, false);
            escritor.write( conteudoNovo );
            escritor.close();

            getLista(c);

        }catch(IOException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static ArrayList<Avaliacao> getLista(Context c){
        AL_CACHE = new ArrayList<>();

        File refArquivo = new File( c.getFilesDir().getPath() + NOME_ARQUIVO );

        try {
            FileReader leitor = new FileReader(refArquivo);
            BufferedReader leitorDeLinha = new BufferedReader(leitor);

            String linhaAvaliacao = null;

            int numeroLinha = 0;
            while((linhaAvaliacao = leitorDeLinha.readLine()) != null){

                String[] partesDaLinha = linhaAvaliacao.split(";");
                Avaliacao daVez = new Avaliacao();
                daVez.setId( numeroLinha );
                daVez.setConteudo( partesDaLinha[0] );
                daVez.setData( partesDaLinha[1] );
                daVez.setMedia( partesDaLinha[2] );
                daVez.setDisciplina( partesDaLinha[3] );
                AL_CACHE.add(daVez);
                numeroLinha++;
            }


        } catch (IOException e) {
            e.printStackTrace();

        }
        return AL_CACHE;
    }


}

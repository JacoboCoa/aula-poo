package jacobo.coa.a05_controle_abastecimento;

import android.content.Context;
import android.widget.Spinner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class AbastecimentoDAO {

    private static ArrayList<Abastecimento> AL_CACHE = new ArrayList<>();

    private static final String NOME_ARQUIVO = "abastecimentos1.txt";

    public static boolean salvar(Context c, Abastecimento aSerSalvo) {
        AL_CACHE.add(aSerSalvo);

        String abastEmString = "";
        abastEmString += aSerSalvo.getKmAtual() + ";";
        abastEmString += aSerSalvo.getLitrosAbastecidos() + ";";
        abastEmString += aSerSalvo.getDataAbastecimento() + ";";
        abastEmString += aSerSalvo.getPosto() + "\n";

        File refArquivo = new File(c.getFilesDir().getPath() + NOME_ARQUIVO);
        try {
            FileWriter escritor = new FileWriter(refArquivo, true);
            escritor.write(abastEmString);
            escritor.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static ArrayList<Abastecimento> getLista(Context c) {
        AL_CACHE = new ArrayList<>();

        File refArquivo = new File(c.getFilesDir().getPath() + NOME_ARQUIVO);

        try {
            FileReader leitor = new FileReader(refArquivo);
            BufferedReader leitorDeLinha = new BufferedReader(leitor);

            String linhaAbastecimento = null;

            while ((linhaAbastecimento = leitorDeLinha.readLine()) != null) {

                String[] partesDaLinha = linhaAbastecimento.split(";");
                Abastecimento daVez = new Abastecimento();
                daVez.setKmAtual(partesDaLinha[0]);
                daVez.setLitrosAbastecidos(partesDaLinha[1]);
                daVez.setDataAbastecimento(partesDaLinha[2]);
                daVez.setPosto(partesDaLinha[3]);

                AL_CACHE.add(daVez);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        return AL_CACHE;

    }
}
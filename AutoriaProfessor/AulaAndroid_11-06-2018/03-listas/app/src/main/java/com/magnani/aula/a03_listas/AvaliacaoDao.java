package com.magnani.aula.a03_listas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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

    private static boolean salvarNovo(Context c, Avaliacao aSerSalva){
        DbHelper meuBd = new DbHelper(c);
        SQLiteDatabase db = meuBd.getWritableDatabase();

        //forma 1 (sql hard coded - não segura)
//        String SQLGravarAvaliacao = "INSERT INTO avaliacao " +
//                "(media, conteudo, disciplina, data) " +
//                "VALUES " +
//                "(" +
//                    "'"+aSerSalva.getMedia()+"'," +
//                    "'"+aSerSalva.getConteudo()+"'," +
//                    "'"+aSerSalva.getDisciplina()+"'," +
//                    "'"+aSerSalva.getData()+"'" +
//                " )";
//        db.execSQL(SQLGravarAvaliacao);

        //forma 2 (SQL quase hard coded)
//        String SQLGravarAvaliacao = "INSERT INTO avaliacao " +
//                "(media, conteudo, disciplina, data) " +
//                "VALUES " +
//                "(?,?,?,?)";
//        String[] valores = {aSerSalva.getMedia(), aSerSalva.getConteudo(), aSerSalva.getDisciplina(), aSerSalva.getData()};
//        db.execSQL(SQLGravarAvaliacao, valores );

        ContentValues chaveValor = new ContentValues();
        chaveValor.put("media", aSerSalva.getMedia());
        chaveValor.put("conteudo", aSerSalva.getConteudo());
        chaveValor.put("data", aSerSalva.getData());
        chaveValor.put("disciplina", aSerSalva.getDisciplina());
        long id = db.insert("avaliacao", null, chaveValor);
        aSerSalva.setId( id );

        AL_CACHE.add(aSerSalva);
        return true;
    }



    private static boolean salvarEdicao(Context c, Avaliacao aSerSalva){
        DbHelper meuBd = new DbHelper(c);
        SQLiteDatabase db = meuBd.getWritableDatabase();
        ContentValues chaveValor = new ContentValues();
        chaveValor.put("media", aSerSalva.getMedia());
        chaveValor.put("conteudo", aSerSalva.getConteudo());
        chaveValor.put("data", aSerSalva.getData());
        chaveValor.put("disciplina", aSerSalva.getDisciplina());
        String[] whereId = { String.valueOf( aSerSalva.getId() ) };
        db.update("avaliacao", chaveValor, "id = ?", whereId);
        db.close();
        getLista(c);
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
        DbHelper meuBd = new DbHelper(c);
        SQLiteDatabase db = meuBd.getWritableDatabase();
        String[] whereId = { String.valueOf(aSerExcluida.getId()) };
        db.delete("avaliacao", "id = ?", whereId);
        getLista(c);
        return true;
    }

    public static ArrayList<Avaliacao> getLista(Context c){
        AL_CACHE = new ArrayList<>();

        DbHelper meuBd = new DbHelper(c);
        SQLiteDatabase db = meuBd.getReadableDatabase();

        String SQLBuscarAvaliacoes = "SELECT media, conteudo, disciplina, data, id FROM avaliacao";
        Cursor ponteiro = db.rawQuery(SQLBuscarAvaliacoes, null);

        while(ponteiro.moveToNext()){
            Avaliacao daVez = new Avaliacao();
            daVez.setMedia( ponteiro.getString(0) );
            daVez.setConteudo( ponteiro.getString(1) );
            daVez.setDisciplina( ponteiro.getString(2) );
            daVez.setData( ponteiro.getString(3) );
            daVez.setId( ponteiro.getLong(4) );
            AL_CACHE.add(daVez);
        }

        return AL_CACHE;
    }


}

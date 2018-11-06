package com.magnani.aula.a03_listas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    private static final int VERSAO_BD = 1;

    public DbHelper(Context context) {
        super(context, "meu_banco", null, DbHelper.VERSAO_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String SQLCriacaoTabelas = "CREATE TABLE avaliacao (" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "MEDIA TEXT," +
                "CONTEUDO TEXT," +
                "DISCIPLINA TEXT," +
                "DATA TEXT" +
            ");";
        sqLiteDatabase.execSQL(SQLCriacaoTabelas);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE avaliacao");
        this.onCreate(sqLiteDatabase);
    }

}

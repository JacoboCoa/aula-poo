package com.magnani.aula.a03_listas;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class AvaliacaoViewHolder extends RecyclerView.ViewHolder {

    //esta classe representa cada gaveta que será apresentada na lista

    private TextView tvData;
    private TextView tvConteudo;
    private TextView tvMedia;
    private TextView tvDisciplina;

    private Avaliacao objetoSendoExibido;

    public AvaliacaoViewHolder(View itemView) {
        super(itemView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent abrirAtividade = new Intent( view.getContext(), AdicionarAvaliacaoActivity.class );
                abrirAtividade.putExtra("avaliacao", AvaliacaoViewHolder.this.objetoSendoExibido);
                ((MainActivity) view.getContext()).startActivityForResult(abrirAtividade, MainActivity.RC_ADICIONAR_AVALIACAO);
            }
        });

        itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(final View view) {
                new AlertDialog.Builder(view.getContext())
                        .setTitle("VOCÊ QUER EXCLUIR???")
                        .setMessage("Essa ação não poderá ser desfeita e você está de acordo com isso...")
                        .setPositiveButton("Eu quero", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(view.getContext(), "SIMMMMM", Toast.LENGTH_SHORT).show();
                                AvaliacaoDao.excluir(view.getContext(), objetoSendoExibido);
                                ((MainActivity) view.getContext()).atualizaDatasetLista();
                            }
                        })
                        .setNegativeButton("NÃO, JAMAIS", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(view.getContext(), "NÃOOOO", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();


                Toast.makeText(view.getContext(), "CLICOU LONGAMENTE", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        this.tvData = itemView.findViewById(R.id.tvData);
        this.tvConteudo = itemView.findViewById(R.id.tvConteudo);
        this.tvMedia = itemView.findViewById(R.id.tvMedia);
        this.tvDisciplina = itemView.findViewById(R.id.tvDisciplina);
    }

    public void atualizaGaveta(Avaliacao objetoAvaliacao){
        this.objetoSendoExibido = objetoAvaliacao;

        this.tvData.setText( objetoAvaliacao.getData() );
        this.tvConteudo.setText( objetoAvaliacao.getConteudo() );
        this.tvDisciplina.setText( objetoAvaliacao.getDisciplina() );
        this.tvMedia.setText( objetoAvaliacao.getMedia() );

        if(objetoAvaliacao.getMedia().equals("M1")){
            this.tvMedia.setTextColor(Color.BLUE);
        }else{
            this.tvMedia.setTextColor(Color.GRAY);
        }
    }

}

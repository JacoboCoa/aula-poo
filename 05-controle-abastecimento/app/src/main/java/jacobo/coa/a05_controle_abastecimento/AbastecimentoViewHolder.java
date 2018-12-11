package jacobo.coa.a05_controle_abastecimento;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class AbastecimentoViewHolder extends RecyclerView.ViewHolder {

    //Esta classe representa cada gaveta que será apresentada na lista

    private TextView tvKmAtual ;
    private TextView tvLitrosAbastecidos;
    private TextView tvData;
    private ImageView ivposto;

//    private String[] gasStationName;
//    private Integer[] imgid;
//    private Activity context;

    public AbastecimentoViewHolder(View itemView){
        super(itemView);
        this.tvKmAtual = itemView.findViewById(R.id.tvKmItem);
        this.tvLitrosAbastecidos = itemView.findViewById(R.id.tvLitrosItem);
        this.tvData = itemView.findViewById(R.id.tvDataItem);
        this.ivposto = itemView.findViewById(R.id.imageGasStationItem);     //is it Work?
    }

    public void atualizaGaveta(Abastecimento objetoAbastecimento){

        this.tvKmAtual.setText(objetoAbastecimento.getKmAtual() + " Km");
        this.tvLitrosAbastecidos.setText(objetoAbastecimento.getLitrosAbastecidos() + " L");
        this.tvData.setText(objetoAbastecimento.getDataAbastecimento());
        this.ivposto.setImageResource(R.drawable.ic_gas_station);

        if (objetoAbastecimento.getPosto().equals("Ipiranga")) {
            this.ivposto.setImageResource(R.drawable.ipiranga_logo);
        } else if (objetoAbastecimento.getPosto().equals("Petrobras")){
            this.ivposto.setImageResource(R.drawable.petrobras_logo);
        } else if (objetoAbastecimento.getPosto().equals("Shell")){
            this.ivposto.setImageResource(R.drawable.shell_logo);
        } else if (objetoAbastecimento.getPosto().equals("Texaco")) {
            this.ivposto.setImageResource(R.drawable.texaco_logo);
        }

        //Aqui?
//        } else {
//            this.ivposto.setImageResource(R.drawable.ic_gas_station);
//        }
    }
}

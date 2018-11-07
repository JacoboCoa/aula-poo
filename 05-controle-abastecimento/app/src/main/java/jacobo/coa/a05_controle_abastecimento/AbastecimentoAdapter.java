package jacobo.coa.a05_controle_abastecimento;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class AbastecimentoAdapter extends RecyclerView.Adapter{
    public ArrayList<Abastecimento> listaAbastecimentos;

//    private String[] gasStationName;
//    private Integer[] imgid;
//    private Activity context;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
    //public RecyclerView.ViewHolder onCreateViewHolder(Activity context, String[] gasStationName, Integer imgid){
        View elementoPaiDoXML =
                LayoutInflater.from(
                        parent.getContext()
                ).inflate(
                        R.layout.abastecimento_item_lista,
                        parent,
                        false
                );
        AbastecimentoViewHolder minhaGaveta = new AbastecimentoViewHolder(elementoPaiDoXML);
        return minhaGaveta;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        //Vestir Gaveta
        AbastecimentoViewHolder minhaGaveta = (AbastecimentoViewHolder) viewHolder;
        Abastecimento daVez = listaAbastecimentos.get(i);
        minhaGaveta.atualizaGaveta(daVez);
    }

    @Override
    public int getItemCount() {
        //Retorna o total de itens na lista
        return listaAbastecimentos.size();
    }
}

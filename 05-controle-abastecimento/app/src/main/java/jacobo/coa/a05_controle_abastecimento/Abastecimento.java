package jacobo.coa.a05_controle_abastecimento;

import android.widget.ImageView;
import android.widget.Spinner;

public class Abastecimento {
    //private ImageView posto;
    private String kmAtual;
    private String litrosAbastecidos;
    private String dataAbastecimento;
    private String posto;
    private int contKm;
    private int contLitros;

    private Spinner spinner;

    private String[] gasStationNome = {"Ipiranga","Petrobras","Shell","Texaco","Outro"};
    private Integer[] imgid = {R.drawable.ipiranga_logo,R.drawable.petrobras_logo,
            R.drawable.shell_logo,R.drawable.texaco_logo,R.drawable.ic_gas_station};

    public String getKmAtual() {
        return kmAtual;
    }

    public void setKmAtual(String kmAtual) {
        this.kmAtual = kmAtual;
    }

    public String getLitrosAbastecidos() {
        return litrosAbastecidos;
    }

    public void setLitrosAbastecidos(String litrosAbastecidos) {
        this.litrosAbastecidos = litrosAbastecidos;
    }

    public String getDataAbastecimento() {
        return dataAbastecimento;
    }

    public void setDataAbastecimento(String dataAbastecimento) {
        this.dataAbastecimento = dataAbastecimento;
    }

    public String getPosto() {
        return posto;
    }

    public void setPosto(String posto) {
        this.posto = posto;
    }

    public String[] getGasStationNome() {
        return gasStationNome;
    }

    public void setGasStationNome(String[] gasStationNome) {
        this.gasStationNome = gasStationNome;
    }

    public Integer[] getImgid() {
        return imgid;
    }

    public void setImgid(Integer[] imgid) {
        this.imgid = imgid;
    }

    public Spinner getSpinner() {
        return spinner;
    }

    public void setSpinner(Spinner spinner) {
        this.spinner = spinner;
    }

    public int getContKm() {
        return contKm;
    }

    public void setContKm(int contKm) {
        this.contKm = contKm;
    }

    public int getContLitros() {
        return contLitros;
    }

    public void setContLitros(int contLitros) {
        this.contLitros = contLitros;
    }
}

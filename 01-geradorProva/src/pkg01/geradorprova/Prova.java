/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg01.geradorprova;

/**
 *
 * @author 4813650
 */
public class Prova {

    //Atributos
    private String nome;
    private int peso;
    private String local;
    private String data;

    //Métodos
    public Prova(String nomeDaProva) {        //ñ tem string, ñ tem retorno
        this.nome = nomeDaProva;
        this.peso = 10;
    }

    public String obtemDetalhes() {
        String retorno = "";
        //retorno = retorno + "Nome: " + this.nome + "\n";
        //retorno = retorno + "Peso: " + this.peso + "\n";
        //retorno = retorno + "Local: " + this.local + "\n";
        //retorno = retorno + "Data: " + this.data + "\n";

        //String aceita operador "+=
        retorno += "Nome: " + this.getNome() + "\n";
        retorno += "Peso: " + this.getPeso() + "\n";
        retorno += "Local: " + this.getLocal() + "\n";
        retorno += "Data: " + this.getData() + "\n";
        return retorno;
    }
    
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the peso
     */
    public int getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(int peso) {
        this.peso = peso;
    }

    /**
     * @return the local
     */
    public String getLocal() {
        return local;
    }

    /**
     * @param local the local to set
     */
    public void setLocal(String local) {
        this.local = local;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

}

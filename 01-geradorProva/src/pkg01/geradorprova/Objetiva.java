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
final class Objetiva extends Questao{
        private String[] opcoes; //no construtor
        private int respostaCorreta;
        
        public Objetiva(){
            this.opcoes = new String[5];
        }
        //final Objetiva (String[5]);

    /**
     * @return the opcoes
     */
    public String[] getOpcoes() {
        return opcoes;
    }

    /**
     * @param opcoes the opcoes to set
     */
    public void setOpcoes(String[] opcoes) {
        this.opcoes = opcoes;
    }

    /**
     * @return the repostaCorreta
     */
    public int getRespostaCorreta() {
        return respostaCorreta;
    }

    /**
     * @param repostaCorreta the repostaCorreta to set
     */
    public void setRespostaCorreta(int repostaCorreta) {
        this.respostaCorreta = repostaCorreta;
    }
    
    /*public void Imprimir_opcoes(){
        //System.out.println("\nOpcao " + (opcao+1) + ": " + getOpcoes());
        for (int i=0;i<5;i++){
            System.out.println("\nOpcao " + (i+1) + ": " + this.opcoes[i]);
        }
    }*/
    /*    @Override
    public String imprimir_questao(){
        String retorno = "";
        for (int i=0;i<this.getOpcoes().length;i++){    //Tamanho real do Vetor
            //System.out.println("\nOpcao " + (i+1) + ": " + this.opcoes[i]);
            retorno += "\nOpcao " + (i+1) + ": " + this.opcoes[i];
        }
        return retorno;
    }*/
}
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
final class Discursiva extends Questao {
        private String criteriosCorrecao;

    /**
     * @return the criteriosCorrecao
     */
    public String getCriteriosCorrecao() {
        return criteriosCorrecao;
    }

    /**
     * @param criteriosCorrecao the criteriosCorrecao to set
     */
    public void setCriteriosCorrecao(String criteriosCorrecao) {
        this.criteriosCorrecao = criteriosCorrecao;
    }
    /*public void Imprimir_resposta(){
        System.out.println("\nResposta: \n\n\n");
    }*/
        @Override
    public String imprimir_questao(){
        //System.out.println("\nResposta: \n\n\n");
        String retorno = "";
        retorno += "\nResposta: \n\n\n";
        return retorno;
    }
}
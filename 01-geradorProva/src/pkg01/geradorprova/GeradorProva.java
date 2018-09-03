/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg01.geradorprova;

import java.util.Scanner;

/**
 *
 * @author Suzana
 */
public class GeradorProva {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Leituda de Dados
        String nome_da_disciplina = "";
        Scanner sc = new Scanner(System.in);
        System.out.println("Qual a Disciplina da Prova?");
        nome_da_disciplina = sc.nextLine();
        
        String local_da_prova = "";
        System.out.println("\nQual o Local da Prova?");
        local_da_prova = sc.nextLine();
        
        String data_da_prova = "";
        System.out.println("\nQual a Data da Prova?");
        data_da_prova = sc.nextLine();
        
        int peso_da_prova;
        System.out.println("\nQual o Peso da Prova?");
        peso_da_prova = sc.nextLine();
        //CONTINUAR AQUI E TESTAR EM CIMA, E NA CLASSE PROVA.JAVA O PESO.
        
        Prova x = new Prova(nome_da_disciplina);
        //x.nome = "POO";
        //x.setLocal("Lab 3 - Bloco B6");
        x.setLocal(local_da_prova);
        //x.setData ("2018-08-28");
        x.setData(data_da_prova);
        //x.peso = 4;
        //x.setPeso(peso_da_prova);
        //x.obtemDetalhes();    //Aqui ñ se faz nada com a string...
        
        //Forma Didática
        //String retornoDoMetodo = x.obtemDetalhes();
        //System.out.println(retornoDoMetodo);
        
        //Forma Resumida
        System.out.println(x.obtemDetalhes());
        
        
        
        Discursiva d = new Discursiva();
        d.setPergunta("Qual seu nome?");
        d.setPeso(0);
        d.setCriteriosCorrecao("Saber o próprio nome");
        
        Objetiva o = new Objetiva();
        o.setPergunta("Qual o melhor time do Brasil?");
        o.setPeso(2);
        String[] opcoes = new String[5];
        opcoes[0] = "Gremio";
        opcoes[1] = "Inter";
        opcoes[2] = "Flamengo";
        opcoes[3] = "Corinthians";
        opcoes[4] = "Sao Paulo";
        o.setOpcoes(opcoes);
        o.setRespostaCorreta(3);
    }
}

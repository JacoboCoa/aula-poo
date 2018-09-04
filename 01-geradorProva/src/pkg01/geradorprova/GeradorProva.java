/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg01.geradorprova;

import java.util.Scanner;
import javax.swing.JOptionPane;

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
        Scanner ler = new Scanner(System.in);
        System.out.println("Qual a Disciplina da Prova?");
        nome_da_disciplina = ler.nextLine();
        
        String local_da_prova = "";
        System.out.println("\nQual o Local da Prova?");
        local_da_prova = ler.nextLine();
        
        String data_da_prova = "";
        System.out.println("\nQual a Data da Prova?");
        data_da_prova = ler.nextLine();
        
        int peso_da_prova = 0;
        System.out.println("\nQual o Peso da Prova?");
        peso_da_prova = ler.nextInt();
        ler.nextLine();                  //Para Limpar o Buffer da Leitura Anterior
        
        //Atribuição dos Dados à Prova
        Prova x = new Prova(nome_da_disciplina);
        x.setLocal(local_da_prova);
        x.setData(data_da_prova);
        x.setPeso(peso_da_prova);
        
        //Leitura de Dados das Questões Discursivas 
        System.out.println("\nQual a Quantidade de Questoes Discursivas?");
        int qtd = 0;
        qtd = ler.nextInt();
        ler.nextLine();                 //Limpeza do Buffer
        String[] pergunta_discursiva = new String[qtd];
        String[] criterio_discursiva = new String[qtd];
        int[] peso_discursiva = new int[qtd];
        for (int i=0;i<qtd;i++){
            System.out.println("\nQuestão Discursiva " + (i+1) + ":\n\nDescreva a Pergunta:");
            pergunta_discursiva[i] = ler.nextLine();
            System.out.println("\nDescreva os Criterios Para Correcao:");
            criterio_discursiva[i] = ler.nextLine();
            System.out.println("\nDigite o Peso da Questao:");
            peso_discursiva[i] = ler.nextInt();
            ler.nextLine();                     //Limpeza do Buffer
        }
        Discursiva[] questoes_discursivas = new Discursiva[qtd];
        for (int i=0;i<qtd;i++){
            questoes_discursivas[i] = new Discursiva();
            questoes_discursivas[i].setPergunta(pergunta_discursiva[i]);
            questoes_discursivas[i].setCriteriosCorrecao(criterio_discursiva[i]);
            questoes_discursivas[i].setPeso(peso_discursiva[i]);
        }
        //Leitura de Dados das Questões Objetivas
        System.out.println("\nQual a Quantidade de Questoes Objetivas?");
        int qtd_obj = 0;
        qtd_obj = ler.nextInt();
        ler.nextLine();
        String[] pergunta_objetiva = new String[qtd_obj];
        int[] peso_objetiva = new int[qtd_obj];
        String[][] opcoes_obj = new String[qtd_obj][5];
        int[] alternativa_correta = new int[qtd_obj];
        for (int i=0;i<qtd_obj;i++){
            System.out.println("\nQuestão Objetiva " + (i+1) + ":\n\nDescreva a Pergunta:");
            pergunta_objetiva[i] = ler.nextLine();
            System.out.println("\nDigite o Peso da Questao:");
            peso_objetiva[i] = ler.nextInt();
            ler.nextLine();                     //Limpeza do Buffer
            System.out.println("\nDescreva as 5 Alternativas:");
            for (int j=0;j<5;j++){
                System.out.println("\nOpcao (" + (j+1) + "):");
                opcoes_obj[i][j] = ler.nextLine();
            }
            System.out.println("\nDigite o Numero da Questao Correta de 1 a 5:");
            alternativa_correta[i] = ler.nextInt();
            ler.nextLine();                     //Limpeza do Buffer
        }
        //Atribuição dos Dados Obtidos às Questões Objetivas
        Objetiva[] questoes_objetivas = new Objetiva[qtd_obj];      //VERIFICAR
        for (int i=0;i<qtd_obj;i++){
            questoes_objetivas[i] = new Objetiva();
            questoes_objetivas[i].setPergunta(pergunta_objetiva[i]);
            questoes_objetivas[i].setPeso(peso_objetiva[i]);
            questoes_objetivas[i].setOpcoes(opcoes_obj[i]);         //VERIFICAR
            questoes_objetivas[i].setRespostaCorreta(alternativa_correta[i]-1);     //Igualar com a Representação
        }
        //Impressão
        System.out.println("\nIMPRESSAO DA PROVA\n\n");
        System.out.println(x.obtemDetalhes());
        x.setQuestoesDiscursivas(questoes_discursivas);
        x.setQuestoesObjetivas(questoes_objetivas);
        for (int i=0;i<qtd;i++){
            //questoes_discursivas[i].Imprimir_pergunta();
            //questoes_discursivas[i].imprimir_questao();
            //JOptionPane.showInputDialog(questoes_discursivas[i].Imprimir_pergunta());
            //JOptionPane.showInputDialog(questoes_discursivas[i].imprimir_questao());
            //CONTINUAR AQUI
        }
        for (int i=0;i<qtd_obj;i++){
            //questoes_objetivas[i].Imprimir_pergunta();
            //questoes_objetivas[i].imprimir_questao();
            //JOptionPane.showInputDialog(questoes_objetivas[i].Imprimir_pergunta());
            //JOptionPane.showInputDialog(questoes_objetivas[i].imprimir_questao());
        }
    }
}

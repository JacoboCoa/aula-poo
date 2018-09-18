/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg01.geradorprova;

import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
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
        //Leituda de Dados do Cabeçalho
        String nome_da_disciplina = JOptionPane.showInputDialog("Qual a Disciplina da Prova?");
        String local_da_prova = JOptionPane.showInputDialog("Qual o Local da Prova?");
        String data_da_prova = JOptionPane.showInputDialog("Qual a Data da Prova?");
        String peso = JOptionPane.showInputDialog("Qual o Peso da Prova?");
        int peso_da_prova = Integer.parseInt(peso);
        
        //Atribuição dos Dados à Prova
        Prova x = new Prova(nome_da_disciplina);
        x.setLocal(local_da_prova);
        x.setData(data_da_prova);
        x.setPeso(peso_da_prova);
        //JOptionPane.showMessageDialog(null,x.obtemDetalhes());      //Teste de Impressão
        
        //
        ArrayList<Questao> questoes = new ArrayList();
        String continuar = "";
        do{
        String tipo_questao = JOptionPane.showInputDialog(""
                + "Qual o tipo da questão a ser adicionada?\nD = Discursiva\nO = Objetiva");
        if ("D".equals(tipo_questao)){
            //Leitura de Dados das Questões Discursivas 
            String pergunta_discursiva = JOptionPane.showInputDialog(""
                    + "Questao Discursiva - Descreva a Pergunta:");
            String criterio_discursiva = JOptionPane.showInputDialog(""
                    + "Questao Discursiva - Descreva os Criterios para a Correcao:");
            String peso_d = JOptionPane.showInputDialog(""
                    + "Questao Discursiva - Digite o Peso da Questao:");
            double peso_discursiva = Double.parseDouble(peso_d);
            //Atribuição dos Dados
            Discursiva questoes_discursivas = new Discursiva();
            questoes_discursivas.setPergunta(pergunta_discursiva);
            questoes_discursivas.setCriteriosCorrecao(criterio_discursiva);
            questoes_discursivas.setPeso(peso_da_prova);
            //Adição da Questão ao ArrayList
            questoes.add(questoes_discursivas);
            //System.out.println(questoes.get(0).Imprimir_pergunta());  //Teste de Impressão
        } else {
            //Leitura de Dados das Questões Objetivas
            String pergunta_objetiva = JOptionPane.showInputDialog(""
                    + "Questao Objetiva - Descreva a Pergunta:");
            String peso_o = JOptionPane.showInputDialog(""
                    + "Questao Objetiva - Digite o Peso da Questao:");
            double peso_objetiva = Double.parseDouble(peso_o);
            JOptionPane.showMessageDialog(null,""
                    + "Questao Objetiva - Descreva as 5 alternativas:");
            String[] opcoes_obj = new String[5];
            for (int i=0;i<5;i++){
                opcoes_obj[i] = JOptionPane.showInputDialog("Opcao " + (i+1) + ":");
            }
            String alt_correta = JOptionPane.showInputDialog(""
                    + "Questao Objetiva - Digite o Numero da Questao Correta");
            int alternativa_correta = Integer.parseInt(alt_correta);
            //Atribuição dos Dados
            Objetiva questoes_objetivas = new Objetiva();
            questoes_objetivas.setPergunta(pergunta_objetiva);
            questoes_objetivas.setPeso(peso_objetiva);
            questoes_objetivas.setOpcoes(opcoes_obj);
            questoes_objetivas.setRespostaCorreta(alternativa_correta);
            //Adição da Questão ao ArrayList
            questoes.add(questoes_objetivas);
        }
        continuar = JOptionPane.showInputDialog(""
                + "Deseja adicionar mais uma Questao na Prova?\nS = Sim\nN = Nao");
        } while ("S".equals(continuar));
        x.setQuestoes(questoes);
        JOptionPane.showMessageDialog(null,x.obtemDetalhes());      //Teste de Impressão
    }
}
        /*
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
    */
    /*
    //Escrever em Arquivo
    try{
        Path caminho = Paths.get("arquivo.txt");
        String conteudo = "Bolinha\nQuadradinho";
        byte[] stringEmBytes 
        
        
        
        byte[] stringEmBytes = conteudo.getBytes();
        Files.write(caminho, stringEmBytes, StandardOpenOption.APPEND,
                StandardOpenOption.CREATE);
        JOptionPane.showMessageDialog(null, "Deu Certo");
    }catch (Exception e){
        JOptionPane.showMessageDialog(null, "Deu Errado");
    }
    //Ler Arquivo
    try{
        Path caminho = Paths.get("arquivo.txt");
        byte[] bytesDoConteudoDoArquivo = Files.readAllBytes(caminho);
    }
}
        
    
    Files.write(path, stringEmBytes);*/

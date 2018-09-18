/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg01.geradorprova;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
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
                questoes_discursivas.setPeso(peso_discursiva);
                //Adição da Questão ao ArrayList
                questoes.add(questoes_discursivas);
                //System.out.println(questoes.get(0).Imprimir_pergunta());  //Teste de Impressão
            } else {
                if ("O".equals(tipo_questao)){
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
                } else{
                    JOptionPane.showMessageDialog(null, "Opcao Invalida");
                    break;
                }
            }
            continuar = JOptionPane.showInputDialog(""
                    + "Deseja adicionar mais uma Questao na Prova?\nS = Sim\nN = Nao");
        } while ("S".equals(continuar));
        String nome_do_arquivo = JOptionPane.showInputDialog(""
                + "Qual sera o nome do Arquivo?");
        x.setQuestoes(questoes);
        //Salvando em .txt
        try{
            Path caminho = Paths.get(nome_do_arquivo + ".txt");
            String conteudo = x.obtemProvaImpressao();
            byte[] stringEmBytes = conteudo.getBytes();
            Files.write(caminho, stringEmBytes, StandardOpenOption.APPEND,StandardOpenOption.CREATE);
            JOptionPane.showMessageDialog(null, "Deu Certo");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Deu Errado");
        }
    }
}
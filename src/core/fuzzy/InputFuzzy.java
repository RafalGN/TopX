/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package core.fuzzy;

import java.util.List;
import java.util.Random;

/**
 *
 * @author Rogerio
 */
public class InputFuzzy {

    private int id_review;
    private double autor_reputation;
    private double padroes;
    private double corretude;
    private String avaliacaoManual;
    private double valorFuzzy;

    public double getValorFuzzy() {
        return valorFuzzy;
    }

    public void setValorFuzzy(double valorFuzzy) {
        this.valorFuzzy = valorFuzzy;
    }

    public InputFuzzy(String input, boolean autorAleatorio) {
        String[] splited = input.split("\t");
//        this.autor_reputation = Double.parseDouble(splited[0]);
        if (autorAleatorio) {
            Random gerador = new Random();
            this.autor_reputation = gerador.nextDouble() * 9; // [0,100[;
        } else {
            this.autor_reputation = Double.parseDouble(splited[0]);
        }
        this.padroes = Double.parseDouble(splited[1]);
        this.corretude = Double.parseDouble(splited[2].replace(',', '.'));
    }

    public InputFuzzy(String input) {
        String[] splited = input.split("\t");
//        this.autor_reputation = Double.parseDouble(splited[0]);
        this.id_review = Integer.parseInt(splited[0]);
        this.autor_reputation = Double.parseDouble(splited[1]);
        this.padroes = Double.parseDouble(splited[2]);
        this.corretude = Double.parseDouble(splited[3].replace(',', '.'));
        this.avaliacaoManual = splited[4];
    }

    public InputFuzzy(double autor_reputation, double padroes, double corretude) {
        this.autor_reputation = autor_reputation;
        this.padroes = padroes;
        this.corretude = corretude;
    }
    
    
    public InputFuzzy(){}
    
    public int getId_review() {
        return id_review;
    }

    public void setId_review(int id_review) {
        this.id_review = id_review;
    }
    
    /**
     * @return the autor_reputation
     */
    public double getAutor_reputation() {
        return autor_reputation;
    }

    /**
     * @param autor_reputation the autor_reputation to set
     */
    public void setAutor_reputation(double autor_reputation) {
        this.autor_reputation = autor_reputation;
    }

    /**
     * @return the padroes
     */
    public double getPadroes() {
        return padroes;
    }

    /**
     * @param padroes the padroes to set
     */
    public void setPadroes(double padroes) {
        this.padroes = padroes;
    }

    /**
     * @return the corretude
     */
    public double getCorretude() {
        return corretude;
    }

    /**
     * @param corretude the corretude to set
     */
    public void setCorretude(double corretude) {
        this.corretude = corretude;
    }

    public static String toARFF(List<InputFuzzy> valores) {
        String cabecalho = "@relation Opinions\n\n "
                + "@attribute autor numeric\n"
                + "@attribute padroes numeric\n"
                + "@attribute corretude numeric\n"
                + "@attribute class {IF,SF,BM,PL}\n"
                + "@data\n";
                
        String data = "";
        for(InputFuzzy ipf: valores){
            data = data + ipf.getAutor_reputation() +","+ipf.getPadroes() + ","+ipf.getCorretude() + "," +ipf.getAvaliacaoManual()+"\n";
        }
        return cabecalho + data;
    }

    @Override
    public String toString() {
        return this.autor_reputation + "\t" + this.padroes + "\t" + this.corretude;
    }

    public String getAvaliacaoManual() {
        return avaliacaoManual;
    }

    public void setAvaliacaoManual(String avaliacaoManual) {
        this.avaliacaoManual = avaliacaoManual;
    }
}

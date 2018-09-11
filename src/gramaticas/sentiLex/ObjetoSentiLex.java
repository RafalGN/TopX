/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gramaticas.sentiLex;

import java.util.List;

/**
 *
 * @author User
 */
public class ObjetoSentiLex {

    private String expressao;
    private String classeGramatical;
    private int polaridade;
    private List<String> alvoSentimentoFuncao;
    private String anotacaoPolaridade;

    public ObjetoSentiLex(String expressao, String classeGramatical, int polaridade, List<String> alvoSentimentoFuncao, String anotacaoPolaridade) {
        this.expressao = expressao;
        this.classeGramatical = classeGramatical;
        this.polaridade = polaridade;
        this.alvoSentimentoFuncao = alvoSentimentoFuncao;
        this.anotacaoPolaridade = anotacaoPolaridade;
    }

    public ObjetoSentiLex(String expressao, String classeGramatical, int polaridade) {
        this.expressao = expressao;
        this.classeGramatical = classeGramatical;
        this.polaridade = polaridade;
    }
    
    
    
    public String getExpressao() {
        return expressao;
    }

    public void setExpressao(String expressao) {
        this.expressao = expressao;
    }

    public String getClasseGramatical() {
        return classeGramatical;
    }

    public void setClasseGramatical(String classeGramatical) {
        this.classeGramatical = classeGramatical;
    }

    public int getPolaridade() {
        return polaridade;
    }

    public void setPolaridade(int polaridade) {
        this.polaridade = polaridade;
    }

    public List<String> getAlvoSentimentoFuncao() {
        return alvoSentimentoFuncao;
    }

    public void setAlvoSentimentoFuncao(List<String> alvoSentimentoFuncao) {
        this.alvoSentimentoFuncao = alvoSentimentoFuncao;
    }

    public String getAnotacaoPolaridade() {
        return anotacaoPolaridade;
    }

    public void setAnotacaoPolaridade(String anotacaoPolaridade) {
        this.anotacaoPolaridade = anotacaoPolaridade;
    }    
    
}

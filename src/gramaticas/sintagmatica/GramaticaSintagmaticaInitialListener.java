/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gramaticas.sintagmatica;

import java.util.HashMap;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 *
 * @author User
 */
public class GramaticaSintagmaticaInitialListener implements GramaticaSintagmaticaListener {

    private HashMap<String, String> pares;

    public HashMap<String, String> getPares() {
        return pares;
    }

    public GramaticaSintagmaticaInitialListener() {
        pares = new HashMap<>();
    }

    @Override
    public void enterNao_opc(GramaticaSintagmaticaParser.Nao_opcContext ctx) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitNao_opc(GramaticaSintagmaticaParser.Nao_opcContext ctx) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterSn(GramaticaSintagmaticaParser.SnContext ctx) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitSn(GramaticaSintagmaticaParser.SnContext ctx) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterComplemento(GramaticaSintagmaticaParser.ComplementoContext ctx) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitComplemento(GramaticaSintagmaticaParser.ComplementoContext ctx) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterDet(GramaticaSintagmaticaParser.DetContext ctx) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitDet(GramaticaSintagmaticaParser.DetContext ctx) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterSp(GramaticaSintagmaticaParser.SpContext ctx) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitSp(GramaticaSintagmaticaParser.SpContext ctx) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterMod(GramaticaSintagmaticaParser.ModContext ctx) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitMod(GramaticaSintagmaticaParser.ModContext ctx) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterSn_suj(GramaticaSintagmaticaParser.Sn_sujContext ctx) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitSn_suj(GramaticaSintagmaticaParser.Sn_sujContext ctx) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterIntens(GramaticaSintagmaticaParser.IntensContext ctx) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitIntens(GramaticaSintagmaticaParser.IntensContext ctx) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterSa_opc(GramaticaSintagmaticaParser.Sa_opcContext ctx) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitSa_opc(GramaticaSintagmaticaParser.Sa_opcContext ctx) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterSp_opc(GramaticaSintagmaticaParser.Sp_opcContext ctx) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitSp_opc(GramaticaSintagmaticaParser.Sp_opcContext ctx) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterPre_det(GramaticaSintagmaticaParser.Pre_detContext ctx) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitPre_det(GramaticaSintagmaticaParser.Pre_detContext ctx) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterDet_base(GramaticaSintagmaticaParser.Det_baseContext ctx) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitDet_base(GramaticaSintagmaticaParser.Det_baseContext ctx) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterSa(GramaticaSintagmaticaParser.SaContext ctx) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitSa(GramaticaSintagmaticaParser.SaContext ctx) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterOracao(GramaticaSintagmaticaParser.OracaoContext ctx) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitOracao(GramaticaSintagmaticaParser.OracaoContext ctx) {
        try {
            int totalSubs = ctx.sn_suj().SUBS().size();
            int totalPrep = ctx.sn_suj().PREP().size();
            
            int restanteSubs = totalSubs;
            int restantePrep = totalPrep;
            
            String nucSN = "";
            
            while(restanteSubs > 0 || restantePrep > 0){
                if(restanteSubs <= 0){
                }else{
                    nucSN = nucSN + " " + ctx.sn_suj().SUBS(totalSubs - restanteSubs);
                    restanteSubs--;
                }
                if(restantePrep <= 0){
                }else{
                    nucSN = nucSN + " " + ctx.sn_suj().PREP(totalPrep - restantePrep);
                    restantePrep--;
                }
            }
            
            ctx.sn_suj().SUBS(0).getText();
            
            
//            String nucSN = geraOracao(ctx.sn_suj());
            String SA = geraOracao(ctx.sv().complemento().sa_opc().sa());
            
            pares.put(nucSN, SA);
//            System.out.println(nucSN + " - " + SA);
            
        } catch (NullPointerException npe) {
//            npe.printStackTrace();
        }
    }

    @Override
    public void enterSv(GramaticaSintagmaticaParser.SvContext ctx) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitSv(GramaticaSintagmaticaParser.SvContext ctx) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterPos_det(GramaticaSintagmaticaParser.Pos_detContext ctx) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitPos_det(GramaticaSintagmaticaParser.Pos_detContext ctx) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterPeriodo(GramaticaSintagmaticaParser.PeriodoContext ctx) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitPeriodo(GramaticaSintagmaticaParser.PeriodoContext ctx) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterSn_opc(GramaticaSintagmaticaParser.Sn_opcContext ctx) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitSn_opc(GramaticaSintagmaticaParser.Sn_opcContext ctx) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visitTerminal(TerminalNode tn) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void visitErrorNode(ErrorNode en) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void enterEveryRule(ParserRuleContext prc) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exitEveryRule(ParserRuleContext prc) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param pt
     * @return
     */
    public String geraOracao(ParseTree pt) {
        ParseTree no = null;
        String oracao = "";
        for (int i = 0; i < pt.getChildCount(); i++) {
            no = pt.getChild(i);

//            if (no.getChildCount() > 0) {
            oracao = oracao.trim() + " " + teste(no).trim();
//                oracoes.add(teste(no));
//                System.out.println(oracoes.get(oracoes.size() - 1));
//            }
        }
        return oracao.trim();
    }

    /**
     *
     * @param pt
     * @return
     */
    private String teste(ParseTree pt) {
        if (pt == null) {
            return "";
        } else if (pt.getChildCount() <= 0) {
            String valor = pt.getText().trim();
            if (!valor.isEmpty()) {
                return pt.getText() + " ";
            } else {
                return "";
            }
        } else {
            String retorno = "";
            for (int i = 0; i <= pt.getChildCount(); i++) {
                retorno = retorno + teste(pt.getChild(i));
            }
            return retorno;
        }
    }
}

// Generated from C:\Users\User\Dropbox\Federal\MESTRADO\Projeto\workspace\ProjetoFinal\src\gramaticas\padroes\GramaticaPadroes.g4 by ANTLR 4.0
package gramaticas.padroes;

import gramaticas.padroes.GramaticaPadroesParser.ProdutoCompostoContext;
import java.util.HashMap;
import java.util.HashSet;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.ErrorNode;

public class GramaticaPadroesInitialListener implements GramaticaPadroesListener {

    HashMap<String, String> pares = new HashMap();
    HashSet<String> advs = new HashSet<>();

    @Override
    public void enterPadroes(GramaticaPadroesParser.PadroesContext ctx) {
    }

    @Override
    public void exitPadroes(GramaticaPadroesParser.PadroesContext ctx) {
    }

    @Override
    public void enterPadrao1(GramaticaPadroesParser.Padrao1Context ctx) {
    }

    @Override
    public void exitPadrao1(GramaticaPadroesParser.Padrao1Context ctx) {
        addPar(ctx, "padrao1");
    }

    @Override
    public void enterPadrao2(GramaticaPadroesParser.Padrao2Context ctx) {
    }

    @Override
    public void exitPadrao2(GramaticaPadroesParser.Padrao2Context ctx) {
        addPar(ctx, "padrao2");
        for (TerminalNode no : ctx.ADV()) {
            advs.add(no.getText());
//            System.out.println(no.getText());
        }
    }

    @Override
    public void enterPadrao3(GramaticaPadroesParser.Padrao3Context ctx) {
    }

    @Override
    public void exitPadrao3(GramaticaPadroesParser.Padrao3Context ctx) {
        addPar(ctx, "padrao3");
        for (TerminalNode no : ctx.ADV()) {
            advs.add(no.getText());
//            System.out.println(no.getText());
        }
    }

    @Override
    public void enterPadrao4(GramaticaPadroesParser.Padrao4Context ctx) {
    }

    @Override
    public void exitPadrao4(GramaticaPadroesParser.Padrao4Context ctx) {
        addPar(ctx, "padrao4");
        try {
            advs.add(ctx.ADV().getText());
//            System.out.println(ctx.ADV().getText());
        } catch (NullPointerException npe) {
        }
    }

    @Override
    public void enterPadrao5(GramaticaPadroesParser.Padrao5Context ctx) {
    }

    @Override
    public void exitPadrao5(GramaticaPadroesParser.Padrao5Context ctx) {
        addPar(ctx, "padrao5");
        advs.add(ctx.ADV().getText());
    }

    @Override
    public void enterPadrao6(GramaticaPadroesParser.Padrao6Context ctx) {
    }

    @Override
    public void exitPadrao6(GramaticaPadroesParser.Padrao6Context ctx) {
        addPar(ctx, "padrao6");
        advs.add(ctx.ADV().getText());
    }

//	@Override public void enterPadrao7(GramaticaPadroesParser.Padrao7Context ctx) { }
//	@Override public void exitPadrao7(GramaticaPadroesParser.Padrao7Context ctx) { 
//            addPar(ctx, "padrao7");
//        }
    @Override
    public void enterPeriodo(GramaticaPadroesParser.PeriodoContext ctx) {
    }

    @Override
    public void exitPeriodo(GramaticaPadroesParser.PeriodoContext ctx) {
    }

    @Override
    public void enterProdutoComposto(GramaticaPadroesParser.ProdutoCompostoContext ctx) {
    }

    @Override
    public void exitProdutoComposto(GramaticaPadroesParser.ProdutoCompostoContext ctx) {
    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
    }

    @Override
    public void visitTerminal(TerminalNode node) {
    }

    @Override
    public void visitErrorNode(ErrorNode node) {
    }

    private String capturaComposto(ProdutoCompostoContext contexto) {
        String carac = "";
        for (int i = 0; i < contexto.getChildCount(); i++) {
            carac += contexto.getChild(i) + " ";
        }
        return carac;
    }

    private void addPar(ParserRuleContext ctx, String tipo) {
        String palavras = "";
        for (int i = 0; i < ctx.getChildCount(); i++) {
            if (ctx.getChild(i) instanceof ProdutoCompostoContext) {
                palavras += capturaComposto((ProdutoCompostoContext) ctx.getChild(i)) + " ";
            } else {
                palavras += ctx.getChild(i).getText() + " ";
            }
        }


        pares.put(palavras.trim(), tipo);
    }
}
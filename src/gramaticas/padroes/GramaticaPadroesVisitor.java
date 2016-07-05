// Generated from C:\Users\User\Dropbox\Federal\MESTRADO\Projeto\workspace\ProjetoFinal\src\gramaticas\padroes\GramaticaPadroes.g4 by ANTLR 4.0
package gramaticas.padroes;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

public interface GramaticaPadroesVisitor<T> extends ParseTreeVisitor<T> {
	T visitPadroes(GramaticaPadroesParser.PadroesContext ctx);

	T visitPadrao3(GramaticaPadroesParser.Padrao3Context ctx);

	T visitPadrao4(GramaticaPadroesParser.Padrao4Context ctx);

	T visitPadrao1(GramaticaPadroesParser.Padrao1Context ctx);

	T visitProdutoComposto(GramaticaPadroesParser.ProdutoCompostoContext ctx);

	T visitPadrao2(GramaticaPadroesParser.Padrao2Context ctx);

	T visitPadrao5(GramaticaPadroesParser.Padrao5Context ctx);

	T visitPadrao6(GramaticaPadroesParser.Padrao6Context ctx);

	T visitPeriodo(GramaticaPadroesParser.PeriodoContext ctx);
}
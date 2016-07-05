// Generated from C:\Users\User\Dropbox\Federal\MESTRADO\Projeto\workspace\SentiWords\src\sentiwords\Sintagmas\GramaticaSintagmatica.g4 by ANTLR 4.0
package gramaticas.sintagmatica;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.Token;

public interface GramaticaSintagmaticaVisitor<T> extends ParseTreeVisitor<T> {
	T visitNao_opc(GramaticaSintagmaticaParser.Nao_opcContext ctx);

	T visitSn(GramaticaSintagmaticaParser.SnContext ctx);

	T visitComplemento(GramaticaSintagmaticaParser.ComplementoContext ctx);

	T visitDet(GramaticaSintagmaticaParser.DetContext ctx);

	T visitSp(GramaticaSintagmaticaParser.SpContext ctx);

	T visitMod(GramaticaSintagmaticaParser.ModContext ctx);

	T visitSn_suj(GramaticaSintagmaticaParser.Sn_sujContext ctx);

	T visitIntens(GramaticaSintagmaticaParser.IntensContext ctx);

	T visitSa_opc(GramaticaSintagmaticaParser.Sa_opcContext ctx);

	T visitSp_opc(GramaticaSintagmaticaParser.Sp_opcContext ctx);

	T visitPre_det(GramaticaSintagmaticaParser.Pre_detContext ctx);

	T visitDet_base(GramaticaSintagmaticaParser.Det_baseContext ctx);

	T visitSa(GramaticaSintagmaticaParser.SaContext ctx);

	T visitOracao(GramaticaSintagmaticaParser.OracaoContext ctx);

	T visitSv(GramaticaSintagmaticaParser.SvContext ctx);

	T visitPos_det(GramaticaSintagmaticaParser.Pos_detContext ctx);

	T visitPeriodo(GramaticaSintagmaticaParser.PeriodoContext ctx);

	T visitSn_opc(GramaticaSintagmaticaParser.Sn_opcContext ctx);
}
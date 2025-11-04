// Generated from C:/Users/felipe/source/repos/EasyLanguage/src/main/java/br/edu/cefsa/faculdade/model/EasyLanguage.g4 by ANTLR 4.13.2
package br.edu.cefsa.faculdade.model;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link EasyLanguageParser}.
 */
public interface EasyLanguageListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(EasyLanguageParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(EasyLanguageParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#decls}.
	 * @param ctx the parse tree
	 */
	void enterDecls(EasyLanguageParser.DeclsContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#decls}.
	 * @param ctx the parse tree
	 */
	void exitDecls(EasyLanguageParser.DeclsContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#declaracao}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracao(EasyLanguageParser.DeclaracaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#declaracao}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracao(EasyLanguageParser.DeclaracaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#comandos}.
	 * @param ctx the parse tree
	 */
	void enterComandos(EasyLanguageParser.ComandosContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#comandos}.
	 * @param ctx the parse tree
	 */
	void exitComandos(EasyLanguageParser.ComandosContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(EasyLanguageParser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(EasyLanguageParser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#cmdLeitura}.
	 * @param ctx the parse tree
	 */
	void enterCmdLeitura(EasyLanguageParser.CmdLeituraContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#cmdLeitura}.
	 * @param ctx the parse tree
	 */
	void exitCmdLeitura(EasyLanguageParser.CmdLeituraContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#cmdEscrita}.
	 * @param ctx the parse tree
	 */
	void enterCmdEscrita(EasyLanguageParser.CmdEscritaContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#cmdEscrita}.
	 * @param ctx the parse tree
	 */
	void exitCmdEscrita(EasyLanguageParser.CmdEscritaContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#cmdAtribuicao}.
	 * @param ctx the parse tree
	 */
	void enterCmdAtribuicao(EasyLanguageParser.CmdAtribuicaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#cmdAtribuicao}.
	 * @param ctx the parse tree
	 */
	void exitCmdAtribuicao(EasyLanguageParser.CmdAtribuicaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#cmdSe}.
	 * @param ctx the parse tree
	 */
	void enterCmdSe(EasyLanguageParser.CmdSeContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#cmdSe}.
	 * @param ctx the parse tree
	 */
	void exitCmdSe(EasyLanguageParser.CmdSeContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#cmdEnquanto}.
	 * @param ctx the parse tree
	 */
	void enterCmdEnquanto(EasyLanguageParser.CmdEnquantoContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#cmdEnquanto}.
	 * @param ctx the parse tree
	 */
	void exitCmdEnquanto(EasyLanguageParser.CmdEnquantoContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#cmdPara}.
	 * @param ctx the parse tree
	 */
	void enterCmdPara(EasyLanguageParser.CmdParaContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#cmdPara}.
	 * @param ctx the parse tree
	 */
	void exitCmdPara(EasyLanguageParser.CmdParaContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#bloco}.
	 * @param ctx the parse tree
	 */
	void enterBloco(EasyLanguageParser.BlocoContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#bloco}.
	 * @param ctx the parse tree
	 */
	void exitBloco(EasyLanguageParser.BlocoContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#expressao}.
	 * @param ctx the parse tree
	 */
	void enterExpressao(EasyLanguageParser.ExpressaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#expressao}.
	 * @param ctx the parse tree
	 */
	void exitExpressao(EasyLanguageParser.ExpressaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#termo}.
	 * @param ctx the parse tree
	 */
	void enterTermo(EasyLanguageParser.TermoContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#termo}.
	 * @param ctx the parse tree
	 */
	void exitTermo(EasyLanguageParser.TermoContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#fator}.
	 * @param ctx the parse tree
	 */
	void enterFator(EasyLanguageParser.FatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#fator}.
	 * @param ctx the parse tree
	 */
	void exitFator(EasyLanguageParser.FatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#opArit}.
	 * @param ctx the parse tree
	 */
	void enterOpArit(EasyLanguageParser.OpAritContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#opArit}.
	 * @param ctx the parse tree
	 */
	void exitOpArit(EasyLanguageParser.OpAritContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#opRel}.
	 * @param ctx the parse tree
	 */
	void enterOpRel(EasyLanguageParser.OpRelContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#opRel}.
	 * @param ctx the parse tree
	 */
	void exitOpRel(EasyLanguageParser.OpRelContext ctx);
	/**
	 * Enter a parse tree produced by {@link EasyLanguageParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(EasyLanguageParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link EasyLanguageParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(EasyLanguageParser.TipoContext ctx);
}
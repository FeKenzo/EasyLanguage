// Generated from C:/Users/felipe/source/repos/EasyLanguage/src/main/java/br/edu/cefsa/faculdade/parser/EasyLanguage.g4 by ANTLR 4.13.2

package br.edu.cefsa.faculdade.parser;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link EasyLanguageParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface EasyLanguageVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link EasyLanguageParser#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(EasyLanguageParser.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by {@link EasyLanguageParser#decls}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecls(EasyLanguageParser.DeclsContext ctx);
	/**
	 * Visit a parse tree produced by {@link EasyLanguageParser#declaracao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaracao(EasyLanguageParser.DeclaracaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link EasyLanguageParser#comandos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComandos(EasyLanguageParser.ComandosContext ctx);
	/**
	 * Visit a parse tree produced by {@link EasyLanguageParser#cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmd(EasyLanguageParser.CmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link EasyLanguageParser#cmdLeitura}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdLeitura(EasyLanguageParser.CmdLeituraContext ctx);
	/**
	 * Visit a parse tree produced by {@link EasyLanguageParser#cmdEscrita}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdEscrita(EasyLanguageParser.CmdEscritaContext ctx);
	/**
	 * Visit a parse tree produced by {@link EasyLanguageParser#cmdAtribuicao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdAtribuicao(EasyLanguageParser.CmdAtribuicaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link EasyLanguageParser#cmdSe}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdSe(EasyLanguageParser.CmdSeContext ctx);
	/**
	 * Visit a parse tree produced by {@link EasyLanguageParser#cmdEnquanto}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdEnquanto(EasyLanguageParser.CmdEnquantoContext ctx);
	/**
	 * Visit a parse tree produced by {@link EasyLanguageParser#cmdPara}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmdPara(EasyLanguageParser.CmdParaContext ctx);
	/**
	 * Visit a parse tree produced by {@link EasyLanguageParser#bloco}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBloco(EasyLanguageParser.BlocoContext ctx);
	/**
	 * Visit a parse tree produced by {@link EasyLanguageParser#expressao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressao(EasyLanguageParser.ExpressaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link EasyLanguageParser#termo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermo(EasyLanguageParser.TermoContext ctx);
	/**
	 * Visit a parse tree produced by {@link EasyLanguageParser#fator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFator(EasyLanguageParser.FatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link EasyLanguageParser#opArit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpArit(EasyLanguageParser.OpAritContext ctx);
	/**
	 * Visit a parse tree produced by {@link EasyLanguageParser#opRel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpRel(EasyLanguageParser.OpRelContext ctx);
	/**
	 * Visit a parse tree produced by {@link EasyLanguageParser#tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo(EasyLanguageParser.TipoContext ctx);
}
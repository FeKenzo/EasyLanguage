package br.edu.cefsa.faculdade.model;

import br.edu.cefsa.faculdade.parser.*;

public class EasyCustomVisitor extends EasyLanguageBaseVisitor<Void> {

    private final EasySymbolTable tabela = new EasySymbolTable();
    private final CodeGenerator code = new CodeGenerator();
    private int indent = 1; // nível de indentação
    private boolean hasSemanticError = false; // flag de erro global

    public CodeGenerator getCode() {
        return code;
    }

    public boolean hasSemanticError() {
        return hasSemanticError;
    }

    @Override
    public Void visitPrograma(EasyLanguageParser.ProgramaContext ctx) {
        try {
            code.append("public class ProgramaGerado {");
            code.addIndented("public static void main(String[] args) {", indent);

            visitChildren(ctx);

            code.addIndented("}", indent);
            code.append("}");
        } catch (Exception e) {
            hasSemanticError = true;
            System.err.println("Erro durante a geração do programa: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Void visitDeclaracao(EasyLanguageParser.DeclaracaoContext ctx) {
        try {
            String tipoEasy = ctx.tipo().getText();
            String tipoJava = switch (tipoEasy) {
                case "inteiro" -> "int";
                case "booleano" -> "boolean";
                case "texto" -> "String";
                default -> "Object";
            };

            for (var id : ctx.ID()) {
                String nome = id.getText();
                try {
                    tabela.add(new EasySymbol(nome, tipoEasy));
                    code.addIndented(tipoJava + " " + nome + ";", indent);
                } catch (EasySemanticException e) {
                    hasSemanticError = true;
                    System.err.println("Erro semântico (declaração): " + e.getMessage());
                }
            }
        } catch (Exception e) {
            hasSemanticError = true;
            System.err.println("Erro inesperado em declaração: " + e.getMessage());
        }
        return null;
    }

    @Override
    public Void visitCmdAtribuicao(EasyLanguageParser.CmdAtribuicaoContext ctx) {
        try {
            String nomeVar = ctx.ID().getText();
            String expressao = ctx.expressao().getText();

            try {
                EasySymbol var = tabela.get(nomeVar);

                // Validação básica de tipo
                if (var.getTipo().equals("inteiro") && expressao.contains("\"")) {
                    throw new EasySemanticException("Tipo incompatível para variável '" + nomeVar + "'. Esperado inteiro.");
                } else if (var.getTipo().equals("texto") && expressao.matches("\\d+")) {
                    throw new EasySemanticException("Tipo incompatível para variável '" + nomeVar + "'. Esperado texto.");
                } else if (var.getTipo().equals("booleano")
                        && !expressao.equals("verdadeiro")
                        && !expressao.equals("falso")
                        && !expressao.matches(".+[><=!].+")) { // permite comparações booleanas
                    throw new EasySemanticException("Tipo incompatível para variável '" + nomeVar + "'. Esperado booleano.");
                }

                // Se passou nas validações → gera código
                code.addIndented(nomeVar + " = " + expressao + ";", indent);

            } catch (EasySemanticException e) {
                hasSemanticError = true;
                System.err.println("Erro semântico (atribuição): " + e.getMessage());
            }
        } catch (Exception e) {
            hasSemanticError = true;
            System.err.println("Erro inesperado em atribuição: " + e.getMessage());
        }

        return null;
    }

    @Override
    public Void visitCmdEscrita(EasyLanguageParser.CmdEscritaContext ctx) {
        try {
            String conteudo = ctx.expressao().getText();

            // Valida se o conteúdo está vazio ou nulo
            if (conteudo == null || conteudo.isEmpty()) {
                throw new EasySemanticException("Comando 'escreva' sem expressão.");
            }

            code.addIndented("System.out.println(" + conteudo + ");", indent);

        } catch (EasySemanticException e) {
            hasSemanticError = true;
            System.err.println("Erro semântico (escrita): " + e.getMessage());
        } catch (Exception e) {
            hasSemanticError = true;
            System.err.println("Erro inesperado em comando 'escreva': " + e.getMessage());
        }

        return null;
    }

    @Override
    public Void visitCmdLeitura(EasyLanguageParser.CmdLeituraContext ctx) {
        try {
            String var = ctx.ID().getText();
            EasySymbol simbolo = tabela.get(var);
            String tipo = simbolo.getTipo();

            // Gera leitura de acordo com tipo da variável
            code.addIndented("java.util.Scanner sc = new java.util.Scanner(System.in);", indent);
            switch (tipo) {
                case "inteiro" -> code.addIndented(var + " = sc.nextInt();", indent);
                case "texto" -> code.addIndented(var + " = sc.nextLine();", indent);
                case "booleano" -> code.addIndented(var + " = sc.nextBoolean();", indent);
                default -> throw new EasySemanticException("Tipo desconhecido para leitura: " + tipo);
            }

        } catch (EasySemanticException e) {
            hasSemanticError = true;
            System.err.println("Erro semântico (leitura): " + e.getMessage());
        } catch (Exception e) {
            hasSemanticError = true;
            System.err.println("Erro inesperado em comando 'leia': " + e.getMessage());
        }

        return null;
    }

    @Override
    public Void visitCmdPara(EasyLanguageParser.CmdParaContext ctx) {
        try {
            String nomeVar = ctx.ID().getText();
            String inicio = ctx.expressao(0).getText();
            String fim = ctx.expressao(1).getText();
            String passo = ctx.expressao(2).getText();

            // Verifica se variável existe e é inteira
            EasySymbol var = tabela.get(nomeVar);
            if (!var.getTipo().equals("inteiro")) {
                throw new EasySemanticException("A variável do laço 'para' deve ser do tipo inteiro: " + nomeVar);
            }

            // Gera o código Java equivalente ao laço for
            code.addIndented("for (" + nomeVar + " = " + inicio + "; " + nomeVar + " <= " + fim + "; " +
                    nomeVar + " += " + passo + ") {", indent);

            indent++;
            visit(ctx.bloco());
            indent--;

            code.addIndented("}", indent);

        } catch (EasySemanticException e) {
            hasSemanticError = true;
            System.err.println("Erro semântico (para): " + e.getMessage());
        } catch (Exception e) {
            hasSemanticError = true;
            System.err.println("Erro inesperado no comando 'para': " + e.getMessage());
        }

        return null;
    }

    @Override
    public Void visitCmdSe(EasyLanguageParser.CmdSeContext ctx) {
        try {
            String condicao = ctx.expressao().getText();

            // Verifica se condição parece lógica
            if (!(condicao.contains(">") || condicao.contains("<") ||
                    condicao.contains("==") || condicao.contains("!=") ||
                    condicao.contains("verdadeiro") || condicao.contains("falso"))) {
                throw new EasySemanticException("Condição inválida no comando 'se': " + condicao);
            }

            code.addIndented("if (" + condicao + ") {", indent);
            indent++;
            visit(ctx.bloco(0));
            indent--;

            if (ctx.SENAO() != null) {
                code.addIndented("} else {", indent);
                indent++;
                visit(ctx.bloco(1));
                indent--;
            }

            code.addIndented("}", indent);

        } catch (EasySemanticException e) {
            hasSemanticError = true;
            System.err.println("Erro semântico (condicional): " + e.getMessage());
        } catch (Exception e) {
            hasSemanticError = true;
            System.err.println("Erro inesperado em comando 'se': " + e.getMessage());
        }

        return null;
    }

    @Override
    public Void visitBloco(EasyLanguageParser.BlocoContext ctx) {
        try {
            visitChildren(ctx);
        } catch (Exception e) {
            hasSemanticError = true;
            System.err.println("Erro inesperado em bloco de comandos: " + e.getMessage());
        }
        return null;
    }
}

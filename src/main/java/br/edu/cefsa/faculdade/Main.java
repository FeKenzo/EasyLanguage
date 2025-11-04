package br.edu.cefsa.faculdade;

import br.edu.cefsa.faculdade.model.*;
import br.edu.cefsa.faculdade.parser.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.nio.file.*;

public class Main {
    public static void main(String[] args) {
        try {
            String caminho = "src/main/java/br/edu/cefsa/faculdade/teste.easy";
            String codigo = Files.readString(Path.of(caminho));

            EasyLanguageLexer lexer = new EasyLanguageLexer(CharStreams.fromString(codigo));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            EasyLanguageParser parser = new EasyLanguageParser(tokens);

            ParseTree tree = parser.programa();

            EasyCustomVisitor visitor = new EasyCustomVisitor();
            visitor.visit(tree);

            // Verifica erros semânticos antes de salvar
            if (!visitor.hasSemanticError()) {
                String saida = "src/main/java/br/edu/cefsa/faculdade/ProgramaGerado.java";
                Files.writeString(Path.of(saida), visitor.getCode().getCodigo());
                System.out.println("✅ Código Java gerado com sucesso em: " + saida);
            } else {
                System.err.println("❌ Código Java NÃO gerado devido a erros semânticos.");
            }

        } catch (Exception e) {
            System.err.println("Erro durante a geração de código:");
            e.printStackTrace();
        }
    }
}

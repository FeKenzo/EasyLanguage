package br.edu.cefsa.faculdade.tests;

import br.edu.cefsa.faculdade.model.*;
import br.edu.cefsa.faculdade.parser.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.nio.file.*;

public class TestRunner {

    public static void main(String[] args) {
        String[] arquivos = {
                "src/main/java/br/edu/cefsa/faculdade/tests/test1_valido.easy",
                "src/main/java/br/edu/cefsa/faculdade/tests/test2_decisao.easy",
                "src/main/java/br/edu/cefsa/faculdade/tests/test3_laco.easy",
                "src/main/java/br/edu/cefsa/faculdade/tests/test4_erro_variavel_nao_declarada.easy",
                "src/main/java/br/edu/cefsa/faculdade/tests/test5_erro_tipo_incompativel.easy"
        };

        for (String caminho : arquivos) {
            System.out.println("\n==============================");
            System.out.println("Executando teste: " + caminho);
            System.out.println("==============================");
            executarTeste(caminho);
        }
    }

    private static void executarTeste(String caminho) {
        try {
            String codigo = Files.readString(Path.of(caminho));
            EasyLanguageLexer lexer = new EasyLanguageLexer(CharStreams.fromString(codigo));
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            EasyLanguageParser parser = new EasyLanguageParser(tokens);
            ParseTree tree = parser.programa();

            EasyCustomVisitor visitor = new EasyCustomVisitor();
            visitor.visit(tree);

            System.out.println("✅ Teste concluído com sucesso.\n");
        } catch (Exception e) {
            System.err.println("💥 Erro detectado: " + e.getMessage());
        }
    }
}

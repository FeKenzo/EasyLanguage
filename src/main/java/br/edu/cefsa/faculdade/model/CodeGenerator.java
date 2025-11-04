package br.edu.cefsa.faculdade.model;

public class CodeGenerator {
    private final StringBuilder codigo = new StringBuilder();

    public void append(String linha) {
        codigo.append(linha).append("\n");
    }

    public void addIndented(String linha, int nivel) {
        codigo.append("    ".repeat(Math.max(0, nivel))).append(linha).append("\n");
    }

    public String getCodigo() {
        return codigo.toString();
    }

    public void clear() {
        codigo.setLength(0);
    }
}

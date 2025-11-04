package br.edu.cefsa.faculdade.model;

import java.util.HashMap;
import java.util.Map;

public class EasySymbolTable {
    private Map<String, EasySymbol> symbols = new HashMap<>();

    public void add(EasySymbol symbol) throws EasySemanticException {
        if (symbols.containsKey(symbol.getNome())) {
            throw new EasySemanticException("Variável '" + symbol.getNome() + "' já foi declarada.");
        }
        symbols.put(symbol.getNome(), symbol);
    }

    public EasySymbol get(String nome) throws EasySemanticException {
        if (!symbols.containsKey(nome)) {
            throw new EasySemanticException("Variável '" + nome + "' não foi declarada.");
        }
        return symbols.get(nome);
    }

    public boolean exists(String nome) {
        return symbols.containsKey(nome);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (EasySymbol symbol : symbols.values()) {
            sb.append(symbol.toString()).append("\n");
        }
        return sb.toString();
    }
}

package br.edu.cefsa.faculdade.model;

public class EasySymbol {
    private final String nome;
    private final String tipo;
    private Object valor;

    public EasySymbol(String nome, String tipo) {
        this.nome = nome;
        this.tipo = tipo;
        this.valor = null;
    }

    public String getNome() { return nome; }
    public String getTipo() { return tipo; }
    public Object getValor() { return valor; }

    public void setValor(Object valor) { this.valor = valor; }

    public void setValorFromString(String valorStr) throws EasySemanticException {
        try {
            switch (tipo) {
                case "inteiro":
                    this.valor = Integer.parseInt(valorStr);
                    break;
                case "booleano":
                    if (valorStr.equals("verdadeiro") || valorStr.equals("falso")) {
                        this.valor = valorStr.equals("verdadeiro");
                    } else {
                        throw new EasySemanticException("Valor inválido para tipo booleano: " + valorStr);
                    }
                    break;
                case "texto":
                    this.valor = valorStr.replace("\"", ""); // remove aspas
                    break;
                default:
                    throw new EasySemanticException("Tipo desconhecido: " + tipo);
            }
        } catch (NumberFormatException e) {
            throw new EasySemanticException("Valor incompatível para tipo " + tipo + ": " + valorStr);
        }
    }

    @Override
    public String toString() {
        return nome + " (" + tipo + ") = " + valor;
    }
}

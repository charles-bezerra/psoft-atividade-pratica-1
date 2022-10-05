package entities;

public class Produto {
    private String nome;
    private String fabricacao;
    private float preco;

    public Produto (String nome, String fabricacao, float preco) {
        this.nome = nome;
        this.fabricacao = fabricacao;
        this.preco = preco;
    }

    public String getNome() {
        return this.nome;
    }

    public String getFabricacao() {
        return this.fabricacao;
    }

    public float getPreco() {
        return this.preco;
    }
}

package entities;

public class Lote {
    private static int count = -1;
    private int id;
    private Produto produto;
    private int quantidade;
    private String dataValidade;

    public Lote (Produto produto, int quantidade, String dataValidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.dataValidade = dataValidade;
        generateId();
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getId() {
        return id;
    }

    private void generateId () {
        this.id = ++Lote.count;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    @Override
    public String toString() {
        return "Lote{" +
                "id=" + id +
                ", produto=" + produto +
                ", quantidade=" + quantidade +
                ", dataValidade='" + dataValidade + '\'' +
                '}';
    }
}

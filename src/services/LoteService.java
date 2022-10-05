package services;

import entities.Lote;
import entities.Produto;

import java.util.HashMap;
import java.util.Map;

public class LoteService {
    Map<Integer, Lote> lotes;

    public LoteService () {
        this.lotes = new HashMap<>();
    }

    public void listar() {
        Lote[] arrayLotes = (Lote[]) lotes.values().toArray();

        for (Lote elementLote: arrayLotes) {
            System.out.println(elementLote);
        }
    }

    public void criar(Produto produto, int quantidade, String dataValidade) {
        Lote lote = new Lote(produto, quantidade, dataValidade);
        this.lotes.put(lote.getId(), lote);
    }
}

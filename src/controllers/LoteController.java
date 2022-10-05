package controllers;

import entities.Lote;
import entities.Produto;
import services.LoteService;

import java.util.HashMap;
import java.util.Map;

public class LoteController {

    LoteService loteService;

    public LoteController () {
        this.loteService = new LoteService();
    }


    public void listar() {
        loteService.listar();
    }
}

package org.jopitarelo.desafio_target_1.models;

import java.util.List;

public class Vendedor {
    private String nome;
    private List<Venda> vendas;

    public Vendedor(String nome) {
        this.nome = nome;
    }

    public void setNome(String nome) { this.nome = nome; }
    public String getNome() { return nome; }

    public void setVendas(List<Venda> vendas) { this.vendas = vendas; }
    public List<Venda> getVendas() { return this.vendas; }
}

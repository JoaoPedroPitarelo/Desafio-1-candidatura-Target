package org.jopitarelo.desafio_target_1.models;

public class Venda {
    private String vendedor;
    private double valor;

    public Venda() {}

    public Venda(String vendedor, double valor) {
        this.vendedor = vendedor;
        this.valor = valor;
    }

    public String getVendedor() { return vendedor; }

    public double getValor() { return valor; }
    public void setValor(double novoValor) {
        if (novoValor > 0.0) {
            this.valor = novoValor;
        }
    }

    @Override
    public String toString() {
        return "Venda: \n\tvalor: R$" + this.valor + "\n\tvendedor: " + this.vendedor;
    }
}

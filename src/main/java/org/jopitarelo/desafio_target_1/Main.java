package org.jopitarelo.desafio_target_1;

import org.jopitarelo.desafio_target_1.models.Vendedor;
import org.jopitarelo.desafio_target_1.services.VendaService;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        VendaService service = new VendaService();

        for (Vendedor vendedor : service.carregarVendedores()) {
            double comissao = service.calcularComissao(vendedor);
            System.out.printf("%s: R$ %.2f%n", vendedor.getNome(), comissao);
        }
    }
}

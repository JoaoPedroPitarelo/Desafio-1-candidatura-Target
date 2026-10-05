package org.jopitarelo.desafio_target_1.services;

import org.jopitarelo.desafio_target_1.models.ArquivoVendas;
import org.jopitarelo.desafio_target_1.models.Venda;
import org.jopitarelo.desafio_target_1.models.Vendedor;

import tools.jackson.databind.ObjectMapper;
import tools.jackson.databind.json.JsonMapper;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class VendaService {

    private final ObjectMapper mapper = JsonMapper.builder().build();

    public List<Venda> carregarDados() throws IOException {
        try (InputStream is = getClass().getResourceAsStream("/vendas.json")) {
            if (is == null) {
                throw new FileNotFoundException("vendas.json não encontrado no classpath");
            }
            return mapper.readValue(is, ArquivoVendas.class).getVendas();
        }
    }

    public List<Vendedor> carregarVendedores() throws IOException {
        Map<String, List<Venda>> porVendedor = carregarDados()
            .stream()
            .collect(Collectors.groupingBy(Venda::getVendedor));

        return porVendedor.entrySet().stream()
            .map(e -> {
                Vendedor v = new Vendedor(e.getKey());
                v.setVendas(e.getValue());
                return v;
            })
            .toList();
    }

    public double calcularComissao(Vendedor vendedor) {
        if (vendedor.getVendas() == null) {
            return 0.0;
        }

        return vendedor.getVendas().stream()
                .mapToDouble(venda -> comissaoDaVenda(venda.getValor()))
                .sum();
    }

    private double comissaoDaVenda(double valor) {
        if (valor < 100.0) {
            return 0.0;
        }
        if (valor < 500.0) {
            return valor * 0.01;
        }
        return valor * 0.05;
    }
}

package org.teiacoltec.poo.tp2.service;

import org.teiacoltec.poo.tp2.util.SerializacaoUtil;
import java.util.List;
import java.io.IOException;

public class GerenciadorDados {

    public <T> void salvarLista(List<T> lista, String arquivo) throws IOException {
        SerializacaoUtil.salvarLista(lista, arquivo);
    }

    public <T> List<T> carregarLista(String arquivo) throws IOException, ClassNotFoundException {
        return SerializacaoUtil.carregarLista(arquivo);
    }

} 
package br.com.ada.crud.controller.pais.impl;

import br.com.ada.crud.controller.pais.PaisController;
import br.com.ada.crud.controller.pais.exception.PaisNaoEncontrado;
import br.com.ada.crud.model.pais.Pais;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class PaisArmazenamentoVolatilController implements PaisController {

    private List<Pais> paises = new ArrayList<>();

    @Override
    public void cadastrar(Pais pais) {
        pais.setId(UUID.randomUUID());
        paises.add(pais);
    }

    @Override
    public Pais ler(UUID id) {
        Pais encontrado = null;

        for (Pais pais : paises) {

            if (pais.getId().equals(id)) {
                encontrado = pais;
            }
        }

        if (encontrado == null) {
            throw new PaisNaoEncontrado();
        }

        return encontrado;
    }

    @Override
    public void atualizar(UUID id, Pais pais) {
        Pais encontrado = null;

        for (int i = 0; i < paises.size(); i++) {
            Pais antigo = paises.get(i);

            if (antigo.getId().equals(id)) {
                encontrado = antigo;
                paises.set(i, pais);
            }
        }

        if (encontrado == null) {
            throw new PaisNaoEncontrado();
        }

    }

    @Override
    public Pais deletar(UUID id) {
        Iterator<Pais> iterador = paises.iterator();
        Pais deletado = null;

        while (iterador.hasNext()) {
            Pais pais = iterador.next();

            if (pais.getId().equals(id)) {
                deletado = pais;
                iterador.remove();
            }

        }

        if (deletado == null) {
            throw new PaisNaoEncontrado();
        }

        return deletado;
    }

    @Override
    public List<Pais> listar() {
        return paises;
    }
}

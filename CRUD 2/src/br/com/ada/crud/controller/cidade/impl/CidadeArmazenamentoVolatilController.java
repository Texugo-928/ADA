package br.com.ada.crud.controller.cidade.impl;

import br.com.ada.crud.controller.cidade.CidadeController;
import br.com.ada.crud.controller.cidade.exception.CidadeNaoEncontrada;
import br.com.ada.crud.model.cidade.Cidade;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class CidadeArmazenamentoVolatilController implements CidadeController {

    private List<Cidade> cidades = new ArrayList<>();

    @Override
    public void cadastrar(Cidade cidade) {
        cidade.setId(UUID.randomUUID());
        cidades.add(cidade);
    }

    @Override
    public Cidade ler(UUID id) {
        Cidade encontrada = null;

        for (Cidade cidade : cidades) {

            if (cidade.getId().equals(id)) {
                encontrada = cidade;
            }
        }

        if (encontrada == null) {
            throw new CidadeNaoEncontrada();
        }

        return encontrada;
    }

    @Override
    public void atualizar(UUID id, Cidade cidade) {
        Cidade encontrada = null;

        for (int i = 0; i < cidades.size(); i++) {
            Cidade antiga = cidades.get(i);

            if (antiga.getId().equals(id)) {
                encontrada = antiga;
                cidades.set(i, cidade);
            }
        }

        if (encontrada == null) {
            throw new CidadeNaoEncontrada();
        }

    }

    @Override
    public Cidade deletar(UUID id) {
        Iterator<Cidade> iterador = cidades.iterator();
        Cidade deletada = null;

        while (iterador.hasNext()) {
            Cidade cidade = iterador.next();

            if (cidade.getId().equals(id)) {
                deletada = cidade;
                iterador.remove();
            }

        }

        if (deletada == null) {
            throw new CidadeNaoEncontrada();
        }

        return deletada;
    }

    @Override
    public List<Cidade> listar() {
        return cidades;
    }
}

package br.com.ada.crud.controller.estado.impl;

import br.com.ada.crud.controller.estado.EstadoController;
import br.com.ada.crud.controller.estado.exception.EstadoNaoEncontrado;
import br.com.ada.crud.model.estado.Estado;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class EstadoArmazenamentoVolatilController implements EstadoController {

    private List<Estado> estados = new ArrayList<>();

    @Override
    public void cadastrar(Estado estado) {
        estado.setId(UUID.randomUUID());
        estados.add(estado);
    }

    @Override
    public Estado ler(UUID id) {
        Estado encontrado = null;

        for (Estado estado : estados) {

            if (estado.getId().equals(id)) {
                encontrado = estado;
            }
        }

        if (encontrado == null) {
            throw new EstadoNaoEncontrado();
        }

        return encontrado;
    }

    @Override
    public void atualizar(UUID id, Estado estado) {
        Estado encontrado = null;

        for (int i = 0; i < estados.size(); i++) {
            Estado antigo = estados.get(i);

            if (antigo.getId().equals(id)) {
                encontrado = antigo;
                estados.set(i, estado);
            }
        }

        if (encontrado == null) {
            throw new EstadoNaoEncontrado();
        }

    }

    @Override
    public Estado deletar(UUID id) {
        Iterator<Estado> iterador = estados.iterator();
        Estado deletado = null;

        while (iterador.hasNext()) {
            Estado estado = iterador.next();

            if (estado.getId().equals(id)) {
                deletado = estado;
                iterador.remove();
            }

        }

        if (deletado == null) {
            throw new EstadoNaoEncontrado();
        }

        return deletado;
    }

    @Override
    public List<Estado> listar() {
        return estados;
    }
}

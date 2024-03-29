package br.com.ada.crud.model.estado.dao;

import br.com.ada.crud.model.estado.Estado;

import java.util.List;
import java.util.UUID;

public interface EstadoDAO {

    void cadastrar(Estado estado);

    List<Estado> listar();

    Estado ler(UUID id);

    void atualizar(UUID id, Estado estado);

    Estado deletar(UUID id);
}

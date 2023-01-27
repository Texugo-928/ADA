package br.com.ada.crud.controller.estado;

import br.com.ada.crud.model.estado.Estado;

import java.util.List;
import java.util.UUID;

public interface EstadoController {

    void cadastrar(Estado estado);

    Estado ler(UUID id);

    void atualizar(UUID id, Estado estado);

    Estado deletar(UUID id);

    List<Estado> listar();

}

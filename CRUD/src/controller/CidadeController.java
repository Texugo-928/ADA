package controller;

import model.cidade.Cidade;

import java.util.List;
import java.util.UUID;

public interface CidadeController {

    void cadastrar(Cidade cidade);

    Cidade ler(UUID id);

    void atualizar(UUID id, Cidade cidade);

    Cidade deletar(UUID id);

    List<Cidade> listar();

}

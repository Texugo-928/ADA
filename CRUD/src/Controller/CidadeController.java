package Controller;

import Model.Cidade;

import java.util.List;
import java.util.UUID;

public interface CidadeController {

    void create(Cidade cidade);

    Cidade read(UUID id);

    void update(UUID id, Cidade cidade);

    Cidade delete(UUID id);

    List<Cidade> list();

}

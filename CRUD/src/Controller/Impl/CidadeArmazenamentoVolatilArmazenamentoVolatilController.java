package Controller.Impl;

import Controller.CidadeController;
import Model.Cidade;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class CidadeArmazenamentoVolatilArmazenamentoVolatilController implements CidadeController {

    private List<Cidade> cidades = new ArrayList<>();

    @Override
    public void create(Cidade cidade) {

        cidade.setId(UUID.randomUUID());

        cidades.add(cidade);

    }

    @Override
    public Cidade read(UUID id) {

        Cidade encontrada = null;

        for (Cidade cidade : cidades) {

            if (cidade.getId().equals(id)) {

                encontrada = cidade;

            }

        }

        return encontrada;
    }

    @Override
    public void update(UUID id, Cidade cidade) {

        for (int i = 0; i < cidades.size(); i++) {

            Cidade antiga = cidades.get(i);

            if (antiga.getId().equals(id)) {

                cidades.set(i, cidade);

            }

        }

    }

    @Override
    public Cidade delete(UUID id) {

        Iterator<Cidade> iterador = cidades.iterator();

        Cidade deletada = null;

        while (iterador.hasNext()) {

            Cidade cidade = iterador.next();

            if (cidade.getId().equals(id)) {

                deletada = cidade;
                iterador.remove();
            }

        }

        return deletada;
    }

    @Override
    public List<Cidade> list() {
        return cidades;
    }
}

package br.com.ada.crud.model.cidade.dao.impl;

import br.com.ada.crud.model.cidade.Cidade;
import br.com.ada.crud.model.cidade.dao.CidadeDAO;
import br.com.ada.crud.model.cidade.dao.DAOException;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class CidadeBinaryDAO implements CidadeDAO {

    private final String DIRETORIO_RAIZ = "database/binario";
    private final String DIRETORIO_CIDADE = DIRETORIO_RAIZ + "/cidades";

    @Override
    public void cadastrar(Cidade cidade) {
        Path diretorio = Paths.get(DIRETORIO_CIDADE);

        if (!diretorio.toFile().exists()) {
            throw new RuntimeException("Diretório não disponível");
        }

        File file = new File(diretorio.toAbsolutePath().toString(), cidade.getId().toString() + ".dat");

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(cidade);
            objectOutputStream.flush();

            objectOutputStream.close();
            fileOutputStream.close();
        }
        catch (IOException ex) {
            throw new DAOException("Falha ao trabalhar os arquivos.", ex);
        }
    }

    @Override
    public List<Cidade> listar() {
        FilenameFilter filter = (dir, nome) -> nome.endsWith(".dat");

        List<Cidade> cidades = new ArrayList<>();
        File diretorio = new File(DIRETORIO_CIDADE);

        for (File arquivo : Objects.requireNonNull(diretorio.listFiles(filter))) {
            try {
                FileInputStream fileInputStream = new FileInputStream(arquivo);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

                Object object = objectInputStream.readObject();

                if (object instanceof Cidade) {
                    Cidade cidade = (Cidade) object;
                    cidades.add(cidade);
                }
            }
            catch (IOException | ClassNotFoundException ex) {
                throw new DAOException("Falha na leitura do arquivo " + arquivo.getAbsolutePath(), ex);
            }
        }

        return cidades;
    }

    @Override
    public Cidade ler(UUID id) {
        File arquivo = new File(DIRETORIO_CIDADE, id.toString() + ".dat");

        try {
            FileInputStream fileInputStream = new FileInputStream(arquivo);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            Object object = objectInputStream.readObject();

            if (object instanceof Cidade) {
                return (Cidade) object;
            }
            else {
                return null;
            }
        }
        catch (IOException | ClassNotFoundException ex) {
            throw new DAOException("Falha na leitura do arquivo " + arquivo.getAbsolutePath(), ex);
        }
    }

    @Override
    public void atualizar(UUID id, Cidade cidade) {
        File file = new File(DIRETORIO_CIDADE, id.toString() + ".dat");

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(cidade);
            objectOutputStream.flush();

            objectOutputStream.close();
            fileOutputStream.close();
        }
        catch (IOException ex) {
            throw new DAOException("Falha ao trabalhar os arquivos.", ex);
        }

    }

    @Override
    public Cidade deletar(UUID id) {
        Cidade cidade = ler(id);

        if (cidade != null) {
            File arquivo = new File(DIRETORIO_CIDADE, id.toString() + ".dat");
            arquivo.delete();
        }

        return cidade;
    }
}

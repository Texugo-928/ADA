package br.com.ada.crud.model.estado.dao.impl;

import br.com.ada.crud.model.estado.Estado;
import br.com.ada.crud.model.estado.dao.EstadoDAO;
import br.com.ada.crud.model.estado.dao.DAOException;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class EstadoBinaryDAO implements EstadoDAO {

    private final String DIRETORIO_RAIZ = "database/binario";
    private final String DIRETORIO_ESTADO = DIRETORIO_RAIZ + "/estados";

    @Override
    public void cadastrar(Estado estado) {
        Path diretorio = Paths.get(DIRETORIO_ESTADO);

        if (!diretorio.toFile().exists()) {
            throw new RuntimeException("Diretório não disponível");
        }

        File file = new File(diretorio.toAbsolutePath().toString(), estado.getId().toString() + ".dat");

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(estado);
            objectOutputStream.flush();

            objectOutputStream.close();
            fileOutputStream.close();
        }
        catch (IOException ex) {
            throw new DAOException("Falha ao trabalhar os arquivos.", ex);
        }
    }

    @Override
    public List<Estado> listar() {
        FilenameFilter filter = (dir, nome) -> nome.endsWith(".dat");

        List<Estado> estados = new ArrayList<>();
        File diretorio = new File(DIRETORIO_ESTADO);

        for (File arquivo : Objects.requireNonNull(diretorio.listFiles(filter))) {
            try {
                FileInputStream fileInputStream = new FileInputStream(arquivo);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

                Object object = objectInputStream.readObject();

                if (object instanceof Estado) {
                    Estado estado = (Estado) object;
                    estados.add(estado);
                }
            }
            catch (IOException | ClassNotFoundException ex) {
                throw new DAOException("Falha na leitura do arquivo " + arquivo.getAbsolutePath(), ex);
            }
        }

        return estados;
    }

    @Override
    public Estado ler(UUID id) {
        File arquivo = new File(DIRETORIO_ESTADO, id.toString() + ".dat");

        try {
            FileInputStream fileInputStream = new FileInputStream(arquivo);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            Object object = objectInputStream.readObject();

            if (object instanceof Estado) {
                return (Estado) object;
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
    public void atualizar(UUID id, Estado estado) {
        File file = new File(DIRETORIO_ESTADO, id.toString() + ".dat");

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(estado);
            objectOutputStream.flush();

            objectOutputStream.close();
            fileOutputStream.close();
        }
        catch (IOException ex) {
            throw new DAOException("Falha ao trabalhar os arquivos.", ex);
        }

    }

    @Override
    public Estado deletar(UUID id) {
        Estado estado = ler(id);

        if (estado != null) {
            File arquivo = new File(DIRETORIO_ESTADO, id.toString() + ".dat");
            arquivo.delete();
        }

        return estado;
    }
}

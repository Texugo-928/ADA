package br.com.ada.crud.model.pais.dao.impl;

import br.com.ada.crud.model.pais.Pais;
import br.com.ada.crud.model.pais.dao.PaisDAO;
import br.com.ada.crud.model.pais.dao.DAOException;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class PaisBinaryDAO implements PaisDAO {

    private final String DIRETORIO_RAIZ = "database/binario";
    private final String DIRETORIO_PAIS = DIRETORIO_RAIZ + "/paises";

    @Override
    public void cadastrar(Pais pais) {
        Path diretorio = Paths.get(DIRETORIO_PAIS);

        if (!diretorio.toFile().exists()) {
            throw new RuntimeException("Diretório não disponível");
        }

        File file = new File(diretorio.toAbsolutePath().toString(), pais.getId().toString() + ".dat");

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(pais);
            objectOutputStream.flush();

            objectOutputStream.close();
            fileOutputStream.close();
        }
        catch (IOException ex) {
            throw new DAOException("Falha ao trabalhar os arquivos.", ex);
        }
    }

    @Override
    public List<Pais> listar() {
        FilenameFilter filter = (dir, nome) -> nome.endsWith(".dat");

        List<Pais> paises = new ArrayList<>();
        File diretorio = new File(DIRETORIO_PAIS);

        for (File arquivo : Objects.requireNonNull(diretorio.listFiles(filter))) {
            try {
                FileInputStream fileInputStream = new FileInputStream(arquivo);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

                Object object = objectInputStream.readObject();

                if (object instanceof Pais) {
                    Pais pais = (Pais) object;
                    paises.add(pais);
                }
            }
            catch (IOException | ClassNotFoundException ex) {
                throw new DAOException("Falha na leitura do arquivo " + arquivo.getAbsolutePath(), ex);
            }
        }

        return paises;
    }

    @Override
    public Pais ler(UUID id) {
        File arquivo = new File(DIRETORIO_PAIS, id.toString() + ".dat");

        try {
            FileInputStream fileInputStream = new FileInputStream(arquivo);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            Object object = objectInputStream.readObject();

            if (object instanceof Pais) {
                return (Pais) object;
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
    public void atualizar(UUID id, Pais pais) {
        File file = new File(DIRETORIO_PAIS, id.toString() + ".dat");

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(pais);
            objectOutputStream.flush();

            objectOutputStream.close();
            fileOutputStream.close();
        }
        catch (IOException ex) {
            throw new DAOException("Falha ao trabalhar os arquivos.", ex);
        }

    }

    @Override
    public Pais deletar(UUID id) {
        //TODO: nao esta deletando
        Pais pais = ler(id);

        if (pais != null) {
            File arquivo = new File(DIRETORIO_PAIS, id.toString() + ".dat");
            arquivo.delete();
        }

        return pais;
    }
}

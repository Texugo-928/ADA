package br.com.ada.crud.model.estado.dao.impl;

import br.com.ada.crud.model.estado.Estado;
import br.com.ada.crud.model.estado.dao.EstadoDAO;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class EstadoXMLDao implements EstadoDAO {

    private final String DIRETORIO_RAIZ = "database/xml";
    private final String DIRETORIO_ESTADO = DIRETORIO_RAIZ + "/estados";

    @Override
    public void cadastrar(Estado estado) {
        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newDefaultInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();

            Document document = builder.newDocument();
            Element elementEstado = document.createElement("estado");
            document.appendChild(elementEstado);

            Element elementId = document.createElement("id");
            elementId.setTextContent(estado.getId().toString());
            elementEstado.appendChild(elementId);

            Element elementNomeEstado = document.createElement("nome_estado");
            elementNomeEstado.setTextContent(estado.getNome());
            elementEstado.appendChild(elementNomeEstado);

            Element elementSigla = document.createElement("sigla");
            elementSigla.setTextContent(estado.getSigla());
            elementEstado.appendChild(elementSigla);

            Element elementPais = document.createElement("pais");
            elementPais.setTextContent(estado.getPais());
            elementEstado.appendChild(elementPais);

            File arquivo = new File(DIRETORIO_ESTADO, estado.getId().toString() + ".xml");
            try (FileOutputStream output = new FileOutputStream(arquivo)) {
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");

                DOMSource source = new DOMSource(document);
                StreamResult result = new StreamResult(output);

                transformer.transform(source, result);
            } catch (IOException | TransformerException e) {
                throw new RuntimeException(e);
            }
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Estado> listar() {
        FilenameFilter filter = (dir, nome) -> nome.endsWith(".xml");
        File diretoRaiz = new File(DIRETORIO_ESTADO);
        List<Estado> estados = new ArrayList<>();
        for (File arquivo : diretoRaiz.listFiles(filter)) {
            try {
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();

                Document document = builder.parse(arquivo);

                Element elementEstado = document.getDocumentElement();
                Node elementId = elementEstado.getElementsByTagName("id").item(0);
                Node elementNomeEstado = elementEstado.getElementsByTagName("nome_estado").item(0);
                Node elementSigla = elementEstado.getElementsByTagName("sigla").item(0);
                Node elementPais = elementEstado.getElementsByTagName("pais").item(0);

                Estado estado = new Estado();
                estado.setId(UUID.fromString(elementId.getTextContent()));
                estado.setNome(elementNomeEstado.getTextContent());
                estado.setSigla(elementSigla.getTextContent());
                estado.setPais(elementPais.getTextContent());

                estados.add(estado);
            } catch (ParserConfigurationException | SAXException | IOException e) {
                throw new RuntimeException(e);
            }
        }
        return estados;
    }

    @Override
    public Estado ler(UUID id) {
        File arquivo = new File(DIRETORIO_ESTADO, id.toString() + ".xml");
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(arquivo);
            Element elementEstado = document.getDocumentElement();
            Node elementId = elementEstado.getElementsByTagName("id").item(0);
            Node elementNomeEstado = elementEstado.getElementsByTagName("nome_estado").item(0);
            Node elementSigla = elementEstado.getElementsByTagName("sigla").item(0);
            Node elementPais = elementEstado.getElementsByTagName("pais").item(0);

            Estado estado = new Estado();
            estado.setId(UUID.fromString(elementId.getTextContent()));
            estado.setNome(elementNomeEstado.getTextContent());
            estado.setSigla(elementSigla.getTextContent());
            estado.setPais(elementPais.getTextContent());

            return estado;
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void atualizar(UUID id, Estado estado) {
        File arquivo = new File(DIRETORIO_ESTADO, id.toString() + ".xml");
        arquivo.delete();

        estado.setId(id);

        cadastrar(estado);
    }

    @Override
    public Estado deletar(UUID id) {
        Estado estado = ler(id);
        if (estado != null) {
            File arquivo = new File(DIRETORIO_ESTADO, id.toString() + ".xml");
            arquivo.delete();
        }
        return estado;
    }
}

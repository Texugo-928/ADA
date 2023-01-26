package br.com.ada.crud.model.cidade.dao.impl;

import br.com.ada.crud.model.cidade.Cidade;
import br.com.ada.crud.model.cidade.dao.CidadeDAO;

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

public class CidadeXMLDao implements CidadeDAO {

    private final String DIRETORIO_RAIZ = "database/xml";
    private final String DIRETORIO_CIDADE = DIRETORIO_RAIZ + "/cidades";

    @Override
    public void cadastrar(Cidade cidade) {
        try {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newDefaultInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();

        Document document = builder.newDocument();
        Element elementCidade = document.createElement("cidade");
        document.appendChild(elementCidade);

        Element elementId = document.createElement("id");
        elementId.setTextContent(cidade.getId().toString());
        elementCidade.appendChild(elementId);

        Element elementNomeCidade = document.createElement("nome_cidade");
        elementNomeCidade.setTextContent(cidade.getNome());
        elementCidade.appendChild(elementNomeCidade);

        Element elementEstadoSigla = document.createElement("estado_sigla");
        elementEstadoSigla.setTextContent(cidade.getEstadoSigla());
        elementCidade.appendChild(elementEstadoSigla);

        File arquivo = new File(DIRETORIO_CIDADE, cidade.getId().toString() + ".xml");
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
    public List<Cidade> listar() {
        FilenameFilter filter = (dir, nome) -> nome.endsWith(".xml");
        File diretoRaiz = new File(DIRETORIO_CIDADE);
        List<Cidade> cidades = new ArrayList<>();
        for (File arquivo : diretoRaiz.listFiles(filter)) {
            try {
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();

                Document document = builder.parse(arquivo);

                Element elementCidade = document.getDocumentElement();
                Node elementId = elementCidade.getElementsByTagName("id").item(0);
                Node elementNomeCidade = elementCidade.getElementsByTagName("nome_cidade").item(0);
                Node elementEstadoSigla = elementCidade.getElementsByTagName("estado_sigla").item(0);

                Cidade cidade = new Cidade();
                cidade.setId(UUID.fromString(elementId.getTextContent()));
                cidade.setNome(elementNomeCidade.getTextContent());
                cidade.setEstadoSigla(elementEstadoSigla.getTextContent());

                cidades.add(cidade);
            } catch (ParserConfigurationException | SAXException | IOException e) {
                throw new RuntimeException(e);
            }
        }
        return cidades;
    }

    @Override
    public Cidade ler(UUID id) {
        File arquivo = new File(DIRETORIO_CIDADE, id.toString() + ".xml");
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(arquivo);
            Element elementCidade = document.getDocumentElement();
            Node elementId = elementCidade.getElementsByTagName("id").item(0);
            Node elementNomeCidade = elementCidade.getElementsByTagName("nome_cidade").item(0);
            Node elementEstadoSigla = elementCidade.getElementsByTagName("estado_sigla").item(0);

            Cidade cidade = new Cidade();
            cidade.setId(UUID.fromString(elementId.getTextContent()));
            cidade.setNome(elementNomeCidade.getTextContent());
            cidade.setEstadoSigla(elementEstadoSigla.getTextContent());
            return cidade;
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void atualizar(UUID id, Cidade cidade) {
        File arquivo = new File(DIRETORIO_CIDADE, id.toString() + ".xml");
        arquivo.delete();

        cidade.setId(id);

        cadastrar(cidade);
    }

    @Override
    public Cidade deletar(UUID id) {
        Cidade cidade = ler(id);
        if (cidade != null) {
            File arquivo = new File(DIRETORIO_CIDADE, id.toString() + ".xml");
            arquivo.delete();
        }
        return cidade;
    }
}

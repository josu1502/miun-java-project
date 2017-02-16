package com.miun.appguestbook.josu1502.appguestbook;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by Joakim on 17-02-07.
 */

public class MessageBuilder {

    private InputStream inStream;
    private Document doc;

    public MessageBuilder(InputStream inStream) {

        this.inStream = inStream;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = dbf.newDocumentBuilder();
            doc = documentBuilder.parse(inStream);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Message getMessage() {
        Message message = new Message("", "");
        NodeList messages = doc.getElementsByTagName("name");
        Node item = messages.item(0);
        message.setMessage(item.getTextContent());

        messages = doc.getElementsByTagName("price");
        item = messages.item(0);
        message.setName(item.getTextContent());

        return message;
    }

    public List<Message> getMessages() {
        List<Message> messageList = new ArrayList<>();
        NodeList day = doc.getElementsByTagName("lunchday");
        NodeList messages = doc.getElementsByTagName("name");
        NodeList desc = doc.getElementsByTagName("description");
        NodeList names = doc.getElementsByTagName("price");

        for (int i = 0; i < messages.getLength(); i++) {
            Node messageItem = messages.item(i);
            Node nameItem = names.item(i);

            messageList.add(new Message(nameItem.getTextContent(),messageItem.getTextContent()));
        }

        return messageList;
    }

}

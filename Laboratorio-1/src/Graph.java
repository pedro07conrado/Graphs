package src;

import java.util.LinkedList;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class Graph {
    private int V ;           
    private int E;                 
    private LinkedList<Integer>[] adj;  

    public Graph(int v) {
        this.V = v;  
        this.E = 0;  
        adj = (LinkedList<Integer>[]) new LinkedList[v];  

        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public Graph(File inputFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("node");
            
            adj = (LinkedList<Integer>[]) new LinkedList[nodeList.getLength()];  
            this.V = nodeList.getLength();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    adj[i] = new LinkedList<>();

                }
            }

            NodeList edgeList = doc.getElementsByTagName("edge");
            for (int i = 0; i < edgeList.getLength(); i++) {
                Node edge = edgeList.item(i);
                if (edge.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) edge;
                    int source = (int) Double.parseDouble(element.getAttribute("source"));
                    int target = (int )Double.parseDouble(element.getAttribute("target"));
                    this.addEdge(source,target);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);  
        adj[w].add(v);  
        E++;  
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void printGraph() {
        for (int v = 0; v < V; v++) {
            System.out.print(v + ": ");
            for (int w : adj[v]) {
                System.out.print(w + " ");
            }
            System.out.println();
        }
    }

}

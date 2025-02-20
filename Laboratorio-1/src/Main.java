package src;

import java.io.File;

public class Main {  
    public static void main(String[] args) {

        File inputFile = new File(args[0]);

        Graph G = new Graph(inputFile);  
        Graphcalculator GraphCalculator = new Graphcalculator(G);

        System.out.println("\n|-----------------Betweenness Centrality-----------------|\n");
        GraphCalculator.calculateBetweennessCentrality();
        GraphCalculator.printbetweennessCentrality();
        GraphCalculator.saveBetweennessCentralityToFile("saida.txt");

       
    }
}

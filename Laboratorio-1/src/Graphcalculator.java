package src;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;
public class Graphcalculator {
    private float[] betweennessCentrality; 
    private Graph G;

    public Graphcalculator(Graph G) {
        this.betweennessCentrality = new float[G.V()];
        this.G = G;
    }

    public void calculateBetweennessCentrality() {
        int V = G.V();
        float[] betweenness = new float[V]; 

    
        for (int s = 0; s < V; s++) {
            boolean[] marked = new boolean[V];
            int[] distTo = new int[V];
            int[] pathCount = new int[V]; 
            Stack<Integer> stack = new Stack<>(); 
            List<Integer>[] predecessors = new List[V]; 

            for (int i = 0; i < V; i++) {
                distTo[i] = Integer.MAX_VALUE; 
                pathCount[i] = 0; 
                predecessors[i] = new ArrayList<>(); 
            }

         
            marked[s] = true;
            distTo[s] = 0;
            pathCount[s] = 1; 
            Queue<Integer> queue = new LinkedList<>();
            queue.add(s);

            // Executa a BFS
            while (!queue.isEmpty()) {
                int v = queue.poll();
                stack.push(v); 

                for (int w : G.adj(v)) {
                    if (!marked[w]) {
                        marked[w] = true;
                        distTo[w] = distTo[v] + 1;
                        queue.add(w);
                    }

                 
                    if (distTo[w] == distTo[v] + 1) {
                        pathCount[w] += pathCount[v];
                        predecessors[w].add(v);
                    }
                }
            }

            
            float[] delta = new float[V]; 
            while (!stack.isEmpty()) {
                int w = stack.pop();
                for (int v : predecessors[w]) {
                    delta[v] += (float) pathCount[v] / pathCount[w] * (1 + delta[w]);
                }
                if (w != s) {
                    betweenness[w] += delta[w];
                }
            }
        }

 
      
        for (int v = 0; v < V; v++) {
            betweenness[v] /= ((V - 1) * (V - 2) / 1);
        }
      

        this.betweennessCentrality = betweenness;
    }


    public float[] getBetweennessCentrality() {
        return betweennessCentrality;
    }
    public void printbetweennessCentrality() {
        DecimalFormat df = new DecimalFormat("0.######");
        for (int v = 0; v < this.betweennessCentrality.length; v++) {
            String formattedValue = df.format(betweennessCentrality[v]);
            System.out.println("Vértice: " + v + " centralidade: " + formattedValue);
        }
    }

    public void saveBetweennessCentralityToFile(String fileName) {
        DecimalFormat df = new DecimalFormat("0.######");
        try (FileWriter writer = new FileWriter(fileName)) {
            for (int v = 0; v < this.betweennessCentrality.length; v++) {
                String formattedValue = df.format(betweennessCentrality[v]);
                writer.write("Vértice: " + v + " centralidade: " + formattedValue + "\n");
            }
            System.out.println("Dados salvos em: " + fileName);
        } catch (IOException e) {
            System.err.println("Erro ao salvar o arquivo: " + e.getMessage());
        }
    }

}
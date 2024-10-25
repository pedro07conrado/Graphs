package Introduction;
import java.util.ArrayList;

// Here I'm creating generic class
public class Grafos<T> {
    private ArrayList<T> Vertices; 
    private ArrayList<T> arestas; 

    public Grafos(){
        this.Vertices = new ArrayList<T>();
        this.arestas = new ArrayList<T>(); 
    }

    public void AddVertices(T dado){
         
    }

    public void AddArestas(T inicio, T fim){
        
    }
}

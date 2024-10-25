package Introduction;

import java.util.ArrayList;

public class Vertices<T> {
    private T dado;
    private ArrayList<T> EntradaAresta;
    private ArrayList<T> SaidaAresta;    
    
    public Vertices(T valor) {
        this.dado = valor; 
        this.EntradaAresta = new ArrayList<T>();
        this.SaidaAresta = new ArrayList<T>();
    }

    public T getDado() {
        return dado;
    }

    public void setDado(T dado){
         this.dado = dado;  
    }

    public void AdicionarArestaEntrada(Aresta<T> aresta){
        this.EntradaAresta.add(dado);
    }
    public void AdicionarArestaSaida(Aresta<T> aresta){
        this.SaidaAresta.add(dado);
    }
    
}

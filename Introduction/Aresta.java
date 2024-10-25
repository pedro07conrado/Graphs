package Introduction;

import java.util.ArrayList;

public class Aresta<T>{
    private Vertices<T> inicio; 
    private Vertices<T> fim; 

    public Aresta(){
        this.inicio = inicio; 
        this.fim = fim; 
    }
    
    public Vertices<T> getInicio() {
        return inicio;
    }

    public void SetInicio(Vertices<T> inicio){
        this.inicio = inicio; 
    }
    public Vertices<T> getFim() {
        return fim;
    }
    public void setFim(Vertices<T> fim) {
        this.fim = fim;
    }
}

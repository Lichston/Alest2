import java.util.Set;

public class ListaEncadeada{

    private Nodo inicio;
    private Nodo fim;
    private int tamanho;
    private int contFusoes;

        private class Nodo{
            
            char dna;
            Nodo proximo;
            Nodo anterior;
            public Nodo(char dna){
                
                this.dna = dna;
                this.proximo = null;
                this.anterior = null;
            }

        }

    
    public ListaEncadeada(){
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    public void esvaziar(){
        this.tamanho = 0;
        this.inicio = null;
        this.fim = null;
    }

    public boolean estaVazia(){
        return ((this.tamanho==0 && inicio == null && fim == null));
    }

    public void adiciona(String sDNA){
        
        for(int i=0;i<sDNA.length();i++){

        Nodo novoNodo = new Nodo(sDNA.charAt(i));
        
        if(estaVazia() == true){
            this.inicio = novoNodo;
            this.fim = novoNodo;
            tamanho++;
        }
        else adicionaRecursivo(this.inicio , novoNodo);
        }        
    }

    public void adicionaNoFim(Nodo novoNodo){       
        this.fim.proximo = novoNodo;
        novoNodo.anterior = this.fim;
        this.fim = novoNodo;
        tamanho++;
    }        
    

    private void adicionaRecursivo(Nodo nodo, Nodo novoNodo){

        if(nodo.equals(this.inicio)){
            if(nodo.proximo == null){ this.fim = novoNodo; this.inicio.proximo = novoNodo; novoNodo.anterior = this.inicio; tamanho++;}
            else if(nodo.proximo != null) adicionaRecursivo(nodo.proximo, novoNodo);
        }
        else {adicionaNoFim(novoNodo);}

    } 


    public Nodo existe(Nodo nodo){

        if(estaVazia()) return null;

        return existeRecursivo(inicio, nodo );

    }

    private Nodo existeRecursivo(Nodo aux, Nodo nodo){

        if(nodo.equals(nodo)) return nodo;
        else return existeRecursivo(nodo.proximo, nodo);
        
    }

    public void remove(Nodo nodo){

        if (existe(nodo) != null){removeRecursivo(this.inicio, nodo);}

    }

    public void removeRecursivo(Nodo aux, Nodo nodo){

        if(aux.equals(this.inicio)){

            if(aux.equals(nodo)){
                aux.proximo.anterior = null;
                inicio = aux.proximo;
            }
            else removeRecursivo(aux.proximo, nodo );

        }

        else if (aux.equals(this.fim)){
            if(aux.equals(nodo) ){ aux.anterior.proximo = null; fim = aux.anterior;  }
        }

    
        else{
            if (aux.equals(nodo)){ aux.anterior.proximo = aux.proximo; aux.proximo.anterior = aux.anterior; }
            else removeRecursivo(aux.proximo, nodo);
        }

    }         

    

    public void fusao(){        
        if((estaVazia() == false)) fusaoRecursiva(this.inicio);
    }    

    private void fusaoRecursiva(Nodo nodo){


        if((nodo.proximo != null)){
            if(nodo.dna != nodo.proximo.dna) {
                
                String aux = "DNA";
                
                char c1 = nodo.dna;
                char c2 = nodo.proximo.dna;



                aux = aux.replace(Character.toString(c1 + c2), "");

                adicionaNoFim(new Nodo(aux.charAt(0)));
                remove(nodo);
                remove(nodo.proximo);
                contFusoes++;
                fusaoRecursiva(this.inicio);

            }
            else {
                fusaoRecursiva(nodo.proximo);
            }
        }

        else {}

    }  

    public int getContFusoes() {
        return contFusoes;
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        Nodo current = this.inicio;

        while (current != null) {
            sb.append(current.dna);
            if (current.proximo != null) {
                sb.append(" -> ");
            }
            current = current.proximo;
        }

        return sb.toString();
    }
}



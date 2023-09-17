
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
        return ((this.tamanho==0));
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
    }        
    

    private void adicionaRecursivo(Nodo nodo, Nodo novoNodo){

        if(nodo.equals(this.inicio)){
            if(nodo.proximo == null){ this.fim = novoNodo; this.inicio.proximo = novoNodo; novoNodo.anterior = this.inicio;}
            else if(nodo.proximo != null) adicionaRecursivo(nodo.proximo, novoNodo);
        }
        else if(nodo.equals(this.fim)){
            nodo.proximo = novoNodo; novoNodo.anterior = nodo; this.fim = novoNodo;
        }
        else
            adicionaRecursivo(nodo.proximo, novoNodo);

    } 


    public Nodo existe(char dna){

        if(estaVazia()) return null;

        return existeRecursivo(inicio, dna);

    }

    private Nodo existeRecursivo(Nodo nodo, char dna){

        if(nodo.dna == dna) return nodo;
        else return existeRecursivo(nodo.proximo, dna);
        
    }

    public void remove(char dna){

        if (existe(dna) != null){removeRecursivo(this.inicio, dna);}

    }

    public void removeRecursivo(Nodo nodo, char dna){

        if(nodo.equals(this.inicio)){

            if(nodo.dna == dna){
                Nodo aux = inicio.proximo;
                inicio = aux;
                inicio.anterior = null;
            }
            else removeRecursivo(nodo.proximo, dna);

        }

        else if((nodo.anterior != null) && (nodo.proximo != null)){
            if (nodo.dna == dna){ nodo.anterior = nodo.proximo; nodo.proximo = nodo.anterior; }
            else removeRecursivo(nodo.proximo, dna);
        }

        else if (nodo.equals(this.fim)){
            if(nodo.dna == dna){ this.fim = nodo.anterior; }
        }

    }         

    

    public void fusao(){        
        if(estaVazia() == false) fusaoRecursiva(this.inicio);
    }    

    private void fusaoRecursiva(Nodo nodo){


        if((nodo.proximo != null)){
            if(nodo.dna == nodo.proximo.dna) fusaoRecursiva(nodo.proximo);
            else {
                String aux = "DNA";

                aux.replaceAll(Character.toString(nodo.dna), "");
                aux.replaceAll(Character.toString(nodo.proximo.dna), "");

                adicionaNoFim(new Nodo(aux.charAt(0)));
                remove(nodo.dna);
                remove(nodo.proximo.dna);
                contFusoes++;
                fusaoRecursiva(this.inicio);
            }
        }

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



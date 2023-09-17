
public class ListaEncadeada{

    private Nodo inicio;
    private Nodo fim;
    private int tamanho;

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

    
    public ListaEncadeada(String sDNA){
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
        else if(this.inicio == this.fim){this.fim.proximo = novoNodo; this.fim = novoNodo; this.fim.anterior = inicio;}

        else adicionaRecursivo(this.inicio , novoNodo);
        }        
    }

    private void adicionaRecursivo(Nodo Nodo, Nodo novoNodo){

        

    } 

    public void fusao(){        
        if(estaVazia() == false) fusaoRecursiva(inicio);
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

        if (existe(dna) != null){

        }

    }

    private void fusaoRecursiva(Nodo nodo){

        if((nodo.proximo != null)){
            if(nodo.dna == nodo.proximo.dna) fusaoRecursiva(nodo.proximo);
            else {
                String aux = "DNA";

                aux.replaceAll(Character.toString(nodo.dna), "");
                aux.replaceAll(Character.toString(nodo.proximo.dna), "");

                adiciona(new Nodo(aux.charAt(0)));
            }
        }

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

public class ListaEncadeada{

    private Nodo inicio;
    private Nodo fim;
    private int tamanho;

        private class Nodo{
            
            char dna;
            Nodo proximo;

            public Nodo(char dna){
                
                this.dna = dna;

            }

        }

    
    public ListaEncadeada(String sDNA){
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
        adiciona(sDNA);
    }

    public void esvaziar(){
        this.tamanho = 0;
        this.inicio = null;
        this.fim = null;
    }

    public boolean estaVazia(){
        return ((this.tamanho==0));
    }

    private void adiciona(String sDNA){
        
        for(int i=0;i<sDNA.length();i++){

        Nodo novoNodo = new Nodo(sDNA.charAt(i));
        
        if(estaVazia() == true){
            this.inicio = novoNodo;
            this.fim = novoNodo;
            tamanho++;
        }
        else if(this.fim.proximo == null){ fim.proximo = novoNodo; fim = novoNodo;}
        }
    }

    private void fusao(){
        
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
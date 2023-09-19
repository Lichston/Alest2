
public class ListaEncadeada{

    private Nodo inicio;
    private Nodo fim;
    private int tamanho;
    private int contFusoes;
    private long tempoMS;
    private String tempo;

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
            this.tamanho++;
        }
        else adicionaNoFim(novoNodo);
        }        
    }

    public void adicionaNoFim(Nodo novoNodo){       
        this.fim.proximo = novoNodo;
        this.fim.proximo.anterior = this.fim;
        this.fim = novoNodo;
        this.tamanho++;
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
                inicio = aux.proximo;            }
            else removeRecursivo(aux.proximo, nodo );

        }

        else if (aux.equals(this.fim)){
            if(aux.equals(nodo) ){ aux.anterior.proximo = null; fim = aux.anterior;  }
        }

    
        else{
            if (aux.equals(nodo)){ aux.anterior.proximo = aux.proximo; aux.proximo.anterior = aux.anterior;  }
            else removeRecursivo(aux.proximo, nodo);
        }

    }         

    

    public void fusao(){        

        long tempoInicial = System.currentTimeMillis();        
        Nodo nodo = this.inicio;
        
        for(int i = 0; i<tamanho; i++){
            
            if(nodo.proximo != null){


                if(nodo.dna != nodo.proximo.dna){

                    String aux = "DNA";
                
                    char c1 = nodo.dna;
                    char c2 = nodo.proximo.dna;



                    aux = aux.replace(Character.toString(c1), "");
                    aux = aux.replace(Character.toString(c2), "");

                    adicionaNoFim(new Nodo(aux.charAt(0)));
                    remove(nodo);
                    remove(nodo.proximo);
                    contFusoes++;

                    this.tamanho = this.tamanho - 2;

                    nodo = this.inicio;
                }

                else if(nodo.dna == nodo.proximo.dna){
                    nodo = nodo.proximo;
                }
            }
            


        }

        if(!(tudoIgual())){fusao();}

        long tempoFinal =  System.currentTimeMillis() - tempoInicial;
        setTempoMS(this.tempoMS + tempoFinal);
        setTempo(tempoMS + "ms");

    }    


    private boolean tudoIgual(){
        Nodo aux = this.inicio;
        int verificador = 0;

        for(int i=0; i<tamanho ; i++){

            if(aux.equals(this.fim)){
            }
            else if(aux.dna == aux.proximo.dna){
                verificador++;
                aux = aux.proximo;
            }
        }

        if(verificador >= tamanho - 1) return true;
        return false;

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

    public int getTamanho() {
        return tamanho;
    }

    public long getTempoMS() {
        return tempoMS;
    }

    public String getTempo() {
        return tempo;
    }

    public void setTempo(String tempo) {
        this.tempo = tempo;
    }

    private void setTempoMS(long tempoMS) {
        this.tempoMS = tempoMS;
    }

    
}



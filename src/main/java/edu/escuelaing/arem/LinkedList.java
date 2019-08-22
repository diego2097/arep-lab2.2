package edu.escuelaing.arem;

/**
 *Clase que representa un linkedlist 
 * @author Diego Corredor
 */
public class LinkedList<T>{
    
    private Head head; 

    public LinkedList() {
        this.head = new Head(null,null);
    }
    
    /**
     * Este metodo se encarga de agregar nodos al linkedlist
     * @param data el dato del nuevo nodo
     */
    public void add(T data){
        Node node = new Node(null,null,data); 
        if (head.getFirst()==null){
            head.setFirst(node);
            head.setLast(node);
        }
        else{
            if (head.getFirst().getNext()==null){
                head.getFirst().setNext(node);
            }
            head.getLast().setNext(node);
            node.setPrevious(head.getLast());
            head.setLast(node);
        }
    }
    
    /**
     * Este metodo obtiene el nodo en la posicion espesificada
     * @param i El index del nodo que se desea obtener
     * @return T El objeto que se encuentre en dicho nodo
     */
    public T get(int i){
        if(i > size()){
           throw new IndexOutOfBoundsException();
        }
        int n=0;
        Node node = head.getFirst();
        while(i!=n){
            node = node.getNext();
            n++;
        }
        return (T)node.getData();
    }
    
    /**
     * Este metodo calcula la longitud del linkedlist
     * @return int retorna la longitud del linkedlist 
     */
    public int size(){
        Node first = head.getFirst();
        int n=0;
        while(first!=null){
            first = first.getNext();
            n++;
        }
        return n;
    }
    
    public Head getHead() {
        return head;
    }
    
    public void setHead(Head head) {
        this.head = head;
    }   
}
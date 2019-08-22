package edu.escuelaing.arem;

/**
 * Esta clase representa un nodo 
 * @author Diego Corredor
 */
public class Node<T> {

     
    private Node previous;
    private Node next;
    private T data; 
    
    
    public Node(Node previous, Node next, T data) {
        this.previous = previous;
        this.next = next;
        this.data = data;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

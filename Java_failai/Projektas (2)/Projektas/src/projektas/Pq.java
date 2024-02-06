/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projektas;

/**
 *
 * @author Martynas
 * @param <E>
 */
public class Pq<E> implements PriorityQueue<E> {
    // Node class to represent the elements in the queue
    private static class Node<E> {
        private E element;
        int priority;
        Node<E> next;

        public Node(E element, int priority) {
            this.element = element;
            this.priority = priority;
        }
    }

    private Node<E> head;  // Reference to the head of the queue

    public Pq() {
        head = null;
    }

    /**
     * Adds element by  priority
     * @param element
     * @param priority 
     */
    @Override
    public void add(E element, int priority) {

        Node newNode = new Node(element, priority);

        // If the queue is empty, set the new node as the head of the queue
        if (head == null) {
            head = newNode;
            return;
        }      
        // If the new node has the highest priority, set it as the new head of the queue
        if (priority > head.priority) {
            newNode.next = head;
            head = newNode;
            return;
        }

        // Find the correct position for the new node in the queue based on its priority
        Node current = head;
        while (current.next != null && priority <= current.next.priority) {
            current = current.next;
        }

        // Insert the new node after the current node
        newNode.next = current.next;
        current.next = newNode;
    }
    
    /**
     * prints priority queue
     */
    public void print() {
    Node<E> curr = head;
    while (curr != null) {
        System.out.println(curr.element + " (priority: " + curr.priority + ")");
        curr = curr.next;
    }
}

    /**
     * 
     * @return element that has highest priority and removes it
     */
public E poll()
{
        if (isEmpty()) return null;

        // remove the first node from the linked list
        Node<E> node = head;
        head = head.next;
        

        return node.element;
}

    /**
     *
     * @return element that has highest priority
     */
    @Override
    public E peek() {
        return head.element;
    }

    /**
     * 
     * @return size of th queue
     */
    public int size() {
        int size = 0;

        // Iterate through the queue and count the number of elements
        Node<E> current = head;
        while (current != null) {
            size++;
            current = current.next;
        }

        return size;
    }

    /**
     * Checks if the queue is empty
     * @return 
     */
    @Override
    public boolean isEmpty() {
        return head == null;
    }
    
    /**
     * Checks if the queue contains element
     * @param element
     * @return 
     */
    @Override
    public boolean Contains(E element){
        Node<E> current = head;
        while(current !=null){
            if(current.element == element){
                return true;               
            }
            current = current.next;
        }return false;         
    }
    /**
     * Clears the queue
     */
    @Override
    public void clear(){
        head = null;
        head = head.next;
    }
}


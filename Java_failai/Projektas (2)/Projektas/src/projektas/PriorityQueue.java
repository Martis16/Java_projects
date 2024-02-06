/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package projektas;

/**
 *
 * @author Martynas
 */
public interface PriorityQueue<E> {
    
   void add(E element, int priority);
    
    E poll();
    
    E peek();
    
    void clear();
    
    boolean isEmpty();
    
    boolean Contains(E element);
}


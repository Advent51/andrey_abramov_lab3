package com.adventorium.utils;

import java.util.ListIterator;

/**
 * Created by Андрей on 08.05.2016.
 */
public class TypeChanger<E extends Comparable,T extends Comparable> {

    public void apply(DoublyLinkedList<E> inputted, DoublyLinkedList<T> newList) {
        //DoublyLinkedList<T> newList = new DoublyLinkedList();
        for(ListIterator<E> i = inputted.listIterator(0); i.hasNext(); ) {
            E item = i.next();
            T itemCasted = ((T) item);
            newList.add(itemCasted);
        }
        //return newList;
    }
}

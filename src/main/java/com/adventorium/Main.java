package com.adventorium;

import com.adventorium.utils.DoublyLinkedList;
import com.adventorium.utils.TypeChanger;

import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * Created by Андрей on 05.05.2016.
 */
public class Main {

    public static void main(String[] args) {

        DoublyLinkedList<Integer> dll = new DoublyLinkedList();
        //LinkedList<Integer> dll = new LinkedList();

        System.out.println("Добавляем");

        dll.add(15);
        dll.add(30);
        dll.add(64);
        dll.add(0, 1);
        dll.add(4, 1);
        dll.add(4, 1);

        printItMovingForwardWithIterator(dll);
        printItMovingForwardWithIterator(dll, 10);

        System.out.println("Получим размер листа: " + dll.size());

        dll.remove(0);
        dll.remove((Integer)15);
        dll.remove((Integer) 30);

        System.out.println("После удаления:");
        printItMovingForwardWithIterator(dll);

        System.out.println("Изменим один элемент на 1000:");
        dll.set(1, 1000);
        printItMovingForwardWithIterator(dll);

        System.out.println("Получим первый элемент: " + dll.get(0));
        printItMovingForwardWithIterator(dll);
        printItMovingForwardWithIterator(dll, 10);

        System.out.println("Итератор");

        Iterator<Integer> itr = dll.iterator();
        System.out.println("Удалим первый элемент:");
        itr.next();
        itr.remove();
        printItMovingForwardWithIterator(dll);

        System.out.println("Продемонстируем работу цикличности при помощи iterator.next:");
        printItMovingForwardWithIterator(dll, 5);
        System.out.println("Продемонстируем работу foreach:");
        printItMovingForwardWithIterator(dll);

        System.out.println("Listerator");

        ListIterator<Integer> listItr = dll.listIterator(0);

        System.out.println("Add 15");
        listItr.add(15);
        printItMovingForwardWithIterator(dll);
        System.out.println("Set next to 25");
        listItr.next();
        listItr.set(25);
        printItMovingForwardWithIterator(dll);

        printItMovingBackWithListIterator(dll);
        printItMovingBackWithListIterator(dll, 10);
        printItMovingForwardWithListIterator(dll);
        printItMovingForwardWithListIterator(dll, 10);

        System.out.println("Size: "+dll.size());
        Integer[] array = new Integer[dll.size()];
        dll.toArray(array);
        System.out.println("To array");
        System.out.println(Arrays.toString(array));

        System.out.println("Before sorting");
        printItMovingForwardWithListIterator(dll);
        dll.sort(null);
        System.out.println("After sorting");
        printItMovingForwardWithListIterator(dll);

        printIt(dll);

        System.out.println("Mapping doesn't work yet");
        /*System.out.println("CHANGING TYPE");
        TypeChanger<Integer, Float> typeChanger = new TypeChanger<Integer, Float>();
        DoublyLinkedList<Float> newList = new DoublyLinkedList<Float>();
        //dll.map(typeChanger, newList);
        typeChanger.apply(dll,newList);
        //printIt(newList);

        System.out.println("Новый лист в новом формате:");
        for(Iterator<Float> i = newList.iterator(); i.hasNext();){
            Float item = i.next();
            System.out.print(item +"  ");
        }
        System.out.println();*/
    }

    public static void printItMovingForwardWithIterator(DoublyLinkedList dll, int times){
        Iterator<Object> iterator = dll.iterator();
        Object value = null;
        System.out.println("It will print "+times+" elements from first using x.next:");
        for(int i = 0; i<times; i++) {
            value = iterator.next();
            System.out.print(value + "  ");
        }
        System.out.println();
    }

    public static void printItMovingForwardWithIterator(DoublyLinkedList dll){
        System.out.println("It will print foreach:");
        for(Iterator<Object> i = dll.iterator(); i.hasNext(); ) {
            Object item = i.next();
            System.out.print(item +"  ");
        }
        System.out.println();
    }

    public static void printItMovingForwardWithListIterator(DoublyLinkedList dll, int times){
        ListIterator<Object> listIterator = dll.listIterator(0);
        Object value = null;
        System.out.println("It will print "+times+" elements from first using x.next and listerator:");
        for(int i = 0; i<times; i++) {
            value = listIterator.next();
            System.out.print(value + "  ");
        }
        System.out.println();
    }

    public static void printItMovingForwardWithListIterator(DoublyLinkedList dll){
        System.out.println("It will print foreach with listerator:");
        for(ListIterator<Object> i = dll.listIterator(0); i.hasNext(); ) {
            Object item = i.next();
            System.out.print(item +"  ");
        }
        System.out.println();
    }

    public static void printItMovingBackWithListIterator(DoublyLinkedList dll, int times){
        ListIterator<Object> listIterator = dll.listIterator(dll.size());
        Object value = null;
        System.out.println("It will print "+times+" elements from last using x.prev:");
        for(int i = 0; i<times; i++) {
            value = listIterator.previous();
            System.out.print(value + "  ");
        }
        System.out.println();
    }

    public static void printItMovingBackWithListIterator(DoublyLinkedList dll){
        System.out.println("It will print foreach with listerator moving back:");
        for(ListIterator<Object> i = dll.listIterator(dll.size()); i.hasPrevious(); ) {
            Object item = i.previous();
            System.out.print(item +"  ");
        }
        System.out.println();
    }

    public static void printIt(DoublyLinkedList dll){
        System.out.println("EXTRA BACK:");
        ListIterator<Object> i = dll.listIterator(dll.size());
        for( Object c : dll) {
            Object item = i.previous();
            System.out.print(item +"  ");
        }
        System.out.println();
    }
}

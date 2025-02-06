package org.example.list;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListImpl {

    public static void main(String[] args) {
        LinkedList<String> placesToVisit = new LinkedList<>();
        var placesToVisitNew = new LinkedList<String>();

        placesToVisit.add("Sydney");
        placesToVisit.add(0, "Canberra");
        System.out.println(placesToVisit);
        addMoreElements(placesToVisit);
        System.out.println(placesToVisit);
        removeElements(placesToVisit);
        System.out.println(placesToVisit);

        getElements(placesToVisit);
        iterateOver(placesToVisit);
        testIterator(placesToVisit);


    }

    private static void testIterator(LinkedList<String> list) {
        var itr = list.listIterator();

        itr.add("Lake Wivenhoe");
        while (itr.hasNext()) {
            System.out.println(itr.next());
            if (itr.next().equals("Brisbane")) {
                itr.remove();
            }
        }
        System.out.println(list);

        while (itr.hasPrevious()) {
            System.out.println(itr.previous());
        }
        System.out.println(list);

        var itr2 = list.listIterator(3); // starts iteration from 3rd index
        System.out.println(itr2.next());
    }

    public static void iterateOver(LinkedList<String> list) {
        list.push("Sydney");
        list.push("QUeensland");
        list.push("Brisbane");
        String prevTown = list.getFirst();
        ListIterator<String> itr = list.listIterator();
        while (itr.hasNext()) {
            var town = itr.next();
            System.out.println("--> From: "+ prevTown + " to " + town);
            prevTown = town;
        }
        System.out.println("Trip ends at "+ list.getLast());
    }

    private static void addMoreElements(LinkedList<String> list) {
        list.addFirst("Darwin");
        list.addLast("Hobart");
        //Queue Methods
        list.offer("Melbourne");
        list.offerFirst("Brisbane");
        list.offerLast("Toowoomba");
        // Stack methods
        list.push("ALice Springs");

    }

    private static void removeElements(LinkedList<String> list){
        list.remove(4);
        list.remove("Brisbane");
        System.out.println(list);
        String s1 = list.remove(); // removes first element
        System.out.println(s1 + " was removed");

        String s2 = list.removeFirst(); // removes first element
        System.out.println(s2 + " was removed");

        String s3 = list.removeLast(); // removes first element
        System.out.println(s3 + " was removed");

        //Queue methods
        String p1 = list.poll();
        System.out.println(p1 + " was removed");

        String p2 = list.pollFirst();
        System.out.println(p2 + " was removed");

        String p3 = list.pollLast();
        System.out.println(p3+ " was removed");

        //Stack methods
        list.push("Darwin");
        list.push("Gabba");
        String p4 = list.pop();
        System.out.println(p4 + " was removed");

    }

    private static void getElements(LinkedList<String> list) {

        System.out.println("Retrieved element = "+ list.get(0));
        System.out.println("Get first "+list.getFirst());
        System.out.println("Get last "+list.getLast());

        System.out.println("Darwin is at position "+list.indexOf("Darwin"));
        System.out.println("Melbourne is at "+list.lastIndexOf("Melbourne")); // returns -1 since value is not rpesent in list

        // Queue retrieval method - first in first out
        System.out.println("ELement from element() "+list.element());

        //Stack retrieval method
        System.out.println("Element from peek() "+list.peek()); // first element of the lsit
        System.out.println("Element from peek() "+list.peekFirst()); // first element of the lsit
        System.out.println("Element from peek() "+list.peekLast());
    }
}

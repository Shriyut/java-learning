package org.example.list.linkedlistquestions.challenge;

import java.util.LinkedList;
import java.util.Scanner;

record Place(String name, int distance) {

    @Override
    public String toString(){
        return String.format("%s (%d)", name, distance);
    }
}

public class Main {

    public static void main(String[] args) {
        LinkedList<Place> placesToVisit = new LinkedList<>();

        Place adelaide = new Place("Adelaide", 1374);
        addPlace(placesToVisit, adelaide);
        Place adelaide1 = new Place("adelaide", 1374);
        addPlace(placesToVisit, adelaide1);
        addPlace(placesToVisit, new Place("Brisbane", 917));
        addPlace(placesToVisit, new Place("Perth", 917));
        addPlace(placesToVisit, new Place("Alice Springs", 3923));
        addPlace(placesToVisit, new Place("Darwin", 2771));
        addPlace(placesToVisit, new Place("Melbourne", 877));
        placesToVisit.addFirst(new Place("Sydney", 0));
        System.out.println(placesToVisit);

        var iterator = placesToVisit.iterator();
        Scanner scanner = new Scanner(System.in);
        boolean quitLoop = false;
        boolean forward = true;

        printMenu();

        while(!quitLoop) {

//            if (!iterator.hasPrevious()) {
//                System.out.println("Originating : " + iterator.next());
//                forward = true;
//            }
//            if (!iterator.hasNext()) {
//                System.out.println(" FInal : " + iterator.previous());
//                forward = false;
//            }

            System.out.println("Enter value");
            String menuItem = scanner.nextLine().toUpperCase().substring(0, 1);

            switch(menuItem) {
                case "F":
                    System.out.println("User wants to go forward");
                    if (iterator.hasNext()) {
                        System.out.println(iterator.next());
                    }
                    break;
                case "B":
                    System.out.println("User wants to go backward");
                    break;
                case "M":
                    printMenu();
                    break;
                case "L":
                    System.out.println(placesToVisit);
                    break;

                default:
                    quitLoop = true;
                    break;
            }
        }

    }

    private static void addPlace(LinkedList<Place> list, Place place) {
        if (list.contains(place)) {
            System.out.println("Found duplicate: " + place);
            return;
        }

        for (Place p : list) {
            if (p.name().equalsIgnoreCase(place.name())) {
                System.out.println("Found duplicate: " + place);
                return;
            }
        }

        int matchIndex = 0;
        for (var listPlace: list) {
            if (place.distance() < listPlace.distance()) {
                list.add(matchIndex, place);
                return;
            }
            matchIndex++;
        }
        list.add(place);
    }

    private static void printMenu() {
        System.out.println("""
                Available actions (select word or letter
                (F)orward
                (B)ackwards
                (L)ist Places
                (M)enu
                (Q)uit
                """);
    }
}

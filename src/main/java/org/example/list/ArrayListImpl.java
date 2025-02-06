package org.example.list;

import java.util.*;

record GroceryItem(String name, String type, int count) {

    public GroceryItem(String name){
        this(name, "DAIRY", 1);
    }

    @Override
    public String toString() {
        return String.format("%d %s in %s", count, name.toUpperCase(), type);
    }
}

public class ArrayListImpl {

    public static void main(String[] args) {
        Object[] groceryArray = new Object[3];
        groceryArray[0] = new GroceryItem("milk");
        groceryArray[1] = new GroceryItem("apples", "PRODUCE", 6);
        groceryArray[2] = "5 oranges";
        System.out.println(Arrays.toString(groceryArray));

        ArrayList objectList = new ArrayList();
        objectList.add(new GroceryItem("Butter"));
        objectList.add("Yogurt");

        ArrayList<GroceryItem> groceryList = new ArrayList<>();
        groceryList.add(new GroceryItem("Butter"));
//        groceryList.add("Yogurt"); // returns error
        groceryList.add(new GroceryItem("Butter"));
        groceryList.add(new GroceryItem("Milk"));
        groceryList.add(new GroceryItem("Oranges", "PRODUCE", 5));
//        groceryList.add(0, new GroceryItem("Apples", "PRODUCE", 6));
        groceryList.addFirst(new GroceryItem("Apples", "PRODUCE", 6)); // same as above
        groceryList.remove(1);

        System.out.println(groceryList);

        String[] items = {"apples", "bananas", "milk", "eggs"};
        List<String> list = List.of(items); //factory method

        ArrayList<String> groceries = new ArrayList<>(list);
        groceries.add("yogurt");
        System.out.println(groceries);
        System.out.println(list);

        ArrayList<String> nextList = new ArrayList<>(
                List.of("pickles", "mustard", "cheese")
        );
        groceries.addAll(nextList);
        System.out.println(groceries);
        System.out.println(groceries.size());

        groceries.set(0, "yogurt");
        System.out.println(groceries);

        System.out.println(groceries.get(2)); //index starts with 0

        if (groceries.contains("mustard")) {
            System.out.println("COntains mustard");
        }

        System.out.println("first "+ groceries.indexOf("yogurt"));
        System.out.println("last = "+ groceries.lastIndexOf("yogurt"));

        groceries.remove("yogurt"); // only removes first occurence
        System.out.println(groceries);
        groceries.removeAll(List.of("apples", "eggs"));
        System.out.println(groceries);
        groceries.retainAll(List.of("apples", "milk", "mustard"));
        System.out.println(groceries);

        groceries.clear(); //removes all elements
        System.out.println(groceries);
        System.out.println("isEMpty = "+ groceries.isEmpty());

        groceries.addAll(Arrays.asList("eggs", "pickles", "mustard", "ham"));
        System.out.println(groceries);

        groceries.sort(Comparator.naturalOrder());
        // Comparator allows instances to be compared to one another
        System.out.println(groceries);

        var groceryArrayNew = groceries.toArray(new String[groceries.size()]);
        System.out.println(Arrays.toString(groceryArrayNew));

        String[] originalArray = new String[] {"First", "Second", "Third"};
        var originalList = Arrays.asList(originalArray);
        originalList.set(0, "one");
        System.out.println("list: "+ originalList);
        System.out.println("array: "+Arrays.toString(originalArray));
        originalList.sort(Comparator.naturalOrder());
        System.out.println("array: "+Arrays.toString(originalArray));
        //add and remove return an error with originalList because of var
    }
}

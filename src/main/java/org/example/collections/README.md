# Collections Package

java.util package contains Java's most powerful subsystems: the Collections framework.

The Java Collections Framework standardizes the way in which groups of objects are handled by your programs.

Algorithms are another important part of the Collections framework.
Algorithms operate on collections and are defined as static methods within the Collections class.

Another item closely associated with the Collections frameowrk is the Iterator interface.
An iterator offers a general-purpose, standardized way of accessing the elements within a collection.
Because each collection provides an iterator, the elements of any collection class can be accessed through the methods defined by Iterator.

Spliterators are iterators that provide support for parallel iteration.

The Collections framework defines several core interfaces, which represent different types of collections.

The Collection interface is the root of the collection hierarchy.
The Map interface is not a true child of the Collection interface, but it is considered part of the Collections framework.
The List interface defines an ordered collection (also known as a sequence). Lists may contain duplicate elements.
The Set interface defines a collection that does not allow duplicate elements.
The SortedSet interface is a specialized Set that maintains its elements in ascending order.
The NavigableSet interface is a SortedSet extended with navigation methods reporting closest matches for given search targets.
The Queue interface defines a collection used to hold multiple elements prior to processing.
The Deque interface is a linear collection that supports element insertion and removal at both ends.
The Map interface defines an object that maps keys to values. A map cannot contain duplicate keys; each key can map to at most one value.
The SortedMap interface is a specialized Map that maintains its mappings in ascending key order.
The NavigableMap interface is a SortedMap extended with navigation methods returning the closest matches for given search targets.
The java.util.Collections class consists exclusively of static methods that operate on or return collections.

Collections also use the Comparator, RandomAccess, Iterator, and ListIterator interfaces.
Comparator defines how two objects are compared; Iterator, ListIterator, and Spliterator enumerate the objects within a collection.
By implementing RandomAccess, a list indicates that it supports efficient, random access to its elements.

To provide greater flexibility in their use, the collection interface allow some methods to be optional. The optional methods enable you to modify the contents of a collection. 
Collections that support these methods are called modifiable. Collections that do not allow their contents to be changed are called unmodifiable.
If an attempt is made to use one of these methods on an unmodifiable collection, an UnsupportedOperationException is thrown.

## The Collection Interface

The Collection interface is the root interface in the collection hierarchy. It declares the core methods that all collections will have, such as adding and removing elements, checking for containment, and obtaining the size of the collection.
`interface Collection<E>`

Collection extends the iterable interface which means that all collections can be cycled through by use of the for-each style for loop.

Methods declared by Collection:

- boolean add(E e): Adds the specified element to the collection.
- boolean remove(Object o): Removes a single instance of the specified element from the collection, if it is present.
- boolean contains(Object o): Returns true if the collection contains the specified element.
- int size(): Returns the number of elements in the collection.
- boolean isEmpty(): Returns true if the collection contains no elements.
- void clear(): Removes all elements from the collection.
- Iterator<E> iterator(): Returns an iterator over the elements in the collection.
- Object[] toArray(): Returns an array containing all elements in the collection.
- <T> T[] toArray(T[] a): Returns an array containing all elements in the collection; the runtime type of the returned array is that of the specified array.
- boolean containsAll(Collection<?> c): Returns true if the collection contains all elements in the specified collection.
- boolean addAll(Collection<? extends E> c): Adds all elements from the specified collection to this collection.
- boolean removeAll(Collection<?> c): Removes all elements in this collection that are also contained in the specified collection.
- boolean retainAll(Collection<?> c): Retains only the elements in this collection that are contained in the specified collection.
- boolean equals(Object o): Compares the specified object with this collection for equality.
- int hashCode(): Returns the hash code value for this collection.
- Spliterator<E> spliterator(): Creates a Spliterator over the elements in this collection.
- Stream<E> stream(): Returns a sequential Stream with this collection as its source.
- Stream<E> parallelStream(): Returns a possibly parallel Stream with this collection as its source.
- default boolean removeIf(Predicate<? super E> filter): Removes all elements of this collection that satisfy the given predicate.

### The List Interface

The List interface extends the Collection interface and represents an ordered collection (also known as a sequence). Lists may contain duplicate elements. Elements in a list can be accessed by their integer index (position in the list) and search for elements in the list.
`interface List<E> extends Collection<E>`

A list may contain duplicate elements.

### The Set Interface

The Set interface extends the Collection interface and represents a collection that does not allow duplicate elements. It models the mathematical set abstraction.

`interface Set<E> extends Collection<E>`

The add method returns false if an attempt is made to add duplicate elements to a set.

### The SortedSet Interface

The SortedSet interface extends the Set interface and represents a set that maintains its elements in ascending order. The elements in a SortedSet must implement the Comparable interface or be ordered using a Comparator provided at the time of set creation.
`interface SortedSet<E> extends Set<E>`

SortedSet provides below methods in addition to Set

- Comparator<? super E> comparator(): Returns the comparator used to order the elements in this set, or null if this set uses the natural ordering of its elements.
- E first(): Returns the first (lowest) element in this set.
- E last(): Returns the last (highest) element in this set.
- SortedSet<E> headSet(E toElement): Returns a view of the portion of this set whose elements are strictly less than toElement.
- SortedSet<E> tailSet(E fromElement): Returns a view of the portion of this set whose elements are greater than or equal to fromElement.
- SortedSet<E> subSet(E fromElement, E toElement): Returns a view of the portion of this set whose elements range from fromElement, inclusive, to toElement, exclusive.

### The NavigableSet Interface

The NavigableSet interface extends the SortedSet interface and provides navigation methods for finding elements based on their order in the set.
`interface NavigableSet<E> extends SortedSet<E>`
NavigableSet provides below methods in addition to SortedSet
- E lower(E e): Returns the greatest element in this set strictly less than the given element, or null if there is no such element.
- E floor(E e): Returns the greatest element in this set less than or equal to the given element, or null if there is no such element.
- E ceiling(E e): Returns the least element in this set greater than or equal to the given element, or null if there is no such element.
- E higher(E e): Returns the least element in this set strictly greater than the given element, or null if there is no such element.
- NavigableSet<E> descendingSet(): Returns a reverse order view of the elements in this set.
- Iterator<E> descendingIterator(): Returns an iterator over the elements in this set in descending order.
- NavigableSet<E> subSet(E fromElement, boolean fromInclusive, E toElement, boolean toInclusive): Returns a view of the portion of this set whose elements range from fromElement to toElement.
- NavigableSet<E> headSet(E toElement, boolean inclusive): Returns a view of the portion of this set whose elements are less than (or equal to, if inclusive is true) toElement.
- NavigableSet<E> tailSet(E fromElement, boolean inclusive): Returns a view of the portion of this set whose elements are greater than (or equal to, if inclusive is true) fromElement.
- E pollFirst(): Retrieves and removes the first (lowest) element, or returns null if this set is empty.
- E pollLast(): Retrieves and removes the last (highest) element, or returns null if this set is empty.

### The Queue Interface

The Queue interface extends the Collection interface and represents a collection used to hold multiple elements prior to processing. Queues typically follow the First-In-First-Out (FIFO) principle, but other ordering principles can also be used.
`interface Queue<E> extends Collection<E>`
Queue provides below methods in addition to Collection

- boolean offer(E e): Inserts the specified element into this queue if it is possible to do so immediately without violating capacity restrictions.
- E poll(): Retrieves and removes the head of this queue, or returns null if this queue is empty.
- E remove(): Retrieves and removes the head of this queue.
- E peek(): Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
- E element(): Retrieves, but does not remove, the head of this queue.


### The Deque Interface

The Deque interface extends the Queue interface and represents a linear collection that supports element insertion and removal at both ends. Deques can be used as both stacks (LIFO) and queues (FIFO).
`interface Deque<E> extends Queue<E>`
Deque provides below methods in addition to Queue
- void addFirst(E e): Inserts the specified element at the front of this deque.
- void addLast(E e): Inserts the specified element at the end of this deque.
- boolean offerFirst(E e): Inserts the specified element at the front of this deque.
- boolean offerLast(E e): Inserts the specified element at the end of this deque.
- E removeFirst(): Removes and returns the first element of this deque.
- E removeLast(): Removes and returns the last element of this deque.
- E pollFirst(): Removes and returns the first element of this deque, or returns null if this deque is empty.
- E pollLast(): Removes and returns the last element of this deque, or returns null if this deque is empty.
- E getFirst(): Returns the first element of this deque.
- E getLast(): Returns the last element of this deque.
- E peekFirst(): Returns the first element of this deque, or returns null if this deque is empty.
- E peekLast(): Returns the last element of this deque, or returns null if this deque is empty.
- boolean removeFirstOccurrence(Object o): Removes the first occurrence of the specified element from this deque.
- boolean removeLastOccurrence(Object o): Removes the last occurrence of the specified element from this deque.
- void push(E e): Pushes an element onto the stack represented by this deque.
- E pop(): Pops an element from the stack represented by this deque.
- Iterator<E> descendingIterator(): Returns an iterator over the elements in this deque in reverse sequential order.

A deque implementation can be capacity restricted, which means that only a limited number if elements can be added to the deque.
When this is the case, an attempt to add an element to the deque can fail.

## The Collection Class

The Collections class consists exclusively of static methods that operate on or return collections. It contains polymorphic algorithms that operate on collections, "wrappers", which return a new collection backed by a specified collection, and a few other odds and ends.

Some of the classes provide full implementations that can be used as-is.
Others are abstract, providing a skeletal implementation that can be used as starting points for creating concrete collections.
As a general rule, the collection classes are not synchronized but it is possible to obtain synchronized versions.

The core collection classes are:

- ArrayList - Implements a dynamic array by extending AbstractList
- LinkedList - Implements a doubly-linked list by extending AbstractSequentialList
- HashSet - Extends AbstractSet, backed by a hash table (actually a HashMap instance)
- TreeSet - Extends AbstractSet
- LinkedHashSet - Extends HashSet, allows insertion-order iterations
- PriorityQueue - Implements a priority queue data structure, extends AbstractQueue
- ArrayDeque - Implements a resizable-array deque
- HashMap - Implements a hash table, extends AbstractMap

### The ArrayList class

The ArrayList class extends AbstractList and implements the List interface.
ArrayList is a generic class that has this declaration `class ArrayList<E>`

ArrayList supports dynamic arrays that can grow as needed.

ArrayList has the constructors:

- ArrayList() : Constructs an empty list with an initial capacity of ten.
- ArrayList(Collection<? extends E> c) : Constructs a list containing the elements of the specified collection, in the order they are returned by the collection's iterator.
- ArrayList(int initialCapacity) : Constructs an empty list with the specified initial capacity.

### The LinkedList class

The LinkedList class extends AbstractSequentialList and implements the List, Queue, and Deque interfaces.

`class LinkedList<E>`

LinkedList has two constructors:

- `LinkedList()`
- `LinkedList(Collection<? extends E> c)`

### The HashSet class

The HashSet class extends AbstractSet and implements the Set interface.
It creates a collection that uses a hash table for storage. 
HashSet is a generic class that has this declaration: `class HashSet<E>`

A hash table stores information by using a mechanism called hashing.
In hashing, the informational content of a key is used to determine a unique value called its hash code.

The hash code is then used as index at which the data associated with the key is stored. The transformation of the key into its hash code is performed automatically.

Your code can't directly index the hash table, the advantage of hashing is that it allows the execution time of add(), contains(), remove(), and size() to remain constant even for large sets.

The following constructors are defined:

- HashSet() : Constructs a new, empty set; the backing HashMap instance has default initial capacity (16) and load factor (0.75).
- HashSet(Collection<? extends E> c) : Constructs a new set containing the elements in the specified collection.
- HashSet(int initialCapacity) : Constructs a new, empty set; the backing HashMap instance has the specified initial capacity and default load factor (0.75).
- HashSet(int initialCapacity, float loadFactor) : Constructs a new, empty set; the backing HashMap instance has the specified initial capacity and the specified load factor.

HashSet does not define any additional methods beyond those provided by its superclasses and interfaces.

HashSet does nto guarantee the order of its elements, because the process of hashing doesn't usually lend itself to the creation of sorted sets.

If you need sorted storage then another collection, such as TreeSet is a better choice.

### The TreeSet class

The TreeSet class extends AbstractSet and implements the NavigableSet interface.
It creates a collection that uses a tree for storage.
Objects are stored in sorted, ascending order.

Access and retrieval times are quite fst because the underlying tree structure is a self-balancing binary search tree.
The following constructors are defined:
- TreeSet() : Constructs a new, empty tree set, sorted according to the natural ordering of its elements.
- TreeSet(Comparator<? super E> comparator) : Constructs a new, empty tree set, sorted according to the specified comparator.
- TreeSet(Collection<? extends E> c) : Constructs a new tree set containing the elements in the specified collection, sorted according to the natural ordering of its elements.
- TreeSet(SortedSet<E> s) : Constructs a new tree set containing the same elements and using the same ordering as the specified sorted set.

### The LinkedHashSet class

The LinkedHashSet class extends HashSet and adds no members of its own.
It creates a collection that uses a hash table and a linked list to store its elements.
The linked list defines the iteration ordering, which is the order in which elements were inserted into the set (insertion-order).
The following constructors are defined:
- LinkedHashSet() : Constructs a new, empty linked hash set with the default initial capacity (16) and load factor (0.75).
- LinkedHashSet(int initialCapacity) : Constructs a new, empty linked hash set with the specified initial capacity and the default load factor (0.75).
- LinkedHashSet(int initialCapacity, float loadFactor) : Constructs a new, empty linked hash set with the specified initial capacity and load factor.
- LinkedHashSet(Collection<? extends E> c) : Constructs a new linked hash set containing the elements in the specified collection, in the order they are returned by the collection's iterator.

### The PriorityQueue class

The PriorityQueue class extends AbstractQueue and implements the Queue interface.
It creates a collection that uses a priority heap for storage.
It creates a queue that is prioritized based on the queue's comparator.

The following constructors are defined:

- PriorityQueue() : Constructs a default initial capacity (11) priority queue.
- PriorityQueue(int initialCapacity) : Constructs a priority queue with the specified initial capacity that orders its elements according to their natural ordering.
- PriorityQueue(Comparator<? super E> comparator) : Constructs a priority queue with the specified comparator that orders its elements according to the specified comparator.
- PriorityQueue(int initialCapacity, Comparator<? super E> comparator) : Constructs a priority queue with the specified initial capacity that orders its elements according to the specified comparator.
- PriorityQueue(Collection<? extends E> c) : Constructs a priority queue containing the elements in the specified collection.
- PriorityQueue(PriorityQueue<? extends E> c) : Constructs a priority queue containing the elements in the specified priority queue.
- PriorityQueue(SortedSet<? extends E> c) : Constructs a priority queue containing the elements in the specified sorted set.

If no comparator is specified when a PriorityQueue is constructed, then the default comparator for the type of data stored in the queue is used.
The default comparator will order the queue in ascending order. Thus, the head of the queue will be the smallest value.

You can obtain a reference to the comparator used by a PriorityQueue by calling its comparator() method `Comparator<? super E> comparator()`

It returns the comparator. If natural ordering is used for the invoking queue. null is returned.
Although you can iterate through a PriorityQueue using an iterator, the order of that iteration is undefined.

### The ArrayDeque class

The ArrayDeque class implements the Deque interface nd extends the AbstractCollection class.
ArrayDeque create a dynamic array and has no capacity restrictions.

The following constructors are defined:

- ArrayDeque() : Constructs an empty array deque with an initial capacity of 16.
- ArrayDeque(int numElements) : Constructs an empty array deque with an initial capacity sufficient to hold the specified number of elements.
- ArrayDeque(Collection<? extends E> c) : Constructs a deque containing the elements of the specified collection, in the order they are returned by the collection's iterator.

### The EnumSet class

The EnumSet class extends AbstractSet and implements the Set interface.
It is specifically for use with elements of an enum type.

`class EnumSet<E extends Enum<E>>`

EnumSet defines no constructors, instead it uses factory methods.

The following static factory methods are defined:

- static <E extends Enum<E>> EnumSet<E> allOf(Class<E> elementType) : Creates an enum set containing all of the elements in the specified element type.
- static <E extends Enum<E>> EnumSet<E> noneOf(Class<E> elementType) : Creates an empty enum set with the specified element type.
- static <E extends Enum<E>> EnumSet<E> of(E e1) : Creates an enum set initially containing the specified element.

## Accessing a Collection via an Iterator

Iterator enables you to cycle through a collection, obtaining or removing elements.
One way to impelment this is to create an object that implements either the Iterator or the ListIterator interface.

ListIterator extends Iterator to allow bidirectional traversal of a list and the modification of elements.

ListIterator are generic interfaces that have these declarations:

- interface Iterator<E>
- interface ListIterator<E> extends Iterator<E>

The Iterator interface defines the following methods:

- boolean hasNext(): Returns true if the iteration has more elements.
- E next(): Returns the next element in the iteration.
- void remove(): Removes from the underlying collection the last element returned by this iterator.
- default void forEachRemaining(Consumer<? super E> action): Performs the given action for each remaining element until all elements have been processed or the action throws an exception.
- default Spliterator<E> spliterator(): Creates a Spliterator over the elements described by this Iterator.
- default Stream<E> stream(): Returns a sequential Stream with this Iterator as its source.
- default Stream<E> parallelStream(): Returns a possibly parallel Stream with this Iterator as its source.

The ListIterator interface defines the following methods in addition to those defined by Iterator:
- boolean hasPrevious(): Returns true if this list iterator has more elements when traversing the list in the reverse direction.
- E previous(): Returns the previous element in the list and moves the cursor position backwards.
- int nextIndex(): Returns the index of the element that would be returned by a subsequent call to next().
- int previousIndex(): Returns the index of the element that would be returned by a subsequent call to previous().
- void set(E e): Replaces the last element returned by next() or previous() with the specified element.
- void add(E e): Inserts the specified element into the list.
- default void forEachRemaining(Consumer<? super E> action): Performs the given action for each remaining element until all elements have been processed or the action throws an exception.
- default Spliterator<E> spliterator(): Creates a Spliterator over the elements described by this ListIterator.
- default Stream<E> stream(): Returns a sequential Stream with this ListIterator as its source.
- default Stream<E> parallelStream(): Returns a possibly parallel Stream with this ListIterator as its source.

### Using an Iterator

To obtain an iterator for a collection, you call its iterator() method.
This method returns an object that implements the Iterator interface.
For example, the following code creates an ArrayList of String objects and uses an iterator to display the list's contents:
```java
import java.util.ArrayList;
import java.util.Iterator;
public class IteratorDemo {
    public static void main(String[] args) {
        // Create an ArrayList and add some elements
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        // Obtain an iterator for the list
        Iterator<String> iterator = list.iterator();

        // Use the iterator to display the elements in the list
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.println(element);
        }
    }
}
```
The output of this program will be:
```
Apple
Banana
Cherry
```

### for each alternative to iterators

If you won't be mddiying the conents of a collection or obtaining elements in reverse order, then for-each version of the for loop is oftern a more convenient alternative to cycling through a collection than is using an iterator.

For example, the preceding IteratorDemo program can be rewritten to use a for-each loop as follows:
```java
import java.util.ArrayList;
public class ForEachDemo {
    public static void main(String[] args) {
        // Create an ArrayList and add some elements
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        // Use a for-each loop to display the elements in the list
        for (String element : list) {
            System.out.println(element);
        }
    }
}
```

### Spliterators

A Spliterator is an object for traversing and partitioning elements of a source.
It offers substantially more functionality than does either Iterator or ListIterator.
A Spliterator is designed for use with the Java Stream API and supports parallel processing of collections.

It combines the hasNext and next operations into one method called tryAdvance.

The Spliterator interface defines the following methods:

- boolean tryAdvance(Consumer<? super T> action): If a remaining element exists, performs the given action on it, returning true; else returns false.
- Spliterator<T> trySplit(): If this spliterator can be partitioned, returns a Spliterator covering elements, that will, upon return from this method, not be covered by this Spliterator.
- long estimateSize(): Returns an estimate of the number of elements that would be encountered by a complete traversal of this Spliterator.
- int characteristics(): Returns a set of characteristics of this Spliterator and its elements.
- default Comparator<? super T> getComparator(): If this Spliterator's source is SORTED by a Comparator, returns that Comparator.
- default long getExactSizeIfKnown(): If the exact size of this Spliterator is known, returns that size; otherwise, returns -1.
- default boolean hasCharacteristics(int characteristics): Returns true if this Spliterator has all of the given characteristics.
- default void forEachRemaining(Consumer<? super T> action): Performs the given action for each remaining element, sequentially in the current thread, until all elements have been processed or the action throws an exception.
- default Stream<T> stream(): Returns a sequential Stream with this Spliterator as its source.
- default Stream<T> parallelStream(): Returns a possibly parallel Stream with this Spliterator as its source.
- default IntStream intStream(): Returns a sequential IntStream with this Spliterator.OfInt as its source.
- and more

Using spliterator for basic iteration tasks is quite easy: simply call tryAdvance() until it reutrns false.
If you will be applying the same action to each element in the sequence, forEachRemaining() offers a streamlined alternative.
In both the cases, the action that will occur with each iteration is defined by what the Consumer object does with each element.

Consumer is a functional interface that applies an action to an object. 
It is a generic functional interface declared in java.util.function. Consumer specifies only one abstract method accept().
Often, the easiest way to implement Consumer is by use of a lambda expression.

Here is an example that demonstrates how to use a Spliterator to iterate through a collection:
```java
import java.util.ArrayList;
import java.util.Spliterator;
import java.util.function.Consumer;
public class SpliteratorDemo {
    public static void main(String[] args) {
        // Create an ArrayList and add some elements
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        // Obtain a spliterator for the list
        Spliterator<String> spliterator = list.spliterator();

        // Use the spliterator to display the elements in the list
        spliterator.forEachRemaining(new Consumer<String>() {
            @Override
            public void accept(String element) {
                System.out.println(element);
            }
        });
    }
}
```

Each Spliterator has a set of attributes, called characteristics, associated with it. These are defined by static int fields in Spliterator, such as SORTED, DISTINCT, SIZED, and IMMUTABLE etc.


### Storing User-Defined Classes in Collections

When you store objects of user-defined classes in collections, there are some important considerations to keep in mind, especially when using collections that rely on hashing or ordering.
1. Override equals() and hashCode() Methods
2. Implement Comparable Interface (for sorted collections)
3. Use Comparator for Custom Ordering
4. Immutable Objects
5. Thread Safety
6. Testing and Debugging

Here is an example of a user-defined class that can be stored in a HashSet and a TreeSet:
```java
import java.util.HashSet;
import java.util.TreeSet;
public class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
    }

    @Override
    public int hashCode() {
        return name.hashCode() + age;
    }

    @Override
    public int compareTo(Person other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }

    public static void main(String[] args) {
        HashSet<Person> hashSet = new HashSet<>();
        hashSet.add(new Person("Alice", 30));
        hashSet.add(new Person("Bob", 25));

        System.out.println("HashSet:");
        for (Person p : hashSet) {
            System.out.println(p);
        }

        TreeSet<Person> treeSet = new TreeSet<>();
        treeSet.add(new Person("Alice", 30));
        treeSet.add(new Person("Bob", 25));

        System.out.println("\nTreeSet:");
        for (Person p : treeSet) {
            System.out.println(p);
        }

        if (obj == null || getClass() != obj.getClass()) return false;
        Person other = (Person) obj;
        return name.equals(other.name) && age == other.age;
    }
}
        
```

## The RandomAccess Interface

The RandomAccess interface is a marker interface in the java.util package that is used to indicate that a List implementation supports fast (generally constant time) random access to its elements.
It contains no elements. However, by implementing this interface, a collection signals that is supports efficient random access to its elements.

By checking for the RandomAccess interface, client code can determine at run time wheteher a collection is usitable for certain types of random access oeprations - especially as they apply to large collections.

## The Map Interface

The Map interface defines an object that maps keys to values. A map cannot contain duplicate keys; each key can map to at most one value.
Map doesnot implement Iterable interface, this means that you cannot cycle through a map using a for-each style for loop.

`interface Map<K,V>`

The following interfaces support maps:

- SortedMap - A specialized Map that maintains its mappings in ascending key order.
- NavigableMap - A SortedMap extended with navigation methods returning the closest matches for given search targets.
- Map - Defines an object that maps keys to values.
- Map.Entry - A key-value pair contained in a Map.

The Map interface defines the following methods:

- V put(K key, V value): Associates the specified value with the specified key in this map.
- V get(Object key): Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.
- V remove(Object key): Removes the mapping for a key from this map if it is present.
- boolean containsKey(Object key): Returns true if this map contains a mapping for the specified key.
- boolean containsValue(Object value): Returns true if this map maps one or more keys to the specified value.
- int size(): Returns the number of key-value mappings in this map.
- boolean isEmpty(): Returns true if this map contains no key-value mappings.
- void clear(): Removes all of the mappings from this map.
- Set<K> keySet(): Returns a Set view of the keys contained in this map.
- Collection<V> values(): Returns a Collection view of the values contained in this map.
- Set<Map.Entry<K,V>> entrySet(): Returns a Set view of the mappings contained in this map.
- void putAll(Map<? extends K,? extends V> m): Copies all of the mappings from the specified map to this map.
- V putIfAbsent(K key, V value): If the specified key is not already associated with a value, associates it with the given value and returns null, else returns the current value.
- boolean remove(Object key, Object value): Removes the entry for the specified key only if it is currently mapped to the specified value.
- boolean replace(K key, V oldValue, V newValue): Replaces the entry for the specified key only if currently mapped to the specified value.
- V replace(K key, V value): Replaces the entry for the specified key only if it is currently mapped to some value.

### The SortedMap Interface

The SortedMap interface extends the Map interface and represents a map that maintains its mappings in ascending key order. The keys in a SortedMap must implement the Comparable interface or be ordered using a Comparator provided at the time of map creation.
`interface SortedMap<K,V> extends Map<K,V>`
SortedMap provides below methods in addition to Map
- Comparator<? super K> comparator(): Returns the comparator used to order the keys in this map, or null if this map uses the natural ordering of its keys.
- K firstKey(): Returns the first (lowest) key currently in this map.
- K lastKey(): Returns the last (highest) key currently in this map.
- SortedMap<K,V> headMap(K toKey): Returns a view of the portion of this map whose keys are strictly less than toKey.
- SortedMap<K,V> tailMap(K fromKey): Returns a view of the portion of this map whose keys are greater than or equal to fromKey.
- SortedMap<K,V> subMap(K fromKey, K toKey): Returns a view of the portion of this map whose keys range from fromKey, inclusive, to toKey, exclusive.
- Map.Entry<K,V> firstEntry(): Returns a key-value mapping associated with the least key in this map, or null if the map is empty.
- Map.Entry<K,V> lastEntry(): Returns a key-value mapping associated with the greatest key in this map, or null if the map is empty.
- Map.Entry<K,V> pollFirstEntry(): Removes and returns a key-value mapping associated with the least key in this map, or null if the map is empty.

### The NavigableMap Interface

The NavigableMap interface extends the SortedMap interface and provides navigation methods for finding entries based on their order in the map.
`interface NavigableMap<K,V> extends SortedMap<K,V>`
NavigableMap provides below methods in addition to SortedMap
- Map.Entry<K,V> lowerEntry(K key): Returns a key-value mapping associated with the greatest key strictly less than the given key, or null if there is no such key.
- Map.Entry<K,V> floorEntry(K key): Returns a key-value mapping associated with the greatest key less than or equal to the given key, or null if there is no such key.
- Map.Entry<K,V> ceilingEntry(K key): Returns a key-value mapping associated with the least key greater than or equal to the given key, or null if there is no such key.
- Map.Entry<K,V> higherEntry(K key): Returns a key-value mapping associated with the least key strictly greater than the given key, or null if there is no such key.
- NavigableMap<K,V> descendingMap(): Returns a reverse order view of the mappings contained in this map.
- NavigableSet<K> navigableKeySet(): Returns a NavigableSet view of the keys contained in this map.
- NavigableSet<K> descendingKeySet(): Returns a reverse order NavigableSet view of the keys contained in this map.
- NavigableMap<K,V> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive): Returns a view of the portion of this map whose keys range from fromKey to toKey.
- NavigableMap<K,V> headMap(K toKey, boolean inclusive): Returns a view of the portion of this map whose keys are less than (or equal to, if inclusive is true) toKey.
- NavigableMap<K,V> tailMap(K fromKey, boolean inclusive): Returns a view of the portion of this map whose keys are greater than (or equal to, if inclusive is true) fromKey.
- Map.Entry<K,V> pollFirstEntry(): Removes and returns a key-value mapping associated with the least key in this map, or null if the map is empty.
- Map.Entry<K,V> pollLastEntry(): Removes and returns a key-value mapping associated with the greatest key in this map, or null if the map is empty.
- default V getOrDefault(Object key, V defaultValue): Returns the value to which the specified key is mapped, or defaultValue if this map contains no mapping for the key.
- default void forEach(BiConsumer<? super K,? super V> action): Performs the given action for each entry in this map until all entries have been processed or the action throws an exception.
- default void replaceAll(BiFunction<? super K,? super V,? extends V> function): Replaces each entry's value with the result of invoking the given function on that entry until all entries have been processed or the function throws an exception.
- and more

### The Map.Entry Interface

The Map.Entry interface represents a key-value pair contained in a Map.
`interface Map.Entry<K,V>`
The Map.Entry interface defines the following methods:
- K getKey(): Returns the key corresponding to this entry.
- V getValue(): Returns the value corresponding to this entry.
- V setValue(V value): Replaces the value corresponding to this entry with the specified value.
- boolean equals(Object o): Compares the specified object with this entry for equality.
- int hashCode(): Returns the hash code value for this map entry.
- default String toString(): Returns a string representation of this map entry.
- default <T> T getKeyAs(Class<T> keyType): Returns the key corresponding to this entry, cast to the specified type.
- default <T> T getValueAs(Class<T> valueType): Returns the value corresponding to this entry, cast to the specified type.
- default V getOrDefault(V defaultValue): Returns the value corresponding to this entry, or defaultValue if the value is null.
- default void ifPresent(BiConsumer<? super K,? super V> action): If the value is non-null, performs the given action with the key and value.
- default void ifPresentValue(Consumer<? super V> action): If the value is non-null, performs the given action with the value.
- default void ifPresentKey(Consumer<? super K> action): If the key is non-null, performs the given action with the key.

## The Map Classes

The core map classes are:
- HashMap - Implements a hash table, extends AbstractMap
- TreeMap - Implements a Red-Black tree, extends AbstractMap
- LinkedHashMap - Extends HashMap, allows insertion-order iterations
- WeakHashMap - Implements a hash table with weak keys, extends AbstractMap
- IdentityHashMap - Implements a hash table that uses reference-equality, extends AbstractMap
- AbstractMap - Provides a skeletal implementation of the Map interface to minimize the effort required to implement this interface.
- EnumMap - A specialized Map implementation for use with enum type keys, extends AbstractMap

WeakHashMap implements a map that uses "weak keys", which allows an element in a map to be garbage collected when its key is otherwise unused.

### The HashMap class

The HashMap class extends AbstractMap and implements the Map interface.
It creates a collection that uses a hash table for storage.
This allows the execution time of get() and put() to remain constant even for large sets.

HashMap is a generic class that has this declaration: `class HashMap<K,V>`

The following constructors are defined:

- HashMap() : Constructs an empty HashMap with the default initial capacity (16) and load factor (0.75).
- HashMap(int initialCapacity) : Constructs an empty HashMap with the specified initial capacity and the default load factor (0.75).
- HashMap(int initialCapacity, float loadFactor) : Constructs an empty HashMap with the specified initial capacity and load factor.
- HashMap(Map<? extends K,? extends V> m) : Constructs a new HashMap with the same mappings as the specified Map.

### The TreeMap class

The TreeMap class extends AbstractMap and implements the NavigableMap interface.
It creates a collection that uses a Red-Black tree for storage.
A Red-Black tree is a self-balancing binary search tree that ensures that the tree remains approximately balanced during insertions and deletions.
A TreeMap provides an efficient means of storing key/value pairs in sorted prder and allows rapid retrieval.
Unlike a hash map, a tree map guarantees that its elements will be stored in ascending key order.

The following constructors are defined:
- TreeMap() : Constructs a new, empty tree map, sorted according to the natural ordering of its keys.
- TreeMap(Comparator<? super K> comparator) : Constructs a new, empty tree map, sorted according to the specified comparator.
- TreeMap(Map<? extends K,? extends V> m) : Constructs a new tree map containing the same mappings as the specified map, sorted according to the natural ordering of its keys.
- TreeMap(SortedMap<K,? extends V> m) : Constructs a new tree map containing the same mappings and using the same ordering as the specified sorted map.

### The LinkedHashMap class

The LinkedHashMap class extends HashMap and adds no members of its own.
It maintains a linkedlist of the entries in the map, in the order in which they were inserted. 
This allows insertion-order iteration over the map.

When iterating through a collection-view of a LinkedHashMap, the elements will be returned in the order in which they were inserted.
You can also create a LinkedHashMap that maintains access-order, meaning that the order of the elements is based on the order in which they were last accessed, from least-recently accessed to most-recently accessed.

The following constructors are defined:
- LinkedHashMap() : Constructs an empty LinkedHashMap with the default initial capacity (16) and load factor (0.75).
- LinkedHashMap(int initialCapacity) : Constructs an empty LinkedHashMap with the specified initial capacity and the default load factor (0.75).
- LinkedHashMap(int initialCapacity, float loadFactor) : Constructs an empty LinkedHashMap with the specified initial capacity and load factor.
- LinkedHashMap(int initialCapacity, float loadFactor, boolean accessOrder) : Constructs an empty LinkedHashMap with the specified initial capacity, load factor and ordering mode.
- LinkedHashMap(Map<? extends K,? extends V> m) : Constructs a new LinkedHashMap with the same mappings as the specified Map.

`class LinkedHashMap<K, V>`

The default capacity is 16.
The default load factor is 0.75.

### The EnumMap class
The EnumMap class extends AbstractMap and implements the Map interface.
It is specifically for use with keys of an enum type.
`class EnumMap<K extends Enum<K>,V>`
EnumMap defines the following constructors:

- EnumMap(Class<K> keyType) : Constructs an empty enum map with the specified key type.
- EnumMap(EnumMap<K,? extends V> m) : Constructs an enum map initialized from the specified enum map.
- EnumMap(Map<K,? extends V> m) : Constructs an enum map initialized from the specified map.

EnumMap defines no method of its own.

### The IdentityHashMap Class

The IdentityHashMap class extends AbstractMap and implements the Map interface.
It creates a hash table that uses reference-equality in place of object-equality when comparing keys (and values).
`class IdentityHashMap<K,V>`


## Comparators

Both TreeSet and TreeMap store elements in sorted order.
However, it is the comparator that defines precisely what "sorted order" means.
By default, these classes store their elements by using what Java refers to as "natural ordering," which is usually the ordering that you'd expect.

If you want to order elements a different way than natural ordering, you can define your own comparator by implementing the Comparator interface.

`interface Comparator<T>`

The Comparator interface defines the following methods:

- int compare(T o1, T o2): Compares its two arguments for order.
- boolean equals(Object obj): Indicates whether some other object is "equal to" this comparator.
- default Comparator<T> reversed(): Returns a comparator that imposes the reverse ordering of this comparator.
- default Comparator<T> thenComparing(Comparator<? super T> other): Returns a lexicographic-order comparator with another comparator.
- default <\<U>> Comparator<T> thenComparing(Function<? super T,? extends U> keyExtractor, Comparator<? super U> keyComparator): Returns a lexicographic-order comparator with a function that extracts a sort key.
- default <U extends Comparable<? super U>> Comparator<T> thenComparing(Function<? super T,? extends U> keyExtractor): Returns a lexicographic-order comparator with a function that extracts a Comparable sort key.
- default Comparator<T> thenComparingInt(ToIntFunction<? super T> keyExtractor): Returns a lexicographic-order comparator with an int sort key.
- default Comparator<T> thenComparingLong(ToLongFunction<? super T> keyExtractor): Returns a lexicographic-order comparator with a long sort key.
- default Comparator<T> thenComparingDouble(ToDoubleFunction<? super T> keyExtractor): Returns a lexicographic-order comparator with a double sort key.
- and more

You can obtain a comparator that reverses the ordering of the comparator on which it is called by using reversed() method.
`default Comparator<T> reversed()`

### Using a Comparator

To use a comparator, you typically create a class that implements the Comparator interface and overrides the compare() method to define the desired ordering.
Here is an example that demonstrates how to use a Comparator to sort a list of strings in reverse alphabetical order:
```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class ComparatorDemo {
    public static void main(String[] args) {
        // Create an ArrayList and add some elements
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        // Create a comparator that sorts strings in reverse alphabetical order
        Comparator<String> reverseComparator = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s2.compareTo(s1); // Reverse order
            }
        };

        // Sort the list using the comparator
        Collections.sort(list, reverseComparator);

        // Display the sorted list
        for (String element : list) {
            System.out.println(element);
        }
    }
}
``` 

## Collection Algorithms

The Collections class provides static methods that implement various algorithms that operate on collections, such as sorting and searching.
Some of the commonly used algorithms provided by the Collections class include:

- static <T> void sort(List<T> list): Sorts the specified list into ascending order, according to the natural ordering of its elements.
- static <T> void sort(List<T> list, Comparator<? super T> c): Sorts the specified list according to the order induced by the specified comparator.
- static <T> int binarySearch(List<? extends Comparable<? super T>> list, T key): Searches the specified list for the specified object using the binary search algorithm.
- static <T> int binarySearch(List<? extends T> list, T key, Comparator<? super T> c): Searches the specified list for the specified object using the binary search algorithm and the specified comparator.
- static <T> void shuffle(List<T> list): Randomly permutes the specified list using a default source of randomness.
- static <T> void shuffle(List<T> list, Random rnd): Randomly permutes the specified list using the specified source of randomness.
- static <T> void reverse(List<T> list): Reverses the order of the elements in the specified list.
- static <T> void fill(List<? super T> list, T obj): Replaces all of the elements of the specified list with the specified element.
- static <T> T max(Collection<? extends T> coll): Returns the maximum element of the given collection, according to the natural ordering of its elements.
- static <T> T max(Collection<? extends T> coll, Comparator<? super T> comp): Returns the maximum element of the given collection, according to the order induced by the specified comparator.
- static <T> T min(Collection<? extends T> coll): Returns the minimum element of the given collection, according to the natural ordering of its elements.
- static <T> T min(Collection<? extends T> coll, Comparator<? super T> comp): Returns the minimum element of the given collection, according to the order induced by the specified comparator.
- and more

These algorithms can be used to perform common operations on collections without the need to implement the algorithms yourself.
### Example: Sorting a List
Here is an example that demonstrates how to use the Collections.sort() method to sort a list of integers:
```java
import java.util.ArrayList;
import java.util.Collections;
public class CollectionsDemo {
    public static void main(String[] args) {
        // Create an ArrayList and add some elements
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(2);
        list.add(8);
        list.add(1);
        list.add(4);

        // Sort the list in ascending order
        Collections.sort(list);

        // Display the sorted list
        System.out.println("Sorted List: " + list);
    }
}
```

The set of methods that begins with unmodifiable return views of the various collections that cannot be modified.

Collections define three static variables that represent empty collections:
- static final List<?> EMPTY_LIST
- static final Set<?> EMPTY_SET
- static final Map<?,?> EMPTY_MAP

All are immutable.

### Example: Searching a List

Here is an example that demonstrates how to use the Collections.binarySearch() method to search for an element in a sorted list of integers:
```java
import java.util.ArrayList;
import java.util.Collections;
public class BinarySearchDemo {
    public static void main(String[] args) {
        // Create an ArrayList and add some elements
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(5);
        list.add(8);

        // Search for an element in the sorted list
        int key = 4;
        int index = Collections.binarySearch(list, key);

        // Display the result of the search
        if (index >= 0) {
            System.out.println("Element " + key + " found at index: " + index);
        } else {
            System.out.println("Element " + key + " not found.");
        }
    }
}
```

The asList() method of the Arrays class can be used to obtain a fixed-size list backed by the specified array.
`static <T> List<T> asList(T... a)`

Here is an example that demonstrates how to use the Arrays.asList() method to create a list from an array:
```java
import java.util.Arrays;
import java.util.List;
public class ArraysAsListDemo {
    public static void main(String[] args) {
        // Create an array of strings
        String[] array = {"Apple", "Banana", "Cherry"};

        // Convert the array to a list
        List<String> list = Arrays.asList(array);

        // Display the list
        System.out.println("List: " + list);
    }
}
```



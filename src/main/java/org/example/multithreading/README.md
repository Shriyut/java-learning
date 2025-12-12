# Multi-Threading

A multithreaded program contains two or more parts that can run concurrently.
Each part of such a program is called a thread, and each thread defines a separate path of execution.
Thus, multithreading is a specialized form of multitasking.

There are tow different types of multi-tasking in operating systems:

1. Process-based multitasking - Each task is a separate process, and the operating system allocates resources to each process. Processes do not share memory space.
2. Thread-based multitasking - Each task is a separate thread within a single process, and threads share the same memory space.

A process is, in essence, a program that is executing.
Thus, process-based multitasking is the feature that allows your computer to run two or more programs concurrently.

A program is the smallest unit of code that can be scheduled by the scheduler.

In thread based multi tasking environment, the thread is the smalled unit of dispatchable code.
This means that a single program can perform two or more tasks simultaneously.

Multitasking threads require less overhead than multitasking processes.

## Creating Threads in Java

There are two ways to create a thread in Java:
1. By extending the `Thread` class.
2. By implementing the `Runnable` interface.

### Extending the Thread Class

```java
class MyThread extends Thread {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("MyThread: " + i);
            try {
                Thread.sleep(500); // Sleep for 500 milliseconds
            } catch (InterruptedException e) {
                System.out.println("MyThread interrupted");
            }
        }
    }
}
public class ThreadExample {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start(); // Start the thread

        for (int i = 0; i < 5; i++) {
            System.out.println("Main Thread: " + i);
            try {
                Thread.sleep(300); // Sleep for 300 milliseconds
            } catch (InterruptedException e) {
                System.out.println("Main Thread interrupted");
            }
        }
    }
}
```

### Implementing Runnable Interface

```java
class MyRunnable implements Runnable {
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("MyRunnable: " + i);
            try {
                Thread.sleep(500); // Sleep for 500 milliseconds
            } catch (InterruptedException e) {
                System.out.println("MyRunnable interrupted");
            }
        }
    }
}
public class RunnableExample {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyRunnable());
        t1.start(); // Start the thread

        for (int i = 0; i < 5; i++) {
            System.out.println("Main Thread: " + i);
            try {
                Thread.sleep(300); // Sleep for 300 milliseconds
            } catch (InterruptedException e) {
                System.out.println("Main Thread interrupted");
            }
        }
    }
}
```

## Java Thread Model

Java uses a preemptive scheduling model for threads, which means that the Java Virtual Machine (JVM) can suspend the execution of a currently running thread to allow another thread to run.
This is done to ensure that all threads get a fair share of the CPU time.
In Java, each thread has a priority that helps the thread scheduler decide when to switch from one thread to another.
Threads with higher priority are more likely to be executed before threads with lower priority.
However, thread priority does not guarantee the order of execution, as the thread scheduler's behavior can vary between different operating systems and JVM implementations.

Java uses threads to enable the entire environment to be asynchronous.
This helps reduce inefficiency by preventing the waste of CPU cycles.

Single-threaded systems use an approach called an event loop with polling.

In this model, a single thread of control runs in an infinite loop, polling a single event queue to decide what to do next.

Once this polling mechanism returns with say, a signal that a network file is ready to be read, then the event loop dispatches control to the appropriate event handler.
Until this event handler returns, nothing else ca happen in the program.
This wastes CPU time.

The benefit of Java's multithreading is that the main loop/mechanism is eliminated.
One thread can pause without stopping other parts of your program.

When a thread is waiting for a network file to be read, other threads can continue to run.

In a single core system, concurrently executing threads share the CPU, with each thread receving a slice of CPU time.
Therefore, in a single-core system, two or more threads do not actually run at the same time, but idle CPU time is utilized.

In multi-core systems, it is possible for tow or more threads to actually execute simulataneously.

## Thread Lifecycle

A thread can be in one of the following states:

1. New: A thread that has been created but not yet started.
2. Runnable: A thread that is ready to run and is waiting for CPU time.
3. Running: A thread that is currently executing.
4. Blocked/Waiting: A thread that is waiting for a resource or event to occur.
5. Terminated: A thread that has completed its execution. A terminated thread cannot be resumed.

## Thread Priorities 

Each thread has a priority that helps the thread scheduler decide when to switch from one thread to another.
Thread priorities range from 1 (MIN_PRIORITY) to 10 (MAX_PRIORITY), with a default priority of 5 (NORM_PRIORITY).

A thread's priority is used to decide when to switch from one running thread to the next. 
This is called a context switch.

The rules that determine when a context switch takes place are simple:

- A thread can voluntarily relinquish control.
- A thread can be preempted by a higher-priority thread.

Basically, as soon as a higher-priority thread wants to run, it does. This is called preemptive multitasking.

In cases where two threads with the same priority are competing for CPU cycles, the situation is a bit complicated.
For operating systems such as Windows, threads of equal priority are time-sliced automatically in round-robin fashion.
For other types of operating systems, threads of equal priority must voluntarily yield control to their peers.
If they don't the other threads will not run.

## Thread Synchronization

When multiple threads access shared resources, there is a risk of data inconsistency and corruption.
To prevent this, Java provides synchronization mechanisms to control access to shared resources.

Because multi-threading introduces an asynchronous behaviour to your programs, there must be a way for you to enforce synchronicity when you need it.

Once a thread is inside a synchronized method or block, no other thread can enter any synchronized method or block on the same object until the first thread exits the synchronized method or block.
This is called thread synchronization.

## The Main Thread

When a Java program starts up, one thread begins running immediately.
This is usually called the main thread of your program, because it is the oe that is executed when your program begins.

The main thread is created by the Java Virtual Machine (JVM) when the program starts.

The main thread executes the `main()` method of your program.

### currentThread() method

The `currentThread()` method of the `Thread` class returns a reference to the currently executing thread object.

```java
public class MainThreadExample {
    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();
        System.out.println("Current Thread: " + mainThread.getName());
    }
}
```
The output of this program will be:
```
Current Thread: main
```

### Thread Group

A thread group is a collection of threads that can be managed as a single unit.
Thread groups allow you to organize threads into a hierarchical structure, making it easier to manage and control them.

```java
public class ThreadGroupExample {
    public static void main(String[] args) {
        ThreadGroup group = new ThreadGroup("MyThreadGroup");

        Thread t1 = new Thread(group, () -> {
            System.out.println("Thread 1 is running");
        }, "Thread-1");

        Thread t2 = new Thread(group, () -> {
            System.out.println("Thread 2 is running");
        }, "Thread-2");

        t1.start();
        t2.start();

        System.out.println("Active Threads in Group: " + group.activeCount());
    }
}
```

The output of this program will be:
```
Thread 1 is running
Thread 2 is running
Active Threads in Group: 2
```

## Creating Multiple Threads

You can create multiple threads in Java by creating multiple instances of the `Thread` class or by implementing the `Runnable` interface multiple times.

```java
public class MultipleThreadsExample {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            Thread thread = new Thread(() -> {
                System.out.println("Thread " + Thread.currentThread().getName() + " is running");
            }, "Thread-" + i);
            thread.start();
        }
    }
}
```
The output of this program will be:
```
Thread Thread-1 is running
Thread Thread-2 is running
Thread Thread-3 is running
Thread Thread-4 is running
Thread Thread-5 is running
```

## Using isAlive() and join()

The `isAlive()` method checks if a thread is still running, while the `join()` method allows one thread to wait for another thread to finish its execution.

```java
public class IsAliveJoinExample {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(2000); // Simulate work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread 1 finished");
        });

        t1.start();

        System.out.println("Is Thread 1 alive? " + t1.isAlive());

        try {
            t1.join(); // Wait for t1 to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Is Thread 1 alive after join? " + t1.isAlive());
    }
}
```

The output of this program will be:
```
Is Thread 1 alive? true
Thread 1 finished
Is Thread 1 alive after join? false
```

### join() usage

```java
public class JoinExample {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(1000); // Simulate work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread 1 finished");
        });

        Thread t2 = new Thread(() -> {
            try {
                t1.join(); // Wait for t1 to finish
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread 2 finished after Thread 1");
        });

        t1.start();
        t2.start();
    }
}
```

## Using Synchronized Methods

Synchronization is easy in Java, because all objects have their own implicit monitor associated with them.

To enter an object's monitor, just call a method that has been modified with the synchronized keyword.

When a thread calls a synchronized method, it automatically acquires the lock for that object's monitor.

```java
class SharedCounter {
    private int count = 0;

    public void increment() {
        synchronized (this) { // Synchronized block
            count++;
            System.out.println(Thread.currentThread().getName() + " incremented count to: " + count);
        }
    }

    public int getCount() {
        return count;
    }
}

public class SynchronizedStatementExample {
    public static void main(String[] args) {
        SharedCounter counter = new SharedCounter();

        // Create multiple threads that access the shared resource
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                counter.increment();
                try {
                    Thread.sleep(100); // Simulate some work
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread-1");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                counter.increment();
                try {
                    Thread.sleep(100); // Simulate some work
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread-2");

        t1.start();
        t2.start();
    }
}
```

## Interthread Communication

Interthread communication is a mechanism that allows threads to communicate with each other and synchronize their actions.
This is typically done using the `wait()`, `notify()`, and `notifyAll()` methods of the `Object` class.

```java
class SharedResource {
    private int data;
    private boolean available = false;

    public synchronized int consume() throws InterruptedException {
        while (!available) {
            wait(); // Wait until data is available
        }
        available = false;
        notifyAll(); // Notify producers
        return data;
    }

    public synchronized void produce(int value) throws InterruptedException {
        while (available) {
            wait(); // Wait until data is consumed
        }
        data = value;
        available = true;
        notifyAll(); // Notify consumers
    }
}
public class InterthreadCommunicationExample {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Thread producer = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    resource.produce(i);
                    System.out.println("Produced: " + i);
                    Thread.sleep(500); // Simulate time taken to produce
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                for (int i = 0; i < 5; i++) {
                    int value = resource.consume();
                    System.out.println("Consumed: " + value);
                    Thread.sleep(1000); // Simulate time taken to consume
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producer.start();
        consumer.start();
    }
}
```

To avoid polling, Java includes an elegant interprocess communication mechanism via wait(), notify(), and notifyAll() methods.
These methods are implemented as final methods in Object.

All three methods can be called only from within a synchronized context.

- wait() - Causes the current thread to wait until another thread invokes notify() or notifyAll() on the same object.
- notify() - Wakes up a single thread that is waiting on the object's monitor.
- notifyAll() - Wakes up all threads that are waiting on the object's monitor.

## Deadlock

A deadlock is a situation in which two or more threads are blocked forever, waiting for each other to release resources.
This typically occurs when multiple threads hold locks on resources and each thread is waiting for a resource held by another thread.
```java
public class DeadlockExample {
    public static void main(String[] args) {
        final Object resource1 = "Resource 1";
        final Object resource2 = "Resource 2";

        // Thread 1
        Thread t1 = new Thread(() -> {
            synchronized (resource1) {
                System.out.println("Thread 1: Holding " + resource1);
                try { Thread.sleep(100); } catch (InterruptedException e) {}
                System.out.println("Thread 1: Waiting for " + resource2);
                synchronized (resource2) {
                    System.out.println("Thread 1: Acquired " + resource2);
                }
            }
        });

        // Thread 2
        Thread t2 = new Thread(() -> {
            synchronized (resource2) {
                System.out.println("Thread 2: Holding " + resource2);
                try { Thread.sleep(100); } catch (InterruptedException e) {}
                System.out.println("Thread 2: Waiting for " + resource1);
                synchronized (resource1) {
                    System.out.println("Thread 2: Acquired " + resource1);
                }
            }
        });

        t1.start();
        t2.start();
    }
}
```

## Suspending, Resuming, and Stopping Threads

The `suspend()`, `resume()`, and `stop()` methods of the `Thread` class are deprecated because they can lead to deadlocks and other synchronization problems.
```java
public class DeprecatedThreadMethodsExample {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                while (true) {
                    System.out.println("Thread is running...");
                    Thread.sleep(500); // Simulate work
                }
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        });

        thread.start();

        try {
            Thread.sleep(2000); // Allow the thread to run for a while

            // Suspend the thread
            System.out.println("Suspending the thread...");
            thread.suspend();

            Thread.sleep(2000); // Wait while the thread is suspended

            // Resume the thread
            System.out.println("Resuming the thread...");
            thread.resume();

            Thread.sleep(2000); // Allow the thread to run again

            // Stop the thread
            System.out.println("Stopping the thread...");
            thread.stop();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
```

## Obtaining a Thread's State

You can obtain the state of a thread using the `getState()` method of the `Thread` class.
```java
public class ThreadStateExample {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000); // Simulate work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("Thread State before start: " + thread.getState());
        thread.start();
        System.out.println("Thread State after start: " + thread.getState());

        try {
            thread.join(); // Wait for the thread to finish
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread State after completion: " + thread.getState());
    }
}
```

## Daemon Threads

A daemon thread is a background thread that does not prevent the JVM from exiting when the program finishes.
Daemon threads are typically used for tasks such as garbage collection, background monitoring, and other low-priority tasks that do not require user intervention.


## The Concurrent API packages

Java provides a high-level concurrency API in the `java.util.concurrent` package, which includes classes and interfaces for managing threads, synchronization, and concurrent data structures.
Some of the key classes in the `java.util.concurrent` package include:
- `ExecutorService`: A high-level interface for managing a pool of threads and executing tasks asynchronously.
- `Future`: Represents the result of an asynchronous computation.
- `CountDownLatch`: A synchronization aid that allows one or more threads to wait until a set of operations being performed in other threads completes.
- `CyclicBarrier`: A synchronization aid that allows a set of threads to all wait for each other to reach a common barrier point.
- `ConcurrentHashMap`: A thread-safe implementation of the `Map` interface that allows concurrent access by multiple threads.
- `BlockingQueue`: A thread-safe queue that supports operations that wait for the queue to become non-empty when retrieving an element and wait for space to become available in the queue when storing an element.
- `Semaphore`: A counting semaphore that controls access to a shared resource by multiple threads.
- `Synchroizers`: A framework for building locks and other synchronization primitives.
- `ForkJoinPool`: A specialized implementation of `ExecutorService` for parallel processing using the fork/join framework.

Executors manage thread execution.

A future contains a value that is returned by a thread after it executes.

### Using Synchronization Objects

Synchronized objects are supported by the Semaphore, CountDownLatch, CyclicBarrie, Exchanger, and Phaser classes.


### Semaphore

A Semaphore is a synchronization aid that restricts the number of threads that can access a shared resource.

A semaphore controls access to a shared resource through the ise of a counter.
If the counter is greater than zero, then access is allowed.
If it is zero, then access is denied.

What the counter is counting are permits that allow access to the shared resource. 
Thus, to access the resource, a thread must be granted a permit from semaphore.

To use a semaphore, the thread that wants access to the shared resource tries to acquire a permit.
If the semaphore's count is greater than zero, then the thread acquires a permit, which causes the semaphore's count to be decremented.
Otherwise, the thread will be blocked until a permit can be acquired.

When the thread no longer needs access to the shared resource, it releases the permit, then that thread will acquire a permit at that time.

Semaphore has two constructors:

- `Semaphore(int permits)`: Creates a semaphore with the given number of permits and non-fair fairness setting.
- `Semaphore(int permits, boolean fair)`: Creates a semaphore with the given number of permits and the specified fairness setting.

```java
import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    public static void main(String[] args) {
        // Create a semaphore with 2 permits and fairness set to true
        Semaphore semaphore = new Semaphore(2, true);

        // Create and start 5 threads
        for (int i = 1; i <= 5; i++) {
            Thread thread = new Thread(new Worker(semaphore), "Thread-" + i);
            thread.start();
        }
    }
}

class Worker implements Runnable {
    private final Semaphore semaphore;

    public Worker(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " is waiting for a permit...");
            semaphore.acquire(); // Acquire a permit
            System.out.println(Thread.currentThread().getName() + " acquired a permit!");

            // Simulate work
            Thread.sleep(2000);

            System.out.println(Thread.currentThread().getName() + " is releasing the permit...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release(); // Release the permit
            System.out.println(Thread.currentThread().getName() + " released the permit.");
        }
    }
}
```

The output of this program will be similar to:
```
Thread-1 is waiting for a permit...
Thread-1 acquired a permit!
Thread-2 is waiting for a permit...
Thread-2 acquired a permit!
Thread-3 is waiting for a permit...
Thread-1 is releasing the permit...
Thread-1 released the permit.
Thread-3 acquired a permit!
Thread-4 is waiting for a permit...
Thread-2 is releasing the permit...
Thread-2 released the permit.
Thread-4 acquired a permit!
Thread-5 is waiting for a permit...
Thread-3 is releasing the permit...
Thread-3 released the permit.
Thread-5 acquired a permit!
Thread-4 is releasing the permit...
Thread-4 released the permit.
Thread-5 is releasing the permit...
Thread-5 released the permit.
```

### CountDownLatch

A CountDownLatch is a synchronization aid that allows one or more threads to wait until a set of operations being performed in other threads completes.
```java
import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    public static void main(String[] args) {
        // Create a CountDownLatch with a count of 3
        CountDownLatch latch = new CountDownLatch(3);

        // Create and start 3 worker threads
        for (int i = 1; i <= 3; i++) {
            Thread thread = new Thread(new Worker(latch), "Worker-" + i);
            thread.start();
        }

        try {
            System.out.println("Main thread is waiting for workers to finish...");
            latch.await(); // Wait for the latch to reach zero
            System.out.println("All workers have finished. Main thread proceeding.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Worker implements Runnable {
    private final CountDownLatch latch;

    public Worker(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " is working...");
            Thread.sleep(1000); // Simulate work
            System.out.println(Thread.currentThread().getName() + " has finished.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            latch.countDown(); // Decrement the latch count
        }
    }
}
```

Used when you want one or more threads to wait until a set of operations being performed in other threads completes.
### CyclicBarrier

A CyclicBarrier is a synchronization aid that allows a set of threads to all wait for each other to reach a common barrier point.
Used when you want a set of threads to wait for each other to reach a common barrier point.

```java
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
    public static void main(String[] args) {
        // Create a CyclicBarrier for 3 threads with a barrier action
        CyclicBarrier barrier = new CyclicBarrier(3, () -> {
            System.out.println("All threads have reached the barrier. Proceeding...");
        });

        // Create and start 3 worker threads
        for (int i = 1; i <= 3; i++) {
            Thread thread = new Thread(new Worker(barrier), "Worker-" + i);
            thread.start();
        }
    }
}

class Worker implements Runnable {
    private final CyclicBarrier barrier;

    public Worker(CyclicBarrier barrier) {
        this.barrier = barrier;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " is working...");
            Thread.sleep(1000); // Simulate work
            System.out.println(Thread.currentThread().getName() + " has finished. Waiting at the barrier...");
            barrier.await(); // Wait at the barrier
            System.out.println(Thread.currentThread().getName() + " has crossed the barrier.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

### Exchanger

An Exchanger is a synchronization point at which two threads can exchange objects.

```java
import java.util.concurrent.Exchanger;
public class ExchangerExample {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();

        Thread thread1 = new Thread(new Worker(exchanger, "Data from Thread 1"), "Thread-1");
        Thread thread2 = new Thread(new Worker(exchanger, "Data from Thread 2"), "Thread-2");

        thread1.start();
        thread2.start();
    }
}
class Worker implements Runnable {
    private final Exchanger<String> exchanger;
    private String data;

    public Worker(Exchanger<String> exchanger, String data) {
        this.exchanger = exchanger;
        this.data = data;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " is exchanging data: " + data);
            String receivedData = exchanger.exchange(data); // Exchange data
            System.out.println(Thread.currentThread().getName() + " received data: " + receivedData);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
```

The output of this program will be similar to:
```
Thread-1 is exchanging data: Data from Thread 1
Thread-2 is exchanging data: Data from Thread 2
Thread-1 received data: Data from Thread 2
Thread-2 received data: Data from Thread 1
```

### Phaser

A Phaser is a synchronization aid that allows a set of threads to repeatedly wait for each other to reach a common barrier point.
```java
import java.util.concurrent.Phaser;
public class PhaserExample {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(3); // 3 parties

        for (int i = 1; i <= 3; i++) {
            Thread thread = new Thread(new Worker(phaser), "Worker-" + i);
            thread.start();
        }
    }
}
class Worker implements Runnable {
    private final Phaser phaser;

    public Worker(Phaser phaser) {
        this.phaser = phaser;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " is working on phase 1...");
            Thread.sleep(1000); // Simulate work
            phaser.arriveAndAwaitAdvance(); // Wait for others

            System.out.println(Thread.currentThread().getName() + " is working on phase 2...");
            Thread.sleep(1000); // Simulate work
            phaser.arriveAndAwaitAdvance(); // Wait for others

            System.out.println(Thread.currentThread().getName() + " has finished all phases.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
```

The output of this program will be similar to:
```
Worker-1 is working on phase 1...
Worker-2 is working on phase 1...
Worker-3 is working on phase 1...
Worker-1 is working on phase 2...
Worker-2 is working on phase 2...
Worker-3 is working on phase 2...
Worker-1 has finished all phases.
Worker-2 has finished all phases.
Worker-3 has finished all phases.
```

### Using an Executor

An Executor is a high-level interface for managing a pool of threads and executing tasks asynchronously.
```java
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {
    public static void main(String[] args) {
        // Create an ExecutorService with a fixed thread pool of size 3
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Submit 5 tasks to the executor
        for (int i = 1; i <= 5; i++) {
            int taskId = i;
            executor.submit(() -> {
                System.out.println("Task " + taskId + " is running on thread: " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000); // Simulate work
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Task " + taskId + " is completed.");
            });
        }

        // Shut down the executor
        executor.shutdown();
    }
}
```

### Using Callable and Future

Callable interface represents a thread that returns a value.
An application can use Callable objects to compute results that are then returned to invoking thread.

A Callable task is executed by an ExecutorService, by calling its submit() method.

There are three forms of submit(), but only one is used to execute a Callable.

`<T> Future<T> submit(Callable<T> task)`

Future is a generic interface that represents the value that will be returned by a Callable object.
Because this value is obtained at some future time, the name Future is appropriate.

Future is defined like this:

`public interface Future<V> {
    boolean cancel(boolean mayInterruptIfRunning);
    boolean isCancelled();
    boolean isDone();
    V get() throws InterruptedException, ExecutionException;
    V get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException;
}`

```java
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableFutureExample {
    public static void main(String[] args) {
        // Create an ExecutorService with a fixed thread pool of size 3
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Create a Callable task
        Callable<String> task = () -> {
            Thread.sleep(2000); // Simulate some work
            return "Task completed by " + Thread.currentThread().getName();
        };

        // Submit the task to the executor and get a Future
        Future<String> future = executor.submit(task);

        System.out.println("Task submitted. Waiting for the result...");

        try {
            // Retrieve the result of the computation
            String result = future.get(); // This blocks until the task is complete
            System.out.println("Result: " + result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            // Shut down the executor
            executor.shutdown();
        }
    }
}
```

## The TimeUnit Enumeration

The TimeUnit enumeration provides a way to represent time durations at a given unit of granularity and provides utility methods to convert across units.
```java
import java.util.concurrent.TimeUnit;
public class TimeUnitExample {
    public static void main(String[] args) {
        long minutes = 5;
        long seconds = TimeUnit.MINUTES.toSeconds(minutes);
        long milliseconds = TimeUnit.MINUTES.toMillis(minutes);

        System.out.println(minutes + " minutes is equal to " + seconds + " seconds.");
        System.out.println(minutes + " minutes is equal to " + milliseconds + " milliseconds.");
    }
}
```

## The Concurrent Collections

Java provides several thread-safe collections in the `java.util.concurrent` package, which are designed for concurrent access by multiple threads.
Some of the key concurrent collections include:
- `ConcurrentHashMap`: A thread-safe implementation of the `Map` interface that allows concurrent access by multiple threads.
- `CopyOnWriteArrayList`: A thread-safe variant of `ArrayList` in which all mutative operations (add, set, and so on) are implemented by making a fresh copy of the underlying array.
- `CopyOnWriteArraySet`: A thread-safe variant of `Set` that is backed by a `CopyOnWriteArrayList`.
- `BlockingQueue`: A thread-safe queue that supports operations that wait for the queue to become non-empty when retrieving an element and wait for space to become available in the queue when storing an element.
- `ConcurrentLinkedQueue`: A thread-safe, unbounded, non-blocking queue based on linked nodes.
- `ConcurrentSkipListMap`: A thread-safe implementation of a sorted map that uses skip lists to provide expected average log(n) time cost for the containsKey, get, put, and remove operations.
- `ConcurrentSkipListSet`: A thread-safe implementation of a sorted set that uses skip lists to provide expected average log(n) time cost for the contains, add, and remove operations.
- `LinkedBlockingQueue`: A bounded blocking queue based on linked nodes.
- `ArrayBlockingQueue`: A bounded blocking queue backed by an array.
- and more

## Locks

Java provides a high-level locking mechanism in the `java.util.concurrent.locks` package, which includes classes and interfaces for managing locks and synchronization.

Locks offer an alternative to using synchronized to control access to a shared resource.

```java
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class SharedResource {
    private int count = 0;
    private final Lock lock = new ReentrantLock();

    public void increment() {
        lock.lock(); // Acquire the lock
        try {
            count++;
            System.out.println(Thread.currentThread().getName() + " incremented count to: " + count);
        } finally {
            lock.unlock(); // Release the lock
        }
    }

    public int getCount() {
        return count;
    }
}

public class LockExample {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        // Create multiple threads that access the shared resource
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                resource.increment();
                try {
                    Thread.sleep(100); // Simulate some work
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread-1");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                resource.increment();
                try {
                    Thread.sleep(100); // Simulate some work
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread-2");

        t1.start();
        t2.start();
    }
}
```

The output of this program will be similar to:
```
Thread-1 incremented count to: 1
Thread-2 incremented count to: 2
Thread-1 incremented count to: 3
Thread-2 incremented count to: 4
Thread-1 incremented count to: 5
Thread-2 incremented count to: 6
Thread-1 incremented count to: 7
Thread-2 incremented count to: 8
Thread-1 incremented count to: 9
Thread-2 incremented count to: 10
```

## Atomic Operations

Java provides atomic operations in the `java.util.concurrent.atomic` package, which includes classes for performing atomic operations on single variables.
Some of the key atomic classes include:
- `AtomicInteger`: A class that provides atomic operations on an `int` value.
- `AtomicLong`: A class that provides atomic operations on a `long` value.
- `AtomicBoolean`: A class that provides atomic operations on a `boolean` value.
- `AtomicReference<V>`: A class that provides atomic operations on an object reference of type `V`.

```java
import java.util.concurrent.atomic.AtomicInteger;
public class AtomicIntegerExample {
    public static void main(String[] args) {
        AtomicInteger atomicCount = new AtomicInteger(0);

        // Create multiple threads that increment the atomic integer
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                int newValue = atomicCount.incrementAndGet();
                System.out.println(Thread.currentThread().getName() + " incremented count to: " + newValue);
                try {
                    Thread.sleep(100); // Simulate some work
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread-1");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                int newValue = atomicCount.incrementAndGet();
                System.out.println(Thread.currentThread().getName() + " incremented count to: " + newValue);
                try {
                    Thread.sleep(100); // Simulate some work
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Thread-2");

        t1.start();
        t2.start();
    }
}
```

The output of this program will be similar to:
```
Thread-1 incremented count to: 1
Thread-2 incremented count to: 2
Thread-1 incremented count to: 3
Thread-2 incremented count to: 4
Thread-1 incremented count to: 5
Thread-2 incremented count to: 6
Thread-1 incremented count to: 7
Thread-2 incremented count to: 8
Thread-1 incremented count to: 9
Thread-2 incremented count to: 10
```

## Parallel Programming via the Fork/Join Framework

The Fork/Join framework is a high-level concurrency framework in Java that allows you to parallelize tasks by breaking them down into smaller subtasks.

Parallel programming is the name commonly given to the techniques that take advantage of computers that contain two or more processors (multicore).

The Fork/Join Framework enhances mutithreaded programming in two important ways.
First, it simplifies the creation and use of multiple threads.
Second, it automatically makes use of multiple processors.

### Main Fork/Join Classes

The main classes in the Fork/Join framework are:
- `ForkJoinPool`: A specialized implementation of `ExecutorService` for parallel processing using the fork/join framework.
- `ForkJoinTask<V>`: An abstract class that represents a task that can be executed in a `ForkJoinPool`.
- `RecursiveAction`: A subclass of `ForkJoinTask` that represents a task that does not return a result.
- `RecursiveTask<V>`: A subclass of `ForkJoinTask` that represents a task that returns a result of type `V`.

### ForkJoinTask<V>

```java
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinTaskExample {
    public static void main(String[] args) {
        // Create an array of numbers
        int[] numbers = new int[100];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1; // Fill the array with numbers 1 to 100
        }

        // Create a ForkJoinPool
        ForkJoinPool pool = new ForkJoinPool();

        // Create a task to calculate the sum of the array
        SumTask task = new SumTask(numbers, 0, numbers.length);

        // Invoke the task and get the result
        int result = pool.invoke(task);

        System.out.println("Sum of array: " + result);
    }
}

// RecursiveTask to calculate the sum of an array
class SumTask extends RecursiveTask<Integer> {
    private static final int THRESHOLD = 10; // Threshold for splitting tasks
    private final int[] numbers;
    private final int start;
    private final int end;

    public SumTask(int[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (end - start <= THRESHOLD) {
            // Compute sum sequentially
            int sum = 0;
            for (int i = start; i < end; i++) {
                sum += numbers[i];
            }
            return sum;
        } else {
            // Split the task into two subtasks
            int mid = (start + end) / 2;
            SumTask leftTask = new SumTask(numbers, start, mid);
            SumTask rightTask = new SumTask(numbers, mid, end);

            // Fork the subtasks
            leftTask.fork();
            rightTask.fork();

            // Join the results of the subtasks
            return leftTask.join() + rightTask.join();
        }
    }
}
```

The output of this program will be:
```
Sum of array: 5050
```

### RecursiveAction

```java
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class RecursiveActionExample {
    public static void main(String[] args) {
        // Create an array of numbers
        int[] numbers = new int[20];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1; // Fill the array with numbers 1 to 20
        }

        // Create a ForkJoinPool
        ForkJoinPool pool = new ForkJoinPool();

        // Create a task to increment the array elements
        IncrementTask task = new IncrementTask(numbers, 0, numbers.length);

        // Invoke the task
        pool.invoke(task);

        // Print the updated array
        System.out.println("Updated array:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
    }
}

// RecursiveAction to increment elements of an array
class IncrementTask extends RecursiveAction {
    private static final int THRESHOLD = 5; // Threshold for splitting tasks
    private final int[] numbers;
    private final int start;
    private final int end;

    public IncrementTask(int[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        if (end - start <= THRESHOLD) {
            // Process elements sequentially
            for (int i = start; i < end; i++) {
                numbers[i]++;
            }
        } else {
            // Split the task into two subtasks
            int mid = (start + end) / 2;
            IncrementTask leftTask = new IncrementTask(numbers, start, mid);
            IncrementTask rightTask = new IncrementTask(numbers, mid, end);

            // Fork the subtasks
            invokeAll(leftTask, rightTask);
        }
    }
}
```

The output of this program will be:
```
Updated array:
2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 
```

Users of Fork/Join framework will employ a divide and conquer strategy that is based on recursion.

```java
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

// Task to calculate the sum of an array
class SumTask extends RecursiveTask<Integer> {
    private static final int THRESHOLD = 10; // Threshold for splitting tasks
    private final int[] numbers;
    private final int start;
    private final int end;

    public SumTask(int[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        // If the task is small enough, compute directly
        if (end - start <= THRESHOLD) {
            int sum = 0;
            for (int i = start; i < end; i++) {
                sum += numbers[i];
            }
            return sum;
        } else {
            // Split the task into two subtasks
            int mid = (start + end) / 2;
            SumTask leftTask = new SumTask(numbers, start, mid);
            SumTask rightTask = new SumTask(numbers, mid, end);

            // Fork the subtasks to execute them in parallel
            leftTask.fork();
            rightTask.fork();

            // Join the results of the subtasks
            return leftTask.join() + rightTask.join();
        }
    }
}

public class ForkJoinExample {
    public static void main(String[] args) {
        // Create an array of numbers
        int[] numbers = new int[100];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1; // Fill the array with numbers 1 to 100
        }

        // Create a ForkJoinPool
        ForkJoinPool pool = new ForkJoinPool();

        // Create the main task
        SumTask task = new SumTask(numbers, 0, numbers.length);

        // Invoke the task and get the result
        int result = pool.invoke(task);

        // Print the result
        System.out.println("Sum of array: " + result);
    }
}
```


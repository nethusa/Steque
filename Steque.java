package Queues;

public class Steque<T> {
    private Node<T> front;
    private Node<T> rear;
    private int size;

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }
    public Steque() {
        front = null;
        rear = null;
        size = 0;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
    public void push(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            newNode.next = front;
            front = newNode;
        }
        size++;
        System.out.println("Pushed: " + data);
    }
    public T pop() {
        if (isEmpty()) {
            System.out.println("Steque is empty. Cannot pop.");
            return null;
        }
        T data = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        System.out.println("Popped: " + data);
        return data;
    }
    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
        System.out.println("Enqueued: " + data);
    }
    public void printSteque() {
        if (isEmpty()) {
            System.out.println("Steque is empty.");
            return;
        }
        System.out.print("Steque elements: ");
        Node<T> current = front;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Steque<Integer> steque = new Steque<>();
        steque.push(10);
        steque.push(20);
        steque.push(30);
        steque.printSteque();
        steque.pop();
        steque.printSteque();
        steque.enqueue(40);
        steque.enqueue(50);
        steque.printSteque();
        steque.pop();
        steque.printSteque();
    }
}

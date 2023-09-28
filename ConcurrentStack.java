package chapter_22;

import java.util.EmptyStackException;

public class ConcurrentStack<T> {

    private Node<T> top;

    public synchronized void push(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = top;
        top = newNode;
    }

    public synchronized T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T data = top.data;
        top = top.next;
        return data;
    }

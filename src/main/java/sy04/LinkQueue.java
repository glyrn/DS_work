package syo4;

import sy02.Node;

public class LinkQueue implements IQueue {
    private Node front;
    private Node rear;

    public LinkQueue() {
        front = rear = null;
    }

    @Override
    public void clear() {
        front = rear = null;
    }

    @Override
    public boolean isEmpty() {
        return rear == front;
    }

    @Override
    public int length() {
        Node p = front;
        int length = 0;
        while (p != null) {
            p = p.getNext();
            length++;
        }
        return length;
    }

    @Override
    public Object peek() {
        if (front != null)
            return front.getData();
        else
            return null;
    }

    @Override
    public void offer(Object x) throws Exception {
        Node p = new Node(x);
        if (front != null) {
            rear.setNext(p);
            rear = p;
        } else
            front = rear = p;
    }

    @Override
    public Object poll() {
        if (front != null) {
            Node p = front;
            front = front.getNext();
            if (p == rear)
                rear = null;
            return p.getData();
        } else
            return null;
    }

    public void display() {
        Node node = front;
        while (node != null) {
            System.out.print(node.getData() + " ");
            node = node.getNext();
        }
        System.out.println();
    }
}

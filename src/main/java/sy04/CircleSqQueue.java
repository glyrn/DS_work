package syo4;

public class CircleSqQueue {
    private int[] queueElem;
    private int front;
    private int rear;

    public CircleSqQueue(int maxsize) {
        front = rear = 0;
        queueElem = new int[maxsize];
    }


    public void clear() {
        front = rear = 0;
    }


    public boolean isEmpty() {
        return rear == front;
    }


    public int length() {
        return (rear - front + queueElem.length) % queueElem.length;
    }


    public Object peek() {
        if (front == rear)
            return null;
        else
            return queueElem[front];
    }


    public void offer(int x) throws Exception {
        if ((rear + 1) % queueElem.length == front)
            throw new Exception("队列已满");
        else
            queueElem[rear] = x;
        rear = (rear + 1) % queueElem.length;
    }


    public Object poll() {
        if (front == rear) {
            return null;
        } else {
            Object t = queueElem[front];
            front = (front + 1) % queueElem.length;
            return t;
        }
    }

    public void display() {
        if (!isEmpty()) {
            for (int i = front; i != rear; i = (i + 1) % queueElem.length)
                System.out.print(queueElem[i] + " ");
        } else {
            System.out.println("此队列为空");
        }
    }

    public int getElem(int i) {
        return queueElem[i];
    }
}

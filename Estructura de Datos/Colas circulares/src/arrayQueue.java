import java.util.*;

class arrayQueue {
    protected int Queue[];
    protected int front, rear, size, len;

    /* Constructor */
    public arrayQueue(int n) {
        size = n;
        len = 0;
        Queue = new int[size];
        front = -1;
        rear = -1;
    }

    public boolean isEmpty() {
        return len == 0;
    }

    public boolean isFull() {
        return len == size;
    }

    public int getSize() {
        return len;
    }

    public int peek() {
        if (isEmpty())
            throw new NoSuchElementException("Underflow Exception");
        return Queue[front];
    }

    public void insert(int i) {
        if (isFull()) {
            throw new IndexOutOfBoundsException("Overflow Exception");
        }
        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else {
            rear = (front + 1) % size;
        }
        Queue[rear] = i;
        len++;
    }

    public int remove() {
        if (isEmpty()) {
            throw new NoSuchElementException("Underflow Exception");
        }
        int ele = Queue[front];
        if (front == rear) { // Si solo hay un elemento
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % size;
        }
        len--;
        return ele;
    }

    public void display() {
        System.out.print("\nQueue = ");
        if (isEmpty()) {
            System.out.print("Empty\n");
            return;
        }
        int i = front;
        for (int count = 0; count < len; count++) {
            System.out.print(Queue[i] + " ");
            i = (i + 1) % size;
        }
        System.out.println();
    }
}

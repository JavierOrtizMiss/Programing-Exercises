class Deque {
    static final int MAX = 100;
    int arr[];
    int front;
    int rear;
    int size;
 
    public Deque(int size)
    {
        arr = new int[MAX];
        front = -1;
        rear = 0;
        this.size = size;
    }
 
    boolean isFull()
    {
        return ((front == 0 && rear == size - 1)
                || front == rear + 1);
    }
 
    boolean isEmpty() { return (front == -1); }
 
    void insertfront(int key)
    {
        if (isFull()) {
            System.out.println("Overflow");
            return;
        }
 
        // Inicialmente vacía
        if (front == -1) {
            front = 0;
            rear = 0;
        }
 
        // front está en primera posición Deque
        else if (front == 0)
            front = size - 1;
 
        else // decrementa front end '1'
            front = front - 1;
 
        // inserta element en Deque
        arr[front] = key;
    }
 
    
    void insertrear(int key)
    {
        if (isFull()) {
            System.out.println(" Overflow ");
            return;
        }
 
        if (front == -1) {
            front = 0;
            rear = 0;
        }

        else if (rear == size - 1){
            rear = 0;
        }
        else{
            rear = rear + 1;
    }
        arr[rear] = key;
    }
 
    void deletefront()
    {
        // checa si Deque esta vacía o no
        if (isEmpty()) {
            System.out.println("Queue Underflow\n");
            return;
        }
 
        if (front == rear) {
            front = -1;
            rear = -1;
        }
        else
            if (front == size - 1)
            front = 0;
 
        else 
            front = front + 1;
    }
 
    void deleterear()
    {
        if (isEmpty()) {
            System.out.println(" Underflow");
            return;
        }
        if (front == rear) {
            front = -1;
            rear = -1;
        }
        else if (rear == 0)
            rear = size - 1;
        else
            rear = rear - 1;
    }
 
    
    int getFront()
    {
        if (isEmpty()) {
            System.out.println(" Underflow");
            return -1;
        }
        return arr[front];
    }
 
    
    int getRear()
    {
        if (isEmpty() || rear < 0) {
            System.out.println(" Underflow\n");
            return -1;
        }
        return arr[rear];
    }

    int getSize()
    {
        if (isEmpty()) {
            System.out.println(" Underflow\n");
            return -1;
        }
        return rear - front + 1;
    }

    void display() {
        if (isEmpty()) {
            System.out.println("Queue = Empty");
            return;
        }

        System.out.print("Queue = ");
        int i = front;
        do {
            System.out.print(arr[i] + " ");
            i = (i + 1) % size;
        } while (i != (rear + 1) % size);
        System.out.println();
    }
}
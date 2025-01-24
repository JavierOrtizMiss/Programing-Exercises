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
 
        // si deque esta inicialmente vacía
        if (front == -1) {
            front = 0;
            rear = 0;
        }
 
        // rear esta en la última posición 
        else if (rear == size - 1)
            rear = 0;
 
        // incrementa rear en '1'
        else
            rear = rear + 1;
 
        // inserta el elemento
        arr[rear] = key;
    }
 
    void deletefront()
    {
        // checa si Deque esta vacía o no
        if (isEmpty()) {
            System.out.println("Queue Underflow\n");
            return;
        }
 
        // Deque tiene solo un elemento
        if (front == rear) {
            front = -1;
            rear = -1;
        }
        else
            // regresa a la posición inicial
            if (front == size - 1)
            front = 0;
 
        else // incrementa front en '1' para sacar el elemento actual
            front = front + 1;
    }
 
    void deleterear()
    {
        if (isEmpty()) {
            System.out.println(" Underflow");
            return;
        }
 
        // Deque tiene un solo elemento
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

    void display()
    {
        System.out.print("\nQueue = ");
        if (isEmpty()) {
            System.out.print("Empty\n");
            return;
        }
        int i = front;
        for (int count = 0; count < size; count++) {
            System.out.print(arr[i] + " ");
            i = (i + 1) % size;
        }
        System.out.println();
    }
}
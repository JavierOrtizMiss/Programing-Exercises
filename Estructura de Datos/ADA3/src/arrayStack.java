import java.util.*;

/*  Clase arrayStack  */
class arrayStack {
    protected int arr[];
    protected int top, size, len;

    /*  Constructor  */
    public arrayStack(int n) {
        size = n;
        len = 0;
        arr = new int[size];
        top = -1;
    }

    /*  -método está vacía */
    public boolean isEmpty() {
        return top == -1;
    }

    /*  método está llena */
    public boolean isFull() {
        return top == size - 1; 
    }

    /*  método para obtener el tamaño de la pila */
    public int getSize() {
        return len;
    }

    /*  método para saber cuál es el elemento en la cima de la pila */
    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return arr[top];
    }

    /*  método push */
    public void push(int i) {
        if (top + 1 >= size)
            throw new IndexOutOfBoundsException("Overflow Exception");
        if (top + 1 < size)
            arr[++top] = i;
        len++;
    }

    /*  método pop */
    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        len--;
        return arr[top--];
    }

    /*  desplegar la pila */
    public void display() {
        System.out.print("\nPila = ");
        if (len == 0) {
            System.out.print("Vacía\n");
            return;
        }
        for (int i = top; i >= 0; i--)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}

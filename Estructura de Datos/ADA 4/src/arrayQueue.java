import java.util.*;
 
/*  Class arrayQueue  */
class arrayQueue
{
    protected int Queue[] ;
    protected int front, rear, size, len;
 
    /* Constructor */
    public arrayQueue(int n) 
    {
        size = n;
        len = 0;
        Queue = new int[size];
        front = -1;
        rear = -1;
    }    
    
    public boolean isEmpty() 
    {
        return front == -1;
    }    
    
    public boolean isFull() 
    {
        return front==0 && rear == size -1 ;
    }    
    
    public int getSize()
    {
        return len ;
    }    
    
    public int peek() 
    {
        if (isEmpty())
           throw new NoSuchElementException("Underflow Exception");
        return Queue[front];
    }    
    
    public void insert(int i) 
    {
        if (rear == -1) 
        {
            front = 0;
            rear = 0;
            Queue[rear] = i;
        }
        else if (rear + 1 >= size)
                throw new IndexOutOfBoundsException("Overflow Exception");
             else if ( rear + 1 < size)
                Queue[++rear] = i;    
        len++ ;        
    }    


    public void moveLeft() {
        for (int i = 0; i < rear; i++) {
            Queue[i] = Queue[i + 1]; 
        }
        rear--; 
    }
    
    public int remove() 
    {
        if (isEmpty())
           throw new NoSuchElementException("Underflow Exception");
        else 
        {
            len-- ;
            int ele = Queue[front];
            if ( front == rear) 
            {
                front = -1;
                rear = -1;
            }
            else
                moveLeft();               
            return ele;
        }        
    }
    
    public void display()
    {
        System.out.print("\nQueue = ");
        if (len == 0)
        {
            System.out.print("Empty\n");
            return ;
        }
        for (int i = front; i <= rear; i++)
            System.out.print(Queue[i]+" ");
        System.out.println();        
    }
}
import java.util.*;

public class Queue {
    int front;
    int rear;
    int CAPACITY=10;
    int[] A= new int[CAPACITY];
    public Queue()
    {
        front=-1;
        rear=-1;  
    }

    public void enqueue(int x)
    {
        if((rear+1)%CAPACITY==front)
        {
            System.out.println("Queue is full");
        }
        else if(front==-1)
        {
            front=0;
            rear=0;
        }
        else
        {
            rear=(rear+1)%CAPACITY;
        }
        A[rear]=x;
    }

    public void dequeue()
    {
        if(front==-1)
        {
            System.out.println("Queue is empty");
        }
        else if(front==rear)
        {
            front=-1;
            rear=-1;
        }
        else
        {
            front=(front+1)%CAPACITY;
        }
    }

    public int Front()
    {
        if(front==-1)
        {
            return -1;
        }
        else
        {
            return A[front];
        }
    }
    
    public void printQueue()
    {
        int count= ((rear+CAPACITY-front)%CAPACITY)+1;
        for(int i=0; i<count;i++)
        {
            int index= (front+i) % CAPACITY;
            System.out.println(A[index]+" ");
        }
    }
    public static void main(String[] args)
    {
        Queue Q= new Queue();
        Q.enqueue(2);
        Q.enqueue(3);
        Q.enqueue(4);
        Q.enqueue(5);
        Q.dequeue();
        //Q.printQueue();
        int value=Q.Front();
        if(value==-1)
        {
            System.out.println("The Queue is empty");
        }
        else
        {
            System.out.println(value);
        }
    }
}
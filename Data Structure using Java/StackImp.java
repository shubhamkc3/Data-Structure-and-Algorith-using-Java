import java.util.*;
public class StackImp 
{
    private int maxSize;
    private int[] stackArray;
    private int top;
    
    public StackImp(int s) {
       maxSize = s;
       stackArray = new int[maxSize];
       top = -1;
    }
    public void push(int j) {
       stackArray[++top] = j;
    }
    public int pop() {
       return stackArray[top--];
    }
    public int peek() {

       return stackArray[top];
    }
    public boolean isEmpty() {
       return (top == -1);
    }
    public boolean isFull() {
       return (top == maxSize - 1);
    }
    public static void main(String[] args) {
       StackImp theStack = new StackImp(10); 
       theStack.push(10);
       theStack.push(20);
       theStack.push(30);
       theStack.push(40);
       theStack.push(50);
       
       while (!theStack.isEmpty()) {
          int value = theStack.pop();
          System.out.print(value);
          System.out.print(" ");
       }
       System.out.println("");
    }
    
}
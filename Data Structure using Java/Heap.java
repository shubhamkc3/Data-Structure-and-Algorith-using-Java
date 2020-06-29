public class Heap {
    private int[] Heap;
    private int size;
    private int maxsize;

    public Heap(int maxsize)
    {
        this.maxsize = maxsize; 
        this.size = 0; 
        Heap = new int[this.maxsize + 1]; 
        Heap[0] = Integer.MAX_VALUE; 
    }

    private int parent(int pos)
    {
        return pos/2;
    }

    private int leftchild(int pos)
    {
        return 2*pos;
    }
    private int rightchild(int pos)
    {
        return (2*pos)+1;
    }

    public void swap(int fpos, int spos)
    {
        int temp;
        temp=Heap[fpos];
        Heap[fpos]=Heap[spos];
        Heap[spos]=temp;
    }

    public void insert(int element)
    {
        Heap[++size]=element;
        int current=size;
        while(Heap[current]>Heap[parent(current)])
        {
            swap(current,parent(current));
            current=parent(current);
        }
    }

    public void print()
    {
        for(int i=1; i<=size/2;i++)
        {
            System.out.print(" PARENT : " + Heap[i] + " LEFT CHILD : " + 
            Heap[2 * i] + " RIGHT CHILD :" + Heap[2 * i + 1]); 
            System.out.println(); 
        }
    }
    public static void main(String[] args)
    {
        Heap maxHeap= new Heap();
        maxHeap.insert(5); 
        maxHeap.insert(3); 
        maxHeap.insert(17); 
        maxHeap.insert(10); 
        maxHeap.insert(84); 
        maxHeap.insert(19); 
        maxHeap.insert(6); 
        maxHeap.insert(22); 
        maxHeap.insert(9); 
        maxHeap.print(); 
    }
}
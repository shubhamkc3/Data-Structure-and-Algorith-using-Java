public class HeapSort{

    public void Heapsort(int array[])
    {
        int n=array.length;
        for(int i=(n/2-1); i>=0; i--)
        {
            Heapify(array,n,i);
        }

        for(int i=n-1;i>=0;i--)
        {
            int temp=array[0];
            array[0]=array[i];
            array[i]=temp;
            Heapify(array,i,0);
        }
    }

    

    public void Heapify(int array[], int n,int i)
    {
        int largest=i;
        int left=2*i+1;
        int right=2*i+2;

        if(left<n && array[left]> array[largest])
        {
            largest=left;
        }
        if(right<n && array[right]>array[largest])
        {
            largest=right;
        }

        if(largest!=i)
        {
            int temp=array[i];
            array[i]=array[largest];
            array[largest]=temp;
            Heapify(array,n,largest);
        }

    }
    public void printArray(int array[])
    {
        int n=array.length;
        System.out.println("Array sorted using heap sort algorithm");
        for(int i=0;i<n;i++)
        {
            System.out.println(array[i]+" ");
        }

    }

    public static void main(String[] args)
    {
        int array[] = {7,11,12,5,6,13};
        HeapSort HS= new HeapSort();
        HS.Heapsort(array);
        HS.printArray(array);
    }
}   
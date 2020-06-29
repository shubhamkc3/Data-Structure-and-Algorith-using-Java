public class BinarySearch {
    
    public static int search(int arr[],int first, int last, int x) 
    {
        
        while(first<=last)
        {
            int mid=(first+last)/2;
             if(arr[mid]==x)
            {
                return mid;
               
            }
            if(arr[mid]<x)
            {
                first=mid+1;
            }
            else
            {
                last=mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args)
    {
        int[] array= new int[]{1,2,3,4,5,6,7};
        int size=array.length-1;
        int value=3;
        int result= search(array,0, size, value);
        if(result==-1)
        {
            System.out.println("Element is not in an array");
        }
        else
        {
            System.out.println("Element is in index:"+result);
        }
    }
}
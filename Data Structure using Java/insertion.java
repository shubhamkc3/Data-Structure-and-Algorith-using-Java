public class insertion {

    public static void insertionsort(int[] arr )
    {
        int n = arr.length; 
        for (int k = 0; k < n; k++) 
        { 
           int j=k;
           int temp;
           while(j>0 && arr[j-1]>arr[j])
           {
               temp=arr[j];
               arr[j]=arr[j-1];
               arr[j-1]=temp;
               j--;
           }
           
        }
        for(int i=0; i<n; i++)
        {
            System.out.println(arr[i]+ " ");
            
        }
    }
    public static void main(String[] args)
    {
        int[] array= new int[]{ 11, 13, 5, 6};
        insertionsort(array);

    }
    
}
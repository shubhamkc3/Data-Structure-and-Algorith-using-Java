public class selectionsort {
    
    public static void selection(int[] arrays)
    {
        int n=arrays.length;
        int temp=0;
        int min_index=0;
        for(int i=0; i<n; i++)
        {
            min_index=i;
            for(int j=i+1; j<n; j++)
            {
                if(arrays[j]<arrays[min_index])
                {
                    min_index=j;
                    temp=arrays[i];
                    arrays[i]=arrays[min_index];
                    arrays[min_index]=temp; 
                }
                
            }
        }
        for(int i=0; i<n; i++)
        {
            System.out.println(arrays[i]+" ");
        }
    }

    public static void main(String[] args)
    {
       // selectionsort SS= new selectionsort();
        int[] arrays = new int[]{8,7,6,5,4,3,2,1};
        selection(arrays);
    }
}
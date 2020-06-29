import java.util.Arrays;

public class BubbleSort {

     void bubblesort(int[] values)
    {
        int i=0, j=0, temp=0;

        for (i=0; i<values.length-1; i++)
        {
            for(j=0; j<values.length-i-1; j++)
            {
                if(values[j]>values[j+1])
                {
                    temp=values[j];
                    values[j]=values[j+1];
                    values[j+1]=temp;

                }
            }
        }
    
                System.out.printf(Arrays.toString(values));
    }
    public static void main(String[] args)
    {
        BubbleSort b=new BubbleSort();
        int[] values= new int[]{9,8,7,6,5,4,3,2,1};
        b.bubblesort(values);
        
        
    }

}
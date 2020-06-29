import java.util.Arrays;

class MergeSort {

    public static void merge_sort(int[] a, int low, int high)
    {
      int mid;
      if(low<high)
      {
        mid=(low+high)/2;
        merge_sort(a,low,mid);
        merge_sort(a,mid+1,high);
        merge(a,low,mid,high);
      }
      
    }

    public static void merge(int[] a, int low, int mid, int high)
    {
      int[] b =new int[a.length];
      int i1,i2,index;
      
      for(index=0; index<=high; index++)
      {
        b[index]=a[index];
      }

        i1=low;
        i2=mid+1;
        index=low;

        while(i1<=mid && i2<=high)
        {
          if(b[i1]<b[i2])
          {
            a[index]=b[i1];
            i1++;
          }
          else
          {
            a[index]=b[i2];
            i2++;
          }
          index++;
        }
       
        while(i1<=mid)
       {
         a[index++]=b[i1++];
       }

        while(i2<=high)
        {
          a[index++]=b[i2++];
        }
       
    }


    // Driver program
    public static void main(String args[]) {
      int arr[] = { 6, 5, 12, 10, 9, 1 };
      int size=arr.length-1;
      merge_sort(arr,0,size);
      System.out.printf(Arrays.toString(arr));
    }
  }
def mergesort(array,low,high):
    if low < high:
        mid=(low+(high))//2
        mergesort(array,low,mid)
        mergesort(array,mid+1, high)
        merge(array,low,mid,high)

def merge(array,low,mid,high):
    b= [0] * len(array)
    for index in range(high+1):
        b[index]=array[index]

    i1=low
    i2=mid+1
    index=low
    
    while i2<=high and i1<=mid:
        if b[i1]<b[i2]:
            array[index]=b[i1]
            i1+=1
        else:
            array[index]=b[i2]
            i2+=1
        index+=1
    while i1<=mid:
        array[index]=b[i1]
        index+=1
        i1+=1
    
    while i2<=high:
        array[index]=b[i2]
        index+=1
        i2+=1
    
#driver code for the merge sort
array=[9,8,7,6,5,4,3,2,1]
size=len(array)-1
mergesort(array,0,size)
print("Sorted array is:")
for i in range (len(array)):
    print("%d" %array[i])
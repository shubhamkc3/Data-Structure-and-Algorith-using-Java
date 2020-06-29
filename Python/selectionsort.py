def selectionsort(array):
    n=len(array)
    for i in range(n):
        min_index=i
        for j in range(i+1,n):
            if array[j]<array[min_index]:
                min_index=j
                array[i],array[min_index]=array[min_index],array[i]



#driver code
array=[5,3,8,2,9,1,7,6,4]
selectionsort(array)
for i in range(len(array)):
    print("%d" %array[i])

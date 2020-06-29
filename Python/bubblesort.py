def bubblesort(array):
    n=len(array)
    for i in range (n-1):
        for j in range(n-i-1):
            if array[j]> array[j+1]:
                array[j], array[j+1] =array[j+1], array[j]


#driver code
array=[4,6,3,9,5,1,8,2,7]
bubblesort(array)

print("Sorted array is:")
for i in range (len(array)):
    print("%d" %array[i])
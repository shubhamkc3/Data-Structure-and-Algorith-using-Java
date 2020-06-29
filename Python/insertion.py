def insertionsort(array):
    for i in range(len(array)):
      j=i
      while j>0 and array[j-1]>array[j]:
          array[j-1],array[j]=array[j],array[j-1]
          j-=1

#driver code to test the program

array= [12,11,13,5,6]
insertionsort(array)
print("Sorted array is:")
for i in range(len(array)):
    print("%d" %array[i])
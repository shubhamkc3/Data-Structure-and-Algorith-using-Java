class Node:
    def __init__(self,data):
        self.data=data
        self.next=None

class LinkedList:
    def __init__(self):
        self.head=None

    def insert(self,data):
        new_Node =Node(data)
        if(self.head):
            current=self.head
            while(current.next):
                current=current.next
            current.next=new_Node
        else:
            self.head=new_Node

    def delete(self,target):
        prev=self.head
        temp=None
        if self.head.data is target:
            self.head=prev.next
        else:
            while prev and prev.data is not target:
                temp=prev
                prev=prev.next
            temp.next=prev.next
            
    def reverselist(self):
        temp=self.head
        next=None
        prev=None
        while(temp):
            self.head=temp
            next=temp.next
            temp.next=prev
            prev=temp
            temp=next

    def search(self, target):
        prev=self.head
        found=False
        while prev and found is False:
            if prev.data is target:
                 found=True
            else:
                prev=prev.next
        if found is True:
            print("The data is in the list")
        else:
            print("The data is not in the list")

    def size(self):
        prev=self.head
        count=0
        while(prev):
            count+=1
            prev=prev.next
        print(count)

  

    def printList(self):
        current=self.head
        while(current):
            print(current.data)
            current=current.next

if __name__=='__main__':    
    L=LinkedList()
    L.insert(2)
    L.insert(6)
    L.insert(1)
    L.insert(3)
   # L.delete(6)
    L.reverselist()
    L.printList()
    L.search(2)
    L.size()

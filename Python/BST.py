class Node:
    def __init__(self,data):
        self.data=data
        self.left=None
        self.right=None

    def insert(self,data):
        if self.data:
            if self.data>data:
                if self.left is None:
                    self.left=Node(data)
                else:
                    self.left.insert(data)
            elif self.data<data:
                if self.right is None:
                    self.right=Node(data)
                else:
                    self.right.insert(data)
        else:
            self.data=Node(data)

    def printBST(self):
        if self.left:
            self.left.printBST()
        print(self.data)
        if self.right:
            self.right.printBST()



BST=Node(10)
BST.insert(3)
BST.insert(7)
BST.insert(4)
BST.insert(8)
BST.printBST()

                
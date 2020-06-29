public class BinarySearchTree {
     Node root;
    public class Node{
        int data;
        Node left,right;

        Node(int d)
        {
            data=d;
            left=null;
            right=null;
        }
    }

   /* public Node insert(Node root,int data)
    {
        Node node=new Node(data);
        if(root==null)
        {
            return node;
        }
        Node parent=null;
        Node current=root;
        while(current!=null)
        {
            parent=current;
            if(current.data<=data)
            {
                current=current.right;
            }
            else
            {
                current=current.left;
            }
        }
        if(parent.data<=data)
        {
            parent.right=node;
            
        }
        else
        {
            parent.left=node;
        }
        return root;

    }*/

    void insert(int data)
    {
        root=insertdata(root, data);
    }

    Node insertdata(Node root, int data)
    {
        if(root==null)
        {
            root= new Node(data);
            return root;
        }
        if(root.data>data)
        {
            root.left=insertdata(root.left, data);
        }
        else if(root.data<data)
        {
            root.right=insertdata(root.right,data);
        }

        return root;
    }

    /* void inorder(Node root)
    {
        if(root!=null)
        {
            inorder(root.left);
            System.out.println(root.data+ " ");
            inorder(root.right);
        }
    }*/

    void delete(int data)
    {
        root=deletedata(root,data);
    }

    Node deletedata(Node root, int data)
    {
        if(root==null)
        {
            return root;
        }
        if(data<root.data)
        {
            root.left=deletedata(root.left,data);
        }
        else if(data>root.data)
        {
            root.right=deletedata(root.right,data);
        }
        else
        {
            if(root.left==null)
            {
                return root.right;
            }
            else if(root.right==null)
            {
                return root.left;
            }

            root.data=min_value(root.right);
            root.right=deletedata(root.right, root.data);
        }
        return root;

    }
    public Node search(int data)
    {
        Node current=root;
        while(current.data!=data)
        {
            if(current!=null)
            {
                
                if(current.data>data)
                {
                    current=current.left;
                }
                else if(current.data<data)
                {
                    current=current.right;
                }

                if(current==null)
                {
                    return null;
                }   
            }
        }
        return current;
    }

    int min_value(Node root)
    {
        int minv=root.data;
        while(root.left!=null)
        {
            minv= root.left.data;
            root=root.left;
        }
        return minv;
    }
    void inorder()  { 
        inorderRec(root); 
     } 
   
     // A utility function to do inorder traversal of BST 
     void inorderRec(Node root) { 
         if (root != null) { 
             inorderRec(root.left); 
             System.out.println(root.data); 
             inorderRec(root.right); 
         } 
     } 
    public static void main(String[] args)
    {
        BinarySearchTree BST= new BinarySearchTree();
        
        BST.insert(3);
        BST.insert(5);
        BST.insert(4);
        BST.insert(2);
        BST.insert(1);
       // BST.inorder();
        Node value=BST.search(5);
        System.out.println(value.data);
    }
}
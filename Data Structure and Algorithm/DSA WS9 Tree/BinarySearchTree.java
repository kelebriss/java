package WS9;

import java.util.*;
import java.lang.*;

public class BinarySearchTree // binary tree method
{
    public class TreeNode //tree node inbuilt class
    {
        private String m_key;
        private Object m_value;
        private TreeNode m_leftchild;
        private TreeNode m_rightchild;
        
        public TreeNode (String inkey, Object inval) // alternate constructor
        {
            if(inkey == null)
             throw new IllegalArgumentException ( " key can not be null");
           
            m_key = inkey;
            m_value = inval;
            m_leftchild = null;
            m_rightchild = null;
        }
        public String getKey() // return the key
        {
            return m_key;
        }
        public Object getValue() // return the value
        {
            return m_value;
        }
        public TreeNode getLeft() // return the left tree node
        {
            return m_leftchild;
        }
        public void setLeft(TreeNode newLeft) // set left tree node
        {
            m_leftchild = newLeft;
        }
        public TreeNode getRight() // return right tree node
        {
            return m_rightchild;
        }
        public void setRight(TreeNode newRight) // set right tree node
        {
            m_rightchild = newRight;
        }
    }
    
    private TreeNode m_root;
    
    public BinarySearchTree() //default constructor
    {
        m_root = null;
    }
    public Object find(String key) // function for calling recursive finding key function
    {
        return findRecursive(key, m_root);
    }
    public Object findRecursive(String key, TreeNode currNode) //recursive function for finding key
    {
        Object val = null;
        if (currNode == null) // if tree does not have node then throw exception
         throw new NoSuchElementException("key" + key + "not found");
         else if(key.equals(currNode.getKey())) // if find the key then assigned value
          val = currNode.getValue();
          else if(key.compareTo( currNode.getKey()) < 0) // if key is smaller then calling find function with left side node
           val = findRecursive(key, currNode.getLeft());
           else 
            val = findRecursive(key, currNode.getRight());  // if key is bigger then calling find function with left side node
            
        return val;
    }
    public void insert(String key, Object value) // function for calling recursive inserting function
    {
        insertRecursive(key, value, m_root);
    }
    public TreeNode insertRecursive(String key, Object data, TreeNode curr) // recursive function for inserting key
    {
        TreeNode upDateNode = curr;
        if( curr == null) // if tree does not have node then initialize and insert in it
         {
             TreeNode newNode = new TreeNode(key, data);
             upDateNode = newNode;
         }
         else if (key.equals(curr.getKey())) // if key is same then throw exception : already exist
          throw new IllegalArgumentException(" already value is exist");
          else if (key.compareTo(curr.getKey()) < 0) // if key is smaller then calling insert function with left side node
           curr.setLeft(insertRecursive(key, data, curr.getLeft()));
           else // if key is bigger then calling insert function with right side node
            curr.setRight(insertRecursive(key, data, curr.getRight()));
        return upDateNode;
    }
    public void delete(String key) // function for calling recursive delete function
    {
        deleteRecursive(key, m_root);
    }
    public TreeNode deleteRecursive(String key, TreeNode curr) // function for recursive delete function
    {
        TreeNode upDateNode = null; 
        if(curr == null) // if tree does not have node then throw exception
         throw new IllegalArgumentException(" Tree is not exist ");
         else if(key.equals(curr.getKey()))// if find the key then delete value
          upDateNode = deleteNode(key, curr);
          else if(key.compareTo(curr.getKey()) < 0)  // if key is smaller then calling delete function with left side node
           curr.setLeft(deleteRecursive(key, curr.getLeft()));
           else  // if key is bigger then calling delete function with right side node
            curr.setRight(deleteRecursive(key, curr.getRight()));
       
       return upDateNode;
    }
    public TreeNode deleteNode(String key, TreeNode delNode) // function for delete node 
    {
        TreeNode upDateNode = null;
        if(delNode.getLeft() == null && delNode.getRight() == null) //if children are null then just make it null
         upDateNode = null;
         else if( delNode.getLeft() != null && delNode.getRight() == null) // if only left child the take left side node
          upDateNode = delNode.getLeft();
          else if( delNode.getLeft() == null && delNode.getRight() != null) // if only right child then take right side node
           upDateNode = delNode.getRight();
           else // if it has 2 child, do left node most right node do promote
           {
            upDateNode = promoteSuccessor(delNode.getRight());  
            if(upDateNode != delNode.getRight())
             {
                upDateNode.setRight(delNode.getRight());
             }
            upDateNode.setLeft(delNode.getLeft());
           }
        
        return upDateNode;
    }
    public TreeNode promoteSuccessor(TreeNode curr) // function for promoting
    {
        TreeNode successor = curr;
        if(curr.getLeft() == null) // if left node is null then successor is current node
         successor = curr;
         else
         {
          if(curr.getLeft() != null) // if has left node then going last left node
           successor = promoteSuccessor(curr.getLeft());
          if(successor == curr.getLeft()) // if get last left node then do promote right node
            curr.setLeft(successor.getRight());
         }
       return successor;
    }
    public int height() // check the height of tree
    {   
        return height(m_root, 0);
    }
    public int height(TreeNode startNode, int htSoFar) // check the height of tree(recursive)
    {
        int iLeftHt, iRightHt;
        
        if(startNode == null)
         return htSoFar;
         else
         {
             iLeftHt = height(startNode.getLeft(), htSoFar+1); // check left side node
             iRightHt = height(startNode.getRight(), htSoFar+1); // check right side node
         }
        if(iLeftHt > iRightHt) // return the larger value
          return iLeftHt;
         else
           return iRightHt;
    }
}
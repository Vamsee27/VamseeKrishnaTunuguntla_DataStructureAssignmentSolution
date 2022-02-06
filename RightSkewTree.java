package com.bst.rightskew;

class Node{
	Node left;
	Node right;
	int data;
}

public class RightSkewTree {
	
	static Node newNode(int data) {
		Node newNode = new Node();
		newNode.left = null;
		newNode.right = null;
		newNode.data = data;
		return newNode;
	}
	
	static Node prevNode = null;
    static Node headNode = null;
	
	
	static void BSTtoSkewed(Node root,int order){

		if(root == null)
		{
			return;
		}

		if(order > 0)
		{
			BSTtoSkewed(root.right, order);
		}
		else
		{
			BSTtoSkewed(root.left, order);
		}
		Node rightNode = root.right;
		Node leftNode = root.left;
		
		if(headNode == null)
        {
            headNode = root;
            root.left = null;
            prevNode = root;
        }
        else
        {
            prevNode.right = root;
            root.left = null;
            prevNode = root;
        }
		
		if (order > 0)
        {
            BSTtoSkewed(leftNode, order);
        }
        else
        {
            BSTtoSkewed(rightNode, order);
        }
    }
	
	static void traverseRightSkewed(Node root)
    {
        if(root == null)
        {
            return;
        }
        System.out.print(root.data + " ");
        traverseRightSkewed(root.right);       
    }
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node root = newNode(50); 
		root.left = newNode(30); 
		root.right = newNode(60); 
		root.left.left = newNode(10); 
		root.right.left= newNode(55);
		
		int order = 0;
		BSTtoSkewed(root, order);
        traverseRightSkewed(headNode);

	}

}

# Tree

A binary tree is a tree data structure in which each node can have at most two children, which are referred to as the left child and the right child. 

The topmost node in a binary tree is called the root, and the bottom-most nodes are called leaves. A binary tree can be visualized as a hierarchical structure with the root at the top and the leaves at the bottom.

Binary trees have many applications in computer science, including data storage and retrieval, expression evaluation, network routing, and game AI. They can also be used to implement various algorithms such as searching, sorting, and graph algorithms.

## Representation of Binary Tree:
Each node in the tree contains the following:
- Data
- Pointer to the left child
- Pointer to the right child

![tree binary](../Media/binarytree.png)

```java
// Class containing left and right child
// of current node and key value
class Node {
	int key;
	Node left, right;

	public Node(int item)
	{
		key = item;
		left = right = null;
	}
}

```

## Basic Operations On Binary Tree:
- Inserting an element.
- Removing an element.
- Searching for an element.
- Deletion for an element.
- Traversing an element. There are four (mainly three) types of traversals in a binary tree which will be discussed ahead.


## Auxiliary Operations On Binary Tree:
- Finding the height of the tree
- Find the level of the tree
- Finding the size of the entire tree.



## Binary Tree Traversals:
Tree Traversal algorithms can be classified broadly into two categories:

- Depth-First Search (DFS) Algorithms
- Breadth-First Search (BFS) Algorithms


### Tree Traversal using Depth-First Search (DFS) algorithm can be further classified into three categories:

- Preorder Traversal (current-left-right): Visit the current node before visiting any nodes inside the left or right subtrees. Here, the traversal is root – left child – right child. It means that the root node is traversed first then its left child and finally the right child.
- Inorder Traversal (left-current-right): Visit the current node after visiting all nodes inside the left subtree but before visiting any node within the right subtree. Here, the traversal is left child – root – right child.  It means that the left child is traversed first then its root node and finally the right child.
- Postorder Traversal (left-right-current): Visit the current node after visiting all the nodes of the left and right subtrees.  Here, the traversal is left child – right child – root.  It means that the left child has traversed first then the right child and finally its root node.



### Tree Traversal using Breadth-First Search (BFS) algorithm can be further classified into one category:

- Level Order Traversal:  Visit nodes level-by-level and left-to-right fashion at the same level. Here, the traversal is level-wise. It means that the most left child has traversed first and then the other children of the same level from left to right have traversed. 


Let us traverse the following tree with all four traversal methods:

![level tree](../Media/levelbinarytree.png)

```
Pre-order Traversal of the above tree: 1-2-4-5-3-6-7
```
```
In-order Traversal of the above tree: 4-2-5-1-6-3-7
```
```
Post-order Traversal of the above tree: 4-5-2-6-7-3-1
```
```
Level-order Traversal of the above tree: 1-2-3-4-5-6-7
```


## Implementation of Binary Tree:
Let us create a simple tree with 4 nodes. The created tree would be as follows. 

![root](../Media/rootbinarytree.png)

```java
// Class containing left and right child
// of current node and key value
class Node {

	int key;

	Node left, right;
	public Node(int item)
	{
		key = item;
		left = right = null;
	}
}

// A Java program to introduce Binary Tree
class BinaryTree {
	
	// Root of Binary Tree
	Node root;
	
	// Constructors
	BinaryTree(int key) { root = new Node(key); }
	BinaryTree() { root = null; }
	public static void main(String[] args)
	{
		BinaryTree tree = new BinaryTree();
		
		// Create root
		tree.root = new Node(1);
		/* Following is the tree after above statement
		1
		/ \
		null null
		*/

		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		/* 2 and 3 become left and right children of 1
			1
			/ \
			2 3
		/ \ / \
	null null null null */
		tree.root.left.left = new Node(4);
		/* 4 becomes left child of 2
			1
			/ \
			2 3
			/ \ / \
		4 null null null
		/ \
		null null
		*/
	}
}

```


# Reference

https://www.geeksforgeeks.org/introduction-to-binary-tree-data-structure-and-algorithm-tutorials/
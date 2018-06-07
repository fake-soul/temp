import java.io.*;
import java.util.Scanner;

class tree {
	int data;
	tree left;
	tree right;

	tree(int value) {
		this.data = value;
	}
}


class btree {
	tree temp ;

	/* Method for insert data from the Tree */
	void insert(tree node, int value) {
		if (value < node.data) {
			if (node.left != null) 
				insert(node.left, value);
			else {
				System.out.println("Inserted " + value + " to left of "+ node.data);
			        node.left = new tree(value);
			}
		} 
		else if (value > node.data) {
			if (node.right != null) 
				insert(node.right, value);
			else {
				System.out.println("Inserted " + value + " to right of "+ node.data);
			        node.right = new tree(value);
			}
    		}
	}

	/* Method for search data from Tree */
	tree search(int key,tree node) {
		if(node != null) {
			if(key == node.data) {
				System.out.println("Data found!");
				return node;
			}
			else {
				if(key < node.data)
					return search(key,node.left);
				else
					return search(key,node.right);
			}
		}
		else {
			System.out.println("Data not found!");
			return null;
		}
	}

	/* Method for find minimum value from the Tree */
	tree minvalue(tree node) {
		if(node == null)
			return null;

		/* Go to the left sub tree to find the min element */
		if(node.left != null)
			return minvalue(node.left);
		else
			return node;
	}

	/* Method for find maximum value from the Tree */
	tree maxvalue(tree node) {
		if(node == null)
			return null;

		/* Go to the left sub tree to find the max element */
		if(node.right != null)
			return maxvalue(node.right);
		else
			return node;
	}

	/* Method for traversed in preorder from the Tree */
	void preorder(tree node) {
		if (node != null)  {
			System.out.println(node.data);
			preorder(node.left);
			preorder(node.right);
		}
	}

	/* Method for traversed in inorder from the Tree */
	void inorder(tree node) {
		if (node != null) {
			preorder(node.left);
			System.out.println(node.data);
			preorder(node.right);
		}
	}

	/* Method for traversed in postorder from the Tree */
	void postorder(tree node) {
		if (node != null) {
			preorder(node.left);
			preorder(node.right);
			System.out.println(node.data);
		}
	}

	/* Method for delete leaf from the Tree */
	void delete(tree node, int key) {
		if(node == null)
			System.out.println("Element Not Found!");
		else if(key < node.data)
			delete(node.left, key);
		else if(key > node.data)
			delete(node.right, key);
		else {
			if(node.right != null && node.left != null) {

				/* Replace with minimum element in the right sub tree */
				temp = minvalue(node.right);
				node.data = temp.data;

				/* Delete that node */
				delete(node.right,temp.data);
			}
			else { 

				/* If there is only one or zero children then directly remove it from the tree and connect its parent to its child */
				temp = node;
				if(temp.left == null)
					node.right = temp.right;
				else if(temp.right == null)
					node.left = temp.left;
				temp = null;
				System.out.println("Data delete successfully!\n");
			}
		}
	} 
}


class copy {
	public static void main(String args[]) {
		int key, choice = 0;
		Scanner input = new Scanner(System.in);
		tree root = null;
		btree bt = new btree();
		while(choice != 7) {
			System.out.println("1. Insert\n2. Search\n3. Delete\n4. Display\n5. Min Value\n6. Max Value\n7. Exit");
			System.out.println("Enter your choice:");
			choice = Integer.parseInt(input.nextLine());
			switch(choice) {
				case 1:
					System.out.println("Enter the value to insert:");
					if(root == null)
						root = new tree(Integer.parseInt(input.nextLine()));					
					else
						bt.insert(root, Integer.parseInt(input.nextLine()));
					break;
				case 2:
					System.out.println("Enter the value to search:");
					bt.search(Integer.parseInt(input.nextLine()),root);
					break;
				case 3:
					System.out.println("Enter the value to delete:");
					bt.delete(root,Integer.parseInt(input.nextLine()));
					break;
				case 4:
					System.out.println("\nPreorder:");
					bt.preorder(root);
					System.out.println("\nInorder:");
					bt.inorder(root);
					System.out.println("\nPostorder:");
					bt.postorder(root);
					break;
				case 5:
					if(bt.minvalue(root) == null)
						System.out.println("Tree is empty!");
					else
						System.out.println("Minimum value is "+bt.minvalue(root).data);
					break;
				case 6:
					if(bt.maxvalue(root) == null)
						System.out.println("Tree is empty!");
					else
						System.out.println("Maximum value is "+bt.maxvalue(root).data);
					break;
				case 7:
					System.out.println("Bye Bye!");
					System.exit(0);
					break;
				default:
					System.out.println("Invalid choice!");
			}
		}
	}
}
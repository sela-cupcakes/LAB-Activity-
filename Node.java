import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class SimpleBSTApp {
    Node root;

    SimpleBSTApp() {
        root = null;
    }

    void insert(int data) {
        root = insertRecursive(root, data);
    }

    Node insertRecursive(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }

        if (data == root.data) {
            System.out.println("Duplicate value " + data + " not inserted.");
            return root;
        } else if (data < root.data) {
            root.left = insertRecursive(root.left, data);
        } else {
            root.right = insertRecursive(root.right, data);
        }
        return root;
    }

    void inorderTraversal() {
        inorderRecursive(root);
    }

    void inorderRecursive(Node root) {
        if (root != null) {
            inorderRecursive(root.left);
            System.out.print(root.data + " ");
            inorderRecursive(root.right);
        }
    }

    boolean search(int data) {
        return searchRecursive(root, data);
    }

    boolean searchRecursive(Node root, int data) {
        if (root == null) {
            return false;
        }
        if (data == root.data) {
            return true;
        } else if (data < root.data) {
            return searchRecursive(root.left, data);
        } else {
            return searchRecursive(root.right, data);
        }
    }

    public static void main(String[] args) {
        SimpleBSTApp tree = new SimpleBSTApp();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nBST Menu:");
            System.out.println("1. Insert");
            System.out.println("2. Inorder Traversal");
            System.out.println("3. Search");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    tree.insert(scanner.nextInt());
                    break;
                case 2:
                    System.out.println("Inorder traversal: ");
                    tree.inorderTraversal();
                    break;
                case 3:
                    System.out.print("Enter value to search for: ");
                    int searchValue = scanner.nextInt();
                    System.out.println("Found: " + tree.search(searchValue));
                    break;
                case 4:
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
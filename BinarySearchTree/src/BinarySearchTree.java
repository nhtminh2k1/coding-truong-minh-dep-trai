
public class BinarySearchTree {

    class Node {

        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    Node root;

    BinarySearchTree() {
        root = null;
    }

    void deleteKey(int key) {
        root = deleteByCopying(root, key);
    }

    Node deleteByCopying(Node root, int key) {

        if (root == null) {
            return root;
        }

        if (key < root.key) {
            root.left = deleteByCopying(root.left, key);
        } else if (key > root.key) {
            root.right = deleteByCopying(root.right, key);
        } else {
            // node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.key = minValue(root.right);

            root.right = deleteByCopying(root.right, root.key);
        }

        return root;
    }

    public Node search(Node root, int key) {

        if (root == null || root.key == key) {
            return root;
        }

        if (root.key < key) {
            return search(root.right, key);
        }

        return search(root.left, key);
    }

    int minValue(Node root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    void insert(int key) {
        root = insertRec(root, key);
    }

    Node insertRec(Node root, int key) {

        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }

        return root;
    }

    void inorder() {
        inorderRec(root);
    }

    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    static int findMax(Node node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }

        int res = node.key;
        int lres = findMax(node.left);
        int rres = findMax(node.right);

        if (lres > res) {
            res = lres;
        }
        if (rres > res) {
            res = rres;
        }
        return res;
    }

    static int findMin(Node node) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }

        int res = node.key;
        int lres = findMin(node.left);
        int rres = findMin(node.right);

        if (lres < res) {
            res = lres;
        }
        if (rres < res) {
            res = rres;
        }
        return res;
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println(
                "Inorder traversal of the given tree");
        tree.inorder();

        System.out.println("\nDelete 20");
        tree.deleteKey(20);
        System.out.println(
                "Inorder traversal of the modified tree");
        tree.inorder();

        System.out.println("\nMaximum element is "
                + tree.findMax(tree.root));
        System.out.println(
                "Inorder traversal of the modified tree");
        tree.inorder();
        System.out.println("\nMinimum element is "
                + tree.findMin(tree.root));
    }

}

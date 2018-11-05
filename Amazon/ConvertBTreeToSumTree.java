 public class ConvertBTreeToSumTree {
    static class Node{
        Node left;
        Node right;
        int val;

        public Node(int val){
            this.val = val;
        }
    }

    static void insert(int data, Node root){
        if(root.val < data){
            if(root.right != null){
                insert(data, root.right);
            } else {
                root.right = new Node(data);
            }
        }

        if(root.val > data){
            if(root.left != null){
                insert(data, root.left);
            } else {
                root.left = new Node(data);
            }
        }
    }

    static void print(Node root){
        if(root.left != null){
            print(root.left);
        }

        System.out.print(" " + root.val);

        if(root.right != null){
            print(root.right);
        }
    }
 
 static int convertBinaryTreeToSumTree(Node root){
        if(root == null){
            return 0;
        }

        int leftSum = convertBinaryTreeToSumTree(root.left);
        int rightSum = convertBinaryTreeToSumTree(root.right);

        int oldVal = root.val;

        root.val = leftSum + rightSum;

        return oldVal + root.val;
    }


    public static void main(String[] args){
        Node root = new Node(5);
        insert(2, root);
        insert(1, root);
        insert(3, root);
        insert(7, root);
        insert(6, root);
        insert(8, root);

//        print(root);
//        System.out.println();
//        printBoundrys(root);

        convertBinaryTreeToSumTree(root);
        print(root);
    }
}

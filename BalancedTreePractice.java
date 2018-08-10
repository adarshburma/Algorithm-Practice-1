public class BalancedTreePractice {
    public int height(Node node){
        if(node == null){
            return 0;
        }

        return 1 + Math.max(height(node.left), height(node.right));
    }

    public boolean isBalanced(Node node){
        int lh;
        int rh;

        if(node == null){
            return true;
        }

        lh = height(node.left);
        rh = height(node.right);

        if(Math.abs(lh - rh) <= 1 && isBalanced(node.left) && isBalanced(node.right)){
            return true;
        }

        return false;
    }

    public static void main(String args[]){
        BalancedTreePractice practice = new BalancedTreePractice();
        Node tree = new Node(5);
        tree.insert(2);
        tree.insert(1);
        tree.insert(3);
        tree.insert(7);
        tree.insert(6);
        tree.insert(8);

        if(practice.isBalanced(tree)){
            System.out.println("Balanced");
        }
        else {
            System.out.println("Not Balanced");
        }

    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class RecoverBinarySearchTree {
    TreeNode first,second, pre;
    
    public void inorder(TreeNode root){
        if(root == null){
            return;
        }
        
        inorder(root.left);
        if(pre == null){
            pre = root;
        }else {
            if(root.val < pre.val){
                if(first == null){
                    first = pre;
                }
                second = root; 
            }
             pre = root; 
        }
        
        inorder(root.right);
        
    }
    public void recoverTree(TreeNode root) {
        if(root == null){
            return;
        }
        inorder(root);
        if(first != null && second != null){
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
        
    }
}

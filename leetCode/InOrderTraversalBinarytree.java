/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class InOrderTraversalBtree {
    
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while(!stack.isEmpty() || p != null){
           if(p != null){
               stack.push(p);
               p = p.left;
           }
            
            else {
                TreeNode poped = stack.pop();
                res.add(poped.val);
                p = poped.right;
            }
        }
       return res; 
    }
}

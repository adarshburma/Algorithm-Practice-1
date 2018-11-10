/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public class LevelNode{
        TreeNode node;
        int level;
        
        LevelNode(TreeNode node, int level){
            this.node = node;
            this.level = level;
        }
    }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<LevelNode> queue = new ArrayDeque<>();
        LevelNode top = new LevelNode(root, 0);
        queue.push(top);
        if(root != null){
            while(!queue.isEmpty()){
                LevelNode t = queue.pop();
                if(t.level <= res.size()-1){
                    List<Integer> level = res.get(t.level);
                    level.add(t.node.val);
                } else{
                    List<Integer> level = new ArrayList<>();
                    level.add(t.node.val);
                    res.add(level);
                }
                
                 if(t.node.right != null){
                    LevelNode right = new LevelNode(t.node.right, t.level+1);
                    queue.push(right);
                }

                if(t.node.left != null){
                    LevelNode left = new LevelNode(t.node.left, t.level+1);
                    queue.push(left);
                }
            }
        }
        
        
        return res;
    }
}

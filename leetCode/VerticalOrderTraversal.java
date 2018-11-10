/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 
 Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.

Examples 1:

Input: [3,9,20,null,null,15,7]

   3
  /\
 /  \
 9  20
    /\
   /  \
  15   7 

Output:

[
  [9],
  [3,15],
  [20],
  [7]
]
Examples 2:

Input: [3,9,8,4,0,1,7]

     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7 

Output:

[
  [4],
  [9],
  [3,0,1],
  [8],
  [7]
]
Examples 3:

Input: [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5)

     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7
    /\
   /  \
   5   2

Output:

[
  [4],
  [9,5],
  [3,0,1],
  [8,2],
  [7]
]
 */
 
 
class Solution {
     class LevelNode{
        TreeNode node;
        int level;
        
        LevelNode(TreeNode treenode, int l){
            node = treenode;
            level = l;
        }
    }
    public List<List<Integer>> verticalOrder(TreeNode root) {
        
        List<List<Integer>> res = new ArrayList<>();
        
        if(root != null) {
            Deque<LevelNode> queue = new ArrayDeque<LevelNode>();
            queue.addLast(new LevelNode(root,0));
            TreeMap<Integer, List<Integer>> map = new TreeMap<>();

            while(!queue.isEmpty()){
                LevelNode ln = queue.removeFirst();
                TreeNode node = ln.node;

                if(map.containsKey(ln.level)){
                    List<Integer> list = map.get(ln.level);
                    list.add(node.val);
                } else {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(node.val);
                    map.put(ln.level, list);
                }

                if(node.left != null){
                    queue.addLast(new LevelNode(node.left, ln.level-1));
                }
                
                if(node.right != null){
                    queue.addLast(new LevelNode(node.right, ln.level+1));
                }
  
            }

            for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
              res.add(entry.getValue()); 
            }
        }
 
        return res;
    }
}

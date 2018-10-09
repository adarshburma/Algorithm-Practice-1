class BinaryTreePreOrderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode n = stack.pop();
            res.add(n.val);
            if(n.right != null){
                stack.push(n.right);
            }
            
            if(n.left != null){
                stack.push(n.left);
            }
        }
        
        return res;
    }
}

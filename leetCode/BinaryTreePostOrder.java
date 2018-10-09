class BinaryTreePostOrder {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res= new ArrayList<>();
        
        if(root == null){
            return res;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while(!stack.isEmpty()){
            TreeNode temp = stack.peek();
            if(temp.right == null && temp.left == null){
                res.add(stack.pop().val);
            }else{
               if(temp.right != null){
                   stack.push(temp.right);
                   temp.right = null;
               } 
                if(temp.left != null){
                    stack.push(temp.left);
                    temp.left = null;
                }
            }
        }
        return res;
    }
}

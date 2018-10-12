static int inorderSuccessor(TreeNode root, int val){
        TreeNode temp = root;
        while(root != null && root.val != val){
            if(root.val > val){
                root = root.left;
            } else {
                root = root.right;
            }
        }

        if(root.val == val){
            if(root.right != null){
                root = root.right;
                while (root.left != null){
                    root = root.left;
                }
                return root.val;
            } else {
                while(temp != null && temp.val != val){
                    if(val > temp.val){
                        temp = temp.right;
                    } else if(val < temp.val){
                        successor = temp.val;
                        temp = temp.left;
                    }
                }
            }
        }

        return successor;
    }

    static int inorderPredecessor(TreeNode root, int val){
        TreeNode temp = root;
       while(root != null && root.val != val){
           if(root.val > val){
               root = root.left;
           } else {
               root = root.right;
           }
       }

       if(root.val == val){
           if(root.left != null){
               root = root.left;
               while (root.right != null){
                   root = root.right;
               }
               return root.val;
           } else {
               while(temp != null && temp.val != val){
                   if(val > temp.val){
                       predecessor = temp.val;
                       temp = temp.right;
                   } else if(val < temp.val){
                       temp = temp.left;
                   }
               }
           }
       }

       return predecessor;
    }

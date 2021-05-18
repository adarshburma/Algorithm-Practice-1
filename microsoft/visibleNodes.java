// link: https://leetcode.com/problems/count-good-nodes-in-binary-tree/

// number of visible nodes on all paths from root to leaves
    static int pathCnt = 0;
    
    static int visibleNodes(Node root) {
        // root is null no visible nodes
        if(root == null) return 0;
        
        // start from root and max val will be propagated as root val to left and right subtrees
        helper(root, root.val);
        return pathCnt;
    }

    static void helper(Node root, int max) {
        
        // leaf children are not visible
        if(root == null) {
            return;
        }
        
        // any node in the path should be >= root val or any value in the path > root  
        if(root.val >= max) {
            max = root.val;
            pathCnt++;
        }
        
        // explore left and right subtrees with max as root val 
        helper(root.left, max);
        helper(root.right, max);
    }
    
    // n -> number of nodes of binary tree.
    // time : O(n)
    // space : O(1) constant

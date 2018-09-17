package org.practice.courses.courseapi;

import java.net.StandardSocketOptions;
import java.util.ArrayList;
import java.util.LinkedList;

public class BinarySearchTreeConstruction {
    static int lastPrinted = 0;
    static class TreeNode{
        TreeNode left;
        TreeNode right;
        int data;

        TreeNode(int data){
            this.data = data;
        }

        public void print(){
            if(left != null){
                left.print();
            }
            System.out.println(data + " ");

            if(right != null){
                right.print();
            }
        }
    }


    public static TreeNode createBinarySearchTree(int[] arr, int start , int end){
        if(end < start){
            return null;
        }

        int mid = (start+end)/2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = createBinarySearchTree(arr, start, mid-1);
        root.right = createBinarySearchTree(arr, mid+1, end);

        return root;
    }

    public static void createLevelLists(TreeNode root, ArrayList<LinkedList<Integer>> lists, int level){
        if(root == null) return;
        LinkedList<Integer> list = null;
        if(lists.size() == level){
            list = new LinkedList<>();
            lists.add(list);
        }else{
            list = lists.get(level);
        }
        list.add(root.data);
        createLevelLists(root.left, lists, level+1);
        createLevelLists(root.right, lists, level+1);
    }

    public static ArrayList<LinkedList<Integer>> createLevelArrayList(TreeNode root){
        ArrayList<LinkedList<Integer>> lists = new ArrayList<>();
        createLevelList(root, lists, 0);
        return lists;
    }

    public static boolean checkBST(TreeNode root){
        if(root == null) return true;

        if(!checkBST(root.left)) return false;

        if(lastPrinted != 0 && root.data <= lastPrinted){
            return false;
        }

        lastPrinted = root.data;

        if(!checkBST(root.right)){
            return false;
        }

        return true;
    }

    public static boolean minMaxCheckBST(TreeNode node, Integer min, Integer max){
        if(node == null) return true;

        if((min != null && node.data <= min)  || (max != null && node.data > max)){
            return false;
        }

        if((!minMaxCheckBST(node.left, min, node.data)) || (!minMaxCheckBST(node.right, node.data,max))){
            return false;
        }

        return true;
    }


    public static void createLevelList(TreeNode root, ArrayList<LinkedList<Integer>> lists, int level){
        if(root == null) return;

        LinkedList<Integer> list = null;
        if(lists.size() == level){
            list = new LinkedList<>();
            lists.add(list);
        }else{
            list = lists.get(level);
        }
        list.add(root.data);
        createLevelList(root.left, lists, level+1);
        createLevelList(root.right, lists, level+1);

    }

    public static ArrayList<LinkedList<Integer>> createLevelListBFS(TreeNode root){
        ArrayList<LinkedList<Integer>> lists = new ArrayList<>();
        LinkedList<TreeNode> current = new LinkedList<>();
        LinkedList<Integer> currentData = new LinkedList<>();
        if(root != null){
            current.add(root);
            currentData.add(root.data);
        }
        while(current.size() > 0){
            lists.add(currentData);
            LinkedList<TreeNode> parents = current;
            current = new LinkedList<TreeNode>();
            currentData = new LinkedList<Integer>();
            for(TreeNode parent: parents){
                if(parent.left != null){
                    current.add(parent.left);
                    currentData.add(parent.left.data);
                }

                if(parent.right != null){
                    current.add(parent.right);
                    currentData.add(parent.right.data);
                }
            }
        }

        return lists;
    }

    public static ArrayList<LinkedList<TreeNode>> BFS(TreeNode root){
        ArrayList<LinkedList<TreeNode>> res = new ArrayList<>();
        LinkedList<TreeNode> current = new LinkedList<>();
        if(root != null){
            current.add(root);
        }
        while(current.size() > 0){
            res.add(current);
            LinkedList<TreeNode> parents = current;
            current = new LinkedList<>();
            for(TreeNode parent : parents){
                if(parent.left != null){
                    current.add(parent.left);
                }

                if(parent.right != null){
                    current.add(parent.right);
                }
            }
        }

        return res;
    }

    public static int height(TreeNode root){
        if(root == null){
            return -1;
        }

        return Math.max(height(root.left), height(root.right)) + 1;
    }

    public static boolean isBalanced(TreeNode root){
        if (root == null) return true;
        int diff = Math.abs(height(root.left) - height(root.right));
        if(diff > 1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public static void main(String args[]){
        int[] input = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14};
        TreeNode root = createBinarySearchTree(input, 0, input.length-1);
        for(LinkedList<Integer> list : createLevelArrayList (root)){
            System.out.println(list);
        }

        System.out.println();

        for(LinkedList<Integer> node: createLevelListBFS(root)){
            System.out.println(node);
        }

        System.out.println();

        for(LinkedList<TreeNode> level: BFS(root)){
            System.out.print("[");
            for(TreeNode node : level){
                System.out.print(node.data + " ");
            }
            System.out.print("]");
            System.out.println();
        }

        System.out.println();
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(4);
        root2.right = new TreeNode(6);
        root2.left.left = new TreeNode(3);
        root2.left.right = new TreeNode(8);
        root2.left.left.left = new TreeNode(2);
        root2.left.left.right = new TreeNode(5);
        System.out.println("is Balanaced:" + isBalanced(root2));

        System.out.println();

        System.out.println("is BST:" + checkBST(root));

        System.out.println();

        System.out.println("is BST min max :" + minMaxCheckBST(root2, null, null));

    }
}

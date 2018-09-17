package org.practice.courses.courseapi;

import apple.laf.JRSUIUtils;

import java.util.ArrayList;
import java.util.LinkedList;

public class BinarySearchTreeConstruction {

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

    public static void main(String args[]){
        int[] input = new int[] {1,2,3,4,5,6,7,8};
        TreeNode root = createBinarySearchTree(input, 0, input.length-1);
        for(LinkedList<Integer> list : createLevelArrayList (root)){
            System.out.println(list);
        }

        System.out.println();

        for(LinkedList<Integer> node: createLevelListBFS(root)){
            System.out.println(node);
        }

    }
}

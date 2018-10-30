package org.practice.courses.courseapi;

public class GetRank {
    static RankNode root = null;
    static class RankNode{
        int left_size;
        RankNode right;
        RankNode left;
        int data;

        RankNode(int data){
            this.data = data;
        }

        void insert(int val){
            if(data >= val) {
                if(this.left != null){
                    left.insert(val);
                } else {
                    left = new RankNode(val);
                }

                left_size++;
            }

            if(data < val){
                if(this.right != null){
                    right.insert(val);
                } else {
                    right = new RankNode(val);
                }
            }
        }
    }

    static int getRank(int num, RankNode root){
        if(num == root.data){
            return root.left_size;
        } else if(num < root.data){
            if(root.left == null){
                return -1;
            } else {
                return getRank(num, root.left);
            }
        }

        return root.right == null ? -1 : 1+root.left_size+getRank(num, root.right);
    }

    static void track (int num){
        if(root == null){
            root = new RankNode(num);
        } else {
            root.insert(num);
        }
    }

    static int getRankForNode(int num){
        return getRank(num, root);
    }

    public static void main(String[] args){
        int[] arr = {5,1,4,4,5,9,7,13,3};


        for(int i = 0 ; i < arr.length; i++){
            track(arr[i]);
        }

        System.out.print("Get Rank for node: " + getRankForNode(4));

    }
}

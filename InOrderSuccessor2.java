package com.iheartmedia.salesforce.config.handler;

public class InOrderSuccessor {
    static class Node{
        Node left;
        Node right;
        int data;
        Node parent = null;

        Node(int data){
            this.data = data;
        }

        void insert(int data){
            if(data < this.data){
                if(left != null){
                    left.insert(data);
                }else{
                    left = new Node(data);
                    left.parent = this;
                }
            } else if(data > this.data){
                if(right != null){
                    right.insert(data);
                }else{
                    right = new Node(data);
                    right.parent = this;
                }
            }
        }

        Node findNode(int value){
            if(data == value){
                return this;
            }

            if(value < data){
                if(left != null){
                    return left.findNode(value);
                }
            }

            if(value > data){
                if(right != null){
                    return right.findNode(value);
                }
            }

            return null;
        }


        void printTree(){
            if(left != null){
                left.printTree();
            }
            if(this.parent != null) {
                System.out.println(this.data + " -> " + this.parent.data);
            }


            if(right != null){
                right.printTree();
            }
        }

        Node leftMost(Node node){
            if(node.left != null){
                node = node.left;
            }

            return node;
        }

    }

    static Node leftMostNode(Node root){
        if(root.left != null){
            root = root.left;
        }
        return root;
    }

    static Node inOrderSuccessor(Node node, int data){
        if(node.right != null){
            return leftMostNode(node.right);
        }

        Node parent = node.parent;
        while(parent != null && parent.right.data == data){
            node = parent;
            parent = parent.parent;
        }
        return parent;
    }

    static Node findInOrderSuccessor(Node root, int data){
        Node node = root.findNode(data);
        return inOrderSuccessor(node, data);
    }

    static Node leftMost(Node node){
        if(node.left != null){
            node = node.left;
        }

        return node;
    }

    static Node rightMost(Node node){
        if(node.right != null){
            node  = node.right;
        }

        return node;
    }


    public static void main(String args[]){
        Node root  = new Node(5);
        root.insert(2);
        root.insert(1);
        root.insert(3);
        root.insert(7);
        root.insert(6);
        root.insert(8);

        root.printTree();

        System.out.println();

        System.out.println(root.findNode(3).data);
        System.out.print("In Order Successor of 3 is: " + findInOrderSuccessor(root, 3).data);

    }

}

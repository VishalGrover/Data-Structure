package Tree;


//The problem statement states that we need to print  nodes at k distance from a node X
public class KNodesFromX {
    public static void main(String[] args){
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(12);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);
        TreeNode target = root.left.right;
        printkthNode(root , target, 2);
    }

    public static int  printkthNode(TreeNode root, TreeNode target, int k){
        if (root == null){
            return  -1;
        }
        if(root == target){
            printkNodesDown(root, k);
            return 0;
        }

        int d1 = printkthNode(root.left, target, k );
        if(d1 != -1){
            if(d1 + 1 != k){
                System.out.println(root.data);
            }
            else{
                printkNodesDown(root.right, k -d1- 2);
            }
            return d1 + 1;
        }

        int d2 = printkthNode(root.right, target, k);
        if(d2 != -1){
            if(d2 + 1 == k){
                System.out.println(root.data);
            }
            else{
                printkNodesDown(root.left, k -d2- 2);
            }
            return d1 + 1;
        }
        return  -1;
    }

    public static void printkNodesDown(TreeNode root, int k){

        if(root == null){
            return;
        }
        if ((k == 0)){
            System.out.println(root.data);
        }

         printkNodesDown(root.left, k -1);
        printkNodesDown(root.right, k -1);
    }
}

class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data){
        this.data = data;
    }
}

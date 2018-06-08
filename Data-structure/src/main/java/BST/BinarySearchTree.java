package BST;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author yanzy
 * @Description 二叉查找树
 * @date 2018-06-06 14:49
 */
public class BinarySearchTree {
    private BSTNode root = null;
    private List<BSTNode> bstNodeList = new ArrayList<BSTNode>(16);
    //查找指定key的node所需的次数
    private int findNum = 0;


    /**
     * 创建一颗二叉查找树
     * @param nodes 所有节点
     */
    public void createBST(Map<Integer, Integer> nodes) {
        for (Map.Entry<Integer, Integer> node : nodes.entrySet()) {
            insertNode(node.getKey(), node.getValue());
        }
    }

    /**
     * 查找节点
     * @param key
     * @return
     */
    public BSTNode findNode(int key) {
        BSTNode currentNode = root;
        while (currentNode != null && currentNode.getKey() != key) {
            ++findNum;
            if (currentNode.getKey() < key) {
                currentNode = currentNode.getRightNode();
            } else if (currentNode.getKey() > key) {
                currentNode = currentNode.getLeftNode();
            }
        }
        return currentNode;
    }

    /**
     * 插入节点
     * @param key
     * @param value
     */
    public void insertNode(int key, int value) {
        if (this.root == null) {
            root = new BSTNode(key, value);
            System.out.println("------->创建根节点成功,key: " + key + " value: " + value);
            return;
        }
        BSTNode currentNode = this.root;
        BSTNode parentNode = this.root;
        boolean isLeftChild = true;

        while (currentNode != null) {
            parentNode = currentNode;
            if (currentNode.getKey() < key) {
                currentNode = currentNode.getRightNode();
                isLeftChild = false;
            } else if (currentNode.getKey() > key) {
                currentNode = currentNode.getLeftNode();
                isLeftChild = true;
            } else {
                System.out.println("插入的节点key有误,key: " + key);
                return;
            }
        }
        BSTNode newNode = new BSTNode(key, value);
        if (isLeftChild) {
            parentNode.setLeftNode(newNode);
        } else {
            parentNode.setRightNode(newNode);
        }
        this.bstNodeList.add(newNode);
    }

    /**
     * 遍历树节点
     * @param code 遍历方式代码，为1 先序遍历树；为2 后序遍历树；为3 中序遍历树
     * @param root
     */
    public void iterateNode(int code, BSTNode root) {
        switch (code) {
            case 1:
                this.preIterate(root);
                break;
            case 2:
                this.postIterate(root);
                break;
            case 3:
                this.inIterate(root);
                break;
        }
    }

    /**
     * 先序遍历，根左右
     * @param root
     */
    public void preIterate(BSTNode root) {
        System.out.println("\n\tkey: "+root.getKey()+",value: "+root.getValue());
        if(root.getLeftNode()!=null){
            preIterate(root.getLeftNode());
        }
        if(root.getRightNode()!=null){
            preIterate(root.getRightNode());
        }
    }

    /**
     * 后序遍历，左右根
     * @param root
     */
    public void postIterate(BSTNode root) {
        if(root.getLeftNode()!=null){
            postIterate(root.getLeftNode());
        }
        if(root.getRightNode()!=null){
            postIterate(root.getRightNode());
        }
        System.out.println("\n\tkey: "+root.getKey()+",value: "+root.getValue());
    }

    /**
     * 中序遍历，左根右
     * @param root
     */
    public void inIterate(BSTNode root) {
        if(root.getLeftNode()!=null){
            inIterate(root.getLeftNode());
        }
        System.out.println("\n\tkey: "+root.getKey()+",value: "+root.getValue());
        if(root.getRightNode()!=null){
            inIterate(root.getRightNode());
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insertNode(3, 3);
        bst.insertNode(2, 2);
        bst.insertNode(5, 5);
        bst.insertNode(1, 1);
        bst.insertNode(6, 6);
        bst.insertNode(4, 4);
        for (BSTNode node : bst.bstNodeList) {
            System.out.println("key: " + node.getKey() + " leftChild: " + node.getLeftNode() + " rightChild: " + node.getRightNode());
        }
        //查找上述创建的bst中key为findKey的节点
        int findKey = 2;
        BSTNode result = bst.findNode(findKey);
        if (result != null) {
            System.out.println("\n----------------------------------" +
                    "\nfind node whose key = " + findKey + ": " + result +
                    "\nfind number is: " + bst.findNum);
        } else {
            System.out.println("\n----------------------------------" +
                    "\ncan not find node whose key = " + findKey +
                    "\nfind number is: " + bst.findNum);
        }
        //先序遍历二叉树
        System.out.println("\n\t--------------------\n先序遍历二叉树结果为：\n");
        bst.iterateNode(1,bst.root);
        //后序遍历二叉树
        System.out.println("\n\t--------------------\n后序遍历二叉树结果为：\n");
        bst.iterateNode(2,bst.root);
        //中序遍历二叉树
        System.out.println("\n\t--------------------\n中序遍历二叉树结果为：\n");
        bst.iterateNode(3,bst.root);
    }
}

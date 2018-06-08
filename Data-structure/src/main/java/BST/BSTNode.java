package BST;

/**
 * @author yanzy
 * @Description BST节点对象
 * @date 2018-06-06 15:51
 */
public class BSTNode {
    int key;
    int value;
    BSTNode leftNode;
    BSTNode rightNode;

    public BSTNode(int key, int value){
        this.key = key;
        this.value = value;
    }

    public void displayNode(){}

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public BSTNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(BSTNode leftNode) {
        this.leftNode = leftNode;
    }

    public BSTNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(BSTNode rightNode) {
        this.rightNode = rightNode;
    }
}

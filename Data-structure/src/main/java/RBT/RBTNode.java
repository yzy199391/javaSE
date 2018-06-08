package RBT;

/**
 * @author yanzy
 * @Description 红黑树节点
 * @date 2018-06-08 9:54
 */
public class RBTNode {
    int key;
    int value;

    String color;

    RBTNode leftNode;
    RBTNode rightNode;

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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public RBTNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(RBTNode leftNode) {
        this.leftNode = leftNode;
    }

    public RBTNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(RBTNode rightNode) {
        this.rightNode = rightNode;
    }
}

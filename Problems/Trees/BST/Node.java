package Data_Structures.BST;

public class Node {

    public int key;
    public String value;
    public Node right;
    public Node left;

    public Node(int k, String v) {
        this.key = k;
        this.value = v;
    }

    @Override
    public String toString() {
        return "key= " + this.key + " value= " + this.value;
    }

    public int getKey() {
        return this.key;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String v) {
        this.value = v;
    }
}
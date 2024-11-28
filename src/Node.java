
public class Node {
    Node leftNode, rightNode;
    int value, bf=0;
    int height=0;
    //bf = altura sub. esquerda - 
    //   = altura sub. direita

    public String toString() {
    	return value + "";
    }
    
     public Node(int value, Node leftNode, Node rightNode) {
    	
		this.leftNode = leftNode;
		this.rightNode = rightNode;
		this.value = value;
	}
	public Node(int value) {
		this.value = value;
	}
	public Node getLeftNode() {
		return leftNode;
	}
	public void setLeftNode(Node leftNode) {
		this.leftNode = leftNode;
	}
	public int getBf() {
		return bf;
	}

	public void setBf(int bf) {
		this.bf = bf;
	}

	public Node getRightNode() {
		return rightNode;
	}
	public void setRightNode(Node rightNode) {
		this.rightNode = rightNode;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
    
	public int degree() {
		int degree = 0;
		if (leftNode != null)
			degree++;
		if (rightNode != null)
			degree++;
		return degree;	
	}
    
}

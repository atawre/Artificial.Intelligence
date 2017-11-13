import java.util.*;
/*
 * The node class contains:
	- A Node's reference to its children (if any),
	- A string to refer to the name of the node
	- A reference to the parent node
*/
class Node {

	protected List<Node> children;

	//the state of this node
	private QuartoBoard quartoBoard;

	//references the parent node
	protected Node parent;
	
	//constructor method
	public Node(QuartoBoard board) {
		this.children = new ArrayList<Node>();
		this.quartoBoard = board;
	}
	
	//returns the node's name
	public QuartoBoard getBoard() {
		return quartoBoard;
	}
	
	//add a new child to the children list.  This also sets the child node's parent node
	public void addChild(Node child) {
		children.add(child);
		child.setParentNode(this);
	}
	
	//returns the list of children for this node
	public List<Node> getChildren() {
		return children;
	}
	
	//changes the node's parent node
	public void setParentNode(Node newParentNode) {
		this.parent = newParentNode;
	}
	
	//gets the node's parent node
	public Node getParentNode() {
		return this.parent;
	}

	//MAIN METHOD
	public static void main(String[] args) {
		QuartoBoard b = new QuartoBoard(5, 5, 32,null);
		Node root = new MaxNode(b);
		for(int i=0; i<5; i++){
			b = new QuartoBoard(5, 5, 32,null);
			b.insertPieceOnBoard(i,i,i);
			Node c = new MinNode(b);
			root.addChild(c);
		}

		List<Node> children;
		for (Node child : root.getChildren()) {
			child.quartoBoard.printBoardState();
		}
	}
}

/*
 * The MinNode class is a subclass of the node class 
 * that requires no modification of functionality
*/
class MinNode extends Node {
	//constructor method
	public MinNode(QuartoBoard board) {
		super(board);
	}

}

/*
 * The MaxNode class is a subclass of the node class 
 * that requires no modification of functionality.
*/
class MaxNode extends Node {
	//constructor method
	public MaxNode(QuartoBoard board) {
		super(board);
	}
}

/*
 * The TerminatingNode class is a subclass of the node class.
 * A TerminatingNode has a value assigned to it.
*/
class TerminatingNode extends Node {
	private int value;
	
	//constructor method
	public TerminatingNode(QuartoBoard board, int value) {
		super(board);
		this.value = value;
	}
	
	//terminating nodes should not have children
	public void addChild(Node child) {
		System.out.println("\nTerminating Nodes cannot have children");
		System.exit(-1);
	}
	
	//return the value
	public int getValue() {
		return this.value;
	}

}



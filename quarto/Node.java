import java.util.*;
/*
 * The node class contains:
	- A Node's reference to its children (if any),
	- A string to refer to the name of the node
	- A reference to the parent node
*/
class Node {

	protected List<Node> children;
    protected static final int NUMBER_OF_ROWS = 5;
    protected static final int NUMBER_OF_COLUMNS = 5;
    protected static final boolean ACTION_PIECE_SELECTION = true;
    protected static int pieceId = 0;
    
	//the state of this node
	private QuartoBoard board;

	//references the parent node
	protected Node parent;
	
	//constructor method
	public Node(QuartoBoard board) {
		this.children = new ArrayList<Node>();
		this.board = new QuartoBoard(board);
	}

	//constructor method
	public Node() {
		this.children = new ArrayList<Node>();
		this.board = new QuartoBoard(5, 5, 32,null);
	}
	//changes the node's parent node
	public void setPieceId(int id) {
		this.pieceId = id;
	}
	
	//gets the node's parent node
	public int getPieceId() {
		return this.pieceId;
	}
	
	//returns the node's name
	public QuartoBoard getBoard() {
		return board;
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

	//generate next set of states for the node.
	public void generateStates(boolean pieceSelection) {
        boolean max = false;
        if(this instanceof MaxNode)
            max = true;
        //max ^= true; //toggle node type.
        if(pieceSelection){
            System.out.println(this.board.chooseNextPieceNotPlayed());
        }
	}

	private boolean checkIfGameIsDraw(QuartoBoard b) {
		return b.checkIfBoardIsFull();
	}

	//loop through board and see if the game is in a won state
	private boolean checkIfGameIsWon(QuartoBoard b) {

		//loop through rows
		for(int i = 0; i < NUMBER_OF_ROWS; i++) {
			//gameIsWon = this.quartoBoard.checkRow(i);
			if (b.checkRow(i)) {
				System.out.println("Win via row: " + (i) + " (zero-indexed)");
				return true;
			}

		}
		//loop through columns
		for(int i = 0; i < NUMBER_OF_COLUMNS; i++) {
			//gameIsWon = this.quartoBoard.checkColumn(i);
			if (b.checkColumn(i)) {
				System.out.println("Win via column: " + (i) + " (zero-indexed)");
				return true;
			}

		}

		//check Diagonals
		if (b.checkDiagonals()) {
			System.out.println("Win via diagonal");
			return true;
		}

		return false;
	}

	public int heuristic() {
        Scanner scanner = new Scanner(System.in);
        QuartoBoard cb = new QuartoBoard(this.board);
        int turn = 0; //0 - piece, 1 - move.
        int pieceID = 0;
        int[] move = new int[2];
        int utility = 0;
        boolean done = false;
        boolean max = false;
        if(this instanceof MaxNode)
            max = true;
        while(!done){
            //System.out.print("choose Piece : "); System.out.println(max);
            pieceID = cb.chooseRandomPieceNotPlayed(100);
            max ^= true; //toggle node type.
            //System.out.print("choose Move : "); System.out.println(max);
            move = cb.chooseRandomPositionNotPlayed(100);
            cb.insertPieceOnBoard(move[0], move[1], pieceID);
            if(checkIfGameIsDraw(cb)){
		        cb.printBoardState();
		        System.out.println("\nBoard full!");
                done = true;
            }else if (checkIfGameIsWon(cb)){
		        cb.printBoardState();
		        System.out.println("\nSomebody won!");
                done = true;
                if(this instanceof MaxNode)
                    utility = max?1:-1;
                else
                    utility = max?-1:1;
            }
            //String line = scanner.nextLine();
        }
        System.out.print("utility : "); System.out.println(utility);
        return utility;
    }

	//MAIN METHOD
	public static void main(String[] args) {
		QuartoBoard b = new QuartoBoard(5, 5, 32,null);
		Node root = new MaxNode(b);
        root.heuristic();
/*
		Node root = new MaxNode(b);
		for(int i=0; i<5; i++){
			b = new QuartoBoard(5, 5, 32,null);
			b.insertPieceOnBoard(i,i,i);
			Node c = new MinNode(b);
			root.addChild(c);
		}

		List<Node> children;
		for (Node child : root.getChildren()) {
			child.board.printBoardState();
		}
*/
	}

	public String getName() {
		// TODO Auto-generated method stub
		return "";
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
	public MinNode() {
		super();
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
	public MaxNode() {
		super();
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

	//constructor method
	public TerminatingNode(QuartoBoard board) {
		super(board);
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

	//return the value
	public void setValue(int h) {
		this.value = h;
	}

}

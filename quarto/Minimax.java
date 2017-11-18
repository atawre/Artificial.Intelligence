import java.util.*;
import java.lang.Math;

/*
 * The Minimax class contains:
	- The main() method
	- alphaBetaSearch
	- maxValue
	- minValue
	- code to build example game trees
**/

public class Minimax {

	/*
	 * The main method()
	 * 
	 * If a parameter is provided (e.g., java Minimax 1234), then a
	 * minimax tree with depth 3 and branching factor 3 is built,
	 * using randomly-generated integers, with the parameter used
	 * as the seed for the random-number generator.
	 * 
	 * If no parameter is provided, then the example minimax tree
	 * in the buildAlphaBetaTreeExample method is used.
	 */
	public static void main(String[] args) {

		long seed = 0;

		//the root of the alpha-beta tree example
		//Node alphaBetaExampleRoot = buildAlphaBetaTreeExample();
		Node alphaBetaExampleRoot = new MaxNode();
		//value returned by the alpha-beta search algorithm
		int value = alphaBetaSearch(alphaBetaExampleRoot);
		System.out.println("\nValue of the Alpha-Beta Tree Example: " + value);		
	}
	
	/*
	 * The alphaBetaSearch algorithm is used for computing the value for the alpha-beta tree example
	 * @param node  a node from a minimax game tree
	 * @return the value of the tree.
	 */
	public static int alphaBetaSearch(Node node) {

                // call maxValue on the root of the tree, with 
                // alpha and beta set to very small and very large initial values
		int value = maxValue(node, Integer.MIN_VALUE, Integer.MAX_VALUE, true);

		return value;
	}


	/*
	 * The maxValue algorithm is used for computing the value of a MAX node,
	 * using alpha-beta pruning where appropriate.
	 * @param node  a node from a minimax game tree
	 * @param alpha  the alpha value passed from the node's parent
	 * @param beta   the beta value passed from the node's parent
	 * @return the value of the node.
	 */
	public static int maxValue(Node node, int alpha, int beta, boolean pieceSelection) {
		System.out.println("maxValue=> generating children.");
		if(pieceSelection){}
			//for each available piece generate node.(max 32)
			//the list generated in above line is list of children.
		else{}
			//for each available board position place the piece and generate node. (max 25)
			//the list generated in above line is list of children.
		
		// if the current node is a TerminatingNode
		if (node instanceof TerminatingNode) {
			//return the value assigned to the Terminating node
			return ((TerminatingNode)node).getValue();
		}
		else {
			int value = Integer.MIN_VALUE;

			List<Node> children = node.getChildren();
			for(Iterator<Node> i = children.iterator(); i.hasNext(); ) {
				Node child = i.next();

                value = Math.max(value, minValue(child, alpha, beta, false));
                if(value >= beta){
                    System.out.println("** All children of " + node.getName() + " after " + child.getName() + " are pruned.");
                    System.out.println("Value returned for node " + node.getName() + " is " + value);
                    return value;
                }
                alpha = Math.max(alpha, value);
				
				// Insert necessary code below, to update the node's value,
				// as well as alpha and beta.
				// Use alpha-beta pruning where appropriate.
				//
				// When a node's remaining children are to be pruned, use the
				// following two lines to print information before returning
				// the value:
				//
				//	System.out.println("** All children of " + node.getName() + " after " + child.getName() + " are pruned.");
				//	System.out.println("Value returned for node " + node.getName() + " is " + value);
			}
			System.out.println("Value returned for node " + " is " + value);
			return value;
		}
	}


	/*
	 * The minValue algorithm is used for computing the value of a MIN node,
	 * using alpha-beta pruning where appropriate.
	 * @param node  a node from a minimax game tree
	 * @param alpha  the alpha value passed from the node's parent
	 * @param beta   the beta value passed from the node's parent
	 * @return the value of the node.
	 */
	public static int minValue(Node node, int alpha, int beta, boolean pieceSelection) {

		// if the current node is a TerminatingNode
		if (node instanceof TerminatingNode) {
			//return the value assigned to the Terminating node
			return ((TerminatingNode)node).getValue();
		}

		else {
			int value = Integer.MAX_VALUE;

			List<Node> children = node.getChildren();
			for(Iterator<Node> i = children.iterator(); i.hasNext(); ) {
				Node child = i.next();

                value = Math.min(value, maxValue(child, alpha, beta, true));
                if(value <= alpha){
                    System.out.println("** All children of " + node.getName() + " after " + child.getName() + " are pruned.");
                    System.out.println("Value returned for node " + node.getName() + " is " + value);
                    return value;
                }
                beta = Math.min(beta, value);
				// Insert necessary code below, to update the node's value,
				// as well as alpha and beta.
				// Use alpha-beta pruning where appropriate.
				//
				// When a node's remaining children are to be pruned, use the
				// following two lines to print information before returning
				// the value:
				//
				//	System.out.println("** All children of " + node.getName() + " after " + child.getName() + " are pruned.");
				//	System.out.println("Value returned for node " + node.getName() + " is " + value);
			}
			System.out.println("Value returned for node " + " is " + value);
			return value;
		}
	}

	/*
	 * This function generates a random integer between
	 * minVal and maxVal, inclusive.
	 * If verbose is set to true, it prints the value on the screen.
	 */
	public static int genRandNum(int minVal, int maxVal, Random random, boolean verbose) {
		int randomNum = minVal + random.nextInt(maxVal - minVal + 1);
		if (verbose) {
			System.out.println(randomNum);
		}
		return randomNum;
	}
}

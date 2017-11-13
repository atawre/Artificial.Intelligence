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

		if (args.length == 0) {
			//the root of the alpha-beta tree example
			Node alphaBetaExampleRoot = buildAlphaBetaTreeExample();

			//value returned by the alpha-beta search algorithm
			int value = alphaBetaSearch(alphaBetaExampleRoot);
			System.out.println("\nValue of the Alpha-Beta Tree Example: " + value);
		}
		else {
	        	try {
       				// Parse the string argument into an integer value.
           			seed = Long.parseLong(args[0]);
			}
        		catch (NumberFormatException nfe) {
				System.out.println("The first argument must be a long.");
				System.exit(1);
			}

			//the root of the alpha-beta tree example
			Node alphaBetaRandomExampleRoot = buildRandomAlphaBetaTreeExample(seed);

			//value returned by the alpha-beta search algorithm
			int value = alphaBetaSearch(alphaBetaRandomExampleRoot);
			System.out.println("\nValue of the Alpha-Beta Tree Example: " + value);
		}
		
	}
	
	
	/*
	 * The alphaBetaSearch algorithm is used for computing the value for the alpha-beta tree example
	 * @param node  a node from a minimax game tree
	 * @return the value of the tree.
	 */
	public static int alphaBetaSearch(Node node) {

                // call maxValue on the root of the tree, with 
                // alpha and beta set to very small and very large initial values
		int value = maxValue(node, Integer.MIN_VALUE, Integer.MAX_VALUE);

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
	public static int maxValue(Node node, int alpha, int beta) {

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
			System.out.println("Value returned for node " + node.getName() + " is " + value);
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
	public static int minValue(Node node, int alpha, int beta) {

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
			System.out.println("Value returned for node " + node.getName() + " is " + value);
			return value;	
		}

	}

				
	
	
	/*
	 * This function is used for building a game tree
	 * @return root node
	 */
	public static Node buildAlphaBetaTreeExample() {
	
		//start with root node (max)
		Node A = (new MaxNode("A"));
		
		//creating the other nodes of the tree
		//MinNodes

		MinNode B = new MinNode("B");
		MinNode C = new MinNode("C");
		MinNode D = new MinNode("D");
		
		//MaxNodes
		MaxNode E = new MaxNode("E");
		MaxNode F = new MaxNode("F");
		MaxNode G = new MaxNode("G");

		MaxNode H = new MaxNode("H");
		MaxNode I = new MaxNode("I");
		MaxNode J = new MaxNode("J");

		MaxNode K = new MaxNode("K");
		MaxNode L = new MaxNode("L");
		MaxNode M = new MaxNode("M");

		//linking the nodes
		//depth 1
		A.addChild(B);
		A.addChild(C);
		A.addChild(D);
		
		//depth 2
		B.addChild(E);
		B.addChild(F);
		B.addChild(G);
		
		C.addChild(H);
		C.addChild(I);
		C.addChild(J);
		
		D.addChild(K);
		D.addChild(L);
		D.addChild(M);
		
		//depth 3
		//terminating nodes
		E.addChild(new TerminatingNode("E1", -4));
		E.addChild(new TerminatingNode("E2", 4));
		E.addChild(new TerminatingNode("E3", 3));
		
		F.addChild(new TerminatingNode("F1", -1));
		F.addChild(new TerminatingNode("F2", 1));
		F.addChild(new TerminatingNode("F3", -3));
		
		G.addChild(new TerminatingNode("G1", -3));
		G.addChild(new TerminatingNode("G2", 3));
		G.addChild(new TerminatingNode("G3", -2));

		H.addChild(new TerminatingNode("H1", -4));
		H.addChild(new TerminatingNode("H2", -3));
		H.addChild(new TerminatingNode("H3", -5));
		
		I.addChild(new TerminatingNode("I1", 0));
		I.addChild(new TerminatingNode("I2", 0));
		I.addChild(new TerminatingNode("I3", -4));

		J.addChild(new TerminatingNode("J1", 1));
		J.addChild(new TerminatingNode("J2", -4));
		J.addChild(new TerminatingNode("J3", -4));

		K.addChild(new TerminatingNode("K1", -3));
		K.addChild(new TerminatingNode("K2", 1));
		K.addChild(new TerminatingNode("K3", 2));

		L.addChild(new TerminatingNode("L1", 4));
		L.addChild(new TerminatingNode("L2", -3));
		L.addChild(new TerminatingNode("L3", -1));

		M.addChild(new TerminatingNode("M1", 5));
		M.addChild(new TerminatingNode("M2", -3));
		M.addChild(new TerminatingNode("M3", 4));
		
		return A;
	}



	/*
	 * This function is used for building a game tree, with random
	 * values stored in the leaf nodes
	 * @return root node
	 */
	public static Node buildRandomAlphaBetaTreeExample(long seed) {

		Random random = new Random();
		random.setSeed(seed);

		int minVal = -10;
		int maxVal = 10;
		int randomNum = 0;

		boolean verbose = false;


		//start with root node (max)
		Node A = (new MaxNode("A"));
		
		//creating the other nodes of the tree
		//MinNodes
		MinNode B = new MinNode("B");
		MinNode C = new MinNode("C");
		MinNode D = new MinNode("D");
		
		//MaxNodes
		MaxNode E = new MaxNode("E");
		MaxNode F = new MaxNode("F");
		MaxNode G = new MaxNode("G");

		MaxNode H = new MaxNode("H");
		MaxNode I = new MaxNode("I");
		MaxNode J = new MaxNode("J");

		MaxNode K = new MaxNode("K");
		MaxNode L = new MaxNode("L");
		MaxNode M = new MaxNode("M");

		//linking the nodes
		//depth 1
		A.addChild(B);
		A.addChild(C);
		A.addChild(D);
		
		//depth 2
		B.addChild(E);
		B.addChild(F);
		B.addChild(G);
		
		C.addChild(H);
		C.addChild(I);
		C.addChild(J);
		
		D.addChild(K);
		D.addChild(L);
		D.addChild(M);
		
		//depth 3
		//terminating nodes

		E.addChild(new TerminatingNode("E1", genRandNum(minVal,maxVal,random,verbose)));
		E.addChild(new TerminatingNode("E2", genRandNum(minVal,maxVal,random,verbose)));
		E.addChild(new TerminatingNode("E3", genRandNum(minVal,maxVal,random,verbose)));

		F.addChild(new TerminatingNode("F1", genRandNum(minVal,maxVal,random,verbose)));
		F.addChild(new TerminatingNode("F2", genRandNum(minVal,maxVal,random,verbose)));
		F.addChild(new TerminatingNode("F3", genRandNum(minVal,maxVal,random,verbose)));

		G.addChild(new TerminatingNode("G1", genRandNum(minVal,maxVal,random,verbose)));
		G.addChild(new TerminatingNode("G2", genRandNum(minVal,maxVal,random,verbose)));
		G.addChild(new TerminatingNode("G3", genRandNum(minVal,maxVal,random,verbose)));

		H.addChild(new TerminatingNode("H1", genRandNum(minVal,maxVal,random,verbose)));
		H.addChild(new TerminatingNode("H2", genRandNum(minVal,maxVal,random,verbose)));
		H.addChild(new TerminatingNode("H3", genRandNum(minVal,maxVal,random,verbose)));

		I.addChild(new TerminatingNode("I1", genRandNum(minVal,maxVal,random,verbose)));
		I.addChild(new TerminatingNode("I2", genRandNum(minVal,maxVal,random,verbose)));
		I.addChild(new TerminatingNode("I3", genRandNum(minVal,maxVal,random,verbose)));

		J.addChild(new TerminatingNode("J1", genRandNum(minVal,maxVal,random,verbose)));
		J.addChild(new TerminatingNode("J2", genRandNum(minVal,maxVal,random,verbose)));
		J.addChild(new TerminatingNode("J3", genRandNum(minVal,maxVal,random,verbose)));

		K.addChild(new TerminatingNode("K1", genRandNum(minVal,maxVal,random,verbose)));
		K.addChild(new TerminatingNode("K2", genRandNum(minVal,maxVal,random,verbose)));
		K.addChild(new TerminatingNode("K3", genRandNum(minVal,maxVal,random,verbose)));

		L.addChild(new TerminatingNode("L1", genRandNum(minVal,maxVal,random,verbose)));
		L.addChild(new TerminatingNode("L2", genRandNum(minVal,maxVal,random,verbose)));
		L.addChild(new TerminatingNode("L3", genRandNum(minVal,maxVal,random,verbose)));

		M.addChild(new TerminatingNode("M1", genRandNum(minVal,maxVal,random,verbose)));
		M.addChild(new TerminatingNode("M2", genRandNum(minVal,maxVal,random,verbose)));
		M.addChild(new TerminatingNode("M3", genRandNum(minVal,maxVal,random,verbose)));
		
		return A;
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

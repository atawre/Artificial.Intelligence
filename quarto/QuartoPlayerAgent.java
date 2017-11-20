public class QuartoPlayerAgent extends QuartoAgent {
	
    public QuartoPlayerAgent(GameClient gameClient, String stateFileName) {
        // because super calls one of the super class constructors(you can overload constructors), you need to pass the parameters required.
        super(gameClient, stateFileName);
    }

    //MAIN METHOD
    public static void main(String[] args) {
        //start the server
        GameClient gameClient = new GameClient();

        String ip = null;
        String stateFileName = null;
        //IP must be specified
        if(args.length > 0) {
            ip = args[0];
        } else {
            //System.out.println("No IP Specified");
            ip = "localhost";
            //System.exit(0);
        }
        if (args.length > 1) {
            stateFileName = args[1];
        }

        gameClient.connectToServer(ip, 4321);
        QuartoPlayerAgent quartoPlayerAgent = new QuartoPlayerAgent(gameClient, stateFileName);
        quartoPlayerAgent.play();

        gameClient.closeConnection();

    }


    /*
	 * Do Your work here
	 * The server expects a binary string, e.g.   10011
	 */
    @Override
    protected String pieceSelectionAlgorithm() {
        //some useful lines:
        //String BinaryString = String.format("%5s", Integer.toBinaryString(pieceID)).replace(' ', '0');

        QuartoBoard copyBoard = new QuartoBoard(this.quartoBoard);

        //do work
		Node root = new MaxNode(copyBoard);
		//value returned by the alpha-beta search algorithm
		int value = Minimax.maxValue(root, Integer.MIN_VALUE, Integer.MAX_VALUE, true, 0);

        //int pieceID = copyBoard.chooseRandomPieceNotPlayed(100);
        String BinaryString = String.format("%5s", Integer.toBinaryString(root.getPieceId())).replace(' ', '0');
        return BinaryString;
    }

    /*
     * Do Your work here
     * The server expects a move in the form of:   row,column
     */
    @Override
    protected String moveSelectionAlgorithm(int pieceID) {
        //do work
    	QuartoBoard copyBoard = new QuartoBoard(this.quartoBoard);
		Node root = new MaxNode();
		Minimax.maxValue(root, Integer.MIN_VALUE, Integer.MAX_VALUE, false, 0);
		return root.row + "," + root.column;
        //int[] move = new int[2];
        //QuartoBoard copyBoard = new QuartoBoard(this.quartoBoard);
        //move = copyBoard.chooseRandomPositionNotPlayed(100);
        //return move[0] + "," + move[1];
    }

}

/* Player.java */

import java.io.*;
import java.util.*;

public class Player {
	public String color;
	public ArrayList<Piece> pieces = new ArrayList<Piece>();
	public int piece_index;

	public Player(String clr) {
		color = clr;
		piece_index = 0;
	}

	public void movePiece(Board board, Piece p, Move move) {
		p.move(board, move);
	}

	public Piece selectPiece(Board board) throws InvalidPieceException{
		System.out.println("\n" + color + "'s turn. Which piece would " + color + " like to move?");
		System.out.println("Enter the piece's coordinates in row,column format. Example: 4,3\n");

		BufferedReader reader;
		reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String pieceInput = reader.readLine(); 
	  		String[] pieceArr = pieceInput.split(",");
	  		Move playerPiece = new Move(Integer.parseInt(pieceArr[0]), Integer.parseInt(pieceArr[1]), 0);
	  		Piece selected_piece = board.contains(playerPiece.x, playerPiece.y);

	  		if ((playerPiece.x > board.RIGHT) || (playerPiece.x < board.LEFT) || (playerPiece.y > board.TOP) || (playerPiece.y < board.BOTTOM)) {
	  			throw new InvalidPieceException(playerPiece);
	  		}
	  		System.out.println("\nThe piece you have selected is: " + selected_piece.name + ". Is this correct? (y/n)");
	  		return selected_piece;

	  		/*
	  		GOAL: Ensure intended piece selected
	  		reader = new BufferedReader(new InputStreamReader(System.in));
	  		String response = reader.readLine();
	  		System.out.println("response = " + response);

	  		if ((response == 'y') || (response == 'yes')) {
	  			return selected_piece;
	  		}
	  		else {
	  			System.out.print("Not Equal");
	  			System.out.print("'y' == 'y'" + ("y" == "y"));

	  			return selectPiece(board);
	  		}
	  		*/
	  		
	  	}
	  	catch (IOException e) {
            System.err.println(e); // Address error here
            return new Empty(board, -1, -1);
        }
	}

	public Move selectMove(Board board, Piece p) {
		ArrayList<Move> available_moves = p.valid_moves(board);
		Move.printMoves(available_moves);

	  	System.out.println("Which move would you like to select?\n");

		BufferedReader reader;
		reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String move_input = reader.readLine(); 
            int move_index = Integer.parseInt(move_input);
            Move selected_move = available_moves.get(move_index);

	  		System.out.println("\nYour move: " + p.name + " to " + selected_move.coordinates());
	  		return selected_move;
	  	}
	  	catch (IOException e) {
            System.err.println(e); // Address error here
            return new Move(-1, -1, 0);
        }
	}

	public void takeTurn(Board board) {
		System.out.println("Here is the current board:\n");
		board.printBoard();
		try {
			Piece selected_piece = selectPiece(board);
			Move selected_move = selectMove(board, selected_piece);
			selected_piece.move(board, selected_move);
		}
		catch (InvalidPieceException e) {
			System.out.println(e);
		}
	}
}
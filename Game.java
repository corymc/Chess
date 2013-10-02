/* Game.java */

import java.util.*;
import java.io.*;

public class Game {
	public static void main(String[] args) {

		Player white = new Player("White");
		Player black = new Player("Black");

		Board board = new Board();
		board.startingBoard(white, black);

		/*
		Bishop p1 = new Bishop(board, white, 4, 4);
		ArrayList<Move> moves = p1.valid_moves(board);
		Move.printMoves(moves);
		white.selectMove(board, p1);
		*/

		/*	PRINTING WHITES PIECES TO TEST Player.pieces attribute
		for (int i = 0; i < white.pieces.size(); i++) {
			Piece curr = white.pieces.get(i);
			System.out.print(curr.printPiece() + ", ");
		}
		*/

		System.out.println("\n\nWelcome to The Chess Game, The World's ugliest graphically-interfaced chess game!\n");
		while (true) {
			white.takeTurn(board);
			black.takeTurn(board);
		}	
	}
}
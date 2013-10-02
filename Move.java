/* Move.java */

import java.util.*;

public class Move {
	public int index;
	public int x;
	public int y;

	public Move(int x_cord, int y_cord, int i) {
		index = i;
		x = x_cord;
		y = y_cord;
	}

	public static void toString(Move m) {
		try {
			System.out.print(m.index + ": (" + m.x + ", " + m.y + ") ");
		}
		catch (NullPointerException e) {
			return;
		}
	}

	public String coordinates() {
		String coord = "(" + this.x + ", " + this.y + ")";
		return coord;
	}

	public static void printMoves(ArrayList<Move> moves) {
		if (moves.size() == 0) {
			System.out.println("No moves Avaliable");
			return;
		}
		int i;
		System.out.print("Available moves: [ ");
		for (i = 0; i < moves.size() - 1; i++) {
			toString(moves.get(i));
			System.out.print(", ");
		}
		toString(moves.get(i));
		System.out.println(" ]\n");
	}


	/*
	public static void printMoves(Move[] moves) {
		if (moves.length == 0) {
			System.out.println("No moves Avaliable");
			return;
		}
		int i;
		System.out.print("Available moves: [ ");
		for (i = 0; i < moves.length - 1; i++) {
			toString(moves[i]);
			System.out.print(", ");
		}
		toString(moves[i]);
		System.out.println(" ]\n");
	}
	*/
}
/* Board.java */

import java.util.*;

public class Board {

	public int LEFT = 0, RIGHT = 7;
	public int BOTTOM = 0, TOP = 7;

	public Piece[][] spaces = new Piece[8][8];

	public Board() {
		for (int y = BOTTOM; y <= TOP; y++) {
			for (int x = LEFT; x <= RIGHT; x++) {
				new Empty(this, x, y); 
			}
		}
	}

	public void place(Piece p, int x, int y) { 
		// should throw an exception if piece placed in ocupied spot? Address later. 
		// could use this method to move pieces
		// each piece constructor calls place
		spaces[x][y] = p;
		p.x_cord = x;
		p.y_cord = y;
	}

	void remove(int x, int y) {
		spaces[x][y] = new Empty(this, x, y);
	}

	public Piece contains(int x, int y) {
		return spaces[x][y];
	}

	public String contained_name(int x, int y) {
		return contains(x, y).name;
	}

	public String contained_color(int x, int y) {
		String c = contains(x, y).color;
		if (c == null) {
			return "     ";
		}
		return c;
	}

	public boolean isEmpty(int x, int y) {
		// returns true if (x, y) is an empty square
		if (contains(x, y) instanceof Empty) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean containsEnemy(Piece p, int x, int y) {
		// returns true if (x, y) contains an enemy piece
		String containedColor = contained_color(x, y);
		if ((! isEmpty(x, y)) && (containedColor != p.color)) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean[] isValid(Piece p, int x, int y) {
		boolean[] validity = new boolean[2];
		if ((x > RIGHT) || (x < LEFT) || (y > TOP) ||(y < BOTTOM)) {
			validity[0] = false;
			validity[1] = false;
		}
		else if (isEmpty(x, y)) {
			validity[0] = true;
			validity[1] = false;
		}
		else if (containsEnemy(p, x, y)) {
			validity[0] = true;
			validity[1] = true;
		}
		else {
			validity[0] = false;
			validity[1] = false;
		}
		return validity;
	}

	public boolean valid(Piece p, int x, int y) {
		// returns true if space is empty or if it contains an enemy piece
		return isValid(p, x, y)[0];
	}

	public boolean hitEnemy(Piece p, int x, int y) {
		// returns true if the current move track has already hit an enemy
		// designed as a condition to break out of a valid_moves for loop
		return isValid(p, x, y)[1];
	}

	public void startingBoard(Player white, Player black) {
		int TOP_ROW = 0, BOTTOM_ROW = 7;

		int w_piece_row = BOTTOM_ROW, w_pawn_row = BOTTOM_ROW - 1;
		int b_piece_row = TOP_ROW, b_pawn_row = TOP_ROW + 1;

		// initialize pawns
		for (int x = 0; x <= RIGHT; x ++) {
			new Pawn(this, white, x, w_pawn_row);
			new Pawn(this, black, x, b_pawn_row);
		}
		// initialize rooks
		new Rook(this, white, LEFT, w_piece_row);
		new Rook(this, white, RIGHT, w_piece_row);
		new Rook(this, black, LEFT, b_piece_row);
		new Rook(this, black, RIGHT, b_piece_row);

		// initialize knights
		new Knight(this, white, LEFT + 1, w_piece_row);
		new Knight(this, white, RIGHT - 1, w_piece_row);
		new Knight(this, black, LEFT + 1, b_piece_row);
		new Knight(this, black, RIGHT - 1, b_piece_row);

		// initialize bishops
		new Bishop(this, white, LEFT + 2, w_piece_row);
		new Bishop(this, white, RIGHT - 2, w_piece_row);
		new Bishop(this, black, LEFT + 2, b_piece_row);
		new Bishop(this, black, RIGHT - 2, b_piece_row);

		// initialize queens
		new Queen(this, white, RIGHT - 4, w_piece_row);
		new Queen(this, black, RIGHT - 4, b_piece_row);

		// initialize kings
		new King(this, white, RIGHT - 3, w_piece_row);
		new King(this, black, RIGHT - 3, b_piece_row);
	}

	public void printBoard() {
		String border_line = " _______________________________________________________________________________________________________________________";
		for (int y = BOTTOM; y <= TOP; y++) {
			System.out.println(border_line);
			System.out.println("|");
			for (int x = LEFT; x <= RIGHT; x++) {
				System.out.print("|  " + contained_color(x, y) + " " + contained_name(x, y));
			}
			System.out.println("|");
		}
		System.out.println(border_line);
	}
}




















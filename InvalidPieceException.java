public class InvalidPieceException extends Exception{
	public Move selectedPiece;

	public InvalidPieceException(Move enteredPiece) {
		super("Invalid piece selected. Entered coordinates: " + enteredPiece);
		selectedPiece = enteredPiece;
	}
}

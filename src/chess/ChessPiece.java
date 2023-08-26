package chess;

import board.Board;
import board.Piece;
import board.Position;

public abstract class ChessPiece extends Piece{

	private Color color;

	public ChessPiece(Board board, Color color) {
		super(board, color);
	}

	public Color getColor() {
		return color;
	}

	protected boolean isThereOpenentPiece(Position position) {
		ChessPiece p = (ChessPiece)getBoard().piece(position);
		
		return p != null && p.getColor() != color;
		}
}
	

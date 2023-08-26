package board;

public class Board {

	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	public Board(int rows, int columns) {
		if(rows < 1 || columns < 1)
		throw new BoardException("Error, invalid data to create a board!");
		
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}
	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}
	
	public Piece piece(int row, int columns) {
		if(!positionExists(row, columns)) 
			throw new BoardException("Error, this position does not exists!");
		return pieces[row][columns];
	}
	
	public Piece piece(Position position) {
		if(!positionExists(position)) 
			throw new BoardException("Error, this position does not exists!");
		return pieces[position.getRow()][position.getColumn()];
	}
	
	public void placePiece(Piece piece, Position position) {
		if(thereIsAPiece(position))
			throw new BoardException("There's a piece in this position!");
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
	
	public Piece removePiece(Position position) {
		if(!positionExists(position)) {
			throw new BoardException("This position dosen't exists.");
		}
		if(piece(position) == null) {
			return null;
		}
		Piece aux = piece(position);
		aux.position = null;
		pieces[position.getRow()][position.getColumn()] = null;
		
		return aux;
	}
	
	private boolean positionExists(int row, int column) {
		
		return row >= 0 && row < rows && column >= 0 && column < columns;
	}
	
	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}
	
	public boolean thereIsAPiece(Position position) {
		if(!positionExists(position)) 
			throw new BoardException("Error, this position does not exists!");
		return piece(position) != null;
	}
}

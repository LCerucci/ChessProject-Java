package aplication;

import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPosition;

public class Programin {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ChessMatch match = new ChessMatch();
		
		while(true){
			try {
				
				UI.clearScreen();
				UI.printBoard(match.getPieces());
				System.out.println();
				System.out.println("Source: ");
				ChessPosition source = UI.readChessPosition(sc);
				
				boolean[][] possibleMoves = match.possibleMoves(source);
				
				UI.clearScreen();
				UI.printBoard(match.getPieces(), possibleMoves);
				
				System.out.println();
				System.out.println("Target: ");
				ChessPosition target = UI.readChessPosition(sc);
				
			}catch(ChessException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
				
			}
		}
	}

}

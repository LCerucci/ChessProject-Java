package aplication;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPosition;

public class Programin {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ChessMatch match = new ChessMatch();
		
		List<ChessPiece> captured = new ArrayList<>();
		
		while(!match.getCheckMate()){
			try {
				
				UI.clearScreen();
				UI.printMatch(match, captured);
				System.out.println();
				System.out.println("Source: ");
				ChessPosition source = UI.readChessPosition(sc);
				
				boolean[][] possibleMoves = match.possibleMoves(source);
				
				UI.clearScreen();
				UI.printBoard(match.getPieces(), possibleMoves);
				
				System.out.println();
				System.out.println("Target: ");
				ChessPosition target = UI.readChessPosition(sc);
				
				ChessPiece capturedPiece = match.performChessMove(source, target);
				
				if(capturedPiece != null) {
					captured.add(capturedPiece);
				}
				
				String type = null;
				
				while(!type.equals("B") && !type.equals("H") && !type.equals("Q") && !type.equals("R")) {
					if(match.getPromoted() != null) {
						System.out.println("ENter the promotion (Q/H/R/B): ");
						type = sc.nextLine();
						match.replacePromotedPiece(type.toUpperCase());
					}
				}
				
			}catch(ChessException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
				
			}catch(InputMismatchException e) {
				System.out.println(e.getMessage());
				sc.nextLine();
			}
		}
		
		UI.clearScreen();
		UI.printMatch(match, captured);
		
		
	}

}

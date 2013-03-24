package de.fichtelmax.mastermind.cli;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import de.fichtelmax.mastermind.GuessResult;
import de.fichtelmax.mastermind.Mastermind;

public class MastermindApplication {

	public static void main(String[] args) {
		final Scanner scanner = new Scanner(System.in);

		Mastermind<String> mastermind = new Mastermind<>("a", "s", "d", "f");

		GuessResult guessResult;
		do {
			guessResult = mastermind.guess(readInput(4, scanner));
			System.out.println("Black: " + guessResult.getDirectHits());
			System.out.println("White: " + guessResult.getColorHits());
		} while (guessResult.getDirectHits() < 4);
		System.out.println("HOORAY!!!");

		scanner.close();
	}

	private static List<String> readInput(int size, Scanner scanner) {
		List<String> input = new ArrayList<>();

		System.out.print("Eingabe: ");
		for (int i = 0; i < size; i++) {
			input.add(scanner.next());
		}

		return input;
	}
}

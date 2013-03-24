package de.fichtelmax.mastermind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Mastermind<T> {
	private List<T> solution = new ArrayList<>();

	public Mastermind(List<T> solution) {
		this.solution = solution;
	}

	@SafeVarargs
	public Mastermind(T... solution) {
		this(Arrays.asList(solution));
	}

	@SafeVarargs
	public static <T> Mastermind<T> randomSolution(int size, T... options) {
		return randomSolution(size, Arrays.asList(options));
	}

	public static <T> Mastermind<T> randomSolution(int size, List<T> options) {
		Random random = new Random();
		ArrayList<T> solution = new ArrayList<>();

		for (int i = 0; i < size; i++) {
			int randomIndex = random.nextInt(options.size());
			solution.add(options.get(randomIndex));
		}

		return new Mastermind<T>(solution);
	}

	public GuessResult guess(@SuppressWarnings("unchecked") T... guess) {
		return guess(Arrays.asList(guess));
	}

	public GuessResult guess(List<T> guess) {
		GuessResult result = new GuessResult();
		List<T> solutionCopy = new ArrayList<>(solution);
		List<T> guessCopy = new ArrayList<>(guess);

		if (guess == null || guess.size() != solutionCopy.size()) {
			throw new IllegalArgumentException("Illegal input: " + guess);
		}

		result.setDirectHits(checkForDirectHits(guessCopy, solutionCopy));
		result.setColorHits(checkForColorHits(guessCopy, solutionCopy));

		return result;
	}

	int checkForColorHits(List<T> guess, List<T> solutionCopy) {
		int hits = 0;
		for (T guessItem : new ArrayList<>(guess)) {
			if (solutionCopy.contains(guessItem)) {
				hits++;
				guess.remove(guessItem);
				solutionCopy.remove(guessItem);
			}
		}

		return hits;
	}

	int checkForDirectHits(List<T> guess, List<T> solutionCopy) {
		int hits = 0;

		for (int i = solutionCopy.size() - 1; i >= 0; i--) {
			if (solutionCopy.get(i).equals(guess.get(i))) {
				hits++;
				solutionCopy.remove(i);
				guess.remove(i);
			}
		}
		return hits;
	}
}

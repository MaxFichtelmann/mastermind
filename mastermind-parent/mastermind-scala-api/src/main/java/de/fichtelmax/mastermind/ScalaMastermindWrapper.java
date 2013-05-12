package de.fichtelmax.mastermind;

import java.util.Arrays;
import java.util.List;

public class ScalaMastermindWrapper<T> extends ScalaMastermind<T> implements
		Mastermind<T> {

	public ScalaMastermindWrapper(List<T> solution) {
		super(solution);
	}

	@SafeVarargs
	public ScalaMastermindWrapper(T... solution) {
		this(Arrays.asList(solution));
	}

	@Override
	public GuessResult guess(@SuppressWarnings("unchecked") T... guess) {
		return guessFromJava(Arrays.asList(guess));
	}

	@Override
	public GuessResult guess(List<T> guess) {
		return guessFromJava(guess);
	}

}

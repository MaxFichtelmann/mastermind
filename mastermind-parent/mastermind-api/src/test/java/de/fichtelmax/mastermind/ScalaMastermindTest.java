package de.fichtelmax.mastermind;

import static de.fichtelmax.mastermind.test.Item.A;
import static de.fichtelmax.mastermind.test.Item.D;
import static de.fichtelmax.mastermind.test.Item.F;
import static de.fichtelmax.mastermind.test.Item.S;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;
import java.util.Collections;

import org.junit.Test;

import de.fichtelmax.mastermind.test.Item;

public class ScalaMastermindTest {

	@Test(expected = IllegalArgumentException.class)
	public void guessAndSolutionLengthsUnequal() {
		ScalaMastermind<Item> mastermind = new ScalaMastermind<>(Arrays.asList(
				A, A));
		mastermind.guess(Arrays.asList(A));
	}

	@Test
	public void sillyTest() {
		ScalaMastermind<Item> mastermind = new ScalaMastermind<>(
				Collections.<Item> emptyList());
		ScalaGuessResult result = mastermind.guess(Collections
				.<Item> emptyList());

		assertThat(result.getDirectHits(), is(0));
		assertThat(result.getColorHits(), is(0));
	}

	@Test
	public void noTwoColorHits() {
		ScalaMastermind<Item> mastermind = new ScalaMastermind<>(Arrays.asList(
				D, D, A, F));
		ScalaGuessResult result = mastermind.guess(Arrays.asList(A, A, S, S));

		assertThat(result.getDirectHits(), is(0));
		assertThat(result.getColorHits(), is(1));
	}

	@Test
	public void successAllSame() {
		ScalaMastermind<Item> mastermind = new ScalaMastermind<>(Arrays.asList(
				A, A, A, A));
		ScalaGuessResult result = mastermind.guess(Arrays.asList(A, A, A, A));

		assertThat(result.getDirectHits(), is(4));
		assertThat(result.getColorHits(), is(0));
	}

	@Test
	public void successAllOther() {
		ScalaMastermind<Item> mastermind = new ScalaMastermind<>(Arrays.asList(
				A, D, F, S));
		ScalaGuessResult result = mastermind.guess(Arrays.asList(A, D, F, S));

		assertThat(result.getDirectHits(), is(4));
		assertThat(result.getColorHits(), is(0));
	}

	@Test
	public void successFewOther() {
		ScalaMastermind<Item> mastermind = new ScalaMastermind<>(Arrays.asList(
				A, D, D, S));
		ScalaGuessResult result = mastermind.guess(Arrays.asList(A, D, D, S));

		assertThat(result.getDirectHits(), is(4));
		assertThat(result.getColorHits(), is(0));
	}

	@Test
	public void noSuccessAllSame() {
		ScalaMastermind<Item> mastermind = new ScalaMastermind<>(Arrays.asList(
				A, A, A, A));
		ScalaGuessResult result = mastermind.guess(Arrays.asList(S, S, S, S));

		assertThat(result.getDirectHits(), is(0));
		assertThat(result.getColorHits(), is(0));
	}

	@Test
	public void noSuccessAllOther() {
		ScalaMastermind<Item> mastermind = new ScalaMastermind<>(Arrays.asList(
				A, D, F, S));
		ScalaGuessResult result = mastermind.guess(Arrays.asList(S, A, D, F));

		assertThat(result.getDirectHits(), is(0));
		assertThat(result.getColorHits(), is(4));
	}
}

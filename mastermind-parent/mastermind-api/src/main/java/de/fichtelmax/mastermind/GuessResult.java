package de.fichtelmax.mastermind;

import java.text.MessageFormat;

/**
 * A wrapper for the result of a guess.
 * 
 * @author Max Fichtelmann
 * 
 */
public class GuessResult {
	private int directHits;
	private int colorHits;

	/**
	 * Sets the number of direct hits (correct color, correct position).
	 * 
	 * @param directHits
	 *            the number of direct hits (correct color, correct position).
	 */
	/* package private */void setDirectHits(int directHits) {
		this.directHits = directHits;
	}

	/**
	 * Returns the number of direct hits (correct color, correct position).
	 * 
	 * @return the number of direct hits (correct color, correct position).
	 */
	public int getDirectHits() {
		return directHits;
	}

	/**
	 * Sets the number of color hits (correct color, wrong position).
	 * 
	 * @param colorHits
	 *            the number of color hits (correct color, wrong position).
	 */
	/* package private */void setColorHits(int colorHits) {
		this.colorHits = colorHits;
	}

	/**
	 * Returns the number of color hits (correct color, wrong position).
	 * 
	 * @return the number of color hits (correct color, wrong position).
	 */
	public int getColorHits() {
		return colorHits;
	}

	@Override
	public String toString() {
		return MessageFormat.format("direct Hits: {0}\ncolor Hits: {1}",
				directHits, colorHits);
	}
}
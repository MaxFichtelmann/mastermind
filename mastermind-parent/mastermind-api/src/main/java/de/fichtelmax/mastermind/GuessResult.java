package de.fichtelmax.mastermind;

import java.text.MessageFormat;

public class GuessResult {
	private int directHits;
	private int colorHits;

	public void setDirectHits(int directHits) {
		this.directHits = directHits;
	}

	public int getDirectHits() {
		return directHits;
	}

	public void setColorHits(int colorHits) {
		this.colorHits = colorHits;
	}

	public int getColorHits() {
		return colorHits;
	}

	@Override
	public String toString() {
		return MessageFormat.format("direct Hits: {0}\ncolor Hits: {1}",
				directHits, colorHits);
	}
}
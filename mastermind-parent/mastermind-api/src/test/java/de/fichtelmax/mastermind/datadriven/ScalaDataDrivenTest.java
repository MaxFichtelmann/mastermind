package de.fichtelmax.mastermind.datadriven;

import java.util.List;

import de.fichtelmax.mastermind.Mastermind;
import de.fichtelmax.mastermind.ScalaMastermindWrapper;

public class ScalaDataDrivenTest extends DataDrivenTest {

	public ScalaDataDrivenTest(TestDataItem testData) {
		super(testData);
	}

	protected Mastermind<String> newMastermind(List<String> solution) {
		return new ScalaMastermindWrapper<String>(solution);
	}

}

package de.fichtelmax.mastermind.datadriven;

import java.util.List;

import de.fichtelmax.mastermind.Mastermind;
import de.fichtelmax.mastermind.MastermindImpl;

public class JavaDataDrivenTest extends DataDrivenTest {

	public JavaDataDrivenTest(TestDataItem testData) {
		super(testData);
	}

	protected Mastermind<String> newMastermind(List<String> solution) {
		return new MastermindImpl<>(solution);
	}

}

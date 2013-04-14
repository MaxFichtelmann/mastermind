package de.fichtelmax.mastermind.datadriven;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import de.fichtelmax.mastermind.GuessResult;
import de.fichtelmax.mastermind.Mastermind;

@RunWith(Parameterized.class)
public abstract class DataDrivenTest {
	@Parameters
	public static Collection<Object[]> collectTestData() throws JAXBException {
		Collection<Object[]> testData = new ArrayList<>();

		InputStream dataStream = DataDrivenTest.class
				.getResourceAsStream("/testdata.xml");
		JAXBContext context = JAXBContext.newInstance(TestData.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();

		TestData data = (TestData) unmarshaller.unmarshal(dataStream);

		for (TestDataItem item : data.getItems()) {
			testData.add(new Object[] { item });
		}

		return testData;
	}

	private TestDataItem testData;

	public DataDrivenTest(TestDataItem testData) {
		super();
		this.testData = testData;
	}

	@Test
	public void test() {
		Mastermind<String> mastermind = newMastermind(testData.getSolution());

		try {
			GuessResult guessResult = mastermind.guess(testData.getGuess());
			assertThat("Exception was expected!",
					testData.getExpectedException(), is(nullValue()));

			assertThat(guessResult, is(notNullValue()));

			assertThat(guessResult.getDirectHits(),
					is(equalTo(testData.getExpectedDirect())));
			assertThat(guessResult.getColorHits(),
					is(equalTo(testData.getExpectedColor())));
		} catch (Throwable t) {
			if (testData.getExpectedException() == null) {
				throw t;
			} else {
				assertThat(t.getClass().getCanonicalName(),
						is(equalTo(testData.getExpectedException())));
			}
		}
	}

	protected abstract Mastermind<String> newMastermind(List<String> solution);

}

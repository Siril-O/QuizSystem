package ua.epam.rd.web;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import ua.edu.rd.domain.Question;
import ua.edu.rd.domain.Quiz;
import ua.edu.rd.domain.Variant;
import ua.edu.rd.web.QuizPassingResultCalculator;

public class QuizPassingResultCalculatorTest {

	@Test(expected = IllegalArgumentException.class)
	public void testCalculateResultNullArgumentsThrowsException() {
		QuizPassingResultCalculator calculator = new QuizPassingResultCalculator();
		calculator.calculateResult(null, null, null);
	}

}

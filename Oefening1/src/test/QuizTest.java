package test;

import static org.junit.Assert.*;

import javax.net.ssl.SSLEngineResult.Status;

import model.Leraar;
import model.Quiz;
import model.QuizStatus;

import org.junit.Before;
import org.junit.Test;

public class QuizTest {
	private Quiz quiz;
	
	@Before
	public void setUp(){
		quiz = new Quiz(4, 3, Leraar.JoskeVermeulen, "Talen", QuizStatus.OPENGESTELD, null);
	}

	/*@Test
	public void testHashCode() {
		fail("Not yet implemented");
	}

	@Test
	public void testQuiz() {
		fail("Not yet implemented");
	}*/

	@Test
	public void testQuizIntIntLeraarStringQuizStatusListOfOpdracht() {
		assertEquals(4, quiz.getAantalDeelnames());
		assertEquals(3, quiz.getLeerjaar());
		assertEquals(Leraar.JoskeVermeulen , quiz.getLeraar());
		assertEquals("Talen", quiz.getOnderwerp());
		assertEquals(QuizStatus.OPENGESTELD, quiz.getQuizStatus());
	}

	@Test
	public void testGetAantalDeelnames() {
		assertEquals(4, quiz.getAantalDeelnames());
	}

	@Test
	public void testSetAantalDeelnames() {
		quiz.setAantalDeelnames(2);
		assertEquals(2, quiz.getAantalDeelnames());
	}

	@Test
	public void testGetLeerjaar() {
		assertEquals(3, quiz.getLeerjaar());
	}

	@Test
	public void testSetLeerjaar() {
		quiz.setLeerjaar(6);
		assertEquals(6, quiz.getLeerjaar());
	}

	@Test
	public void testGetLeraar() {
		assertEquals(Leraar.JoskeVermeulen, quiz.getLeraar());
	}

	@Test
	public void testSetLeraar() {
		quiz.setLeraar(Leraar.PietSnot);
		assertEquals(Leraar.PietSnot, quiz.getLeraar());
	}

	@Test
	public void testGetOnderwerp() {
		assertEquals("Talen", quiz.getOnderwerp());
	}

	@Test
	public void testSetOnderwerp() {
		quiz.setOnderwerp("hoofdsteden");
		assertEquals("hoofdsteden", quiz.getOnderwerp());
	}

	@Test
	public void testGetQuizStatus() {
		assertEquals(QuizStatus.OPENGESTELD, quiz.getQuizStatus());
	}

	@Test
	public void testSetQuizStatus() {
		quiz.setQuizStatus(QuizStatus.LAATSTEKANS);
		assertEquals(QuizStatus.LAATSTEKANS, quiz.getQuizStatus());
	}

	@Test
	public void testAddOpdracht() {
		fail("Not yet implemented");
	}

	@Test
	public void testEqualsObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

	@Test
	public void testObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetClass() {
		fail("Not yet implemented");
	}

	@Test
	public void testEqualsObject1() {
		fail("Not yet implemented");
	}

	@Test
	public void testClone() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString1() {
		fail("Not yet implemented");
	}

	@Test
	public void testNotify() {
		fail("Not yet implemented");
	}

	@Test
	public void testNotifyAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testWaitLong() {
		fail("Not yet implemented");
	}

	@Test
	public void testWaitLongInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testWait() {
		fail("Not yet implemented");
	}

	@Test
	public void testFinalize() {
		fail("Not yet implemented");
	}

}

package Java_Advanced_01.lesson_01;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;

public class SeanceTest {

	@Rule
	public TestWatcher testWather = new TestWatcher() {
		protected void failed(Throwable e, org.junit.runner.Description description) {System.out.println("FAILED --> "+description.getMethodName());};
		protected void succeeded(org.junit.runner.Description description) {System.out.println("SUCCEED --> "+description.getMethodName());};
	};
	
	@Test
    public void testSeanceConstructor() {
        Time startTime = new Time(10, 0);
        Time duration = new Time(2, 30);
        Movie movie = new Movie("The Matrix", duration);
        Seance seance = new Seance(movie, startTime);

        assertEquals(movie, seance.getMovie());
        assertEquals(startTime, seance.getStartTime());
        assertEquals(new Time(12, 30), seance.getEndTime());
    }

    @Test
    public void testSeanceToString() {
        Time startTime = new Time(14, 15);
        Time duration = new Time(2, 0);
        Movie movie = new Movie("Inception", duration);
        Seance seance = new Seance(movie, startTime);
        assertEquals("Inception (02:00) at 14:15 - 16:15", seance.toString());
    }

    @Test
    public void testSeanceEquals() {
        Time startTime1 = new Time(12, 0);
        Time duration1 = new Time(1, 30);
        Movie movie1 = new Movie("Avatar", duration1);
        Seance seance1 = new Seance(movie1, startTime1);

        Time startTime2 = new Time(12, 0);
        Time duration2 = new Time(1, 30);
        Movie movie2 = new Movie("Avatar", duration2);
        Seance seance2 = new Seance(movie2, startTime2);

        Time startTime3 = new Time(14, 0);
        Time duration3 = new Time(2, 0);
        Movie movie3 = new Movie("Inception", duration3);
        Seance seance3 = new Seance(movie3, startTime3);

        assertTrue(seance1.equals(seance2));
        assertFalse(seance1.equals(seance3));
    }

    @Test
    public void testSeanceCompareTo() {
        Time startTime1 = new Time(10, 0);
        Time duration1 = new Time(2, 0);
        Movie movie1 = new Movie("Avatar", duration1);
        Seance seance1 = new Seance(movie1, startTime1);

        Time startTime2 = new Time(11, 30);
        Time duration2 = new Time(2, 30);
        Movie movie2 = new Movie("Inception", duration2);
        Seance seance2 = new Seance(movie2, startTime2);

        assertTrue(seance1.compareTo(seance2) < 0);
        assertTrue(seance2.compareTo(seance1) > 0);
        assertEquals(0, seance1.compareTo(new Seance(movie1, startTime1)));
    }

    @Test
    public void testSeanceHashCode() {
        Time startTime1 = new Time(10, 0);
        Time duration1 = new Time(2, 0);
        Movie movie1 = new Movie("Avatar", duration1);
        Seance seance1 = new Seance(movie1, startTime1);

        Time startTime2 = new Time(10, 0);
        Time duration2 = new Time(2, 0);
        Movie movie2 = new Movie("Avatar", duration2);
        Seance seance2 = new Seance(movie2, startTime2);

        assertEquals(seance1.hashCode(), seance2.hashCode());
    }
	
}

package Java_Advanced_01.lesson_01;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;

public class MovieTest {

	@Rule
	public TestWatcher testWather = new TestWatcher() {
		protected void failed(Throwable e, org.junit.runner.Description description) {System.out.println("FAILED --> "+description.getMethodName());};
		protected void succeeded(org.junit.runner.Description description) {System.out.println("SUCCEED --> "+description.getMethodName());};
	};
	
	@Test
    public void testMovieConstructor() {
        Time duration = new Time(2, 30);
        Movie movie = new Movie("Inception", duration);
        assertEquals("Inception", movie.getTitle());
        assertEquals(duration, movie.getDuration());
    }

    @Test
    public void testMovieToString() {
        Time duration = new Time(1, 45);
        Movie movie = new Movie("The Shawshank Redemption", duration);
        assertEquals("The Shawshank Redemption (01:45)", movie.toString());
    }

    @Test
    public void testMovieEquals() {
        Time duration1 = new Time(2, 30);
        Time duration2 = new Time(2, 30);
        Movie movie1 = new Movie("Avatar", duration1);
        Movie movie2 = new Movie("Avatar", duration2);
        Movie movie3 = new Movie("Inception", duration1);
        assertTrue(movie1.equals(movie2));
        assertFalse(movie1.equals(movie3));
    }

    @Test
    public void testMovieHashCode() {
        Time duration1 = new Time(1, 30);
        Time duration2 = new Time(1, 30);
        Movie movie1 = new Movie("Interstellar", duration1);
        Movie movie2 = new Movie("Interstellar", duration2);
        assertEquals(movie1.hashCode(), movie2.hashCode());
    }
	
}

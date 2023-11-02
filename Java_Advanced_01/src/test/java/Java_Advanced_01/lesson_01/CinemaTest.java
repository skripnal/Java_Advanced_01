package Java_Advanced_01.lesson_01;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;

public class CinemaTest {
	@Rule
	public TestWatcher testWather = new TestWatcher() {
		protected void failed(Throwable e, org.junit.runner.Description description) {System.out.println("FAILED --> "+description.getMethodName());};
		protected void succeeded(org.junit.runner.Description description) {System.out.println("SUCCEED --> "+description.getMethodName());};
	};
	
	@Test
    public void testCinemaAddMovie() {
        Cinema cinema = new Cinema(new Time(9, 0), new Time(22, 0));
        Movie movie = new Movie("Avatar", new Time(2, 30));
        cinema.addMovie(movie);
        assertTrue(cinema.getMoviesLibrary().contains(movie));
    }

    @Test
    public void testCinemaRemoveMovie() {
        Cinema cinema = new Cinema(new Time(9, 0), new Time(22, 0));
        Movie movie = new Movie("Avatar", new Time(2, 30));
        cinema.addMovie(movie);
        cinema.removeMovie(movie);
        assertFalse(cinema.getMoviesLibrary().contains(movie));
    }

    @Test
    public void testCinemaAddSeance() {
        Cinema cinema = new Cinema(new Time(9, 0), new Time(22, 0));
        Movie movie = new Movie("Inception", new Time(2, 0));
        Seance seance = new Seance(movie, new Time(10, 0));
        cinema.addSeance(seance, "MONDAY");
        assertTrue(cinema.getSchedules().get(Days.MONDAY).getSeances().contains(seance));
    }

    @Test
    public void testCinemaRemoveSeance() {
        Cinema cinema = new Cinema(new Time(9, 0), new Time(22, 0));
        Movie movie = new Movie("Inception", new Time(2, 0));
        Seance seance = new Seance(movie, new Time(10, 0));
        cinema.addSeance(seance, "MONDAY");
        cinema.removeSeance(seance, "MONDAY");
        assertFalse(cinema.getSchedules().get(Days.MONDAY).getSeances().contains(seance));
    }

    @Test
    public void testCinemaIsWithinOperatingHours() {
        Cinema cinema = new Cinema(new Time(9, 0), new Time(22, 0));
        Time startTime = new Time(10, 0);
        Time endTime = new Time(12, 0);
        assertTrue(cinema.isWithinOperatingHours(startTime, endTime));
    }

    @Test
    public void testCinemaFindSeanceByMovieTitleAndDay() {
        Cinema cinema = new Cinema(new Time(9, 0), new Time(22, 0));
        Movie movie = new Movie("Avatar", new Time(2, 30));
        Seance seance = new Seance(movie, new Time(10, 0));
        cinema.addSeance(seance, "MONDAY");
        Optional<Seance> foundSeance = cinema.findSeanceByMovieTitleAndDay(cinema.getSchedules().get(Days.MONDAY), "Avatar");
        assertTrue(foundSeance.isPresent());
    }
}

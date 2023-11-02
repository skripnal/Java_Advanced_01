package Java_Advanced_01.lesson_01;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;

public class ScheduleTest {

	@Rule
	public TestWatcher testWather = new TestWatcher() {
		protected void failed(Throwable e, org.junit.runner.Description description) {System.out.println("FAILED --> "+description.getMethodName());};
		protected void succeeded(org.junit.runner.Description description) {System.out.println("SUCCEED --> "+description.getMethodName());};
	};
	
	@Test
    public void testScheduleAddSeance() {
        Time startTime1 = new Time(10, 0);
        Time duration1 = new Time(2, 0);
        Movie movie1 = new Movie("Avatar", duration1);
        Seance seance1 = new Seance(movie1, startTime1);

        Time startTime2 = new Time(14, 0);
        Time duration2 = new Time(1, 30);
        Movie movie2 = new Movie("Inception", duration2);
        Seance seance2 = new Seance(movie2, startTime2);

        Schedule schedule = new Schedule();
        schedule.addSeance(seance1);
        schedule.addSeance(seance2);

        assertTrue(schedule.getSeances().contains(seance1));
        assertTrue(schedule.getSeances().contains(seance2));
    }

    @Test
    public void testScheduleRemoveSeance() {
        Time startTime1 = new Time(10, 0);
        Time duration1 = new Time(2, 0);
        Movie movie1 = new Movie("Avatar", duration1);
        Seance seance1 = new Seance(movie1, startTime1);

        Time startTime2 = new Time(14, 0);
        Time duration2 = new Time(1, 30);
        Movie movie2 = new Movie("Inception", duration2);
        Seance seance2 = new Seance(movie2, startTime2);

        Schedule schedule = new Schedule();
        schedule.addSeance(seance1);
        schedule.addSeance(seance2);

        schedule.removeSeance(seance1);

        assertFalse(schedule.getSeances().contains(seance1));
        assertTrue(schedule.getSeances().contains(seance2));
    }

    @Test
    public void testScheduleToString() {
        Schedule schedule = new Schedule();
        Time startTime1 = new Time(10, 0);
        Time duration1 = new Time(2, 0);
        Movie movie1 = new Movie("Avatar", duration1);
        Seance seance1 = new Seance(movie1, startTime1);

        Time startTime2 = new Time(14, 0);
        Time duration2 = new Time(1, 30);
        Movie movie2 = new Movie("Inception", duration2);
        Seance seance2 = new Seance(movie2, startTime2);

        schedule.addSeance(seance1);
        schedule.addSeance(seance2);

        String expected = "Avatar (02:00) at 10:00 - 12:00\nInception (01:30) at 14:00 - 15:30\n";
        assertEquals(expected, schedule.toString());
    }

    @Test
    public void testScheduleEquals() {
        Schedule schedule1 = new Schedule();
        Time startTime1 = new Time(10, 0);
        Time duration1 = new Time(2, 0);
        Movie movie1 = new Movie("Avatar", duration1);
        Seance seance1 = new Seance(movie1, startTime1);
        schedule1.addSeance(seance1);

        Schedule schedule2 = new Schedule();
        Time startTime2 = new Time(10, 0);
        Time duration2 = new Time(2, 0);
        Movie movie2 = new Movie("Avatar", duration2);
        Seance seance2 = new Seance(movie2, startTime2);
        schedule2.addSeance(seance2);

        assertEquals(schedule1, schedule2);
    }

    @Test
    public void testScheduleHashCode() {
        Schedule schedule1 = new Schedule();
        Time startTime1 = new Time(10, 0);
        Time duration1 = new Time(2, 0);
        Movie movie1 = new Movie("Avatar", duration1);
        Seance seance1 = new Seance(movie1, startTime1);
        schedule1.addSeance(seance1);

        Schedule schedule2 = new Schedule();
        Time startTime2 = new Time(10, 0);
        Time duration2 = new Time(2, 0);
        Movie movie2 = new Movie("Avatar", duration2);
        Seance seance2 = new Seance(movie2, startTime2);
        schedule2.addSeance(seance2);

        assertEquals(schedule1.hashCode(), schedule2.hashCode());
    }
	
}	

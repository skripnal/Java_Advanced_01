package Java_Advanced_01.lesson_01;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;

public class TimeTest {

	@Rule
	public TestWatcher testWather = new TestWatcher() {
		protected void failed(Throwable e, org.junit.runner.Description description) {System.out.println("FAILED --> "+description.getMethodName());};
		protected void succeeded(org.junit.runner.Description description) {System.out.println("SUCCEED --> "+description.getMethodName());};
	};
	
	@Test
	public void testTimeValidConstructor() {
		Time time = new Time(2,30);
		assertEquals(2, time.getHour());
		assertEquals(30, time.getMin());
	}
	
	@Test
	public void testTimeValidConstructorException() {
		assertThrows(IllegalArgumentException.class, () -> new Time(20,70));
	}
	
	@Test
	public void testTimeCompareTo() {
		Time time1 = new Time(10,30);
		Time time2 = new Time(2,10);
		assertTrue(time1.compareTo(time2)>0);
		assertTrue(time2.compareTo(time1)<0);
		assertEquals(0, time1.compareTo(new Time(10,30)));
	}
	
	@Test
	public void testTimeToString() {
        Time time = new Time(8, 15);
        assertEquals("08:15", time.toString());
    }
	
	@Test
	public void testTimeEquals() {
        Time time1 = new Time(9, 45);
        Time time2 = new Time(9, 45);
        Time time3 = new Time(10, 30);
        assertTrue(time1.equals(time2));
        assertFalse(time1.equals(time3));
    }

    @Test
    public void testTimeHashCode() {
        Time time1 = new Time(11, 20);
        Time time2 = new Time(11, 20);
        assertEquals(time1.hashCode(), time2.hashCode());
    }
}

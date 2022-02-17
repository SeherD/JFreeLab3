package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.*;

public class RangeTest {
	private Range exampleRange;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {

	}
	
	
	@Test
	//Testing positive integer within range
	public void positiveIntegerContainsTest() {
		exampleRange = new Range(0, 5); //create sample range to test
		assertTrue(exampleRange.contains(2));
	}

	@Test
	//Testing negative integer within range
	public void negativeIntegerContainsTest() {
		exampleRange = new Range(-100, 5); //create sample range to test
		assertTrue(exampleRange.contains(-12));
	}

	@Test
	//Testing negative range containing 0
	public void zeroRangeContainsTest() {
		exampleRange = new Range(-100, 5); //create sample range to test
		assertTrue(exampleRange.contains(0));
	}


	@Test
	//Testing upper bound to see if present
	public void upperBoundContainsTest() {
		exampleRange = new Range(2,41); //create sample range to test
		assertTrue(exampleRange.contains(41));
	}

	@Test
	//Testing lower bound to see if present
	public void lowerBoundContainsTest() {
		exampleRange = new Range(2,41); //create sample range to test
		assertTrue(exampleRange.contains(2));
	}

	@Test
	//Testing outside upper bound to see if present
	public void outsideUpperBoundContainsTest() {
		exampleRange = new Range(2,41); //create sample range to test
		assertFalse(exampleRange.contains(44));
	}

	@Test
	//Testing outside upper bound to see if present
	public void outsideLowerBoundContainsTest() {
		exampleRange = new Range(2,41); //create sample range to test
		assertFalse(exampleRange.contains(1));
	}


	@Test
	//Testing range of doubles with contains
	public void doubleContainsTest() {
		exampleRange = new Range(-10.5, -1); //create sample range to test
		assertTrue(exampleRange.contains(-5));
	}


	
	@Test
	//Testing return value of zero
	public void shouldBeZeroCentralValueTest() {
		exampleRange = new Range(-1, 1); //create sample range to test
		assertEquals("The central value of -1 and 1 should be 0",0, exampleRange.getCentralValue(), .000000001d);
	}

	@Test
	//Testing standard range should be positive
	public void shouldBePositiveCentralValueTest() {
		exampleRange = new Range(0,4); //create sample range to test
		assertEquals("The central value of 0 and 4 should be 2",2, exampleRange.getCentralValue(), .000000001d);
	}

	@Test
	//Testing small range of values and if value works as decimal
	public void shouldBeDecimalCentralValueTest() {
		exampleRange = new Range(-1, 0); //create sample range to test
		assertEquals("The central value of -1 and 0 should be -0.5",-0.5, exampleRange.getCentralValue(), .000000001d);
	}

	@Test
	//Testing range of doubles
	public void shouldBeNegativeDoubleCentralValueTest() {
		exampleRange = new Range(-10.5, -1.5); //create sample range to test
		assertEquals("The central value of range -10.5 and -1.5 should be -6",-6, exampleRange.getCentralValue(), .000000001d);
	}


	@Test
	//Testing range size of 1
	public void shouldBeTotalRangeCentralValueTest() {
		exampleRange = new Range(-1, -1); //create sample range to test
		assertEquals("The central value of -1 and 0 should be -1",-1, exampleRange.getCentralValue(), .000000001d);
	}

	@Test(expected = IllegalArgumentException.class)
	//Testing invalid range 
	public void shouldBeThreeCentralValueTest() {
		exampleRange = new Range(7, -1); //create sample range to test
	} 

	@Test
	// Testing return value of zero
	public void shouldBeZeroUpperBoundTest() {
		exampleRange = new Range(-1, 0); // create sample range to test
		assertEquals("The upper bound of range -1 and 0 should be 0", 0, exampleRange.getUpperBound(), .000000001d);
	}

	@Test
	// Testing standard range should be positive
	public void shouldBeFourUpperBoundTest() {
		exampleRange = new Range(0, 4); // create sample range to test
		assertEquals("The upper bound of range 0 and 4 should be 4", 4, exampleRange.getUpperBound(), .000000001d);
	}

	@Test
	// Testing standard range should be negative
	public void shouldBeNegativeUpperBoundTest() {
		exampleRange = new Range(-141, -4); // create sample range to test
		assertEquals("The upper bound of range -141 and -4 should be -4", -4, exampleRange.getUpperBound(),
				.000000001d);
	}

	@Test
	// Testing range size of 1
	public void shouldBeNegative1UpperBoundTest() {
		exampleRange = new Range(-1, -1); // create sample range to test
		assertEquals("The upper bound of range -1 and -1 should be -1", -1, exampleRange.getUpperBound(), .000000001d);
	}

	@Test
	// Testing range of doubles
	public void shouldBeNegativeDoubleUpperBoundTest() {
		exampleRange = new Range(-10.5, -1); // create sample range to test
		assertEquals("The upper bound of range -10.5 and -1 should be -1", -1, exampleRange.getUpperBound(),
				.000000001d);
	}

	

	@Test
	//Testing return value of zero
	public void shouldBeZeroLowerBoundTest() {
		exampleRange = new Range(0, 5); //create sample range to test
		assertEquals("The lower bound of range 0 to 5 should be 0",0, exampleRange.getLowerBound(), .000000001d);
	}

	@Test
	//Testing standard range should be positive
	public void shouldBeTwoLowerBoundTest() {
		exampleRange = new Range(2,41); //create sample range to test
		assertEquals("The lower bound of range 0 and 4 should be 4",2, exampleRange.getLowerBound(), .000000001d);
	}

	@Test
	//Testing standard range should be negative
	public void shouldBeNegativeLowerBoundTest() {
		exampleRange = new Range(-141,-4); //create sample range to test
		assertEquals("The lower bound of range -141 and -4 should be -4",-141, exampleRange.getLowerBound(), .000000001d);
	}

	@Test
	//Testing range size of 1
	public void shouldBeNegative1LowerBoundTest() {
		exampleRange = new Range(-1, -1); //create sample range to test
		assertEquals("The lower bound of range -1 and -1 should be -1",-1, exampleRange.getLowerBound(), .000000001d);
	}

	@Test
	//Testing range of doubles
	public void shouldBeNegativeDoubleLowerBoundTest() {
		exampleRange = new Range(-10.5, -1); //create sample range to test
		assertEquals("The lower bound of range -10.5 and -1 should be -1",-10.5, exampleRange.getLowerBound(), .000000001d);
	}

	
	@Test(expected = IllegalArgumentException.class)
	//Testing invalid range 
	public void invalidRange() {
		exampleRange = new Range(7, -1); //create sample range to test
	} 

	
	//Testing range of size 0
	@Test
	public void shouldBeZeroLengthTest() {
		exampleRange = new Range(-1, -1);
		assertEquals("The length of range -1 to -1 should be 0", 0, exampleRange.getLength(), .000000001d);
	}
	
	//Testing null range object
	@Test(expected = NullPointerException.class)
	public void shouldBeUndefinedRangeNullLengthTest() {
		exampleRange.getLength();
	}

	
	//Testing range of size 2
	@Test
	public void shouldBeTwoLengthTest() {
		exampleRange = new Range(-1, 1);
		assertEquals("The length of range -1 to 1 should be 2", 2, exampleRange.getLength(), .000000001d);
	}
	//Testing large size range 
	@Test
	public void largeRangeLengthTest() {
		exampleRange = new Range(-9999999, 9999999);
		assertEquals("The length of range -9999999 to 9999999 should be 19999998", 19999998, exampleRange.getLength(),
				.000000001d);
	}
	//Testing range with decimal upper and lower bounds
	@Test
	public void rangeDecimalsLengthTest() {
		exampleRange = new Range(-9999999.6584, 9999999.3455);
		assertEquals("The length of range -9999999.6584 to 9999999.3455 should be 19,999,999.0039", 19999999.0039,
				exampleRange.getLength(), .000000001d);
	}

	//Testing an invalid range
	@Test(expected = IllegalArgumentException.class)
	public void shouldBeUndefinedLengthTest() {
		exampleRange = new Range(1, -1);
		exampleRange.getLength();

	}

	@After
	public void tearDown() throws Exception {
		exampleRange=null;
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
}

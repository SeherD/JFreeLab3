package org.jfree.data.test;

import static org.junit.Assert.*;

import org.junit.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;
import org.jmock.*;

public class DataUtilitiesTest {
	Mockery mockingContext ;
	KeyedValues values ;
	 private Mockery mocker;
		@BeforeClass public static void setUpBeforeClass() throws Exception {
	    }
	    
		//Before the tests are run, the mocker is initialized.
		@Before
		public void setUp() throws Exception {
			mocker = new Mockery();
			mockingContext = new Mockery();
			values = mockingContext.mock(KeyedValues.class);
			
		}
		/**
		 * This test will attempt to execute the calculateRowTotal
		 * function at the minimum boundary, which is row index 0.
		 * It should sum up the columns of row 0 and obtain the result 15.
		 */
		@Test
	    public void minBoundaryCalculateRowTotalTest() {
		    final Values2D values = mocker.mock(Values2D.class);
		    mocker.checking(new Expectations() {
		        {
		            one(values).getColumnCount();
		            will(returnValue(3));
		            one(values).getRowCount();
		            will(returnValue(3));
		            one(values).getValue(0, 0);
		            will(returnValue(8));
		            one(values).getValue(0, 1);
		            will(returnValue(3));
		            one(values).getValue(0, 2);
		            will(returnValue(4));
		            one(values).getValue(1, 0);
		            will(returnValue(5));
		            one(values).getValue(1, 1);
		            will(returnValue(6));
		            one(values).getValue(1, 2);
		            will(returnValue(2));
		            one(values).getValue(2, 0);
		            will(returnValue(1));
		            one(values).getValue(2, 1);
		            will(returnValue(9));
		            one(values).getValue(2, 2);
		            will(returnValue(3));
		        }
		    });
	        assertEquals(DataUtilities.calculateRowTotal(values, 0), 15, .000000001d);
	    }
		
		/**
		 * This test will attempt to execute the calculateRowTotal
		 * function at the maximum boundary, which is row index 2.
		 * It should sum up the columns of row 2 and obtain the result 12.
		 */
		@Test
	    public void maxBoundaryCalculateRowTotalTest() {
		    final Values2D values = mocker.mock(Values2D.class);
		    mocker.checking(new Expectations() {
		        {
		        	one(values).getColumnCount();
		            will(returnValue(3));
		            one(values).getRowCount();
		            will(returnValue(3));
		            one(values).getValue(0, 0);
		            will(returnValue(8));
		            one(values).getValue(0, 1);
		            will(returnValue(3));
		            one(values).getValue(0, 2);
		            will(returnValue(4));
		            one(values).getValue(1, 0);
		            will(returnValue(5));
		            one(values).getValue(1, 1);
		            will(returnValue(6));
		            one(values).getValue(1, 2);
		            will(returnValue(2));
		            one(values).getValue(2, 0);
		            will(returnValue(1));
		            one(values).getValue(2, 1);
		            will(returnValue(9));
		            one(values).getValue(2, 2);
		            will(returnValue(3));
		        }
		    });
	        assertEquals(DataUtilities.calculateRowTotal(values, 2), 13, .000000001d);
	    }
		
		/**
		 * This test will attempt to execute the calculateRowTotal
		 * function at an index just below the maximum boundary,
		 * which is row index 3.
		 * It should sum up the columns of row 3 and obtain the result 10.
		 */
		@Test
	    public void belowMaxBoundaryCalculateRowTotalTest() {
		    final Values2D values = mocker.mock(Values2D.class);
		    mocker.checking(new Expectations() {
		        {
		        	one(values).getColumnCount();
		            will(returnValue(2));
		            one(values).getRowCount();
		            will(returnValue(5));
		            one(values).getValue(0, 0);
		            will(returnValue(8));
		            one(values).getValue(0, 1);
		            will(returnValue(3));
		            one(values).getValue(1, 0);
		            will(returnValue(5));
		            one(values).getValue(1, 1);
		            will(returnValue(6));
		            one(values).getValue(2, 0);
		            will(returnValue(1));
		            one(values).getValue(2, 1);
		            will(returnValue(1));
		            one(values).getValue(3, 0);
		            will(returnValue(7));
		            one(values).getValue(3, 1);
		            will(returnValue(3));
		            one(values).getValue(4, 0);
		            will(returnValue(1));
		            one(values).getValue(4, 1);
		            will(returnValue(2));
		        }
		    });
	        assertEquals(DataUtilities.calculateRowTotal(values, 3), 10, .000000001d);
	    }
		
		/**
		 * This test will attempt to execute the calculateRowTotal
		 * function at an index just above the minimum boundary,
		 * which is row index 1.
		 * It should sum up the columns of row 1 and obtain the result 11.
		 */
		@Test
	    public void aboveMinBoundaryCalculateRowTotalTest() {
		    final Values2D values = mocker.mock(Values2D.class);
		    mocker.checking(new Expectations() {
		        {
		        	one(values).getColumnCount();
		            will(returnValue(2));
		            one(values).getRowCount();
		            will(returnValue(5));
		            one(values).getValue(0, 0);
		            will(returnValue(8));
		            one(values).getValue(0, 1);
		            will(returnValue(3));
		            one(values).getValue(1, 0);
		            will(returnValue(5));
		            one(values).getValue(1, 1);
		            will(returnValue(6));
		            one(values).getValue(2, 0);
		            will(returnValue(1));
		            one(values).getValue(2, 1);
		            will(returnValue(1));
		            one(values).getValue(3, 0);
		            will(returnValue(7));
		            one(values).getValue(3, 1);
		            will(returnValue(3));
		            one(values).getValue(4, 0);
		            will(returnValue(1));
		            one(values).getValue(4, 1);
		            will(returnValue(2));
		        }
		    });
	        assertEquals(DataUtilities.calculateRowTotal(values, 1), 11, .000000001d);
	    }
		
		/**
		 * This test will attempt to execute the calculateRowTotal
		 * function at an index just above the maximum boundary, and
		 * hence out of bounds. We will test row index 3.
		 * It should throw an IndexOutOfBoundsException
		 */
		@Test(expected=IndexOutOfBoundsException.class)
	    public void aboveMaxBoundsCalculateRowTotalTest() {
		    final Values2D values = mocker.mock(Values2D.class);
		    mocker.checking(new Expectations() {
		        {
		        	one(values).getColumnCount();
		            will(returnValue(3));
		            one(values).getRowCount();
		            will(returnValue(3));
		            one(values).getValue(0, 0);
		            will(returnValue(8));
		            one(values).getValue(0, 1);
		            will(returnValue(3));
		            one(values).getValue(0, 2);
		            will(returnValue(4));
		            one(values).getValue(1, 0);
		            will(returnValue(5));
		            one(values).getValue(1, 1);
		            will(returnValue(6));
		            one(values).getValue(1, 2);
		            will(returnValue(2));
		            one(values).getValue(2, 0);
		            will(returnValue(1));
		            one(values).getValue(2, 1);
		            will(returnValue(9));
		            one(values).getValue(2, 2);
		            will(returnValue(3));
		            one(values).getValue(3, 0);
		            will(throwException(new IndexOutOfBoundsException()));
		        }
		    });
	        DataUtilities.calculateRowTotal(values, 3);
	    }
		
		/**
		 * This test will attempt to execute the calculateRowTotal
		 * function at an index just below the minimum boundary, and
		 * hence out of bounds. We will test row index -1.
		 * It should throw an IndexOutOfBoundsException
		 */
		@Test(expected=IndexOutOfBoundsException.class)
	    public void belowMinBoundsCalculateRowTotalTest() {
		    final Values2D values = mocker.mock(Values2D.class);
		    mocker.checking(new Expectations() {
		        {
		        	one(values).getColumnCount();
		            will(returnValue(3));
		            one(values).getRowCount();
		            will(returnValue(3));
		            one(values).getValue(0, 0);
		            will(returnValue(8));
		            one(values).getValue(0, 1);
		            will(returnValue(3));
		            one(values).getValue(0, 2);
		            will(returnValue(4));
		            one(values).getValue(1, 0);
		            will(returnValue(5));
		            one(values).getValue(1, 1);
		            will(returnValue(6));
		            one(values).getValue(1, 2);
		            will(returnValue(2));
		            one(values).getValue(2, 0);
		            will(returnValue(1));
		            one(values).getValue(2, 1);
		            will(returnValue(9));
		            one(values).getValue(2, 2);
		            will(returnValue(3));
		            one(values).getValue(-1, 0);
		            will(throwException(new IndexOutOfBoundsException()));
		        }
		    });
	        DataUtilities.calculateRowTotal(values, -1);
	    }
		
		/**
		 * This test will attempt to execute the calculateRowTotal
		 * function at an index in the middle of the boundaries,
		 * which is row index 2.
		 * It should sum up the columns of row 2 and obtain the result 2.
		 */
		@Test
	    public void middleOfBoundariesCalculateRowTotalTest() {
		    final Values2D values = mocker.mock(Values2D.class);
		    mocker.checking(new Expectations() {
		        {
		        	one(values).getColumnCount();
		            will(returnValue(2));
		            one(values).getRowCount();
		            will(returnValue(5));
		            one(values).getValue(0, 0);
		            will(returnValue(8));
		            one(values).getValue(0, 1);
		            will(returnValue(3));
		            one(values).getValue(1, 0);
		            will(returnValue(5));
		            one(values).getValue(1, 1);
		            will(returnValue(6));
		            one(values).getValue(2, 0);
		            will(returnValue(1));
		            one(values).getValue(2, 1);
		            will(returnValue(1));
		            one(values).getValue(3, 0);
		            will(returnValue(7));
		            one(values).getValue(3, 1);
		            will(returnValue(3));
		            one(values).getValue(4, 0);
		            will(returnValue(1));
		            one(values).getValue(4, 1);
		            will(returnValue(2));
		        }
		    });
	        assertEquals(DataUtilities.calculateRowTotal(values, 2), 2, .000000001d);
	    }
		
		/**
		 * This test will attempt to execute the calculateRowTotal
		 * in a row with many columns, each containing large integer values.
		 * It should sum up the columns of row 0 and obtain the result 9847.
		 */
		@Test
	    public void lotsOfRowsCalculateRowTotalTest() {
		    final Values2D values = mocker.mock(Values2D.class);
		    mocker.checking(new Expectations() {
		        {
		        	one(values).getColumnCount();
		            will(returnValue(10));
		            one(values).getRowCount();
		            will(returnValue(1));
		            one(values).getValue(0, 0);
		            will(returnValue(233));
		            one(values).getValue(0, 1);
		            will(returnValue(105));
		            one(values).getValue(0, 2);
		            will(returnValue(95));
		            one(values).getValue(0, 3);
		            will(returnValue(583));
		            one(values).getValue(0, 4);
		            will(returnValue(688));
		            one(values).getValue(0, 5);
		            will(returnValue(309));
		            one(values).getValue(0, 6);
		            will(returnValue(688));
		            one(values).getValue(0, 7);
		            will(returnValue(1600));
		            one(values).getValue(0, 8);
		            will(returnValue(1234));
		            one(values).getValue(0, 9);
		            will(returnValue(4312));
		        }
		    });
	        assertEquals(DataUtilities.calculateRowTotal(values, 0), 9847, .000000001d);
	    }
		
		/**
		 * This test will attempt to execute the calculateRowTotal
		 * in a column with many columns, each containing large integer values,
		 * that can be either positive or negative.
		 * It should sum up the columns of row 0 and obtain the result -1785.
		 */
		@Test
	    public void negativeValuesCalculateRowTotalTest() {
		    final Values2D values = mocker.mock(Values2D.class);
		    mocker.checking(new Expectations() {
		        {
		        	one(values).getColumnCount();
		            will(returnValue(10));
		            one(values).getRowCount();
		            will(returnValue(1));
		            one(values).getValue(0, 0);
		            will(returnValue(-233));
		            one(values).getValue(0, 1);
		            will(returnValue(105));
		            one(values).getValue(0, 2);
		            will(returnValue(95));
		            one(values).getValue(0, 3);
		            will(returnValue(-583));
		            one(values).getValue(0, 4);
		            will(returnValue(688));
		            one(values).getValue(0, 5);
		            will(returnValue(309));
		            one(values).getValue(0, 6);
		            will(returnValue(-688));
		            one(values).getValue(0, 7);
		            will(returnValue(1600));
		            one(values).getValue(0, 8);
		            will(returnValue(1234));
		            one(values).getValue(0, 9);
		            will(returnValue(-4312));
		        }
		    });
	        assertEquals(DataUtilities.calculateRowTotal(values, 0), -1785, .000000001d);
	    }
		
		/**
		 * This test will attempt to execute the calculateRowTotal
		 * function with a null value as integer input. It should throw
		 * a NullPointerException
		 */
		@Test(expected=NullPointerException.class)
	    public void nullIntInputCalculateRowTotalTest() {
		    final Values2D values = mocker.mock(Values2D.class);
		    mocker.checking(new Expectations() {
		        {
		            one(values).getColumnCount();
		            will(returnValue(3));
		            one(values).getRowCount();
		            will(returnValue(3));
		            one(values).getValue(0, 0);
		            will(returnValue(8));
		            one(values).getValue(1, 0);
		            will(returnValue(3));
		            one(values).getValue(2, 0);
		            will(returnValue(4));
		            one(values).getValue(0, 1);
		            will(returnValue(5));
		            one(values).getValue(1, 1);
		            will(returnValue(6));
		            one(values).getValue(2, 1);
		            will(returnValue(2));
		            one(values).getValue(0, 2);
		            will(returnValue(1));
		            one(values).getValue(1, 2);
		            will(returnValue(9));
		            one(values).getValue(2, 2);
		            will(returnValue(3));
		            one(values).getValue(0, -1);
		            will(throwException(new IndexOutOfBoundsException()));
		        }
		    });
		    Integer nullInt = null;
	        DataUtilities.calculateRowTotal(values, nullInt);
	    }
		
		/**
		 * This test will attempt to execute the calculateRowTotal
		 * function with a null value as Values2D input. It should throw
		 * an IllegalArgumentException
		 */
		@Test(expected=IllegalArgumentException.class)
	    public void nullValues2DInputCalculateRowTotalTest() {
		    final Values2D values = null;
	        DataUtilities.calculateRowTotal(values, 1);
	    }
		
		
		
		/**
		 * This test will attempt to execute the calculateColumnTotal
		 * function at the minimum boundary, which is column index 0.
		 * It should sum up the rows of column 0 and obtain the result 15.
		 */
		
		@Test
	    public void minBoundaryCalculateColumnTotalTest() {
		    final Values2D values = mocker.mock(Values2D.class);
		    mocker.checking(new Expectations() {
		        {
		            one(values).getColumnCount();
		            will(returnValue(3));
		            one(values).getRowCount();
		            will(returnValue(3));
		            one(values).getValue(0, 0);
		            will(returnValue(8));
		            one(values).getValue(1, 0);
		            will(returnValue(3));
		            one(values).getValue(2, 0);
		            will(returnValue(4));
		            one(values).getValue(0, 1);
		            will(returnValue(5));
		            one(values).getValue(1, 1);
		            will(returnValue(6));
		            one(values).getValue(2, 1);
		            will(returnValue(2));
		            one(values).getValue(0, 2);
		            will(returnValue(1));
		            one(values).getValue(1, 2);
		            will(returnValue(9));
		            one(values).getValue(2, 2);
		            will(returnValue(3));
		        }
		    });
	        assertEquals(DataUtilities.calculateColumnTotal(values, 0), 15, .000000001d);
	    }
		
		/**
		 * This test will attempt to execute the calculateColumnTotal
		 * function at the maximum boundary, which is column index 2.
		 * It should sum up the rows of column 2 and obtain the result 12.
		 */
		@Test
	    public void maxBoundaryCalculateColumnTotalTest() {
		    final Values2D values = mocker.mock(Values2D.class);
		    mocker.checking(new Expectations() {
		        {
		        	one(values).getColumnCount();
		            will(returnValue(3));
		            one(values).getRowCount();
		            will(returnValue(3));
		            one(values).getValue(0, 0);
		            will(returnValue(8));
		            one(values).getValue(1, 0);
		            will(returnValue(3));
		            one(values).getValue(2, 0);
		            will(returnValue(4));
		            one(values).getValue(0, 1);
		            will(returnValue(5));
		            one(values).getValue(1, 1);
		            will(returnValue(6));
		            one(values).getValue(2, 1);
		            will(returnValue(2));
		            one(values).getValue(0, 2);
		            will(returnValue(1));
		            one(values).getValue(1, 2);
		            will(returnValue(9));
		            one(values).getValue(2, 2);
		            will(returnValue(2));
		        }
		    });
	        assertEquals(DataUtilities.calculateColumnTotal(values, 2), 12, .000000001d);
	    }
		
		/**
		 * This test will attempt to execute the calculateColumnTotal
		 * function at an index just below the maximum boundary,
		 * which is column index 3.
		 * It should sum up the rows of column 3 and obtain the result 10.
		 */
		@Test
	    public void belowMaxBoundaryCalculateColumnTotalTest() {
		    final Values2D values = mocker.mock(Values2D.class);
		    mocker.checking(new Expectations() {
		        {
		        	one(values).getColumnCount();
		            will(returnValue(5));
		            one(values).getRowCount();
		            will(returnValue(2));
		            one(values).getValue(0, 0);
		            will(returnValue(8));
		            one(values).getValue(1, 0);
		            will(returnValue(3));
		            one(values).getValue(0, 1);
		            will(returnValue(5));
		            one(values).getValue(1, 1);
		            will(returnValue(6));
		            one(values).getValue(0, 2);
		            will(returnValue(1));
		            one(values).getValue(1, 2);
		            will(returnValue(1));
		            one(values).getValue(0, 3);
		            will(returnValue(7));
		            one(values).getValue(1, 3);
		            will(returnValue(3));
		            one(values).getValue(0, 4);
		            will(returnValue(1));
		            one(values).getValue(1, 4);
		            will(returnValue(2));
		        }
		    });
	        assertEquals(DataUtilities.calculateColumnTotal(values, 3), 10, .000000001d);
	    }
		
		/**
		 * This test will attempt to execute the calculateColumnTotal
		 * function at an index just above the minimum boundary,
		 * which is column index 1.
		 * It should sum up the rows of column 1 and obtain the result 11.
		 */
		@Test
	    public void aboveMinBoundaryCalculateColumnTotalTest() {
		    final Values2D values = mocker.mock(Values2D.class);
		    mocker.checking(new Expectations() {
		        {
		        	one(values).getColumnCount();
		            will(returnValue(5));
		            one(values).getRowCount();
		            will(returnValue(2));
		            one(values).getValue(0, 0);
		            will(returnValue(8));
		            one(values).getValue(1, 0);
		            will(returnValue(3));
		            one(values).getValue(0, 1);
		            will(returnValue(5));
		            one(values).getValue(1, 1);
		            will(returnValue(6));
		            one(values).getValue(0, 2);
		            will(returnValue(1));
		            one(values).getValue(1, 2);
		            will(returnValue(1));
		            one(values).getValue(0, 3);
		            will(returnValue(7));
		            one(values).getValue(1, 3);
		            will(returnValue(3));
		            one(values).getValue(0, 4);
		            will(returnValue(1));
		            one(values).getValue(1, 4);
		            will(returnValue(2));
		        }
		    });
	        assertEquals(DataUtilities.calculateColumnTotal(values, 1), 11, .000000001d);
	    }
		
		/**
		 * This test will attempt to execute the calculateColumnTotal
		 * function at an index just above the maximum boundary, and
		 * hence out of bounds. We will test column index 3.
		 * It should throw an IndexOutOfBoundsException
		 */
		@Test(expected=IndexOutOfBoundsException.class)
	    public void aboveMaxBoundsCalculateColumnTotalTest() {
		    final Values2D values = mocker.mock(Values2D.class);
		    mocker.checking(new Expectations() {
		        {
		            one(values).getColumnCount();
		            will(returnValue(3));
		            one(values).getRowCount();
		            will(returnValue(3));
		            one(values).getValue(0, 0);
		            will(returnValue(8));
		            one(values).getValue(1, 0);
		            will(returnValue(3));
		            one(values).getValue(2, 0);
		            will(returnValue(4));
		            one(values).getValue(0, 1);
		            will(returnValue(5));
		            one(values).getValue(1, 1);
		            will(returnValue(6));
		            one(values).getValue(2, 1);
		            will(returnValue(2));
		            one(values).getValue(0, 2);
		            will(returnValue(1));
		            one(values).getValue(1, 2);
		            will(returnValue(9));
		            one(values).getValue(2, 2);
		            will(returnValue(3));
		            one(values).getValue(0, 3);
		            will(throwException(new IndexOutOfBoundsException()));
		        }
		    });
	        DataUtilities.calculateColumnTotal(values, 3);
	    }
		
		/**
		 * This test will attempt to execute the calculateColumnTotal
		 * function at an index just below the minimum boundary, and
		 * hence out of bounds. We will test column index -1.
		 * It should throw an IndexOutOfBoundsException
		 */
		@Test(expected=IndexOutOfBoundsException.class)
	    public void belowMinBoundsCalculateColumnTotalTest() {
		    final Values2D values = mocker.mock(Values2D.class);
		    mocker.checking(new Expectations() {
		        {
		            one(values).getColumnCount();
		            will(returnValue(3));
		            one(values).getRowCount();
		            will(returnValue(3));
		            one(values).getValue(0, 0);
		            will(returnValue(8));
		            one(values).getValue(1, 0);
		            will(returnValue(3));
		            one(values).getValue(2, 0);
		            will(returnValue(4));
		            one(values).getValue(0, 1);
		            will(returnValue(5));
		            one(values).getValue(1, 1);
		            will(returnValue(6));
		            one(values).getValue(2, 1);
		            will(returnValue(2));
		            one(values).getValue(0, 2);
		            will(returnValue(1));
		            one(values).getValue(1, 2);
		            will(returnValue(9));
		            one(values).getValue(2, 2);
		            will(returnValue(3));
		            one(values).getValue(0, -1);
		            will(throwException(new IndexOutOfBoundsException()));
		        }
		    });
	        DataUtilities.calculateColumnTotal(values, -1);
	    }
		
		/**
		 * This test will attempt to execute the calculateColumnTotal
		 * function with a null value as integer input. It should throw
		 * a NullPointerException
		 */
		@Test(expected=NullPointerException.class)
	    public void nullIntInputCalculateColumnTotalTest() {
		    final Values2D values = mocker.mock(Values2D.class);
		    mocker.checking(new Expectations() {
		        {
		            one(values).getColumnCount();
		            will(returnValue(3));
		            one(values).getRowCount();
		            will(returnValue(3));
		            one(values).getValue(0, 0);
		            will(returnValue(8));
		            one(values).getValue(1, 0);
		            will(returnValue(3));
		            one(values).getValue(2, 0);
		            will(returnValue(4));
		            one(values).getValue(0, 1);
		            will(returnValue(5));
		            one(values).getValue(1, 1);
		            will(returnValue(6));
		            one(values).getValue(2, 1);
		            will(returnValue(2));
		            one(values).getValue(0, 2);
		            will(returnValue(1));
		            one(values).getValue(1, 2);
		            will(returnValue(9));
		            one(values).getValue(2, 2);
		            will(returnValue(3));
		            one(values).getValue(0, -1);
		            will(throwException(new IndexOutOfBoundsException()));
		        }
		    });
		    Integer nullInt = null;
	        DataUtilities.calculateColumnTotal(values, nullInt);
	    }
		
		/**
		 * This test will attempt to execute the calculateColumnTotal
		 * function with a null value as Values2D input. It should throw
		 * an IllegalArgumentException
		 */
		@Test(expected=IllegalArgumentException.class)
	    public void nullValues2DInputCalculateColumnTotalTest() {
		    final Values2D values = null;
	        DataUtilities.calculateColumnTotal(values, 1);
	    }
		
		/**
		 * This test will attempt to execute the calculateColumnTotal
		 * function at an index in the middle of the boundaries,
		 * which is column index 2.
		 * It should sum up the rows of column 2 and obtain the result 2.
		 */
		@Test
	    public void middleOfBoundariesCalculateColumnTotalTest() {
		    final Values2D values = mocker.mock(Values2D.class);
		    mocker.checking(new Expectations() {
		        {
		        	one(values).getColumnCount();
		            will(returnValue(5));
		            one(values).getRowCount();
		            will(returnValue(2));
		            one(values).getValue(0, 0);
		            will(returnValue(8));
		            one(values).getValue(1, 0);
		            will(returnValue(3));
		            one(values).getValue(0, 1);
		            will(returnValue(5));
		            one(values).getValue(1, 1);
		            will(returnValue(6));
		            one(values).getValue(0, 2);
		            will(returnValue(1));
		            one(values).getValue(1, 2);
		            will(returnValue(1));
		            one(values).getValue(0, 3);
		            will(returnValue(7));
		            one(values).getValue(1, 3);
		            will(returnValue(3));
		            one(values).getValue(0, 4);
		            will(returnValue(1));
		            one(values).getValue(1, 4);
		            will(returnValue(2));
		        }
		    });
	        assertEquals(DataUtilities.calculateColumnTotal(values, 2), 2, .000000001d);
	    }
		
		/**
		 * This test will attempt to execute the calculateColumnTotal
		 * in a column with many rows, each containing large integer values.
		 * It should sum up the rows of column 0 and obtain the result 9847.
		 */
		@Test
	    public void lotsOfRowsCalculateColumnTotalTest() {
		    final Values2D values = mocker.mock(Values2D.class);
		    mocker.checking(new Expectations() {
		        {
		        	one(values).getColumnCount();
		            will(returnValue(1));
		            one(values).getRowCount();
		            will(returnValue(10));
		            one(values).getValue(0, 0);
		            will(returnValue(233));
		            one(values).getValue(1, 0);
		            will(returnValue(105));
		            one(values).getValue(2, 0);
		            will(returnValue(95));
		            one(values).getValue(3, 0);
		            will(returnValue(583));
		            one(values).getValue(4, 0);
		            will(returnValue(688));
		            one(values).getValue(5, 0);
		            will(returnValue(309));
		            one(values).getValue(6, 0);
		            will(returnValue(688));
		            one(values).getValue(7, 0);
		            will(returnValue(1600));
		            one(values).getValue(8, 0);
		            will(returnValue(1234));
		            one(values).getValue(9, 0);
		            will(returnValue(4312));
		        }
		    });
	        assertEquals(DataUtilities.calculateColumnTotal(values, 0), 9847, .000000001d);
	    }
		
		/**
		 * This test will attempt to execute the calculateColumnTotal
		 * in a column with many rows, each containing large integer values,
		 * that can be either positive or negative.
		 * It should sum up the rows of column 0 and obtain the result -1785.
		 */
		@Test
	    public void negativeValuesCalculateColumnTotalTest() {
		    final Values2D values = mocker.mock(Values2D.class);
		    mocker.checking(new Expectations() {
		        {
		        	one(values).getColumnCount();
		            will(returnValue(1));
		            one(values).getRowCount();
		            will(returnValue(10));
		            one(values).getValue(0, 0);
		            will(returnValue(-233));
		            one(values).getValue(1, 0);
		            will(returnValue(105));
		            one(values).getValue(2, 0);
		            will(returnValue(95));
		            one(values).getValue(3, 0);
		            will(returnValue(-583));
		            one(values).getValue(4, 0);
		            will(returnValue(688));
		            one(values).getValue(5, 0);
		            will(returnValue(309));
		            one(values).getValue(6, 0);
		            will(returnValue(-688));
		            one(values).getValue(7, 0);
		            will(returnValue(1600));
		            one(values).getValue(8, 0);
		            will(returnValue(1234));
		            one(values).getValue(9, 0);
		            will(returnValue(-4312));
		        }
		    });
	        assertEquals(DataUtilities.calculateColumnTotal(values, 0), -1785, .000000001d);
	    }
	@Test
	public void nNumberArrayIsCreatedCreateNumArrayTest() {
		double data[] = {0.0, -1.0, 23.0, -34.9, 52.1};
		Double expected[] = {0.0, -1.0, 23.0, -34.9, 52.1};
		Number result[];
		result = DataUtilities.createNumberArray(data);
		assertArrayEquals("An array of Double is returned", expected, result);
	}
	
	/**
	 * Under Test: createNumberArray( double[] data )
	 * 
	 * Test Case: Empty double[] is passed as argument.
	 * 
	 * Expected: returns an empty Double[].
	 */
	@Test
	public void arrayIsEmptyCreateNumArrayTest() {
		double data[] = {};
		Double expected[] = {};
		Number result[] = DataUtilities.createNumberArray(data);
		assertArrayEquals("An empty Double array is returned", expected, result);
	}
	
	/**
	 * Under Test: createNumberArray( double[] data )
	 * 
	 * Test Case: null parameter.
	 * 
	 * Expected: IllegalArgumentException is thrown.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void illegalArgumentExceptionCreateNumArrayTest() {
		 
		Number[] result = DataUtilities.createNumberArray(null);
		
	}

	/**
	 * Under Test: createNumberArray2D( double[][] data )
	 * 
	 * Test Case: valid double[][] is passed as argument.
	 * 
	 * Expected: returns 2D array of type Double.
	 */
	@Test
	public void numberArray2DIsCreatedCreateNumArray2DTest() {
		double data[][] = {{78.3333, 44.09, -23.00, 9.2, -1.0},
				{101.1, 98.0000000, -45.7, -12.999999, 3.0}, 
				{54.00, 8546.3, -495.54554, 99886.44, -0.234234},
				{745874.0, -2342.0000, -4334.0, 88543.0998, 34.2}};
		Double expected[][] = {{78.3333, 44.09, -23.00, 9.2, -1.0},
				{101.1, 98.0000000, -45.7, -12.999999, 3.0}, 
				{54.00, 8546.3, -495.54554, 99886.44, -0.234234},
				{745874.0, -2342.0000, -4334.0, 88543.0998, 34.2}};
		Number result[][] = DataUtilities.createNumberArray2D(data);
		for(int i = 0; i < 4; i++) {
			assertArrayEquals(expected[i], result[i]);
		}
	}
	
	/**
	 * Under Test: createNumberArray2D( double[][] data )
	 * 
	 * Test Case: Empty double[][] passed as argument.
	 * 
	 * Expected: returns an empty Double[][].
	 */
	@Test
	public void emptyArrayAsInputCreateNumArray2DTest() {
		double data[][] = {{},{},{},{}};
		Double expected[][] = {{},{},{},{}};
		Number result[][] = DataUtilities.createNumberArray2D(data);
		
		for(int i = 0; i < 4; i++) {
			assertArrayEquals(expected, result);
		}
	}
	
	/**
	 * Under Test: createNumberArray2D( double[][] data )
	 * 
	 * Test Case: passing a double[][] with a empty double[] element.
	 * 
	 * Expected: returns a exact 2D array of type Double.
	 */
	@Test
	public void emptyArrayElementCreateNumArray2DTest() {
		double data[][] = {{78.3333, 44.09, -23.00, 9.2, -1.0},
				{}, 
				{54.00, 8546.3, -495.54554, 99886.44, -0.234234},
				{745874.0, -2342.0000, -4334.0, 88543.0998, 34.2}};
		Double expected[][] = {{78.3333, 44.09, -23.00, 9.2, -1.0},
				{}, 
				{54.00, 8546.3, -495.54554, 99886.44, -0.234234},
				{745874.0, -2342.0000, -4334.0, 88543.0998, 34.2}};
		Number result[][] = DataUtilities.createNumberArray2D(data);
		for(int i = 0; i < 4; i++) {
			assertArrayEquals(expected[i], result[i]);
		}
	}
	
	/**
	 * Under Test: createNumberArray2D( double[][] data )
	 * 
	 * Test Case: null parameter.
	 * 
	 * Expected: IllegalArgumentException is thrown.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void illegalArgumentExceptionNullArrayCreateNumArray2DTest() {
		
		Number [][] result = DataUtilities.createNumberArray2D(null);
	}
	
	/**
	 * Under Test: createNumberArray2D( double[][] data )
	 * 
	 * Test Case: passing a double[][] is a null double[] element.
	 * 
	 * Expected: IllegalArgumentException is thrown.
	 */
	@Test (expected = IllegalArgumentException.class)
	public void illegalArgumentExceptionNullElementCreateNumArray2DTest() {
		double data[][] = {{78.3333, 44.09, -23.00, 9.2, -1.0},
				null, 
				{54.00, 8546.3, -495.54554, 99886.44, -0.234234},
				{745874.0, -2342.0000, -4334.0, 88543.0998, 34.2}};
		Number result[][] = DataUtilities.createNumberArray2D(data);
	}
	
	
	

	/**
	 * Under Test: getCumulativePercentages(KeyedValues values)
	 * 
	 * Test Case: null keys in values parameter.
	 * 
	 * Expected: IllegalArgumentException is thrown.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void nullKeysCalculateCumulativePercentageTest() {
		mockingContext.checking(new Expectations() {
			{
				one(values).getKey(0);
				will(returnValue(null));
				one(values).getKey(1);
				will(returnValue(null));
				one(values).getKey(2);
				will(returnValue(null));
				atLeast(1).of(values).getValue(0);
				will(returnValue(5));
				atLeast(1).of(values).getValue(1);
				will(returnValue(10));
				atLeast(1).of(values).getValue(2);
				will(returnValue(15));

				atLeast(1).of(values).getItemCount();
				will(returnValue(3));

			}
		});

		KeyedValues result = DataUtilities.getCumulativePercentages(values);

	}
	
	/**
	 * Under Test: getCumulativePercentages(KeyedValues values)
	 * 
	 * Test Case: null object values parameter.
	 * 
	 * Expected: IllegalArgumentException is thrown.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void percentageNullCalculateCumulativePercentageTest() {

		KeyedValues result = DataUtilities.getCumulativePercentages(null);

	}
	/**
	 * Under Test: getCumulativePercentages(KeyedValues values)
	 * 
	 * Test Case: three key-values pairs for the values parameter.
	 * 
	 * Expected: IllegalArgumentException is thrown.
	 */
	@Test
	public void threeValuesCalculateCumulativePercentageTest() {
		// setup

		mockingContext.checking(new Expectations() {
			{
				one(values).getKey(0);
				will(returnValue(0));
				one(values).getKey(1);
				will(returnValue(1));
				one(values).getKey(2);
				will(returnValue(2));
				atLeast(1).of(values).getValue(0);
				will(returnValue(5));
				atLeast(1).of(values).getValue(1);
				will(returnValue(10));
				atLeast(1).of(values).getValue(2);
				will(returnValue(15));

				atLeast(1).of(values).getItemCount();
				will(returnValue(3));

			}
		});
		KeyedValues result = DataUtilities.getCumulativePercentages(values);

		assertEquals(0.1666666666666667, (double) result.getValue(0),  .000000001d);
		assertEquals( 0.5,(double) result.getValue(1), .000000001d);
		assertEquals(1.0,(double) result.getValue(2),  .000000001d);

		// tear-down: NONE in this test method
	}
	/**
	 * Under Test: getCumulativePercentages(KeyedValues values)
	 * 
	 * Test Case: 0 values for the values parameter.
	 * 
	 * Expected: All values are NaN
	 */
	@Test
	public void percentageZeroCalculateCumulativePercentageTest() {
		// setup

		mockingContext.checking(new Expectations() {
			{
				one(values).getKey(0);
				will(returnValue(0));
				one(values).getKey(1);
				will(returnValue(1));
				one(values).getKey(2);
				will(returnValue(2));
				atLeast(1).of(values).getValue(0);
				will(returnValue(0));
				atLeast(1).of(values).getValue(1);
				will(returnValue(0));
				atLeast(1).of(values).getValue(2);
				will(returnValue(0));

				atLeast(1).of(values).getItemCount();
				will(returnValue(3));

			}
		});
		KeyedValues result = DataUtilities.getCumulativePercentages(values);
		assertTrue(Double.isNaN(result.getValue(0).doubleValue()));
		assertTrue(Double.isNaN(result.getValue(1).doubleValue()));
		assertTrue(Double.isNaN(result.getValue(2).doubleValue()));
		

		// tear-down: NONE in this test method
	}
	/**
	 * Under Test: getCumulativePercentages(KeyedValues values)
	 * 
	 * Test Case: negative values for the values parameter.
	 * 
	 * Expected: All values are doubles 
	 */
	@Test
	public void percentageNegativesCalculateCumulativePercentageTest() {
		// setup

		mockingContext.checking(new Expectations() {
			{
				one(values).getKey(0);
				will(returnValue(0));
				one(values).getKey(1);
				will(returnValue(1));
				one(values).getKey(2);
				will(returnValue(2));
				atLeast(1).of(values).getValue(0);
				will(returnValue(-5));
				atLeast(1).of(values).getValue(1);
				will(returnValue(-15));
				atLeast(1).of(values).getValue(2);
				will(returnValue(10));

				atLeast(1).of(values).getItemCount();
				will(returnValue(3));

			}
		});
		KeyedValues result = DataUtilities.getCumulativePercentages(values);
		assertEquals(0.5, (double) result.getValue(0),  .000000001d);
		assertEquals( 2,(double) result.getValue(1), .000000001d);
		assertEquals(1.0,(double) result.getValue(2),  .000000001d);
		

		// tear-down: NONE in this test method
	}
	
	
	/**
	 * Under Test: getCumulativePercentages(KeyedValues values)
	 * 
	 * Test Case: seven key-values pairs for the values parameter.
	 * 
	 * Expected: All values are doubles 
	 */
	@Test
	public void bigDictionaryCalculateCumulativePercentageTest() {
		// setup

		mockingContext.checking(new Expectations() {
			{
				one(values).getKey(0);
				will(returnValue(0));
				one(values).getKey(1);
				will(returnValue(1));
				one(values).getKey(2);
				will(returnValue(2));
				one(values).getKey(3);
				will(returnValue(3));
				one(values).getKey(4);
				will(returnValue(4));
				one(values).getKey(5);
				will(returnValue(5));
				one(values).getKey(6);
				will(returnValue(6));
				
				atLeast(1).of(values).getValue(0);
				will(returnValue(5));
				atLeast(1).of(values).getValue(1);
				will(returnValue(10));
				atLeast(1).of(values).getValue(2);
				will(returnValue(15));
				atLeast(1).of(values).getValue(3);
				will(returnValue(5));
				atLeast(1).of(values).getValue(4);
				will(returnValue(10));
				atLeast(1).of(values).getValue(5);
				will(returnValue(15));
				atLeast(1).of(values).getValue(6);
				will(returnValue(20));

				atLeast(1).of(values).getItemCount();
				will(returnValue(7));

			}
		});
		KeyedValues result = DataUtilities.getCumulativePercentages(values);
		assertEquals(result.getItemCount(),7);
		assertEquals( (double) result.getValue(0),0.0625, .000000001d);
		assertEquals((double) result.getValue(1), 0.1875, .000000001d);
		assertEquals((double) result.getValue(2), 0.375, .000000001d);
		assertEquals((double) result.getValue(3), 0.4375, .000000001d);
		assertEquals((double) result.getValue(4), 0.5625, .000000001d);
		assertEquals((double) result.getValue(5), 0.75, .000000001d);
		assertEquals((double) result.getValue(6), 1.0, .000000001d);
		

		
	}
	
	@After
	public void TearDown() {
		mockingContext=null;
		mocker=null;
		values=null;
	}
}

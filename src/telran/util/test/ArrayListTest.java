package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

//import java.util.ArrayList;
//import telran.util.ArrayList;
import telran.util.*;

import org.junit.jupiter.api.Test;
//import org.junit.vintage.engine.descriptor.RunnerTestDescriptor;

class ArrayListTest {
	List<Integer> list; // list telran.util
	Integer[] numbers = { 10, -20, 7, 50, 100, 30 };

	@BeforeEach
	void setUp() { // method create list numbers arraylist
		list = new ArrayList<>(1); // list = create empty list
		for (int i = 0; i < numbers.length; i++) {
			list.add(numbers[i]); // list contains reference to number

		}

	}

	@Test
	void testAdd() {

		assertTrue(list.add(numbers[0]));
		assertEquals(numbers.length + 1, list.size());

	}

	@Test
	void testAddIndex() {

		Integer[] expected0_500 = { 500, 10, -20, 7, 50, 100, 30 };
		Integer[] expected0_500_3_700 = { 500, 10, -20, 700, 7, 50, 100, 30 };
		Integer[] expected0_500_3_700_8_300 = { 500, 10, -20, 700, 7, 50, 100, 30, 300 };
		list.add(0, 500);
		runTest(expected0_500);
		list.add(3, 700);
		runTest(expected0_500_3_700);
		list.add(8, 300);
		runTest(expected0_500_3_700_8_300);

	}

	@Test
	void testRemoveIndex() {
		Integer[] expectedNo10 = { -20, 7, 50, 100, 30 };
		Integer[] expectedNo10_50 = { -20, 7, 100, 30 };
		Integer[] expectedNo10_50_30 = { -20, 7, 100 };
		assertEquals(10, list.remove(0));
		runTest(expectedNo10);
		assertEquals(50, list.remove(2));
		runTest(expectedNo10_50);
		assertEquals(30, list.remove(3));
		runTest(expectedNo10_50_30);
	}

	@Test
	void testGetIndex() {
		assertEquals(10, list.get(0));
		
	}

	@Test
	void testIndexOf() {
		list.add(3,10);
		assertEquals(0,list.indexOf(10));
		assertEquals(-1, list.indexOf(null));
	}
	@Test
	private void runTest(Integer[] expected) {
		int size = list.size();
		Integer[] actual = new Integer[expected.length];
		for (int i = 0; i < size; i++) {
			actual[i] = list.get(i);
		}
		assertArrayEquals(expected, actual);

	}

//	void printArrayList(ArrayList<Integer> arr) {
//		for (int i = 0; i < arr.size(); i++) {
//			System.out.print(arr.get(i));
//		}
//		System.out.println("");
//	}
//*****************************************************************

}

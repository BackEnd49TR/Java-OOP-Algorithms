package telran.util.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//import java.util.ArrayList;
//import telran.util.ArrayList;
import telran.util.*;

import org.junit.jupiter.api.Test;

class ArrayListTest {

	@Test
	void testAdd() {
		ArrayList<Integer> numbers = new ArrayList<>();
		ArrayList<String> strings = new ArrayList<>();
		numbers.add(5);
		numbers.add(10);
		strings.add("ABC");
		assertEquals(2, numbers.size());
		assertEquals(1, strings.size());
	}

	@Test
	void testAddIndex() {

		ArrayList<Integer> object = new ArrayList<>();

		for (int i = 11; i <= 20; i++) {
			object.add(i);
		}
		assertEquals(10, object.size());

		object.add(0, 1);
		assertEquals(11, object.size());

		object.add(5, 2);
		assertEquals(12, object.size());

		object.add(10, 3);
		assertEquals(13, object.size());

		assertEquals(1, object.get(0));
		assertEquals(11, object.get(1));

		assertEquals(2, object.get(5));
		assertEquals(15, object.get(6));

		assertEquals(3, object.get(10));
		assertEquals(19, object.get(11));

	}

	@Test
	void testRemoveIndex() {
		ArrayList<Integer> object = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			object.add(i);
			
		}
		assertEquals(10,object.size());
		
		object.remove(0);
		object.remove(5);
		object.remove(9);
		assertEquals(1, object.get(0));
		assertEquals(7, object.get(5));
		assertEquals(9, object.get(7));
		assertEquals(7,object.size());

	}
// *******************  Test RemoveIdex corrected VR ***********	
	@Test
	void testRemove() {
		ArrayList<Integer> numbers = new ArrayList<>();
		for(int i=0; i<10; i++) {
			numbers.add(i);
		}
		printArrayList(numbers);
		int removed1 = numbers.remove(9);
		printArrayList(numbers);
		int removed2 = numbers.remove(5);
		printArrayList(numbers);
		int removed3 = numbers.remove(0);
		printArrayList(numbers);
		assertEquals(7, numbers.size());
		assertEquals(9, removed1);
		assertEquals(5, removed2);
		assertEquals(0, removed3);
	}
	void printArrayList(ArrayList<Integer> arr) {
		for(int i=0; i<arr.size(); i++) {
			System.out.print(arr.get(i));
		}
		System.out.println("");
	}
//*****************************************************************

}

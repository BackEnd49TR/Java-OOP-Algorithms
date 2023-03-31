package telran.util.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//import java.util.ArrayList;
import telran.util.ArrayList;

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

//????????????????????????
//		object.add(66);
//		object.add(88);
//		object.add(99);
//		object.add(55);
//????????????????????????

		object.add(0, 1);
		object.add(77);
		object.add(4, 2);
		object.add(9, 3);
		assertEquals(4, object.size());
		assertEquals(1, object.get(0));
		assertEquals(2, object.get(4));
		assertEquals(3, object.get(9));

	}

	@Test
	void testRemoveIndex() {
		ArrayList<Integer> object = new ArrayList<>();
		object.add(10);
		object.add(20);
		object.add(30);
		object.add(40);
		object.add(50);
		object.add(60);
		object.remove(0);
		object.remove(2);
		object.remove(3);
		assertEquals(20, object.get(0));
		assertEquals(50, object.get(2));
		assertEquals(null, object.get(3));

	}

}

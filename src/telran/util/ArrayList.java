package telran.util;

import java.util.Arrays;

public class ArrayList<T> implements List<T> {
	private static final int DEFAULT_CAPACITY = 16;
	private T[] array;
	private int size;

	@SuppressWarnings("unchecked")
	public ArrayList(int capacity) {
		array = (T[]) new Object[capacity];
	}

	public ArrayList() {
		this(DEFAULT_CAPACITY);
	}

	@Override
	public boolean add(T obj) {
		if (size == array.length) {
			reallocate();
		}
		array[size] = obj;
		size++;

		return true;
	}

	private void reallocate() {
		array = Arrays.copyOf(array, array.length * 2);
	}

	@Override
	public void add(int index, T obj) {

		if (size == array.length) {
			reallocate();
		}
		System.arraycopy(array, index, array, index + 1, size - index);
		array[index] = obj;
		size++;
	}

	@Override
	public T remove(int index) {

//		this is OK

//		T removeRef = array[index];
//		int quantityElementsCopies = size - (index - 1);
//		System.arraycopy(array, index + 1, array, index, quantityElementsCopies);
//		size--;
// ************* corrected YG********

		T removeRef = array[index];
		size--;
		System.arraycopy(array, index + 1, array, index, size - index);

//***********************************

		return removeRef;
	}

	@Override
	public T get(int index) {
// array[index] => this is also reference
		T arrRef = array[index];
		return arrRef;
	}

	@Override
	public int size() {

		return size;
	}

	@Override
	public boolean remove(T pattern) {
//		boolean res = false;
//		int index = 0;
//		for (; index < array.length; index++) {
//			if (isEqual(array[index], pattern)) {
//				System.arraycopy(array, index + 1, array, index, size - index);
//				size--;
//				res = true;
//			}
//		}
//
//		return res;

//*********************  V.R. *************

		int index = indexOf(pattern);
		if (index >= 0) {
			remove(index);
		}
		return index < 0 ? false : true;
//****************************************
	}

//****************  V.R. *****************	
	@Override
	public Object[] toArray() {
		return Arrays.copyOf(array, size);
	}

	@Override
	public T[] toArray(T[] buffer) {
		T[] res = buffer;
		if (buffer.length < size) {
			res = (T[]) Arrays.copyOf(array, size, buffer.getClass());
		} else {
			System.arraycopy(array, 0, res, 0, size);
			if (res.length > size) {
				res[size] = null;
			}
		}
		return res;
	}

//	@Override
//	public T[] toArray(T[] buffer) {
//		T[] res = buffer;
//		if(buffer.length < size) {
//			res =  (T[])new Object[size];
//		} 
//		System.arraycopy(array, 0, res, 0, size );
//		if(res.length > size) {
//			res[size] = null;
//		}
//		return res;
//	}

//*******************************************

	@Override
	public int indexOf(T pattern) {
		int res = -1;
		int index = 0;
		while (index < size && res == -1) {
			if (isEqual(array[index], pattern)) {
				res = index;
			}
			index++;
		}
		return res;
	}

	@Override
	public int lastIndexOf(T pattern) {
		int res = -1;
		int index = size - 1;
		while (index >= 0 && res == -1) {
			if (isEqual(array[index], pattern)) {
				res = index;
			}
			index--;
		}
		return res;
	}

	private boolean isEqual(T object, T pattern) {

		return pattern == null ? object == pattern : pattern.equals(object);
	}

}

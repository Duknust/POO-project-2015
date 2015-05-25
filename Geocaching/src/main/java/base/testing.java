package base;

import java.util.ArrayList;

public class testing {
	public static void main(String[] args) {
		Utilities s = new Utilities();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		arr.add(1);
		arr.add(20);
		arr.add(18);
		arr.add(16);
		arr.add(21);
		arr.add(37);
		arr.add(55);
		arr.add(43);
		arr.add(6);
		arr.add(7);
		arr.add(20);
		arr.add(41);

		s.graphic2D(arr);
	}
}

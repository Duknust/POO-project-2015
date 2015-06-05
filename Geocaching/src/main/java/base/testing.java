package base;

import meteo.Meteo;

public class testing {
	public static void main(String[] args) {

		System.out.println(staticMeteo(1));
		System.out.println(staticMeteo(30));
		System.out.println(staticMeteo(200));
		/*
		 * Data data = new Data(); Statistics s = new Statistics(data);
		 * ArrayList<Integer> arr = new ArrayList<Integer>(); arr.add(1);
		 * arr.add(2); arr.add(1); arr.add(1); arr.add(2); arr.add(3);
		 * arr.add(5); arr.add(4); arr.add(6); arr.add(7); arr.add(2);
		 * arr.add(4);
		 * 
		 * ArrayList<String> arr2 = new ArrayList<String>(); arr2.add("J");
		 * arr2.add("F"); arr2.add("M"); arr2.add("A"); arr2.add("M");
		 * arr2.add("J"); arr2.add("J"); arr2.add("A"); arr2.add("S");
		 * arr2.add("O"); arr2.add("N"); arr2.add("D");
		 * 
		 * s.graphic2D(arr, arr2, 12, 10, "n trabalhadores", "n bolotas", true);
		 */
	}

	public static Meteo staticMeteo(int value) {
		float temperature = (float) (-5.41417f - 1.03914f * value + 0.0193654f
				* Math.pow(value, 2) - 0.0000905978f * Math.pow(value, 3) + 1.24375f
				* Math.pow(10, -7) * Math.pow(value, 4));
		float rainProbability = temperature < 12 ? 0.5f : 0.1f;

		return new Meteo(temperature, rainProbability);
	}
}

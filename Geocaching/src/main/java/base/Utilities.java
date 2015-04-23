package base;

import java.util.Random;

public class Utilities {

	public static float getValueToDifficulty() {
		Random randomno = new Random();
		float fstNumb = Math.abs(randomno.nextInt() % 5) + 1;
		float result = randomno.nextFloat() >= 0.5f && fstNumb < 5 ? fstNumb + 0.5f
				: fstNumb;

		return result;
	}
}

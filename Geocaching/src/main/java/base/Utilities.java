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

	public static String fromNameToEmail(String name, String emailDomain) {
		StringBuilder sb = new StringBuilder();
		String[] pieces = name.split(" ");
		for (String s : pieces) {
			sb.append(s.toLowerCase());
		}
		sb.append("@");
		sb.append(emailDomain);
		return sb.toString();
	}

	public static String firstLetterCapital(String continent) {
		String res = "";
		if (continent != null && continent.length() > 0) {
			res = Character.toUpperCase(continent.charAt(0)) + "";
			res = res + continent.substring(1, continent.length());
		}
		return res;
	}
}

package base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;

import caches.Cache;

public class Statistics implements Serializable {

	private static final long serialVersionUID = 1L;
	int numberCachesLastMonth = 0;
	int numberCachesLastYear = 0;

	public Statistics(Statistics e) {
		this.numberCachesLastMonth = e.getNumberCachesLastMonth();
		this.numberCachesLastYear = e.getNumberCachesLastYear();
	}

	public Statistics() {
	}

	@Override
	public Statistics clone() {
		return new Statistics(this);
	}

	public int getNumberCachesLastMonth() {
		return numberCachesLastMonth;
	}

	public void setNumberCachesLastMonth(int numberCachesLastMonth) {
		this.numberCachesLastMonth = numberCachesLastMonth;
	}

	public int getNumberCachesLastYear() {
		return numberCachesLastYear;
	}

	public void setNumberCachesLastYear(int numberCachesLastYear) {
		this.numberCachesLastYear = numberCachesLastYear;
	}

	public void graphiCacheCreationByYear(Data data) {
		graphic2D(getValuesForStatisticsInYears(data.getAllCaches()), null, 50,
				100, "", "", false);
	}

	public void graphiCacheCreationByMonth(Data data) {
		graphic2D(getValuesForStatisticsInMonths(data.getAllCaches()), null,
				12, 100, "", "", false);
	}

	public void graphiCacheCreationByDay(Data data) {
		graphic2D(getValuesForStatisticsInDays(data.getAllCaches()), null, 31,
				100, "", "", false);
	}

	public void graphic2D(ArrayList<Integer> points, ArrayList<String> listX,
			int columns, int limit, String xcaption, String ycaption,
			boolean graph) {
		int i, j;
		String matrix[][] = new String[10][columns];
		int maximum = 0;
		StringBuilder sb = null;

		// init matrix
		for (i = 0; i < 10; i++)
			for (j = 0; j < columns; j++)
				matrix[i][j] = "     ";

		// find maximum
		for (Integer numb : points) {
			if (numb > maximum)
				maximum = numb;
		}

		for (i = 0; i < columns; i++) {
			if (!graph) {
				if (points.get(i) == maximum) {
					matrix[8 - (points.get(i) / (limit / 10)) + 1][i] = "  x  ";
				} else {
					matrix[8 - (points.get(i) / (limit / 10)) + 1][i] = "  .  ";
				}
			} else {
				matrix[8 - (points.get(i) / (limit / 10)) + 1][i] = "  #  ";
			}

		}

		if (graph) {
			for (j = 0; j < columns; j++) {
				boolean swit = false;
				for (i = 0; i < 10; i++) {
					if (matrix[i][j].equals("  #  "))
						swit = true;
					if (swit) {
						matrix[i][j] = "  #  ";
					}
				}
			}
		}

		System.out.println("used scale 1:10");
		if (!graph) {
			System.out.println("[x] maximum value (" + maximum + ")");
			System.out.println("[.] other values\n");
		}
		// System.out.println(" - - - - - - - - - - - - - - - - - - - - ");
		for (i = 0; i < 10; i++) {
			sb = new StringBuilder();
			// sb.append((9 - i) * 10 + "\t" + "|");
			sb.append("| ");
			for (j = 0; j < columns; j++) {
				sb.append(matrix[i][j]);
			}
			sb.append("  | " + limit / 10 * (10 - i));
			if (i == 0 && ycaption != null && !ycaption.isEmpty()) {
				sb.append("  y: " + ycaption);
			}
			System.out.println(sb.toString());
		}
		// System.out.println(" - - - - - - - - - - - - - - - - - - - - ");

		if (listX != null && !listX.isEmpty()) {
			sb = new StringBuilder();
			sb.append("  ");
			for (i = 0; i < columns; i++) {
				String tmp = listX.get(i) + "";
				if (tmp.length() == 1) {
					tmp = "  " + tmp + "  ";
				} else if (tmp.length() == 2) {
					tmp = "  " + tmp + " ";
				} else if (tmp.length() == 3) {
					tmp = " " + tmp + " ";
				} else if (tmp.length() == 4) {
					tmp = " " + tmp;
				} else {
					tmp = tmp.substring(0, 5);
				}
				sb.append(tmp);
			}
			System.out.println(sb.toString());
		}

		if (xcaption != null && !xcaption.isEmpty()) {
			System.out.println("x: " + xcaption);
		}
	}

	public ArrayList<Integer> getValuesForStatisticsInMonths(
			HashMap<String, Cache> caches) {
		ArrayList<Integer> months = new ArrayList<Integer>();
		for (int i = 0; i < 12; i++) {
			months.add(i, 0);
		}

		for (Cache c : caches.values()) {
			int actualValue = c.getCreationDate().get(GregorianCalendar.MONTH);
			months.add(c.getCreationDate().get(GregorianCalendar.MONTH),
					actualValue + 1);
		}

		return months;
	}

	public ArrayList<Integer> getValuesForStatisticsInDays(
			HashMap<String, Cache> caches) {
		ArrayList<Integer> days = new ArrayList<Integer>();
		for (int i = 0; i < 31; i++) {
			days.add(i, 0);
		}

		for (Cache c : caches.values()) {
			int actualValue = c.getCreationDate().get(
					GregorianCalendar.DAY_OF_MONTH);
			days.add(c.getCreationDate().get(GregorianCalendar.DAY_OF_MONTH),
					actualValue + 1);
		}

		return days;
	}

	// only last 50 years
	public ArrayList<Integer> getValuesForStatisticsInYears(
			HashMap<String, Cache> caches) {
		ArrayList<Integer> years = new ArrayList<Integer>();
		for (int i = 0; i < 50; i++) {
			years.add(i, 0);
		}

		int last50years = new GregorianCalendar().get(GregorianCalendar.YEAR) - 50;

		for (Cache c : caches.values()) {
			int actualValue = c.getCreationDate().get(GregorianCalendar.YEAR);
			years.add(c.getCreationDate().get(GregorianCalendar.YEAR)
					- last50years, actualValue + 1);
		}

		return years;
	}
}

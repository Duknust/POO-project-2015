package base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.SortedSet;
import java.util.TreeSet;

import user.User;
import user.UserAbstract;
import user.UserAbstract.Role;
import caches.Cache;
import caches.Log;

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

	public TreeSet<ToTop> topTenCacheFinders(HashMap<String, UserAbstract> users) {
		TreeSet<ToTop> top = new TreeSet<ToTop>();
		for (UserAbstract user : users.values()) {
			if (user.getRole() == Role.USER) {
				ToTop toTop = new ToTop(user.getTotalFound(), user.getName());
				top.add(toTop);
			}
		}
		return top;
	}

	public TreeSet<ToTop> topTenCacheCreators(HashMap<String, Cache> caches) {
		TreeSet<ToTop> top = new TreeSet<ToTop>();
		HashMap<String, Integer> usersCount = new HashMap<String, Integer>();
		for (Cache cache : caches.values()) {
			String name = cache.getOwner().getName();
			if (usersCount.containsKey(name)) {
				usersCount.put(name, usersCount.get(name) + 1);
			} else {
				usersCount.put(name, 1);
			}
		}
		for (String s : usersCount.keySet()) {
			ToTop toTop = new ToTop(usersCount.get(s), s);
			top.add(toTop);
		}
		return top;
	}

	public void monthStatistics(Data data, User user,
			GregorianCalendar dateFinnish, boolean withGraph) {
		GregorianCalendar dateInit;
		if (dateFinnish.get(GregorianCalendar.MONTH) == 0) {
			dateInit = new GregorianCalendar(
					dateFinnish.get(GregorianCalendar.YEAR) - 1, 11,
					dateFinnish.get(GregorianCalendar.DAY_OF_MONTH));
		} else {
			dateInit = new GregorianCalendar(
					dateFinnish.get(GregorianCalendar.YEAR),
					dateFinnish.get(GregorianCalendar.MONTH) - 1,
					dateFinnish.get(GregorianCalendar.DAY_OF_MONTH));
		}

		int max = -1;

		ArrayList<Cache> cachesCreatedInDate = new ArrayList<Cache>();

		for (Cache c : user.getCaches().values()) {
			if (c.getCreationDate().before(dateFinnish)
					&& c.getCreationDate().after(dateInit)) {
				cachesCreatedInDate.add(c);
			}
		}

		SortedSet<Cache> ss = data.getCachesFoundFrom(user);
		ArrayList<Cache> cachesFoundInDate = new ArrayList<Cache>();
		for (Cache c : ss) {
			TreeSet<Log> ts = c.getLogs(user);
			for (Log log : ts) {
				if (log.getDate().before(dateFinnish)
						&& log.getDate().after(dateInit))
					cachesFoundInDate.add(c);
			}
		}

		System.out.println(user.getName() + " created "
				+ cachesCreatedInDate.size() + " in last year");

		for (Cache c : cachesCreatedInDate) {
			System.out.println(c.toSimpleListing());
		}

		if (withGraph) {
			ArrayList<Integer> points = new ArrayList<Integer>();
			ArrayList<String> days = new ArrayList<String>();
			days.add("1");
			days.add("2");
			days.add("3");
			days.add("4");
			days.add("5");
			days.add("6");
			days.add("7");
			days.add("8");
			days.add("9");
			days.add("10");
			days.add("11");
			days.add("12");
			days.add("13");
			days.add("14");
			days.add("15");
			days.add("16");
			days.add("17");
			days.add("18");
			days.add("19");
			days.add("20");
			days.add("21");
			days.add("22");
			days.add("23");
			days.add("24");
			days.add("25");
			days.add("26");
			days.add("27");
			days.add("28");
			days.add("29");
			days.add("30");
			days.add("31");
			for (int i = 0; i < 31; i++) {
				points.add(0);
			}

			for (Cache c : cachesCreatedInDate) {
				int toSum = points.get(c.getCreationDate().get(
						GregorianCalendar.MONTH));
				points.add(c.getCreationDate().get(GregorianCalendar.MONTH),
						toSum + 1);
			}
			for (int x : points) {
				if (x > max)
					max = x;
			}
			graphic2D(points, days, 31, max, "months", "created couchs", true);

		}
		System.out.println(user.getName() + " found "
				+ cachesFoundInDate.size() + " in last month");

		for (Cache c : cachesFoundInDate) {
			System.out.println(c.toSimpleListing());
		}

		if (withGraph) {
			ArrayList<Integer> points = new ArrayList<Integer>();
			ArrayList<String> days = new ArrayList<String>();
			days.add("1");
			days.add("2");
			days.add("3");
			days.add("4");
			days.add("5");
			days.add("6");
			days.add("7");
			days.add("8");
			days.add("9");
			days.add("10");
			days.add("11");
			days.add("12");
			days.add("13");
			days.add("14");
			days.add("15");
			days.add("16");
			days.add("17");
			days.add("18");
			days.add("19");
			days.add("20");
			days.add("21");
			days.add("22");
			days.add("23");
			days.add("24");
			days.add("25");
			days.add("26");
			days.add("27");
			days.add("28");
			days.add("29");
			days.add("30");
			days.add("31");
			for (int i = 0; i < 31; i++) {
				points.add(0);
			}

			for (Cache c : cachesFoundInDate) {
				int toSum = points.get(c.getCreationDate().get(
						GregorianCalendar.MONTH));
				points.add(c.getCreationDate().get(GregorianCalendar.MONTH),
						toSum + 1);
			}
			for (int x : points) {
				if (x > max)
					max = x;
			}
			graphic2D(points, days, 31, max, "days", "found caches", true);

		}

	}

	public void yearStatistics(Data data, User user,
			GregorianCalendar dateFinnish, boolean withGraph) {
		GregorianCalendar dateInit = new GregorianCalendar(
				dateFinnish.get(GregorianCalendar.YEAR) - 1,
				dateFinnish.get(GregorianCalendar.MONTH),
				dateFinnish.get(GregorianCalendar.DAY_OF_MONTH));

		int max = -1;

		ArrayList<Cache> cachesCreatedInDate = new ArrayList<Cache>();

		for (Cache c : user.getCaches().values()) {
			if (c.getCreationDate().before(dateFinnish)
					&& c.getCreationDate().after(dateInit)) {
				cachesCreatedInDate.add(c);
			}
		}

		SortedSet<Cache> ss = data.getCachesFoundFrom(user);
		ArrayList<Cache> cachesFoundInDate = new ArrayList<Cache>();
		for (Cache c : ss) {
			TreeSet<Log> ts = c.getLogs(user);
			for (Log log : ts) {
				if (log.getDate().before(dateFinnish)
						&& log.getDate().after(dateInit))
					cachesFoundInDate.add(c);
			}
		}

		System.out.println(user.getName() + " created "
				+ cachesCreatedInDate.size() + " in last month");

		for (Cache c : cachesCreatedInDate) {
			System.out.println(c.toSimpleListing());
		}

		if (withGraph) {
			ArrayList<Integer> points = new ArrayList<Integer>();
			ArrayList<String> months = new ArrayList<String>();
			months.add("Jan");
			months.add("Feb");
			months.add("Mar");
			months.add("Apr");
			months.add("May");
			months.add("Jun");
			months.add("Jul");
			months.add("Aug");
			months.add("Sep");
			months.add("Oct");
			months.add("Nov");
			months.add("Dec");
			for (Cache c : cachesCreatedInDate) {
				int toSum = points.get(c.getCreationDate().get(
						GregorianCalendar.MONTH));
				points.add(c.getCreationDate().get(GregorianCalendar.MONTH),
						toSum + 1);
			}
			for (int x : points) {
				if (x > max)
					max = x;
			}
			graphic2D(points, months, 12, max, "months", "created couchs", true);

		}
		System.out.println(user.getName() + " found "
				+ cachesFoundInDate.size() + " in last month");

		for (Cache c : cachesFoundInDate) {
			System.out.println(c.toSimpleListing());
		}

		if (withGraph) {
			ArrayList<Integer> points = new ArrayList<Integer>();
			ArrayList<String> months = new ArrayList<String>();
			months.add("Jan");
			months.add("Feb");
			months.add("Mar");
			months.add("Apr");
			months.add("May");
			months.add("Jun");
			months.add("Jul");
			months.add("Aug");
			months.add("Sep");
			months.add("Oct");
			months.add("Nov");
			months.add("Dec");
			for (Cache c : cachesFoundInDate) {
				int toSum = points.get(c.getCreationDate().get(
						GregorianCalendar.MONTH));
				points.add(c.getCreationDate().get(GregorianCalendar.MONTH),
						toSum + 1);
			}
			for (int x : points) {
				if (x > max)
					max = x;
			}
			graphic2D(points, months, 12, max, "months", "found couchs", true);

		}

	}
}
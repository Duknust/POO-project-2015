package base;

import java.io.BufferedReader;
import java.io.Console;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import user.Admin;
import user.Reviewer;
import user.User;
import user.UserAbstract;
import caches.Cache;
import caches.Log;
import caches.Traditional;

public class Geocaching {

	static Data data = null;
	static BufferedReader input = new BufferedReader(new InputStreamReader(
			System.in));
	static UserAbstract userOnline; // User online and using the System

	public static void main(String[] args) {

		data = getData();

		// populateData(data); // Use Pre-Made Database _ Atention, use with
		// caution ! ---------------------------------------------
		showLogo();

		System.out.println("----------------------------------------------");
		System.out.println("------------- Welcome to GeoPOO --------------");
		System.out.println("----------------------------------------------");
		mStart();

	}

	// ------------------- MAIN MENU ------------------
	private static void mStart() {

		int choice = -1;
		while (choice == -1) {
			System.out.println("-- [1] Login");
			System.out.println("-- [2] Register");
			System.out.println("-----");
			System.out.println("-- [0] Exit");
			System.out.print("?> ");
			try {
				choice = Integer.parseInt(input.readLine());
			} catch (Exception ex) {
				System.out.println("Error: Invalid Option");
				choice = -1;
			}

			switch (choice) {
			case 1:
				clearConsole();
				mLogin();
				break;
			case 2:
				clearConsole();
				if (mSignUp()) {
					System.out.println("User Successfully Registered!");
				} else {
					System.out.println("User Registration Failed!");
				}
				choice = -1;
				break;
			case 0:
				mExit();
				break;
			default:
				System.out.println("Error: Option not available");
				choice = -1;
				break;
			}

		}

	}

	private static void mMain() {
		int choice = -1;

		while (choice == -1) {
			System.out.println("Greetings " + userOnline.getName() + "! \n\n");
			System.out.println("####### Main Menu #######\n");
			System.out.println("-- [1] Profile");
			System.out.println("-- [2] Caches");
			System.out.println("-- [3] Friends");
			System.out.println("-- [4] Statistics");
			System.out.println("-----:");
			System.out.println("-- [0] Exit");

			System.out.print("?> ");
			try {
				choice = Integer.parseInt(input.readLine());
			} catch (Exception ex) {
				System.out.println("Error: Invalid Option");
				choice = -1;
			}

			switch (choice) {
			case 1:
				clearConsole();
				mProfile();
				choice = -1;
				clearConsole();
				break;
			case 2:
				clearConsole();
				mCaches();
				choice = -1;
				clearConsole();
				break;
			case 3:
				clearConsole();
				mFriends();
				choice = -1;
				clearConsole();
				break;
			case 4:
				clearConsole();
				mStats();
				choice = -1;
				clearConsole();
				break;
			case 0:
				clearConsole();
				mExit();
				break;
			default:
				System.out.println("Error: Invalid Option");
				break;
			}
		}
	}

	private static void mExit() {
		if (saveData()) {
			System.out.println("Program exited successfully!");
		} else {
			System.out.println("Program couldn't save the Data");
		}
		System.exit(0);
	}

	private static void mLogin() {
		int choice = -1;
		String email = null, password = null;
		while (choice == -1) {
			System.out.println("####### Login #######\n");
			System.out.println("-- E-Mail:");
			System.out.print("?> ");
			try {
				email = input.readLine();
			} catch (Exception ex) {
				Logger.getLogger(Geocaching.class.getName()).log(Level.SEVERE,
						null, ex);
			}

			System.out.println("-- Password:");
			System.out.print("?> ");

			Console console = System.console();
			if (console == null) {
				try {
					password = input.readLine();
				} catch (Exception ex) {
					Logger.getLogger(Geocaching.class.getName()).log(
							Level.SEVERE, null, ex);
				}
			} else {
				password = new String(console.readPassword()); // No echo
			}

			UserAbstract us = data.getAllUsers().get(email);
			if (us != null) {
				if (us.login(email, password)) {
					userOnline = us; // Sets this user as the current User
										// Online
					clearConsole();
					mMain();
					choice = 0;
				} else {
					System.out
							.println("Error: E-Mail and Password have no match in our System");
				}
			} else {
				System.out.println("Error: E-Mail not found in our System");
			}

		}
	}

	private static boolean mSignUp() {
		int OK = 0;
		String email = "", password = "", name = "", gender = "", address = "", bdate = "";
		boolean status = false;

		System.out.println("####### User Registration #######\n");
		System.out.println("----- Please insert the following fields");

		// E-Mail
		status = false;
		System.out.println("-- E-Mail:");

		while (status == false) {

			System.out.print("?> ");
			try {
				email = input.readLine();
			} catch (Exception ex) {
				Logger.getLogger(Geocaching.class.getName()).log(Level.SEVERE,
						null, ex);
			}
			if (email.length() < 6) { // If necessary verify the E-Mail format
				System.out
						.println("E-Mail needs to have at least 6 characters");
			} else {

				if (data.getAllUsers().get(email) == null) {
					OK++;
					status = true;
				} else {
					System.out.println("E-Mail already in use");
				}
			}
		}
		status = false;

		// Password
		System.out.println("-- Password (Minimum 5 characters):");
		while (status == false) {

			System.out.print("?> ");

			Console console = System.console();
			if (console == null) {
				try {
					password = input.readLine();
				} catch (Exception ex) {
					Logger.getLogger(Geocaching.class.getName()).log(
							Level.SEVERE, null, ex);
				}
			} else {
				password = new String(console.readPassword()); // No echo
			}

			if (password.length() < 5) {
				System.out
						.println("Error: Password must have at least 5 characters of length");
			} else {
				OK++;
				status = true;
			}

		}

		status = false;
		// Name
		System.out.println("-- Name:");
		while (status == false) {
			System.out.print("?> ");
			try {
				name = input.readLine();
			} catch (Exception ex) {
				Logger.getLogger(Geocaching.class.getName()).log(Level.SEVERE,
						null, ex);
			}
			if (name.length() < 3) {
				System.out.println("Name is too short");
			} else {
				OK++;
				status = true;
			}
		}

		// Gender
		System.out.println("-- Gender:");
		System.out.print("Male? (Y/N) > ");
		try {
			gender = input.readLine();
		} catch (Exception ex) {
			Logger.getLogger(Geocaching.class.getName()).log(Level.SEVERE,
					null, ex);
		}

		if (gender.equals("Y") || gender.equals("y") || gender.equals("yes")
				|| gender.equals("Yes")) {
			gender = "Male";
		} else {
			gender = "Female";
		}

		// Address
		status = false;

		System.out.println("-- Address:");

		while (status == false) {
			System.out.print("?> ");
			try {
				address = input.readLine();
			} catch (Exception ex) {
				Logger.getLogger(Geocaching.class.getName()).log(Level.SEVERE,
						null, ex);
			}

			if (address.length() < 3) {
				System.out.println("Address is too short");
			} else {
				OK++;
				status = true;
			}
		}

		// Birth Date
		status = false;

		System.out.println("-- Birth Date:");
		GregorianCalendar gcDate = new GregorianCalendar();
		while (status == false) {
			System.out.print("?> ");
			try {
				bdate = input.readLine();
			} catch (Exception ex) {
				Logger.getLogger(Geocaching.class.getName()).log(Level.SEVERE,
						null, ex);
			}

			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			Date startDate;
			try {
				startDate = df.parse(bdate);
				gcDate.setTime(startDate);
				status = true;
			} catch (ParseException ex) {
				System.out
						.println("Error with the Date Format, please use dd/MM/yyyy");
			}

		}

		User us = new User(email, password, name, gender, address, gcDate,
				false, 0, null, null, data);

		data.getAllUsers().put(email, us);
		status = true;

		return true;
	}

	// ------------------- PROFILE MENU ------------------
	private static void mProfile() {
		int choice = -1;
		while (choice == -1) {
			System.out.println("####### My Profile #######\n");
			System.out.println(userOnline.toStringTotal() + "\n");
			System.out.println("-- [1] Edit Profile");
			System.out.println("-- [2] Premium Membership");
			System.out.println("-----");
			System.out.println("-- [0] Back");
			System.out.print("?> ");
			try {
				choice = Integer.parseInt(input.readLine());
			} catch (Exception ex) {
				System.out.println("Error: Invalid Option");
				choice = -1;
			}

			switch (choice) {
			case 1:
				clearConsole();
				mEditProfile();
				choice = -1;
				clearConsole();
				break;
			case 2:
				clearConsole();
				mPremium();
				choice = -1;
				clearConsole();
				break;
			case 0:
				break;
			default:
				System.out.println("Error: Option not available");
				choice = -1;
				break;
			}
		}
	}

	private static void mFriends() {
		int choice = -1;
		String format = "\t[%3d] ";

		while (choice == -1) {
			System.out.println("####### Friends #######\n");
			ArrayList<User> arrayUser = ((User) userOnline).getFriendsArray();

			for (int i = 0; i < arrayUser.size(); i++)// For each Friend
			{
				User fr = arrayUser.get(i);
				System.out.format(format + fr.toString() + "\n", i + 1);
			}
			System.out.println("\n-- [X] View Friend");
			System.out.println("-----:");
			System.out.println("-- [0] Back");

			System.out.print("?> ");
			try {
				choice = Integer.parseInt(input.readLine());
			} catch (Exception ex) {
				System.out.println("Error: Invalid Option");
				choice = -1;
			}

			switch (choice) {
			case 0:
				clearConsole();
				break;
			default:
				if (choice > 0 && choice <= arrayUser.size()) {
					clearConsole();
					mViewFriend(arrayUser.get(choice - 1));
					clearConsole();
				} else {
					System.out.println("Error: Invalid Option");
				}
				choice = -1;
				break;
			}
		}
	}

	private static void mCaches() {
		int choice = -1;
		while (choice == -1) { // REVIEWER IFS MISSING
			System.out.println("####### Caches Menu #######\n");
			System.out.println("-- [1] Search Caches");
			System.out.println("-- [2] Create a Cache");
			System.out.println("-- [3] View Found Caches");
			System.out.println("-- [4] View Owned Caches");
			System.out.println("-----");
			System.out.println("-- [0] Back");
			System.out.print("?> ");
			try {
				choice = Integer.parseInt(input.readLine());
			} catch (Exception ex) {
				System.out.println("Error: Invalid Option");
				choice = -1;
			}

			switch (choice) {
			case 1:
				clearConsole();
				mSearchCaches();
				choice = -1;
				clearConsole();
				break;
			case 2:
				clearConsole();
				mCreateCache();
				choice = -1;
				clearConsole();
				break;
			case 3:
				clearConsole();
				mViewFoundCaches((User) userOnline);
				choice = -1;
				clearConsole();
				break;
			case 4:
				clearConsole();
				mViewOwnedCaches((User) userOnline);
				choice = -1;
				clearConsole();
				break;
			case 0:
				break;
			default:
				System.out.println("Error: Option not available");
				choice = -1;
				break;
			}
		}
	}

	private static void mStats() {
		throw new UnsupportedOperationException("Not supported yet."); // To
																		// change
																		// body
																		// of
																		// generated
																		// methods,
																		// choose
																		// Tools
																		// |
																		// Templates.
	}

	private static void mPremium() {
		int choice = -1;
		while (choice == -1) {
			System.out.println("####### Premium Membership #######\n");
			System.out.println("-- Premium Status - "
					+ (userOnline.isPremium() ? "Premium" : "Not Premium"));

			if (userOnline.isPremium()) {
				System.out.println("-- [1] Revoke Membership");
			} else {
				System.out.println("-- [1] Buy Membership");
			}

			System.out.println("-----");
			System.out.println("-- [0] Back");
			System.out.print("?> ");
			try {
				choice = Integer.parseInt(input.readLine());
			} catch (Exception ex) {
				System.out.println("Error: Invalid Option");
				choice = -1;
			}

			switch (choice) {
			case 1:
				userOnline.setPremium(!userOnline.isPremium()); // Switch
																// Membership
				clearConsole();
				System.out.println("Premium Membership successfully changed!");
				choice = -1;
				break;
			case 0:
				break;
			default:
				System.out.println("Error: Option not available");
				choice = -1;
				break;
			}
		}
	}

	private static void mEditProfile() {

	}

	// ------------------- FRIENDS MENU ------------------
	private static void mViewFriend(User friend) {
		int choice = -1;
		while (choice == -1) {
			System.out.println("####### " + friend.getName()
					+ " Profile #######\n");
			System.out.println(userOnline.toStringTotal() + "\n");
			System.out.println("-- [1] Remove Friend");
			System.out.println("-- [2] View Activities");
			System.out.println("-- [3] View Statistics");
			System.out.println("-- [4] View Found Caches");
			System.out.println("-- [5] View Owned Caches");
			System.out.println("-----");
			System.out.println("-- [0] Back");
			System.out.print("?> ");
			try {
				choice = Integer.parseInt(input.readLine());
			} catch (Exception ex) {
				System.out.println("Error: Invalid Option");
				choice = -1;
			}

			switch (choice) {
			case 1:
				clearConsole();
				((User) userOnline).removeFriendship(friend);
				System.out.println("Friendship with " + friend.getName()
						+ " has been Removed!");
				// Go Back
				break;
			case 2:
				clearConsole();
				mViewActivities(friend);
				choice = -1;
				clearConsole();
				break;
			case 3:
				clearConsole();
				mViewStatistics(friend);
				choice = -1;
				clearConsole();
				break;
			case 4:
				clearConsole();
				mViewFoundCaches(friend);
				choice = -1;
				clearConsole();
				break;
			case 5:
				clearConsole();
				mViewOwnedCaches(friend);
				choice = -1;
				clearConsole();
				break;
			case 0:
				break;
			default:
				System.out.println("Error: Option not available");
				choice = -1;
				break;
			}
		}
	}

	// ------------------- CACHES MENU ------------------
	private static void mViewOwnedCaches(User user) {

		int choice = -1;
		String format = "\t[%4d] ";

		while (choice == -1) {
			System.out.println("####### " + user.getName()
					+ " Owned caches #######\n");
			ArrayList<Cache> arrayCaches = ((User) userOnline)
					.getCachesArrayPremiumCheck(userOnline);

			for (int i = 0; i < arrayCaches.size(); i++)// For each Cache
			{
				Cache c = arrayCaches.get(i);
				System.out.format(format + c.toSimpleListing() + "\n", i + 1);
			}
			System.out.println("\n-- [X] View Cache");
			System.out.println("-----:");
			System.out.println("-- [0] Back");

			System.out.print("?> ");
			try {
				choice = Integer.parseInt(input.readLine());
			} catch (Exception ex) {
				System.out.println("Error: Invalid Option");
				choice = -1;
			}

			switch (choice) {
			case 0:
				clearConsole();
				break;
			default:
				if (choice > 0 && choice <= arrayCaches.size()) {
					clearConsole();
					mViewCache(arrayCaches.get(choice - 1));
					clearConsole();
				} else {
					System.out.println("Error: Invalid Option");
				}
				choice = -1;
				break;
			}
		}

	}

	private static void mViewFoundCaches(User user) {
		int choice = -1, i = 0;
		String format = "\t[%4d] ";

		while (choice == -1) {
			System.out.println("####### " + userOnline.getName()
					+ " Founds #######\n");
			SortedSet<Cache> arrayCaches = data.getCachesFrom(user);

			for (Cache c : arrayCaches)// For each Friend
			{
				System.out.format(format + c.toSimpleListing() + "\n", i + 1);
				i++;
			}
			System.out.println("\n-- [X] View Cache");
			System.out.println("-----:");
			System.out.println("-- [0] Back");

			System.out.print("?> ");
			try {
				choice = Integer.parseInt(input.readLine());
			} catch (Exception ex) {
				System.out.println("Error: Invalid Option");
				choice = -1;
			}

			switch (choice) {
			case 0:
				clearConsole();
				break;
			default:
				if (choice > 0 && choice <= arrayCaches.size()) {
					clearConsole();
					Cache ca = null;
					Iterator<Cache> it = arrayCaches.iterator();
					i = 1;
					while (it.hasNext()) {
						ca = it.next();
						if (choice == i) {
							break;
						}
						i++;
					}
					mViewCache(ca);
					clearConsole();
				} else {
					System.out.println("Error: Invalid Option");
				}
				choice = -1;
				break;
			}
		}
	}

	private static void mViewCache(Cache get) {

		int choice = -1;
		while (choice == -1) {
			boolean user = false, publish = false, archive = false, disable = false, enable = false, edit = false;
			System.out.println("####### " + get.getCacheTitle() + " #######\n");
			System.out.println(get.toListing() + "\n");
			if (userOnline.getRole() == UserAbstract.Role.USER) { // Only Users
																	// can do
																	// these
																	// actions
				System.out.println("-- [1] Log your visit");
				System.out.println("-- [2] View My Logs");
				System.out.println("-- [3] View Friends Logs");
				System.out.println("-- [4] Report");
				user = true;
			}

			if (userOnline.equals(get.getOwner())
					|| userOnline.equals(get.getReviewer())) { // Only Owner or
																// Reviewer can
																// see this menu
				System.out.println("------- Admin Tools");

				switch (get.getCacheStatus()) {

				case UNPUBLISHED:
					if (userOnline.equals(get.getReviewer())) {
						System.out.println("-- [6] Publish");
						publish = true;
						System.out.println("-- [7] Archive");
						archive = true;
						System.out.println("-- [8] Disable");
						disable = true;
					}
					break;

				case DISABLED:
					System.out.println("-- [7] Archive");
					archive = true;
					System.out.println("-- [8] Enable");
					enable = true;
					break;

				case ENABLED:
					System.out.println("-- [7] Archive");
					archive = true;
					System.out.println("-- [8] Disable");
					disable = true;
					break;

				case ARCHIVED:
					if (get.getPublishDate() != null) {
						// Only Enable if this Cache was already been Published
						System.out.println("-- [8] Enable");
						enable = true;
					}
					break;
				}

				System.out.println("-- [9] Edit Cache");
				edit = true;
			}

			System.out.println("-----");
			System.out.println("-- [0] Back");
			System.out.print("?> ");
			try {
				choice = Integer.parseInt(input.readLine());
			} catch (Exception ex) {
				System.out.println("Error: Invalid Option");
				choice = -1;
			}

			switch (choice) {
			case 1:
				if (user == true) {

					clearConsole();
					mLogCache(get);
				}
				choice = -1;
				break;
			case 2:
				if (user == true) {
					clearConsole();
					HashMap<String, User> userlist = new HashMap<>();
					userlist.put(userOnline.getEmail(), (User) userOnline);
					mViewUserLogs(userlist);
					clearConsole();
				}
				choice = -1;
				break;
			case 3:
				if (user == true) {
					clearConsole();
					mViewUserLogs(((User) userOnline).getFriends());
					clearConsole();
				}
				choice = -1;
				break;
			case 6:
				if (publish == true) {
					clearConsole();
					((Reviewer) userOnline).publishCache(get);
					clearConsole();
				}
				choice = -1;
				break;
			case 7:
				if (archive == true) {
					clearConsole();
					((User) userOnline).archiveCache(get);
					clearConsole();
				}
				choice = -1;
				break;
			case 8:
				if (disable == true) {
					clearConsole();
					((User) userOnline).disableCache(get);
					clearConsole();
				} else if (enable == true) {
					clearConsole();
					((User) userOnline).enableCache(get);
					clearConsole();
				}
				choice = -1;
				break;
			case 9:
				if (edit == true) {
					clearConsole();
					mEditCache(get);
					clearConsole();
				}
				choice = -1;
				break;
			case 0:
				break;
			default:
				System.out.println("Error: Option not available");
				choice = -1;
				break;
			}
		}

	}

	// ------------------- ACTIVITES MENU ------------------

	private static void mViewActivities(User friend) {
		throw new UnsupportedOperationException("Not supported yet."); // To
																		// change
																		// body
																		// of
																		// generated
																		// methods,
																		// choose
																		// Tools
																		// |
																		// Templates.
	}

	// ------------------- STATISTICS MENU ------------------
	private static void mViewStatistics(User friend) {
		throw new UnsupportedOperationException("Not supported yet."); // To
																		// change
																		// body
																		// of
																		// generated
																		// methods,
																		// choose
																		// Tools
																		// |
																		// Templates.
	}

	// ------------------- OTHER STUFF ------------------
	// Clear Console
	public final static void clearConsole() {
		try {
			final String os = System.getProperty("os.name");

			if (os.contains("Windows")) {
				Runtime.getRuntime().exec("cls");
			} else {
				Runtime.getRuntime().exec("clear");
			}
		} catch (final Exception e) {
			for (int clear = 0; clear < 50; clear++) {
				System.out.println("\b");
			}
		}
	}

	// Load Data if it exists else create new one
	public static Data getData() {

		// Load Data
		if (loadData()) {
			return data;
		} else {
			return new Data();
		}
	}

	// Load Data from File
	private static boolean loadData() {
		FileInputStream fin = null;
		try {
			fin = new FileInputStream("data.poo");
			ObjectInputStream ois = new ObjectInputStream(fin);
			data = (Data) ois.readObject();
			fin.close();
		} catch (FileNotFoundException ex) {
			return false;
		} catch (IOException | ClassNotFoundException ex) {
			return false;
		}
		return true;
	}

	// Save Data to File
	private static boolean saveData() {
		FileOutputStream fout = null;
		try {
			fout = new FileOutputStream("data.poo");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(data);
			fout.close();
		} catch (FileNotFoundException ex) {
			return false;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	// Pre-Made Dataset
	private static void populateData(Data data) {

		User u1 = new User("1", "1", "Ulisses", "M", "rua",
				new GregorianCalendar(), true, 0, null, null, data);
		User u2 = new User("2", "2", "Uche Villareal", "M", "rua",
				new GregorianCalendar(), false, 0, null, null, data);
		Reviewer r1 = new Reviewer("r", "r", "Rickon", "M", "rua",
				new GregorianCalendar(), false, 0, null, null, data);
		Admin a1 = new Admin("a", "a", "Aemon", "M", "rua",
				new GregorianCalendar(), false, 0, null, null, data);

		data.getAllUsers().put(u1.getEmail(), u1);
		data.getAllUsers().put(u2.getEmail(), u2);
		data.getAllUsers().put(r1.getEmail(), r1);
		data.getAllUsers().put(a1.getEmail(), a1);

		Position p1 = CountriesData.portugal;
		Position p2 = new Position(41.57238, -8.47875, 1.5f);
		Traditional tc1 = new Traditional(new GregorianCalendar(), "some info",
				"New in Lisbon", 2, 2.5f, p1, "under the rock",
				new TreeMap<GregorianCalendar, Log>(), new ArrayList<>());
		Traditional tc2 = new Traditional(new GregorianCalendar(), "more info",
				"Em Braga", 4, 1.0f, p2, "under the bench",
				new TreeMap<GregorianCalendar, Log>(), new ArrayList<>());

		u1.createCache(tc1);
		u2.createCache(tc2);

		r1.giveMeCache(tc1);
		r1.giveMeCache(tc2);

		r1.publishCache(tc1);
		r1.publishCache(tc2);

		u1.newFriendship(u2);

	}

	// Show GeoCaching Logo
	private static void showLogo() {
		System.out.println("..............................................");
		System.out.println(".............00xxxxxxxxxxxxxx00...............");
		System.out.println("..........0x@x00.........0xx@@@@@x00..........");
		System.out.println("........0xx0..................0x@@@@@x0.......");
		System.out.println(".......xx........0xx0.............0x@@@@x.....");
		System.out.println(".....0x0..........@@x...............0x@@@x....");
		System.out.println("....0x............0@@0................000.....");
		System.out.println("...0@..............0@x........................");
		System.out.println("...@0...............x@..........000xxxx@@@x...");
		System.out.println("..x@.................xx..00xx@@@@@@@@@@@x@@0..");
		System.out.println("..@@...............00x@@@x000............0@x..");
		System.out.println(".0@x......00xxx@@xx00..@@0................@@..");
		System.out.println("..@@...0@@@@@@x0........@@0...............@@0.");
		System.out.println("..x@0...xxx00...........0@@..............0@@0.");
		System.out.println("...@x....................@@x.............x@@..");
		System.out.println("...0@x...................0@@0...........0@@x..");
		System.out.println("....0@@0..................x@x..........0@@x...");
		System.out.println("......0@x0.................0..........0@@x....");
		System.out.println("........x@@x0.......................0x@@0.....");
		System.out.println("..........0x@@xx0................00@@@0.......");
		System.out.println("..............0xx@@xx000000000xx@@x00.........");
		System.out.println(".................00000000000000000............");
		System.out.println("..............................................");
	}

	private static void mLogCache(Cache get) {
		throw new UnsupportedOperationException("Not supported yet."); // To
																		// change
																		// body
																		// of
																		// generated
																		// methods,
																		// choose
																		// Tools
																		// |
																		// Templates.
	}

	private static void mViewUserLogs(HashMap<String, User> userlist) {
		throw new UnsupportedOperationException("Not supported yet."); // To
																		// change
																		// body
																		// of
																		// generated
																		// methods,
																		// choose
																		// Tools
																		// |
																		// Templates.
	}

	private static void mEditCache(Cache get) {
		throw new UnsupportedOperationException("Not supported yet."); // To
																		// change
																		// body
																		// of
																		// generated
																		// methods,
																		// choose
																		// Tools
																		// |
																		// Templates.
	}

	private static void mSearchCaches() {
		throw new UnsupportedOperationException("Not supported yet."); // To
																		// change
																		// body
																		// of
																		// generated
																		// methods,
																		// choose
																		// Tools
																		// |
																		// Templates.
	}

	private static void mCreateCache() {
		throw new UnsupportedOperationException("Not supported yet."); // To
																		// change
																		// body
																		// of
																		// generated
																		// methods,
																		// choose
																		// Tools
																		// |
																		// Templates.
	}

}

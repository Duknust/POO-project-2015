package base;

import caches.Cache;
import caches.Event;
import caches.Log;
import caches.Mystery;
import caches.Traditional;

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
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import user.Admin;
import user.Reviewer;
import user.User;
import user.UserAbstract;

public class Geocaching {

    static Data data = null;
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static UserAbstract userOnline; // User online and using the System

    public static void main(String[] args) {

        data = getData();

        populateData(data); // Use Pre-Made Database _ Atention, use with caution ! ---------------------------------------------
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
                //System.out.println("Error: Invalid Option");
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
            System.out.println("-- [5] Events");
            System.out.println("-----:");
            System.out.println("-- [0] Exit");

            System.out.print("?> ");
            try {
                choice = Integer.parseInt(input.readLine());
            } catch (Exception ex) {
                //System.out.println("Error: Invalid Option");
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
                case 5:
                    clearConsole();
                    mEvents();
                    choice = -1;
                    clearConsole();
                    break;
                case 0:
                    clearConsole();
                    mExit();
                    break;
                default:
                    System.out.println("Error: Invalid Option");
                    choice = -1;
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
                Logger.getLogger(Geocaching.class.getName()).log(Level.SEVERE, null, ex);
            }

            System.out.println("-- Password:");
            System.out.print("?> ");

            Console console = System.console();
            if (console == null) {
                try {
                    password = input.readLine();
                } catch (Exception ex) {
                    Logger.getLogger(Geocaching.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                password = new String(console.readPassword()); // No echo
            }

            UserAbstract us = data.getAllUsers().get(email);
            if (us != null) {
                if (us.login(email, password)) {
                    userOnline = us; // Sets this user as the current User Online
                    clearConsole();
                    mMain();
                    choice = 0;
                } else {
                    System.out.println("Error: E-Mail and Password have no match in our System");
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
                Logger.getLogger(Geocaching.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (email.length() < 6) { // If necessary verify the E-Mail format
                System.out.println("E-Mail needs to have at least 6 characters");
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
                    Logger.getLogger(Geocaching.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                password = new String(console.readPassword()); // No echo
            }

            if (password.length() < 5) {
                System.out.println("Error: Password must have at least 5 characters of length");
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
                Logger.getLogger(Geocaching.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Geocaching.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (gender.equals("Y") || gender.equals("y") || gender.equals("yes") || gender.equals("Yes")) {
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
                Logger.getLogger(Geocaching.class.getName()).log(Level.SEVERE, null, ex);
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
                Logger.getLogger(Geocaching.class.getName()).log(Level.SEVERE, null, ex);
            }

            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            Date startDate;
            try {
                startDate = df.parse(bdate);
                gcDate.setTime(startDate);
                status = true;
            } catch (ParseException ex) {
                System.out.println("Error with the Date Format, please use dd/MM/yyyy");
            }

        }

        User us = new User(email, password, name, gender, address, gcDate, false, 0, null, null, data);

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
                //System.out.println("Error: Invalid Option");
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
        ArrayList<User> arrayUser = ((User) userOnline).getFriendsArray();
        String format = "\t[ %" + (arrayUser.size() + "").length() + "d ] ";

        while (choice == -1) {
            System.out.println("####### Friends #######\n");

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
                //System.out.println("Error: Invalid Option");
                choice = -1;
            }

            switch (choice) {
                case 0:
                    clearConsole();
                    break;
                default:
                    if (choice > 0 && choice <= arrayUser.size()) {
                        clearConsole();
                        mViewUser(arrayUser.get(choice - 1));
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
                //System.out.println("Error: Invalid Option");
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void mPremium() {
        int choice = -1;
        while (choice == -1) {
            System.out.println("####### Premium Membership #######\n");
            System.out.println("-- Premium Status - " + (userOnline.isPremium() ? "Premium" : "Not Premium"));

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
                //System.out.println("Error: Invalid Option");
                choice = -1;
            }

            switch (choice) {
                case 1:
                    userOnline.setPremium(!userOnline.isPremium()); // Switch Membership
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
    private static void mViewUser(User user) {
        int choice = -1;
        boolean friend = false;
        while (choice == -1) {
            System.out.println("####### " + user.getName() + " Profile #######\n");
            System.out.println(user.toStringFriend() + "\n");
            if (((User) userOnline).isFriendsWith(user)) {
                System.out.println("-- [1] Remove Friend");
                friend = true;
            } else {
                System.out.println("-- [1] Add Friend");
                friend = false;
            }
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
                //System.out.println("Error: Invalid Option");
                choice = -1;
            }

            switch (choice) {
                case 1:
                    clearConsole();
                    if (friend) {
                        ((User) userOnline).removeFriendship(user);
                        System.out.println("You are no longer a Friend of " + user.getName() + ".");
                    } else {
                        ((User) userOnline).newFriendship(user);
                        System.out.println("You are now a Friend of " + user.getName() + "!");
                    }
                    pressAnyKeyToContinue();
                    clearConsole();
                    choice = -1;
                    // Go Back
                    break;
                case 2:
                    clearConsole();
                    mViewActivities(user);
                    choice = -1;
                    clearConsole();
                    break;
                case 3:
                    clearConsole();
                    mViewStatistics(user);
                    choice = -1;
                    clearConsole();
                    break;
                case 4:
                    clearConsole();
                    mViewFoundCaches(user);
                    choice = -1;
                    clearConsole();
                    break;
                case 5:
                    clearConsole();
                    mViewOwnedCaches(user);
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
        ArrayList<Cache> arrayCaches = user.getCachesArrayPremiumCheck(user);
        String format = "\t[ %" + (arrayCaches.size() + "").length() + "d ] ";
        arrayCaches.sort(data.compareCachePubDate());
        while (choice == -1) {
            System.out.println("####### " + user.getName() + " Owned caches #######\n");

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
                //System.out.println("Error: Invalid Option");
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
        int choice = -1;
        SortedSet<Cache> arrayCaches = data.getCachesFoundFrom(user);
        String format = "\t[ %" + (arrayCaches.size() + "").length() + "d ] ";

        while (choice == -1) {
            int i = 1;
            System.out.println("####### " + userOnline.getName() + " Founds #######\n");

            System.out.println("\n-- Total Founds: " + arrayCaches.size() + "\n\n");
            for (Cache c : arrayCaches)// For each Friend
            {
                System.out.format(format + c.toSimpleListing() + "\n", i);
                i++;
            }
            System.out.println("\n-- [X] View Cache");
            System.out.println("-----:");
            System.out.println("-- [0] Back");

            System.out.print("?> ");
            try {
                choice = Integer.parseInt(input.readLine());
            } catch (Exception ex) {
                //System.out.println("Error: Invalid Option");
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

    private static void mViewCache(Cache cache) {

        int choice = -1;
        while (choice == -1) {
            boolean user = false, publish = false, archive = false, disable = false, enable = false, edit = false, mystery = false;
            System.out.println("####### " + cache.getCacheTitle() + " #######\n");
            System.out.println(cache.toListing() + "\n");
            if (userOnline.getRole() == UserAbstract.Role.USER) { // Only Users can do these actions
                System.out.println("-- [1] Log your visit");
                System.out.println("-- [2] View Logs");
                System.out.println("-- [3] View My Logs");
                System.out.println("-- [4] View Friends Logs");
                if (cache.getType() == Cache.Type.MYSTERY) {
                    System.out.println("-- [5] Check Coordinates");
                    mystery = true;
                }
                user = true;
            }

            if (userOnline.equals(cache.getOwner()) || userOnline.equals(cache.getReviewer())) { // Only Owner or Reviewer can see this menu
                System.out.println("------- Admin Tools");

                switch (cache.getCacheStatus()) {

                    case UNPUBLISHED:
                        if (userOnline.equals(cache.getReviewer())) {
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
                        if (cache.getPublishDate() != null) {
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
                //System.out.println("Error: Invalid Option");
                choice = -1;
            }

            switch (choice) {
                case 1:
                    if (user == true) {

                        clearConsole();
                        mLogCache(cache);
                    }
                    choice = -1;
                    break;
                case 2:
                    if (user == true) {

                        clearConsole();
                        mLogs(cache);
                        clearConsole();
                    }
                    choice = -1;
                    break;
                case 3:
                    if (user == true) {
                        clearConsole();
                        HashMap<String, User> userlist = new HashMap<>();
                        userlist.put(userOnline.getEmail(), (User) userOnline);
                        mLogs(userlist, cache);
                        clearConsole();
                    }
                    choice = -1;
                    break;
                case 4:
                    if (user == true) {
                        clearConsole();
                        mLogs(((User) userOnline).getFriends(), cache);
                        clearConsole();
                    }
                    choice = -1;
                    break;
                case 5:
                    if (user == true) {
                        clearConsole();
                        Position p = mInputPosition(true);
                        if (((Mystery) cache).checkCoord(p)) {
                            System.out.println("Coordinates are correct !");
                            System.out.println(((Mystery) cache).getFinalText());
                        } else {
                            System.out.println("Coordinates are wrong !");
                        }
                    }
                    choice = -1;
                    break;
                case 6:
                    if (publish == true) {
                        clearConsole();
                        ((Reviewer) userOnline).publishCache(cache);
                        clearConsole();
                    }
                    choice = -1;
                    break;
                case 7:
                    if (archive == true) {
                        clearConsole();
                        ((User) userOnline).archiveCache(cache);
                        clearConsole();
                    }
                    choice = -1;
                    break;
                case 8:
                    if (disable == true) {
                        clearConsole();
                        ((User) userOnline).disableCache(cache);
                        clearConsole();
                    } else if (enable == true) {
                        clearConsole();
                        ((User) userOnline).enableCache(cache);
                        clearConsole();
                    }
                    choice = -1;
                    break;
                case 9:
                    if (edit == true) {
                        clearConsole();
                        mEditCache(cache);
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

    private static void mLogCache(Cache get) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void mLogs(HashMap<String, User> userlist, Cache cache) {
        int choice = -1;
        TreeSet<Log> setLogs = cache.getCache_Logs();
        String format = "  [ %" + (setLogs.size() + "").length() + "d ]";
        while (choice == -1) {
            System.out.println("####### '" + cache.getCacheTitle() + "' - Friend's Logs #######\n");

            int i = 1;
            for (Log log : setLogs)// For each Friend
            {
                for (User friend : userlist.values()) {
                    if (log.getUser().equals(friend)) {
                        System.out.format(format + "\n" + log.toLogListing() + "\n", i);
                        i++;
                    }

                }
            }
            if (i == 1) {
                System.out.println("-- There are no Friend's Logs for this cache!");
            } else {
                System.out.println("\n-- [X] View Log Details");
            }
            System.out.println("-----:");
            System.out.println("-- [0] Back");

            System.out.print("?> ");
            try {
                choice = Integer.parseInt(input.readLine());
            } catch (Exception ex) {
                //System.out.println("Error: Invalid Option");
                choice = -1;
            }

            switch (choice) {
                case 0:
                    clearConsole();
                    break;
                default:
                    if (choice > 0 && choice <= setLogs.size()) {
                        clearConsole();
                        Log log = null;
                        Iterator<Log> iterator = setLogs.iterator();
                        int count = 0;
                        while (iterator.hasNext() && count < choice) {
                            log = iterator.next();
                            count++;
                        }
                        mViewLog(log, cache);
                        clearConsole();
                    } else {
                        System.out.println("Error: Invalid Option");
                    }
                    choice = -1;
                    break;
            }
        }
    }

    private static void mLogs(Cache cache) {
        int choice = -1;
        TreeSet<Log> setLogs = cache.getCache_Logs();
        String format = "  [ %" + (setLogs.size() + "").length() + "d ]";
        while (choice == -1) {
            System.out.println("####### '" + cache.getCacheTitle() + "' - Logs #######\n");

            int i = 1;
            for (Log log : setLogs)// For each Log
            {
                System.out.format(format + "\n" + log.toLogListing() + "\n", i);
                i++;
            }

            System.out.println("\n-- [X] View Log Details");
            System.out.println("-----:");
            System.out.println("-- [0] Back");

            System.out.print("?> ");
            try {
                choice = Integer.parseInt(input.readLine());
            } catch (Exception ex) {
                //System.out.println("Error: Invalid Option");
                choice = -1;
            }

            if (i == 1) {
                System.out.println("-- There are no Logs for this cache!");
            } else {
                System.out.println("\n-- [X] View Log Details");
            }

            switch (choice) {
                case 0:
                    clearConsole();
                    break;
                default:
                    if (choice > 0 && choice <= setLogs.size()) {
                        clearConsole();
                        Log log = null;
                        Iterator<Log> iterator = setLogs.iterator();
                        int count = 0;
                        while (iterator.hasNext() && count < choice) {
                            log = iterator.next();
                            count++;
                        }
                        mViewLog(log, cache);
                        clearConsole();
                    } else {
                        System.out.println("Error: Invalid Option");
                    }
                    choice = -1;
                    break;
            }
        }
    }

    private static void mEditCache(Cache get) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void mSearchCaches() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private static void mCreateCache() {
    	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.        
    }

    private static void mEvents() {
    	int choice = -1;
        while (choice == -1) { // REVIEWER IFS MISSING
            System.out.println("####### Events Menu #######\n");
            System.out.println("-- [1] Active Events");
            System.out.println("-- [2] Happening Events");
            System.out.println("-- [3] Create a Event");
            System.out.println("-- [4] View Owned Events");
            System.out.println("-- [5] View Participated Events");
            System.out.println("-----");
            System.out.println("-- [0] Back");
            System.out.print("?> ");
            try {
                choice = Integer.parseInt(input.readLine());
            } catch (Exception ex) {
                //System.out.println("Error: Invalid Option");
                choice = -1;
            }

            switch (choice) {
                case 1:
                    clearConsole();
                    mActiveEvents();
                    choice = -1;
                    clearConsole();
                    break;
                case 2:
                	clearConsole();
                	mHappeningEvents();
                	choice = -1;
                	break;
                case 3:
                    clearConsole();
                    mCreateEvent();
                    choice = -1;
                    clearConsole();
                    break;
                case 4:
                    clearConsole();
                    mViewOwedEvents(userOnline);
                    choice = -1;
                    clearConsole();
                    break;
                case 5:
                    clearConsole();
                    mParticipatedEvents(userOnline);
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
    
    private static void mHappeningEvents() {
    	int choice = -1;
    	HashMap<String, Event> events = data.getEnabledEvents();
    	ArrayList<Event> list = new ArrayList<Event>();
    	Date today = new GregorianCalendar().getTime();
    	SimpleDateFormat fmt = new SimpleDateFormat("ddMMyyyy");
    	
    	
    	for(Event e: events.values())
    		if(fmt.format(today).equals(fmt.format(e.getDateEvent().getTime())))
    			list.add(e);
    	
        while (choice == -1) {
            int i = 1;
            System.out.println("####### " + userOnline.getName() + " Founds #######\n");

            System.out.println("\n-- Total Founds: " + list.size() + "\n\n");
            for (Event e : list)// For each Friend
            {
            	Date dt = e.getDateEndApplications().getTime();
                System.out.format("\t[%d] - %s - %s\n", i, e.getCacheTitle(), dt.toString());
                i++;
            }
            
            System.out.println("\n-- [X] View Event");
            System.out.println("-----:");
            System.out.println("-- [0] Back");

            System.out.print("?> ");
            try {
                choice = Integer.parseInt(input.readLine());
            } catch (Exception ex) {
                //System.out.println("Error: Invalid Option");
                choice = -1;
            }

            switch (choice) {
                case 0:
                    clearConsole();
                    break;
                default:
                    if (choice > 0 && choice <= list.size()) {
                        clearConsole();
                        Event ev = list.get(choice - 1);
                        mViewEvent(ev);
                        clearConsole();
                    } else {
                        System.out.println("Error: Invalid Option");
                    }
                    choice = -1;
                     break;
            }
        }
	}

	private static void mActiveEvents() {
    	int choice = -1;
    	HashMap<String, Event> events = data.getEnabledEvents();
    	ArrayList<Event> list = new ArrayList<Event>();
    	Calendar today = new GregorianCalendar();
    	
    	for(Event e: events.values())
    		if(today.before(e.getDateEndApplications()))    			
    			list.add(e);
    		
    	list.sort(data.compareEventAppDate());

        while (choice == -1) {
            int i = 1;
            System.out.println("####### " + userOnline.getName() + " Founds #######\n");

            System.out.println("\n-- Total Founds: " + list.size() + "\n\n");
            for (Event e : list)// For each Friend
            {
            	Date dt = e.getDateEndApplications().getTime();
                System.out.format("\t[%d] - %s - %s\n", i, e.getCacheTitle(), dt.toString());
                i++;
            }
            System.out.println("\n-- [X] View Event");
            System.out.println("-----:");
            System.out.println("-- [0] Back");

            System.out.print("?> ");
            try {
                choice = Integer.parseInt(input.readLine());
            } catch (Exception ex) {
                //System.out.println("Error: Invalid Option");
                choice = -1;
            }

            switch (choice) {
                case 0:
                    clearConsole();
                    break;
                default:
                    if (choice > 0 && choice <= list.size()) {
                        clearConsole();
                        Event ev = list.get(choice - 1);
                        mViewEvent(ev);
                        clearConsole();
                    } else {
                        System.out.println("Error: Invalid Option");
                    }
                    choice = -1;
                     break;
            }
        }
		
	}

	private static void mViewEvent(Event ev) {
		int choice = -1;
		
		while (choice == -1) {
			System.out.println("\n-- Event Details --\n");
			System.out.println("\tOrganizer: "+ ev.getOwner().getName());
			System.out.println("\tID: "+ ev.getCacheID());
			System.out.println("\tTitle: "+ ev.getCacheTitle());
			System.out.println("\tDescription: "+ ev.getDescription());
			System.out.println("\tNº Regist: "+ ev.getNRegistrations() +"/"+ ev.getMaxP());
			System.out.println("\tDate Creation: "+ ev.getCreationDate().getTime().toString());
			System.out.println("\tDate End App:  "+ ev.getDateEndApplications().getTime().toString());
			System.out.println("\tDate of Event: "+ ev.getDateEvent().getTime().toString());
			
			System.out.println("\n-- [1] See Participants");
			System.out.println("\n-- [2] See Caches");
			System.out.println("-- [3] Send Application");
	        System.out.println("-----:");
	        System.out.println("-- [0] Back");
	
	        System.out.print("?> ");
	        try {
	            choice = Integer.parseInt(input.readLine());
	        } catch (Exception ex) {
	            choice = -1;
	        }
	
	        switch (choice) {
	            case 0:
	                clearConsole();
	                break;
	            case 1:
	            	clearConsole();
	            	if(ev.getNRegistrations() != 0){
		            	System.out.println("\tPoints - Username");
		                for(UserAbstract u: ev.getParticipants().values())
		                	System.out.println("\t" + ev.getPointsByUser(u) + " - " + u.getName());	            		
	            	} else
	            		System.out.println("Error: Event without users resgistrated!!");
	            	choice = -1;
	                break;
	            case 2:
	            	clearConsole();
	                if(ev.getCaches().size() != 0){
	                	mEventCaches(ev);	            		
	            	} else
	            		System.out.println("Error: Event without caches resgistrated!!");
	                choice = -1;
	                break;
	            case 3:
	            	choice = -1;
	                clearConsole();
	                Calendar today = new GregorianCalendar();
	            	if(today.after(ev.getDateEndApplications())){  
	            		System.out.println("Error: The application date limit is expired!!");
            			break;
            		}
	            	
	            	if(userOnline.equals(ev.getOwner())){
	            		System.out.println("Error: You are the owner!!");
	            		break;
	            	}

	            	if(ev.getNRegistrations() < ev.getMaxP())
	            		if(ev.addParticipant(userOnline))
	            			System.out.println("Congratulations!! Now you are a participant!!");
	            		else
	            			System.out.println("Error: User is already registrated in event!!");
	            	else
	            		System.out.println("Error: The event is full!! Try later..");
	            	break;
	            default:
	                System.out.println("Error: Invalid Option");
	                choice = -1;
	                 break;
	        }
		}
	}

	private static void mEventCaches(Event ev) {
		int i, choice = -1;
		Cache cache = null;
		
		while (choice == -1) {
			System.out.println("\tID - Title");
        	Object[] array = ev.getCaches().values().toArray();
        	
            for(i=0; i< array.length;i++){
            	cache = (Cache)array[i];
            	System.out.format("\t[%d] - %s - %s\n", i+1, cache.getCacheID(), cache.getCacheTitle());
            }
            
            System.out.println("\n-- [X] View Cache");
            System.out.println("-----:");
            System.out.println("-- [0] Back");
            System.out.print("?> ");
	        try {
	            choice = Integer.parseInt(input.readLine());
	        } catch (Exception ex) {
	            choice = -1;
	        }
            
            switch (choice) {
	            case 0:
	                clearConsole();
	                break;
	            default:
	            	if (choice > 0 && choice <= array.length) {
	            		clearConsole();
	            		cache = (Cache)array[choice-1];
                        mViewCache(cache);
                    } else 
	                        System.out.println("Error: Invalid Option");
	                choice = -1;
	                break;
            }
		}
	}

	private static void mViewOwedEvents(UserAbstract user) {
		int i, choice = -1;
		Event ev = null;
		
		while (choice == -1) {
			System.out.println("\tID - Title");
			ArrayList<Event> list = new ArrayList<Event>(); 
        	Iterator<Event> evEnable = data.enabledEvents.values().iterator();
        	Iterator<Event> evPast = data.pastEvents.values().iterator();
        	
        	while(evEnable.hasNext()){
        		ev = evEnable.next();
        		if(user.equals(ev.getOwner()))
        			list.add(ev);
        	}
        	
        	while(evPast.hasNext()){
        		ev = evPast.next();
        		if(user.equals(ev.getOwner()))
        			list.add(ev);
        	}
        	
        	list.sort(data.compareEventDate());
        	
            for(i=0; i< list.size();i++){
            	ev = list.get(i);
            	System.out.format("\t[%d] - %s - %s - %s\n", i+1, ev.getCacheID(), ev.getCacheTitle(), ev.getDateEvent().getTime().toString());
            }
            
            System.out.println("\n-- [X] View Cache");
            System.out.println("-----:");
            System.out.println("-- [0] Back");
            System.out.print("?> ");
	        try {
	            choice = Integer.parseInt(input.readLine());
	        } catch (Exception ex) {
	            choice = -1;
	        }
            
            switch (choice) {
	            case 0:
	                clearConsole();
	                break;
	            default:
	            	if (choice > 0 && choice <= list.size()) {
	            		clearConsole();
	            		ev = list.get(i-1);
                        mViewEvent(ev);
                    } else 
	                        System.out.println("Error: Invalid Option");
	                choice = -1;
	                break;
            }
		}
	}

	private static void mParticipatedEvents(UserAbstract user) {
    	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		
	}

	private static void mSearchEvent() {
    	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
		
	}

	private static void mCreateEvent() {
        GregorianCalendar dateEvent = new GregorianCalendar();
        GregorianCalendar dateEndApplications = new GregorianCalendar();
        String name="", description="", str="";
        Position pos;
        int maxP=0;
        boolean status = false;
        
        // Name Event
        System.out.println("-- Name of Event");
        while (status == false) {
            System.out.print("?> ");
            try {
				name = input.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            if(name.length()>4)
                status = true;
            else
                System.out.println("Error: The name need at least 4 characters!");
        }
        status = false;
        
        // Description
        System.out.println("-- Description of Event");
        while (status == false) {
            System.out.print("?> ");
            
            try {
				description = input.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            if(description.length()>10)
                status = true;
            else
                System.out.println("Error: The name need at least 10 characters!");
        }
        status = false;
        
        
        System.out.println("-- Date Of Event:");
        while (status == false) {
            System.out.print("?> ");
            try {
                str = input.readLine();
            } catch (Exception ex) {
                Logger.getLogger(Geocaching.class.getName()).log(Level.SEVERE, null, ex);
            }

            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            Date startDate;
            try {
                startDate = df.parse(str);
                dateEvent.setTime(startDate);
                status = true;
            } catch (ParseException ex) {
                System.out.println("Error with the Date Format, please use dd/MM/yyyy");
            }
        }
        
        System.out.println("-- Limit Date To Applications:");
        while (status == false) {
            System.out.print("?> ");
            try {
                str = input.readLine();
            } catch (Exception ex) {
                Logger.getLogger(Geocaching.class.getName()).log(Level.SEVERE, null, ex);
            }

            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            Date startDate;
            try {
                startDate = df.parse(str);
                dateEndApplications.setTime(startDate);
                status = true;
            } catch (ParseException ex) {
                System.out.println("Error with the Date Format, please use dd/MM/yyyy");
            }
        }
        
        System.out.println("-- Max of Participants");
        while (status == false) {
            System.out.print("?> ");
            try {
                str = input.readLine();
                maxP = Integer.parseInt(str);
                status = true;
            } catch (Exception ex) {
                System.out.println("Error: Number isn't in the correct format (12)");
            }
        }
        status = false;
        
        //Positon of Event
        pos = mInputPosition(true);
        
        HashMap<String, Cache> caches = data.getByPosition(pos, 5);
        Event event = new Event(new GregorianCalendar(), dateEndApplications, dateEvent, name, description, pos, maxP, userOnline, caches);
        
    }

    private static Position mInputPosition(boolean onlyCoords) {
        int OK = 0;
        String slati = "", slongi = "", sdiff = "";
        float lati = 0.0f, longi = 0.0f, diff = 0.0f;
        String continent = "", country = "", city = "";
        boolean status = false;

        System.out.println("####### Position Input #######\n");
        System.out.println("----- Please insert the following fields");

        // Lati
        System.out.println("-- Latitude");
        while (status == false) {
            System.out.print("?> ");
            try {
                slati = input.readLine();
                lati = Float.parseFloat(slati);
                status = true;
            } catch (Exception ex) {
                System.out.println("Error: Number isn't in the correct format (12.345)");
            }
        }
        status = false;

        // Longi
        System.out.println("-- Longitude");
        while (status == false) {
            System.out.print("?> ");
            try {
                slongi = input.readLine();
                longi = Float.parseFloat(slongi);
                status = true;
            } catch (Exception ex) {
                System.out.println("Error: Number isn't in the correct format (12.345)");
            }
        }
        status = false;

        if (onlyCoords) { // Only the Latitude and Longitude are necessary
            return new Position(lati, longi);
        }

        // Continent
        System.out.println("-- Continent");
        int choice = -1;
        while (choice == -1) {

            System.out.println("Please choose:\n");

            System.out.println("-- [1] Europe");
            System.out.println("-- [2] Asia");
            System.out.println("-- [3] Africa");
            System.out.println("-- [4] Oceania");
            System.out.println("-- [5] North America");
            System.out.println("-- [6] South America");
            System.out.println("-- [7] Antartica");

            System.out.println("-----");
            System.out.println("-- [0] Back");
            System.out.print("?> ");
            try {
                choice = Integer.parseInt(input.readLine());
            } catch (Exception ex) {
                //System.out.println("Error: Invalid Option");
                choice = -1;
            }

            switch (choice) {
                case 1:
                    continent = "Europe";
                    break;
                case 2:
                    continent = "Asia";
                    break;
                case 3:
                    continent = "Africa";
                    break;
                case 4:
                    continent = "Oceania";
                    break;
                case 5:
                    continent = "North America";
                    break;
                case 6:
                    continent = "South America";
                    break;
                case 7:
                    continent = "Antartica";
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Error: Option not available");
                    choice = -1;
                    break;
            }
        }

        // Country
        System.out.println("-- Country");
        while (status == false) {
            System.out.print("?> ");
            try {
                country = input.readLine();
                status = true;
            } catch (Exception ex) {
                Logger.getLogger(Geocaching.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        // City
        System.out.println("-- City");
        while (status == false) {
            System.out.print("?> ");
            try {
                city = input.readLine();
                status = true;
            } catch (Exception ex) {
                Logger.getLogger(Geocaching.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        // Difficulty
        System.out.println("-- Difficulty");
        while (status == false) {
            System.out.print("?> ");
            try {
                sdiff = input.readLine();
                diff = Float.parseFloat(sdiff);
            } catch (Exception ex) {
                Logger.getLogger(Geocaching.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (diff >= 1.0f && diff <= 5.0f) {
                status = true;
            } else {
                System.out.println("Error: Number is between 1.0f and 5.0f");
            }
        }

        return new Position(lati, longi, continent, country, city, diff);
    }

    private static void mViewLog(Log log, Cache cache) {
        int choice = -1;
        while (choice == -1) {
            boolean user = false, delete = false, edit = false;
            System.out.println("####### " + cache.getCacheTitle() + " #######\n");
            System.out.println("\n" + log.toLogListing());

            System.out.println("-- [1] View User");

            if (userOnline.equals(cache.getOwner()) && log.getUser().equals(userOnline) || // If I am the Owner and I made this Log then I can Edit and Delete this Log
                    log.getUser().equals(userOnline)) {  // OR If I am just the User who made this Log then I can Edit and Delete
                System.out.println("------- Admin Tools");
                System.out.println("-- [8] Edit Log");
                System.out.println("-- [9] Delete Log");
                edit = true;
                delete = true;
                /*} else if (log.getUser().equals(userOnline)) {
                 System.out.println("------- Admin Tools");
                 System.out.println("-- [8] Edit Log");
                 System.out.println("-- [9] Delete Log");
                 edit = true;*/
            } else if (userOnline.equals(cache.getReviewer()) || // If I am the Reviewer then I can Edit and Delete this Log
                    userOnline.equals(cache.getOwner())) { // If I am just the Owner then I can only Delete
                System.out.println("------- Admin Tools");
                System.out.println("-- [9] Delete Log");
                delete = true;
                /*} else if (userOnline.equals(cache.getOwner())) { // If I am just the Owner then I can only Delete
                 System.out.println("------- Admin Tools");
                 System.out.println("-- [9] Delete Log");
                 edit = true;*/
            }

            System.out.println("-----");
            System.out.println("-- [0] Back");
            System.out.print("?> ");
            try {
                choice = Integer.parseInt(input.readLine());
            } catch (Exception ex) {
                //System.out.println("Error: Invalid Option");
                choice = -1;
            }

            switch (choice) {
                case 1:

                    clearConsole();
                    mViewUser((User) log.getUser());
                    clearConsole();

                    choice = -1;
                    break;

                case 8:
                    if (edit == true) {
                        clearConsole();
                        mEditLog(log);
                        clearConsole();
                    }
                    choice = -1;
                    break;

                case 9:
                    if (delete == true) {
                        clearConsole();
                        boolean deleted = cache.deleteLog(log);
                        if (deleted) {
                            System.out.println("Log was successfully Deleted!");// Go Back
                        } else {
                            System.out.println("ERROR: Log wasn't Deleted");
                            choice = -1; // NOT Go Back
                        }
                        pressAnyKeyToContinue();
                        clearConsole();
                    }
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // ------------------- STATISTICS MENU ------------------
    private static void mViewStatistics(User friend) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

        User u1 = new User("1", "1", "Ulisses", "M", "rua", new GregorianCalendar(2000, 1, 24, 11, 11, 11), true, 0, null, null, data);
        User u2 = new User("2", "2", "Uche Villareal", "M", "rua", new GregorianCalendar(1982, 2, 2, 11, 11, 11), false, 0, null, null, data);
        User u3 = new User("3", "3", "Ukra", "M", "rua", new GregorianCalendar(1992, 3, 29, 11, 11, 11), false, 0, null, null, data);
        User u4 = new User("4", "4", "Uruguaio", "M", "rua", new GregorianCalendar(2001, 8, 13, 11, 11, 11), false, 0, null, null, data);
        Reviewer r1 = new Reviewer("r", "r", "Rickon", "M", "rua", new GregorianCalendar(1968, 1, 24, 11, 11, 11), false, 0, null, null, data);
        Admin a1 = new Admin("a", "a", "Aemon", "M", "rua", new GregorianCalendar(1987, 7, 14, 11, 11, 11), false, 0, null, null, data);

        data.getAllUsers().put(u1.getEmail(), u1);
        data.getAllUsers().put(u2.getEmail(), u2);
        data.getAllUsers().put(u3.getEmail(), u3);
        data.getAllUsers().put(u4.getEmail(), u4);
        data.getAllUsers().put(r1.getEmail(), r1);
        data.getAllUsers().put(a1.getEmail(), a1);

        Position p1 = CountriesData.portugal;
        Position p2 = new Position(41.57238, -8.47875, 1.5f);
        Traditional tc1 = new Traditional(new GregorianCalendar(2015, 06, 24, 11, 11, 11), "some info", "New in Lisbon", 2, 2.5f, p1, "under the rock", new TreeSet<Log>(), new ArrayList<String>());
        Traditional tc2 = new Traditional(new GregorianCalendar(2015, 06, 19, 9, 12, 47), "more info", "Em Braga", 4, 1.0f, p2, "under the bench", new TreeSet<Log>(), new ArrayList<String>());
        Mystery mc1 = new Mystery(new GregorianCalendar(2015, 06, 25, 2, 3, 4), "more info", "Em Braga", 4, 1.0f, p2, "under the bench", new TreeSet<Log>(), new Position(1.1f, 2.2f), "YOU SOLVED IT!");
        
        Event e1 = new Event(new GregorianCalendar(), new GregorianCalendar(2015,6,2), new GregorianCalendar(2015,6,4), "Evento All Star", "Está tudo a brilhar", new Position(42,51), 5, u1, new HashMap<String,Cache>());
        Event e2 = new Event(new GregorianCalendar(2015,5,2), new GregorianCalendar(2015,5,5), new GregorianCalendar(2015,5,31), "Evento Joker", "Um grande sorriso!!", new Position(82,321), 5, u2, new HashMap<String,Cache>());
        Event e3 = new Event(new GregorianCalendar(2015,5,4), new GregorianCalendar(2015,4,30), new GregorianCalendar(2015,5,31), "Evento Mais Bonito", "Um grandhe sorriso!!", new Position(282,322), 5, u3, new HashMap<String,Cache>());
        Event e4 = new Event(new GregorianCalendar(2015,5,4), new GregorianCalendar(2015,3,30), new GregorianCalendar(2015,4,31), "Evento de Hoje", "Tudo a jogar!!", new Position(82,32), 5, u1, new HashMap<String,Cache>());
        
        e1.addCache(tc1);
        e1.addCache(tc2);
        e1.addCache(mc1);
        
        data.getEnabledEvents().put(e1.getCacheID(), e1);
        data.getEnabledEvents().put(e2.getCacheID(), e2);
        data.getEnabledEvents().put(e3.getCacheID(), e3);
        data.getEnabledEvents().put(e4.getCacheID(), e4);
        
        u1.createCache(tc1);
        u2.createCache(tc2);
        u1.createCache(mc1);

        r1.giveMeCache(tc1);
        r1.giveMeCache(tc2);
        r1.giveMeCache(mc1);

        r1.publishCache(tc1);
        r1.publishCache(tc2);
        r1.publishCache(mc1);

        tc1.setPublishDate(new GregorianCalendar(2015, 06, 24, 11, 22, 9));
        tc1.setPublishDate(new GregorianCalendar(2015, 06, 20, 1, 2, 8));
        tc1.setPublishDate(new GregorianCalendar(2015, 06, 26, 23, 34, 17));

        Log log1 = new Log("FTF!", new GregorianCalendar(2015, 06, 26, 21, 00, 00), Log.Log_Type.FOUND_IT);
        Log log2 = new Log("STF!", new GregorianCalendar(2015, 06, 26, 21, 11, 22), Log.Log_Type.FOUND_IT);
        Log log3 = new Log("Found it, easy!", new GregorianCalendar(2015, 06, 19, 21, 05, 00), Log.Log_Type.FOUND_IT);
        Log log4 = new Log("Just remove the top", new GregorianCalendar(2015, 06, 21, 10, 23, 47), Log.Log_Type.FOUND_IT);
        Log log5 = new Log("Hard to solve tge Enigma but easier to find the cache", new GregorianCalendar(2015, 06, 25, 10, 23, 47), Log.Log_Type.FOUND_IT);

        Log note1 = new Log("Watch out for muggles!", new GregorianCalendar(2015, 06, 26, 21, 00, 00), Log.Log_Type.NOTE);
        tc1.logCache(u2, log1);
        tc1.logCache(u1, note1);
        tc1.logCache(u3, log2);
        tc2.logCache(u4, log3);
        tc2.logCache(u1, log4);
        mc1.logCache(u2, log5);

        u1.newFriendship(u2);
        u2.newFriendship(u3);
        u3.newFriendship(u4);

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

    private static void mEditLog(Log log) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void pressAnyKeyToContinue() {
        System.out.println("Press any key to continue...");
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }

}

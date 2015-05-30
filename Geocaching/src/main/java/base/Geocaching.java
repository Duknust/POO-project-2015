package base;

import caches.Cache;
import caches.Log;
import caches.Log.Log_Type;
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
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.SortedSet;
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

        //data = startData();
        data = populateData(); // Use Pre-Made Database _ Atention, use with caution ! ---------------------------------------------
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

        while (choice == -1) {
            int i = 1;
            SortedSet<Cache> arrayCaches = data.getCachesFoundFrom(user);
            String format = "\t[ %" + (arrayCaches.size() + "").length() + "d ] ";
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
            System.out.println(cache.toListing());

            if (cache.getOwner() != (User) userOnline) {
                Log_Type logt = cache.getFoundStatus((User) userOnline);
                if (logt == null) {
                    System.out.println("- Found Status = None\n");
                } else {
                    System.out.println("- Found Status = " + cache.getFoundStatus((User) userOnline) + "\n");
                }
            }

            // Only Users can do these actions
            System.out.println("-- [1] Log your visit");
            System.out.println("-- [2] View Logs");
            System.out.println("-- [3] View My Logs");
            if (userOnline.getRole() == UserAbstract.Role.USER) { // Only User's have Friends
                System.out.println("-- [4] View Friends Logs");
                user = true;
            }
            System.out.println("-- [5] View Owner");
            if (cache.getType() == Cache.Type.MYSTERY) {
                System.out.println("-- [6] Check Enigma Coordinates");
                mystery = true;
            }

            if (userOnline.equals(cache.getOwner()) || userOnline.equals(cache.getReviewer())) { // Only Owner or Reviewer can see this menu
                System.out.println("------- Admin Tools");

                switch (cache.getCacheStatus()) {

                    case UNPUBLISHED:
                        if (userOnline.equals(cache.getReviewer())) {
                            System.out.println("-- [10] Publish");
                            publish = true;
                            System.out.println("-- [11] Archive");
                            archive = true;
                            System.out.println("-- [12] Disable");
                            disable = true;
                        }
                        break;

                    case DISABLED:
                        System.out.println("-- [11] Archive");
                        archive = true;
                        System.out.println("-- [12] Enable");
                        enable = true;
                        break;

                    case ENABLED:
                        System.out.println("-- [11] Archive");
                        archive = true;
                        System.out.println("-- [12] Disable");
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

                System.out.println("-- [13] Edit Cache");
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
                    clearConsole();
                    mLogCache(cache);
                    choice = -1;
                    break;
                case 2:
                    clearConsole();
                    mLogs(cache);
                    clearConsole();
                    choice = -1;
                    break;
                case 3:
                    clearConsole();
                    mLogs((User) userOnline, cache);
                    clearConsole();
                    choice = -1;
                    break;
                case 4:
                    if (user == true) {
                        clearConsole();
                        mLogsFriends((User) userOnline, cache);
                        clearConsole();
                    }
                    choice = -1;
                    break;
                case 5:
                    clearConsole();
                    mViewUser((User) cache.getOwner());
                    clearConsole();
                    choice = -1;
                    break;
                case 6:
                    if (mystery == true) {
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
                case 10:
                    if (publish == true) {
                        clearConsole();
                        ((Reviewer) userOnline).publishCache(cache);
                        clearConsole();
                    }
                    choice = -1;
                    break;
                case 11:
                    if (archive == true) {
                        clearConsole();
                        ((User) userOnline).archiveCache(cache);
                        clearConsole();
                    }
                    choice = -1;
                    break;
                case 12:
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
                case 13:
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

    private static void mLogCache(Cache cache) {
        int choice = -1;
        Log_Type type;
        while (choice == -1) {

            System.out.println("####### Log your visit at " + cache.getCacheTitle() + " #######\n");

            System.out.println(" [1] Found It\n");
            System.out.println(" [2] DNF\n");
            System.out.println(" [3] Needs Maintenance\n");
            System.out.println(" [4] Needs Archiving\n");
            System.out.println(" [5] Note\n");

            // Reviewer
            System.out.println("-----");
            System.out.println("-- [0] Back");

            System.out.println("-- Choose the Log Type:");
            while (choice == -1) {
                type = null;
                System.out.print("?> ");
                try {
                    choice = Integer.parseInt(input.readLine());
                } catch (Exception ex) {
                    //System.out.println("Error: Invalid Option");
                    choice = -1;
                }

                switch (choice) {
                    case 1:
                        type = Log_Type.FOUND_IT;
                        break;
                    case 2:
                        type = Log_Type.DNF;
                        break;
                    case 3:
                        type = Log_Type.NEEDS_MAINTENANCE;
                        break;
                    case 4:
                        type = Log_Type.NEEDS_ARCHIVING;
                        break;
                    case 5:
                        type = Log_Type.NOTE;
                        break;
                    case 0:
                        break;
                    default:
                        choice = -1;
                        System.out.println("Error: Invalid Option");
                        break;
                }
                if (type != null) {
                    String text = "";
                    boolean bText = false;
                    System.out.println("-- Type the Log");
                    while (bText == false) {
                        System.out.print("?> ");
                        try {
                            text = input.readLine();
                            bText = true;
                        } catch (Exception ex) {
                            System.out.println("Error: Invalid Option");
                        }
                        if (text.trim().length() < 1) {
                            System.out.println("Error: You have to type something!");
                        }
                    }
                    Log newLog = new Log(text, new GregorianCalendar(), type);
                    cache.logCache((User) userOnline, newLog);
                    System.out.println("Cache Successfully Logged!");
                    pressAnyKeyToContinue();
                }
            }
        }
    }

    private static void mLogsFriends(User user, Cache cache) {
        int choice = -1;
        TreeSet<Log> setLogs = cache.getFriendsLogs(user);
        String format = "  [ %" + (setLogs.size() + "").length() + "d ]";
        while (choice == -1) {
            System.out.println("####### '" + cache.getCacheTitle() + "' - Friend's Logs #######\n");

            int i = 1;
            for (Log log : setLogs)// For each Log
            {
                System.out.format(format + "\n" + log.toLogListing() + "\n", i);
                i++;
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

    private static void mLogs(User user, Cache cache) {
        int choice = -1;
        TreeSet<Log> setLogs = cache.getLogs(user);
        String format = "  [ %" + (setLogs.size() + "").length() + "d ]";
        while (choice == -1) {
            System.out.println("####### '" + cache.getCacheTitle() + "' - Logs #######\n");

            int i = 1;
            for (Log log : setLogs)// For each Log
            {
                System.out.format(format + "\n" + log.toLogListing() + "\n", i);
                i++;
            }
            if (i == 1) {
                System.out.println("-- You have no Logs for this cache!");
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

            if ((userOnline.equals(cache.getOwner()) && log.getUser().equals(userOnline)) || // If I am the Owner and I made this Log then I can Edit and Delete this Log
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

    private static void mEditLog(Log log) {
        int choice = -1;
        while (choice == -1) {

            System.out.println("####### Edit " + log.getUser().getName() + "'s Log #######\n");
            System.out.println("\n" + log.toLogListing() + "\n");

            System.out.println("-- [1] Edit Text");
            System.out.println("-- [2] Edit Log Type");

            System.out.println("-----");
            System.out.println("-- [0] Back");
            System.out.print("?> ");
            try {
                choice = Integer.parseInt(input.readLine());
            } catch (Exception ex) {
                //System.out.println("Error: Invalid Option");
                choice = -1;
            }
            boolean edited;
            switch (choice) {
                case 1:
                    String text = null;
                    edited = false;
                    while (edited == false) {
                        System.out.println("\n\n- Type the new Log Text:");
                        System.out.print("?> ");
                        try {
                            text = input.readLine();
                        } catch (Exception ex) {
                            //System.out.println("Error: Invalid Option");
                            text = null;
                        }
                        if (text != null) {
                            log.setLog(text);
                            System.out.println("Log Text edited successfully!");
                            pressAnyKeyToContinue();
                            edited = true;
                        } else {
                            System.out.println("ERROR: Please type again.");
                            pressAnyKeyToContinue();
                        }
                    }
                    clearConsole();

                    choice = -1;
                    break;
                case 2:
                    Log_Type type = log.getLogType();
                    edited = false;
                    boolean foundit = false,
                     dnf = false,
                     needm = false,
                     needa = false,
                     note = false;
                    while (edited == false) {
                        System.out.println("\n\n- Log Types:");

                        // FOUND_IT, DNF, NEEDS_MAINTENANCE, NEEDS_ARCHIVING, NOTE, REVIEWER_NOTE, ARCHIVED, ENABLED, DISABLED;
                        if (type != Log_Type.FOUND_IT) {
                            System.out.println(" [1] Found It\n");
                            foundit = true;
                        }
                        if (type != Log_Type.DNF) {
                            System.out.println(" [2] DNF\n");
                            dnf = true;
                        }
                        if (type != Log_Type.NEEDS_MAINTENANCE) {
                            System.out.println(" [3] Needs Maintenance\n");
                            needm = true;
                        }
                        if (type != Log_Type.NEEDS_ARCHIVING) {
                            System.out.println(" [4] Needs Archiving\n");
                            needa = true;
                        }
                        if (type != Log_Type.NOTE) {
                            System.out.println(" [5] Note\n");
                            note = true;
                        }

                        System.out.println("\n-- [X] Choose the new Log Type:");
                        System.out.println("-----");
                        System.out.println("-- [0] Back");
                        int ntype;
                        System.out.print("?> ");
                        try {
                            ntype = Integer.parseInt(input.readLine());
                        } catch (Exception ex) {
                            //System.out.println("Error: Invalid Option");
                            ntype = 0;
                        }

                        switch (ntype) {
                            case 1:
                                if (foundit) {
                                    log.setLogType(Log_Type.FOUND_IT);
                                    edited = true;
                                    // If now is a FOUND IT then increase user's total founds
                                    log.getUser().incTotalFound();
                                }
                                break;
                            case 2:
                                if (dnf) {
                                    if (type == Log_Type.FOUND_IT)// If it was a FOUND IT then decrease user's total founds
                                    {
                                        log.getUser().decTotalFound();
                                    }
                                    log.setLogType(Log_Type.DNF);
                                    edited = true;
                                }
                                break;
                            case 3:
                                if (needm) {
                                    if (type == Log_Type.FOUND_IT)// If it was a FOUND IT then decrease user's total founds
                                    {
                                        log.getUser().decTotalFound();
                                    }
                                    log.setLogType(Log_Type.NEEDS_MAINTENANCE);
                                    edited = true;
                                }
                                break;
                            case 4:
                                if (needa) {
                                    if (type == Log_Type.FOUND_IT)// If it was a FOUND IT then decrease user's total founds
                                    {
                                        log.getUser().decTotalFound();
                                    }
                                    log.setLogType(Log_Type.NEEDS_ARCHIVING);
                                    edited = true;
                                }
                                break;
                            case 5:
                                if (note) {
                                    if (type == Log_Type.FOUND_IT)// If it was a FOUND IT then decrease user's total founds
                                    {
                                        log.getUser().decTotalFound();
                                    }
                                    log.setLogType(Log_Type.NOTE);
                                    edited = true;
                                }
                                break;
                            default:
                                System.out.println("ERROR: Please choose again.");
                                pressAnyKeyToContinue();
                                break;
                        }
                        if (edited) {
                            System.out.println("Log Type edited successfully!");
                            pressAnyKeyToContinue();
                        }

                    }
                    clearConsole();

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
    public static Data startData() {

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
    private static Data populateData() {
        Data newData = new Data();
        User u1 = new User("1", "1", "Ulisses", "M", "rua", new GregorianCalendar(2000, 1, 24, 11, 11, 11), true, 0, null, null, newData);
        User u2 = new User("2", "2", "Uche Villareal", "M", "rua", new GregorianCalendar(1982, 2, 2, 11, 11, 11), false, 0, null, null, newData);
        User u3 = new User("3", "3", "Ukra", "M", "rua", new GregorianCalendar(1992, 3, 29, 11, 11, 11), false, 0, null, null, newData);
        User u4 = new User("4", "4", "Uruguaio", "M", "rua", new GregorianCalendar(2001, 8, 13, 11, 11, 11), false, 0, null, null, newData);
        Reviewer r1 = new Reviewer("r", "r", "Rickon", "M", "rua", new GregorianCalendar(1968, 1, 24, 11, 11, 11), false, 0, null, null, newData);
        Admin a1 = new Admin("a", "a", "Aemon", "M", "rua", new GregorianCalendar(1987, 7, 14, 11, 11, 11), false, 0, null, null, newData);

        newData.getAllUsers().put(u1.getEmail(), u1);
        newData.getAllUsers().put(u2.getEmail(), u2);
        newData.getAllUsers().put(u3.getEmail(), u3);
        newData.getAllUsers().put(u4.getEmail(), u4);
        newData.getAllUsers().put(r1.getEmail(), r1);
        newData.getAllUsers().put(a1.getEmail(), a1);

        Position p1 = CountriesData.portugal;
        Position p2 = new Position(41.57238, -8.47875, 1.5f);
        Traditional tc1 = new Traditional(new GregorianCalendar(2015, 06, 24, 11, 11, 11), "some info", "New in Lisbon", 2, 2.5f, p1, "under the rock", new TreeSet<Log>(), new ArrayList<>());
        Traditional tc2 = new Traditional(new GregorianCalendar(2015, 06, 19, 9, 12, 47), "more info", "Em Braga", 4, 1.0f, p2, "climb!", new TreeSet<Log>(), new ArrayList<>());
        Mystery mc1 = new Mystery(new GregorianCalendar(2015, 06, 25, 2, 3, 4), "church", "Sameiro", 4, 1.0f, p2, "magnetic", new TreeSet<Log>(), new Position(1.1f, 2.2f), "YOU SOLVED IT!");

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
        return newData;
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

    private static void pressAnyKeyToContinue() {
        System.out.println("Press any key to continue...");
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }

}

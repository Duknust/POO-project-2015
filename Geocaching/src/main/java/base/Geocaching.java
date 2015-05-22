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

        //populateData(data);
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
            System.out.println("Program exit successfully!");
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
                System.out.println("Error: Invalid Option");
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
    private static void mViewFriend(User friend) {
        int choice = -1;
        while (choice == -1) {
            System.out.println("####### " + friend.getName() + " Profile #######\n");
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
                    System.out.println("Friendship with " + friend.getName() + " has been Removed!");
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

    private static void mViewActivities(User friend) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void mViewStatistics(User friend) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void mViewFoundCaches(User friend) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static void mViewOwnedCaches(User friend) {
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
            //  Handle any exceptions.
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
            return false;
        }
        return true;
    }

    // Pre-Made Dataset
    private static void populateData(Data data) {

        User u1 = new User("1", "1", "Ulisses", "M", "rua", new GregorianCalendar(), true, 0, null, null, data);
        User u2 = new User("y@y.com", "12345", "Uche Villareal", "M", "rua", new GregorianCalendar(), false, 0, null, null, data);
        Reviewer r1 = new Reviewer("x1@x.com", "12345", "Rickon", "M", "rua", new GregorianCalendar(), false, 0, null, null, data);
        Admin a1 = new Admin("x2@x.com", "12345", "Aemon", "M", "rua", new GregorianCalendar(), false, 0, null, null, data);

        data.getAllUsers().put(u1.getEmail(), u1);
        data.getAllUsers().put(u2.getEmail(), u2);
        data.getAllUsers().put(r1.getEmail(), r1);
        data.getAllUsers().put(a1.getEmail(), a1);

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

}

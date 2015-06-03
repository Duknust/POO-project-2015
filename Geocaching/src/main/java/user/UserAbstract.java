package user;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.Objects;

public abstract class UserAbstract implements Serializable {

    public enum Role {

        ADMIN, REVIEWER, USER, DEFAULT;

        @Override
        public String toString() {
            switch (this) {
                case ADMIN:
                    return "Administrator";
                case REVIEWER:
                    return "Reviewer";
                case USER:
                    return "User";
                case DEFAULT:
                    return "";
                default:
                    throw new IllegalArgumentException();
            }
        }
    }
    private final String email;
    private byte[] password;
    private String name;
    private String gender;
    private String address;
    private GregorianCalendar birthDate;
    private boolean premium;
    private int totalFound;

    // Constructors
    public UserAbstract(String email, String password, String name, String gender, String address, GregorianCalendar birthDate, boolean premium, int totalFound) {
        this.email = email;
        this.password = getHash(password);
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.birthDate = birthDate;
        this.premium = premium;
        this.totalFound = totalFound;
    }

    // Getters and Setters
    public String getEmail() {
        return email;
    }

    /* // Should be Impossible to change email
     public void setEmail(String email) {
     this.email = email;
     }*/
    public byte[] getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = getHash(password);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public GregorianCalendar getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(GregorianCalendar birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public int getTotalFound() {
        return totalFound;
    }

    public void setTotalFound(int totalFound) {
        this.totalFound = totalFound;
    }

    // Methods
    private byte[] getHash(String password) { //SHA-256
        byte byteData[] = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes());

            byteData = md.digest();

        } catch (NoSuchAlgorithmException ex) {
            return null;
        }
        return byteData;
    }

    public boolean login(String email, String password) {
        return this.getEmail().equals(email) && Arrays.equals(this.getPassword(), getHash(password));
    }

    public boolean checkPassword(String text) {
        return Arrays.equals(this.getPassword(), getHash(text));
    }

    public static String formatDate(GregorianCalendar calendar) {
        if (calendar == null) {
            return "-/-/-";
        }
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        fmt.setCalendar(calendar);
        return fmt.format(calendar.getTime());
    }

    public void incTotalFound() {
        this.totalFound++;
    }

    public void decTotalFound() {
        this.totalFound--;
    }

    // toString
    // Needs to be Overrided
    public Role getRole() {
        return Role.DEFAULT;
    }

    public String toString() {
        return name + " (" + totalFound + ")" + (premium ? " Premium" : "");
    }

    public String toStringTotal() {
        return "E-Mail - " + email
                + "\nName - " + name
                + "\nGender - " + gender
                + "\nAddress - " + address
                + "\nBirth Date - " + formatDate(birthDate)
                + "\nPremium - " + premium
                + "\nTotal Found - " + totalFound;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UserAbstract other = (UserAbstract) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }

}

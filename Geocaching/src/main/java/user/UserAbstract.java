package user;

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.Objects;

public abstract class UserAbstract implements Serializable {

    private String email;
    private String password;
    private String name;
    private String gender;
    private String address;
    private GregorianCalendar birthDate;
    private boolean premium;
    private int totalFound;

    // Constructors
    public UserAbstract(String email, String password, String name, String gender, String address, GregorianCalendar birthDate, boolean premium, int totalFound) {
        this.email = email;
        this.password = password;
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
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
    public boolean login(String email, String password) {
        return this.getEmail().equals(email) && this.getPassword().equals(password);
    }

    // toString
    @Override
    public String toString() {
        return "'" + name + " (" + totalFound + ")'" + (premium ? " Premium" : "");
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

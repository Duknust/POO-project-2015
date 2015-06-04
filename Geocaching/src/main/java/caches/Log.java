package caches;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import user.UserAbstract;

public class Log implements Comparable, Serializable {

    /*
     Who can log ?

     | Cache State | Owner/Reviewer |  Regular User  |
     |             |  View |  Write |  View |  Write |
     |-------------|-------|--------|-------|--------|
     | Archived    |  Yes  |  Notes |  Yes  |  Notes |
     | Enabled     |  Yes  |  Yes   |  Yes  |  Notes |
     | Disabled    |  Yes  |  Notes |  Yes  |  Notes |
     | Unpublished |  Yes  | RNotes |   No  |   No   |


     */
    public enum Log_Type {

        FOUND_IT, DNF, NEEDS_MAINTENANCE, REVIEWER_NOTE, NEEDS_ARCHIVING, NOTE, ARCHIVED, ENABLED, DISABLED;

        @Override
        public String toString() {
            switch (this) {
                case FOUND_IT:
                    return "Found it";
                case DNF:
                    return "Didn't find it";
                case NEEDS_MAINTENANCE:
                    return "Needs Maintenance";
                case REVIEWER_NOTE:
                    return "Reviewer Note";
                case NEEDS_ARCHIVING:
                    return "Needs Archiving";
                case NOTE:
                    return "Note";
                case ARCHIVED: // Automatic Log
                    return "Archived";
                case DISABLED: // Automatic Log
                    return "Disabled";
                case ENABLED: // Automatic Log
                    return "Enabled Listing";
                default:
                    return "";
            }
        }
    }

    private UserAbstract user = null;
    private String log = "";
    private GregorianCalendar date;
    private Log_Type logType;

    // Constructors
    public Log(UserAbstract user, String log, GregorianCalendar date, Log_Type logType) {
        this.user = user;
        this.log = log;
        this.logType = logType;
        this.date = date;
    }

    public Log(String log, GregorianCalendar date, Log_Type logType) {
        this.user = null;
        this.log = log;
        this.logType = logType;
        this.date = date;
    }

    // Getters and Setters
    public UserAbstract getUser() {
        return user;
    }

    public void setUser(UserAbstract user) {
        this.user = user;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    public Log_Type getLogType() {
        return logType;
    }

    public void setLogType(Log_Type logType) {
        this.logType = logType;
    }

    // toString
    @Override
    public String toString() {
        SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        timeFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        String date_str = timeFormat.format(date.getTime());
        return " "
                + user
                + "\nDate="
                + date_str
                + "\nLog = "
                + log;
    }

    public String toLogListing() {
        SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        timeFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        String date_str = timeFormat.format(this.date.getTime());
        return " - Log Type: " + this.logType + "\n"
                + " -     User: " + this.user.getName() + "\n"
                + " -     Date: " + date_str + "\n"
                + " -      Log: " + this.log;
    }

    @Override
    public int compareTo(Object o) {

        // compareTo should return < 0 if this is supposed to be
        // less than other, > 0 if this is supposed to be greater than
        // other and 0 if they are supposed to be equal
        return -((Log) o).getDate().compareTo(this.getDate()); // Minus because the more recent logs need to be the first to be shown
    }

}

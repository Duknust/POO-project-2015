package caches;

import java.util.GregorianCalendar;
import user.UserAbstract;

public class Log {

    public enum Log_Type {

        FOUND_IT, DNF, NEEDS_MAINTENANCE, REVIEWER_NOTE, NEEDS_ARCHIVING, ARCHIVE, NOTE, UPDATED_CACHE;

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
                case ARCHIVE:
                    return "Archive";
                case NOTE:
                    return "Note";
                case UPDATED_CACHE:
                    return "Cache Updated";
                default:
                    throw new IllegalArgumentException();
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

    // toString
    @Override
    public String toString() {
        return " "
                + user
                + "\nDate="
                + date
                + "\nLog = "
                + log;
    }

}

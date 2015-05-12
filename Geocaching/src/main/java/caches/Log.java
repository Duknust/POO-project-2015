package caches;

import java.util.GregorianCalendar;
import user.UserAbstract;

public class Log {

    public enum Trackable_State {

        VISITED, DROPPED, NO_ACTION, NONE, REMOVED;

        @Override
        public String toString() {
            switch (this) {
                case VISITED:
                    return "Visited";
                case DROPPED:
                    return "Was Dropped";
                case NO_ACTION:
                    return "No Action";
                case NONE:
                    return "None";
                case REMOVED:
                    return "Removed";
                default:
                    throw new IllegalArgumentException();
            }
        }
    }

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
    private String trackable = "";
    private Trackable_State trackable_state = Trackable_State.NO_ACTION;
    private GregorianCalendar date;
    private Log_Type logType;

    // Constructors
    public Log(UserAbstract user, String log, String trackable,
            Trackable_State trackable_state, GregorianCalendar date, Log_Type logType) {
        this.user = user;
        this.log = log;
        this.logType = logType;

        this.trackable_state = trackable_state;
        if (trackable_state == Trackable_State.NONE) // If the trackable
        // has no action
        {
            this.trackable = ""; // Then none was referenced
        } else {
            this.trackable = trackable; // Else reference the Trackable
        }
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

    public String getTrackable() {
        return trackable;
    }

    public void setTrackable(String trackable) {
        this.trackable = trackable;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    public Trackable_State getTrackable_state() {
        return trackable_state;
    }

    public void setTrackable_state(Trackable_State trackable_state) {
        this.trackable_state = trackable_state;
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
                + log
                + (trackable_state.NO_ACTION == this.trackable_state ? "\n"
                        : "\nTrackable='" + trackable + '\'' + " "
                        + trackable_state);
    }

}

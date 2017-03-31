package bi.internal.education.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

/**
 * Created by squeezya on 15/02/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Userbi {
    private String firstName;
    private String lastName;
    private int isUserOnCall;
    private Date lastOnlineTime;
    private Date lastLoginDate;
    private String email;
    private String username;

    public Userbi() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getIsUserOnCall() {
        return isUserOnCall;
    }

    public void setIsUserOnCall(int isUserOnCall) {
        this.isUserOnCall = isUserOnCall;
    }

    public Date getLastOnlineTime() {
        return lastOnlineTime;
    }

    public void setLastOnlineTime(Date lastOnlineTime) {
        this.lastOnlineTime = lastOnlineTime;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Userbi{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", isUserOnCall=" + isUserOnCall +
                ", lastOnlineTime=" + lastOnlineTime +
                ", lastLoginDate=" + lastLoginDate +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}

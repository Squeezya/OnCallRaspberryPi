package bi.internal.education.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

/**
 * Created by squeezya on 15/02/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OnCallResponse {
    private int isAnyUserOnCall;
    private ArrayList<Userbi> usersOnCall;

    public OnCallResponse() {
    }

    public int getIsAnyUserOnCall() {
        return isAnyUserOnCall;
    }

    public void setIsAnyUserOnCall(int isAnyUserOnCall) {
        this.isAnyUserOnCall = isAnyUserOnCall;
    }

    public ArrayList<Userbi> getUsersOnCall() {
        return usersOnCall;
    }

    public void setUsersOnCall(ArrayList<Userbi> usersOnCall) {
        this.usersOnCall = usersOnCall;
    }

    @Override
    public String toString() {
        return "OnCallResponse{" +
                "isAnyUserOnCall=" + isAnyUserOnCall +
                ", usersOnCall=" + usersOnCall +
                '}';
    }
}

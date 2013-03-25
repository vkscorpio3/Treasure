/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Excel;

import java.util.ArrayList;

/**
 *
 * @author eswar@vaannila.com
 */
public class UserData {

    private String userName;
    private String emailId;
    private String location;

    public UserData()
    {

    }

    public UserData(String userName, String emailId, String location)
    {
        this.userName = userName;
        this.emailId = emailId;
        this.location = location;
    }

    public ArrayList loadData()
    {
        ArrayList userList = new ArrayList();
        userList.add(new UserData("Michael Scott","michael.scott@dundermifflin.com","Scraton Pennsylvania"));
        userList.add(new UserData("Dwight Schrute","dwight.schrute@dundermifflin.com","Scraton Pennsylvania"));
        userList.add(new UserData("Jim Halpert","jim.halpert@dundermifflin.com","Scraton Pennsylvania"));
        userList.add(new UserData("Pam Beesly","pam.beesly@dundermifflin.com","Scraton Pennsylvania"));
        userList.add(new UserData("Andy Bernad","andy.bernad@dundermifflin.com","Scraton Pennsylvania"));
        userList.add(new UserData("Angela Martin","angela.martin@dundermifflin.com","Scraton Pennsylvania"));
        return userList;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @return the emailId
     */
    public String getEmailId() {
        return emailId;
    }

    /**
     * @return the locaiton
     */
    public String getLocation() {
        return location;
    }

}

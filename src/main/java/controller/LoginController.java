package controller;

import entities.User;
import entities.UserData;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.security.MessageDigest;


public class LoginController {

    public String getPasswordHash(String password) {
        MessageDigest messageDigest;
        String stringHash=null;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(password.getBytes());
            stringHash = new String(messageDigest.digest());
            return stringHash;
        } catch (Exception ex) {

        }
        return stringHash;

    }

    public List<String> getLoginInformation() {
        List<String> loginInformation = new ArrayList<String>();
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter Username: ");
            String username = sc.next();
            System.out.println("Enter Password: ");
            String password = sc.next();
            loginInformation.add(username);
            loginInformation.add(password);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
        return loginInformation;
    }

    /////////////////////
    public boolean verifylogin(String username, String password) {
        List<User> userList = new ArrayList<User>();
        userList = new UserData().getUserList();
        for (User user : userList) {
            String pass = getPasswordHash(password);
            if ((user.getEmail().equals(username)) && user.getPassword().equals(pass)) {
                return true;
            } else {
                return false;

            }
        }
        return false;

    }

}

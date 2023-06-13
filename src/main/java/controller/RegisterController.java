package controller;

import entities.User;
import entities.UserData;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class RegisterController {

    Scanner sc = new Scanner(System.in);

    public void makeRegistration() {
        HashMap<String, String> registerInformation = new HashMap<String, String>();
        User user = new User();
        boolean status = false;
        String email = null;
        System.out.println("Register as a\n1.Normal User\n2.Futsal Owner\n3.Admin\nSelect: ");
        try {
            int ch = sc.nextInt();
            if (ch == 1 || ch == 2 || ch == 3) {
                registerInformation = new RegisterController().getRegistrationInformation();
            }
            switch (ch) {
                case 1:
                    registerInformation.put("type", "user");
                    email = registerInformation.get("email");
                    if (checkIfEmailExist(email)) {
                        System.out.println("User Already registered");
                    } else {
                        List<String> messages = new ValidationController().validateUserRegistration(registerInformation);
                        if ((messages.size()) > 0) {
                            for (String msg : messages) {
                                System.out.println(msg);
                            }
                        } else {
                            status = new UserData().addUser(registerInformation);
                            if (status) {
                                System.out.println("User added Successfully");
                            } else {
                                System.out.println("User registration failed");
                            }
                        }
                    }

                    break;
                case 2:
                    registerInformation.put("type", "futsalowner");
                    email = registerInformation.get("email");
                    if (checkIfEmailExist(email)) {
                        System.out.println("User Already registered");
                    } else {
                        List<String> messages = new ValidationController().validateUserRegistration(registerInformation);
                        if ((messages.size()) > 0) {
                            for (String msg : messages) {
                                System.out.println(msg);
                            }
                        } else {
                            status = new UserData().addUser(registerInformation);
                            if (status) {
                                System.out.println("Futsal Owner Successfully");
                            } else {
                                System.out.println("User registration failed");
                            }
                        }
                    }
                    break;
                case 3:
                    registerInformation.put("type", "admin");
                    email = registerInformation.get("email");
                    if (checkIfEmailExist(email)) {
                        System.out.println("User Already registered");
                    } else {
                        List<String> messages = new ValidationController().validateUserRegistration(registerInformation);
                        if ((messages.size()) > 0) {
                            for (String msg : messages) {
                                System.out.println(msg);
                            }
                        } else {
                            status = new UserData().addUser(registerInformation);
                            if (status) {
                                System.out.println("Admin added Successfully");
                            } else {
                                System.out.println("User registration failed");
                            }
                        }
                    }
                    break;

            }

        } catch (Exception ex) {

        }

    }

    /////////////////////////////////////////////////
    public HashMap<String, String> getRegistrationInformation() {
        HashMap<String, String> registerInformation = new HashMap<String, String>();
        try {

            System.out.println("Enter Id: ");
            BigDecimal id = sc.nextBigDecimal();
            sc.nextLine();

            System.out.println("Enter Email: ");
            String email = sc.next();

            System.out.println("Enter firstname: ");
            String firstname = sc.next();
            sc.nextLine();

            System.out.println("Enter midname: ");
            String midname = sc.nextLine();
            if (midname.equalsIgnoreCase("null")) {
                midname = null;
            }

            System.out.println("Enter lastname: ");
            String lastname = sc.next();

            System.out.println("Enter mobile: ");
            BigInteger mobile = sc.nextBigInteger();
            sc.nextLine();

            System.out.println("Enter password: ");
            String password = sc.next();

            registerInformation.put("id", id.toString());
            registerInformation.put("email", email);
            registerInformation.put("firstname", firstname);
            registerInformation.put("midname", midname);
            registerInformation.put("lastname", lastname);
            registerInformation.put("mobile", mobile.toString());
            registerInformation.put("password", password);

            return registerInformation;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
        return registerInformation;
    }
    ////////////////////////////////////////////////////////

    public User setRegistrationInformation(HashMap<String, String> registerInformation) {
        User user = new User();
        user.setId(new BigDecimal(registerInformation.get("id")));
        user.setType(registerInformation.get("type"));
        user.setEmail(registerInformation.get("email"));
        user.setFirstname(registerInformation.get("firstname"));
        user.setMidname(registerInformation.get("midname"));
        user.setLastname(registerInformation.get("lastname"));
        user.setMobile(new BigInteger(registerInformation.get("mobile")));
        user.setPassword(registerInformation.get("password"));
        return user;
    }

    public boolean checkIfEmailExist(String email) {
        List<User> userList = new UserData().getUserList();
        for (User user : userList) {
            if (user.getEmail().equals(email)) {
                return true;
            }

        }
        return false;
    }

}

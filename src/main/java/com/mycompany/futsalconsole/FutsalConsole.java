package com.mycompany.futsalconsole;

import controller.LoginController;
import controller.RegisterController;
import entities.User;
import entities.UserData;
import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class FutsalConsole {

    public static void main(String[] args) {
        boolean flag = true;
        Scanner sc = new Scanner(System.in);
        System.out.println("*******************************\n\n");
        System.out.println("!!! WELCOME TO  FUTSAL !!!\n\n");
        System.out.println("*******************************\n");
        while(flag){
        System.out.println("\nWhat do you want?\n1.Register\n2.Login\n3.Exit\nSelect: ");
        try {
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    new RegisterController().makeRegistration();
                    break;
                case 2:
                    List<String> loginInformation = new ArrayList<String>();
                    loginInformation = new LoginController().getLoginInformation();
                    String username = loginInformation.get(0);
                    String password = loginInformation.get(1);
                    username = username.toLowerCase();
                    boolean status = new LoginController().verifylogin(username, password);
                    if (status) {
                        HashMap<String,String> user = new UserData().getUserByEmail(username);
                        String type = user.get("type");
                        if("admin".equals(type)){
                            
                        }
                        else if("futsalowner".equals(type)){
                            
                        }
                        else if("user".equals(type)){
                            
                        }
                    } else {
                        System.out.println("Invalid Credentials");
                    }
                    break;
                case 3:
                    flag=false;
                    exit(0);
                    break;
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        }

        List<User> userlist = new UserData().getUserList();
        for (User list : userlist) {
            System.out.println(list);
        }
    }
}

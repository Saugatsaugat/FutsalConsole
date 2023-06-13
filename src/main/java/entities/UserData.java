package entities;

import controller.LoginController;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserData<T> {

    static List<User> userList = new ArrayList<User>();

    public boolean addUser(HashMap<String, String> registerInformation) {
        User user = new User();
        user.setId(new BigDecimal(registerInformation.get("id")));
        user.setType(registerInformation.get("type"));
        user.setEmail(registerInformation.get("email"));
        user.setFirstname(registerInformation.get("firstname"));
        user.setMidname(registerInformation.get("midname"));
        user.setLastname(registerInformation.get("lastname"));
        user.setMobile(new BigInteger(registerInformation.get("mobile")));
        String pass = registerInformation.get("password");
        String password = new LoginController().getPasswordHash(pass);
        user.setPassword(password);
        if (!userList.add(user)) {
            return false;
        }

        return true;

    }

    ////////////////////////////////////
    public List<User> getUserList() {
        return userList;
    }

    //////////////////////////////////////
    public HashMap<String, String> getUserByEmail(String email) {
        HashMap<String, String> user = new HashMap<String, String>();
        for (User list : userList) {
            if (list.getEmail().equals(email)) {
                user.put("Id", list.getId().toString());
                user.put("type", list.getType());
                user.put("firstname", list.getFirstname());
                user.put("midname", list.getMidname());
                user.put("lastname", list.getLastname());
                user.put("email", list.getEmail());
                user.put("mobile", list.getMobile().toString());
            }

        }
        return user;
    }

    ///////////////////////////////////////
   

}

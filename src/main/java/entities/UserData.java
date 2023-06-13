
package entities;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserData {
    static List<User> userList = new ArrayList<User>();

    public boolean addUser(HashMap<String,String> registerInformation){
        User user = new User();
        user.setId(new BigDecimal(registerInformation.get("id")));
        user.setType(registerInformation.get("type"));
        user.setEmail(registerInformation.get("email"));
        user.setFirstname(registerInformation.get("firstname"));
        user.setMidname(registerInformation.get("midname"));
        user.setLastname(registerInformation.get("lastname"));
        user.setMobile(new BigInteger(registerInformation.get("mobile")));
        user.setPassword(registerInformation.get("password"));
        if(!userList.add(user)){
            return false;
        }
       
        return true;
   
      
    }
    public List<User> getUserList(){
        return userList;
    }
   public void printUserList(){
       for (User list : userList) {
            System.out.println("Id:"+list.getId());
            System.out.println("Email:"+list.getEmail());
    }
   }
    
}

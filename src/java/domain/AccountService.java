package domain;

public class AccountService {
    
    private static User adam = new User("adam", "password");
    private static User betty = new User("betty", "password");
    
    public User login(String username, String password){
        switch (username){
            case "adam":
                if (password.equals("password")){
                    return adam;
                }
                break;
            case "betty":
                if (password.equals("password")){
                    return betty;
                }
                break;
            }
        return null;
    }
}

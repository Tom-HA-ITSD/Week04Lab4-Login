package domain;

public class AccountService {
    
    private User adam = new User("adam", "password");
    private User betty = new User("betty", "password");
    
    public User login(String username, String password){
        switch (username){
            case "adam":
                if (password.equals(adam.getPassword())){
                    User user = new User();
                    user.setUsername(adam.getUsername());
                    return user;
                }
                break;
            case "betty":
                if (password.equals(betty.getPassword())){
                    User user = new User();
                    user.setUsername(betty.getUsername());
                    return user;
                }
                break;
            }
        return null;
    }
}

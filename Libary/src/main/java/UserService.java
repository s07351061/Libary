public interface UserService {
    boolean registerUser(String phoneNumber, String password, String userName);
    User loginUser(String phoneNumber, String password);
}

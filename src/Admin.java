public class Admin extends User {
    private String secondPassword;

    public Admin(String name, String password){
        super(name,password);
        this.secondPassword = "123456789";

    }

}

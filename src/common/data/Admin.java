package common.data;
public class Admin implements Record{
    String username, password;
    public Admin(String username, String password){
        this.username = username;
        this.password = password;
    }
    public boolean login(String username, String password){
        return this.username.equals(username) && this.password.equals(password);
    }
    @Override
    public String lineRepresentation(){
        return this.username + "," + this.password;
    }

    @Override
    public String getSearchKey(){
        return this.lineRepresentation();
    }
}

package api.payloads;

import lombok.Getter;

public class User {
    @Getter
    public int id;
    @Getter
    public String username;
    @Getter
    public String firstname;
    @Getter
    public String lastname;
    @Getter
    public String email;
    @Getter
    public String password;
    @Getter
    public String userstatus;

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserstatus(String userstatus) {
        this.userstatus = userstatus;
    }



}

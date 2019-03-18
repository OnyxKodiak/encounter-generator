package encountergenerator.models.forms;

import javax.persistence.Entity;

@Entity
public class Users {
    private Integer id;
    private String name;
    private String password;
    private String cratedate;

    public Users(Integer id, String name, String password, String cratedate) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.cratedate = cratedate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCratedate() {
        return cratedate;
    }

    public void setCratedate(String cratedate) {
        this.cratedate = cratedate;
    }
}

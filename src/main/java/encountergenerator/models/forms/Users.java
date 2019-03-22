package encountergenerator.models.forms;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Users {
    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    @Size(min=3, max=15)
    private String name;
    private String password;
    private String cratedate;

    public Users(String name, String password, String cratedate) {
        this.name = name;
        this.password = password;
        this.cratedate = cratedate;
    }

    public Users(){

    }

    public Integer getId() {
        return id;
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

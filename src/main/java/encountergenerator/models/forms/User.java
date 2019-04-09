package encountergenerator.models.forms;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;


@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    @NotBlank
    @Size(min=3, max=15)
    private String name;

    @NotNull
    @NotBlank
    @Size(min=8, max=255)
    private String password;

    private transient String verify;

    @CreatedDate
    private Date cratedate;

    public User(String name, String password, Date cratedate) {
        this.name = name;
        this.password = password;
        this.cratedate = cratedate;
    }

    public User(){

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

    public String getVerify() { return verify; }

    public void setVerify(String verify) { this.verify = verify; }

    public Date getCratedate() {
        return cratedate;
    }

}
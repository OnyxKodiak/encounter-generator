package encountergenerator.models.forms;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;


@Entity
public class Users {
    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    @NotBlank
    @Size(min=3, max=15)
    private String name;

    @NotNull
    @NotBlank
    private String password;

    @NotNull
    @NotBlank
    private String verify;
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @CreatedDate
    private Date cratedate;

    public Users(String name, String password, Date cratedate) {
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

    public String getVerify() { return verify; }

    public void setVerify(String verify) { this.verify = verify; }

    public Date getCratedate() {
        return cratedate;
    }

    private static String hashPassword(String password) {
        return encoder.encode(password);
    }

    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, verify);
    }

}

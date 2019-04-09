package encountergenerator.models.forms;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name="interests")
public class Interest {
    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    @Size(min=3, max=15)
    private String name;
    private String description;
    private String environment;

    private Integer userid;
    private Date createdate;
    private Date updated;
    private Boolean shared;

    public Interest(String name, String description, String environment, Integer userid, Date createdate, Date updated, Boolean shared) {
        this.name = name;
        this.description = description;
        this.environment = environment;
        this.userid = userid;
        this.createdate = createdate;
        this.updated = updated;
        this.shared = shared;
    }

    public Interest(){

    }

    public Integer getId() {
        return id;
    }

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Boolean getShared() {
        return shared;
    }

    public void setShared(Boolean shared) {
        this.shared = shared;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }
}

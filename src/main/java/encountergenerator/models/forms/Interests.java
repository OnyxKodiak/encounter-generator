package encountergenerator.models.forms;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Interests {
    private Integer id;
    private String desc;
    private Integer userid;
    private Date createdate;
    private Date update;
    private Boolean shared;

    public Interests(Integer id, String desc, Integer userid, Date createdate, Date update, Boolean shared) {
        this.id = id;
        this.desc = desc;
        this.userid = userid;
        this.createdate = createdate;
        this.update = update;
        this.shared = shared;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public Date getUpdate() {
        return update;
    }

    public void setUpdate(Date update) {
        this.update = update;
    }

    public Boolean getShared() {
        return shared;
    }

    public void setShared(Boolean shared) {
        this.shared = shared;
    }
}

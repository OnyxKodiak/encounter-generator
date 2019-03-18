package encountergenerator.models.forms;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Treasures {
    private Integer id;
    private String name;
    private String type;
    private Integer value;
    private String desc;
    private Integer userid;
    private Date createdate;
    private Date update;
    private Boolean shared;

    public Treasures(Integer id, String name, String type, Integer value, String desc, Integer userid, Date createdate, Date update, Boolean shared) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.value = value;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
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

package encountergenerator.models.forms;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name="creatures")
public class Creature {

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    @Size(min=3, max=15)
    private String name;

    private String type;
    private Float cr;
    private Integer str;
    private Integer dex;
    private Integer con;
    private Integer intl;
    private Integer wis;
    private Integer cha;
    private Integer ac;
    private Integer hp;
    private String size;
    private String description;
    private Integer userid;
    private Date createdate;
    private Date updated;
    private Boolean shared;

    public Creature(String name, String type, Float cr, Integer str, Integer dex, Integer con, Integer intl, Integer wis, Integer cha, Integer ac, Integer hp, String size, String description, Integer userid, Date createdate, Date updated, Boolean shared) {
        this.name = name;
        this.type = type;
        this.cr = cr;
        this.str = str;
        this.dex = dex;
        this.con = con;
        this.intl = intl;
        this.wis = wis;
        this.cha = cha;
        this.ac = ac;
        this.hp = hp;
        this.size = size;
        this.description = description;
        this.userid = userid;
        this.createdate = createdate;
        this.updated = updated;
        this.shared = shared;
    }

    public Creature(){

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Float getCr() {
        return cr;
    }

    public void setCr(Float cr) {
        this.cr = cr;
    }

    public Integer getStr() {
        return str;
    }

    public void setStr(Integer str) {
        this.str = str;
    }

    public Integer getDex() {
        return dex;
    }

    public void setDex(Integer dex) {
        this.dex = dex;
    }

    public Integer getCon() {
        return con;
    }

    public void setCon(Integer con) {
        this.con = con;
    }

    public Integer getIntl() {
        return intl;
    }

    public void setIntl(Integer intl) {
        this.intl = intl;
    }

    public Integer getWis() {
        return wis;
    }

    public void setWis(Integer wis) {
        this.wis = wis;
    }

    public Integer getCha() {
        return cha;
    }

    public void setCha(Integer cha) {
        this.cha = cha;
    }

    public Integer getAc() {
        return ac;
    }

    public void setAc(Integer ac) {
        this.ac = ac;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

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
}

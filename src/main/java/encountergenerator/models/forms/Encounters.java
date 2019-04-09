package encountergenerator.models.forms;

import javax.persistence.*;

@Entity
public class Encounters {
    @Id
    @GeneratedValue
    private Integer Id;

    private Integer partylevel;
    private String environment;
    private Integer partysize;
    private Integer difficulty;
    private Integer numencounters;
    private Integer frequency;
    private Integer userid;
    private Boolean userselect;
    private Boolean loot;
    private Integer nummobs;

    public Encounters(Integer partylevel, String environment, Integer partysize, Integer difficulty, Integer numencounters, Integer frequency, Integer userid, Boolean userselect, Boolean loot, Integer nummobs) {
        this.partylevel = partylevel;
        this.environment = environment;
        this.partysize = partysize;
        this.difficulty = difficulty;
        this.numencounters = numencounters;
        this.frequency = frequency;
        this.userid = userid;
        this.userselect = userselect;
        this.loot = loot;
        this.nummobs = nummobs;
    }

    public Encounters(){

    }

    public Integer getId() { return Id; }

    public Integer getPartylevel() {
        return partylevel;
    }

    public void setPartylevel(Integer partylevel) {
        this.partylevel = partylevel;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public Integer getPartysize() {
        return partysize;
    }

    public void setPartysize(Integer partysize) {
        this.partysize = partysize;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
    }

    public Integer getNumencounters() {
        return numencounters;
    }

    public void setNumencounters(Integer numencounters) {
        this.numencounters = numencounters;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Boolean getUserselect() {
        return userselect;
    }

    public void setUserselect(Boolean userselect) {
        this.userselect = userselect;
    }

    public Boolean getLoot() {
        return loot;
    }

    public void setLoot(Boolean loot) {
        this.loot = loot;
    }

    public Integer getNummobs() {
        return nummobs;
    }

    public void setNummobs(Integer nummobs) {
        this.nummobs = nummobs;
    }
}

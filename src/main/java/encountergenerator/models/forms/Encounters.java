package encountergenerator.models.forms;

import javax.persistence.*;

@Entity
public class Encounters {
    @Id
    @GeneratedValue
    private Integer ID;

    private Integer level;
    private String environment;
    private Integer partysize;
    private Integer difficulty;
    private Integer numencounters;
    private Integer frequency;
    private Integer userid;
    private Integer userselect;
    private Boolean loot;
    private Integer nummobs;

    public Encounters(Integer level, String environment, Integer partysize, Integer difficulty, Integer numencounters, Integer frequency, Integer userid, Integer userselect, Boolean loot, Integer nummobs) {
        this.level = level;
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

    public Integer getID() { return ID; }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
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

    public Integer getUserselect() {
        return userselect;
    }

    public void setUserselect(Integer userselect) {
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

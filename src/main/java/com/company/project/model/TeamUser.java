package com.company.project.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

public class TeamUser {
    @Id
    @Column(name = "TEAMID")
    private BigDecimal teamid;


    @Column(name = "USERNAME")
    private String username;

    @Column(name = "ADDDATE")
    private Date adddate;

    /**
     * @return TEAMID
     */
    public BigDecimal getTeamid() {
        return teamid;
    }

    /**
     * @param teamid
     */
    public void setTeamid(BigDecimal teamid) {
        this.teamid = teamid;
    }

    /**
     * @return USERNAME
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return ADDDATE
     */
    public Date getAdddate() {
        return adddate;
    }

    /**
     * @param adddate
     */
    public void setAdddate(Date adddate) {
        this.adddate = adddate;
    }
}
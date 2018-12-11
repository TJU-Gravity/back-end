package com.company.project.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

public class Teamuser {
    @Id
    @Column(name = "TEAMID")
    private int teamid;


    @Column(name = "USERNAME")
    private String username;

    @Column(name = "ADDDATE")
    private Date adddate;

    /**
     * @return TEAMID
     */
    public int getTeamid() {
        return teamid;
    }

    /**
     * @param teamId2
     */
    public void setTeamid(int teamId2) {
        this.teamid = teamId2;
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
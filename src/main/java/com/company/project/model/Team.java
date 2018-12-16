package com.company.project.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

public class Team {
    @Id
    @Column(name = "TEAMID")
    private BigDecimal teamid;

    @Column(name = "TEAMNAME")
    private String teamname;

    @Column(name = "CAPTAINID")
    private String captainid;

    @Column(name = "MEMBERNUM")
    private Short membernum;

    @Column(name = "CREATEDATE")
    private Date createdate;

    @Column(name = "HEADSHOT")
    private String headshot;

    @Column(name = "INTRODUCTION")
    private String introduction;


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
     * @return TEAMNAME
     */
    public String getTeamname() {
        return teamname;
    }

    /**
     * @param teamname
     */
    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    /**
     * @return CAPTAINID
     */
    public String getCaptainid() {
        return captainid;
    }

    /**
     * @param captainid
     */
    public void setCaptainid(String captainid) {
        this.captainid = captainid;
    }

    /**
     * @return MEMBERNUM
     */
    public Short getMembernum() {
        return membernum;
    }

    /**
     * @param membernum
     */
    public void setMembernum(Short membernum) {
        this.membernum = membernum;
    }

    /**
     * @return CREATEDATE
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     * @param createdate
     */
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    /**
     * @return HEADSHOT
     */
    public String getHeadshot() {
        return headshot;
    }

    /**
     * @param headshot
     */
    public void setHeadshot(String headshot) {
        this.headshot = headshot;
    }

    /**
     * @return INTRODUCTION
     */
    public String getIntroduction() {
        return introduction;
    }

    /**
     * @param introduction
     */
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }


}
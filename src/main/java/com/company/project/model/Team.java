package com.company.project.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

public class Team {
    @Id
    @Column(name = "TEAMID")
    private int teamid;

    @Column(name = "TEAMNAME")
    private String teamname;

    @Column(name = "CAPTAINID")
    private Integer captainid;

    @Column(name = "MEMBERNUM")
    private int membernum;

    @Column(name = "CREATEDATE")
    private Date createdate;

    @Column(name = "HEADSHOT")
    private String headshot;

    @Column(name = "INTRODUCTION")
    private String introduction;

    @Column(name = "TAGS")
    private Object tags;

    /**
     * @return TEAMID
     */
    public int getTeamid() {
        return teamid;
    }

    /**
     * @param i
     */
    public void setTeamid(int i) {
        this.teamid = i;
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
    public Integer getCaptainid() {
        return captainid;
    }

    /**
     * @param captainid
     */
    public void setCaptainid(int captainid) {
        this.captainid = captainid;
    }

    /**
     * @return MEMBERNUM
     */
    public int getMembernum() {
        return membernum;
    }

    /**
     * @param i
     */
    public void setMembernum(int i) {
        this.membernum = i;
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

    /**
     * @return TAGS
     */
    public Object getTags() {
        return tags;
    }

    /**
     * @param tags
     */
    public void setTags(Object tags) {
        this.tags = tags;
    }
}
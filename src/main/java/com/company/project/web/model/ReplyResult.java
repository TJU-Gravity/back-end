package com.company.project.web.model;

import com.company.project.model.Reply;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.util.Date;

public class ReplyResult {
    public BigDecimal replyid;

    public BigDecimal postid;

    public String posterid;

    public Date postingtime;

    public String replybody;

    public String nickname;

    public String headshot;
}

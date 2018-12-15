package com.company.project.service;
import com.company.project.model.News;
import com.company.project.model.user;
import com.company.project.core.Service;
//import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

import java.util.List;


/**
 * Created by CodeGenerator on 2018/11/06.
 */
public interface userService extends Service<user> {
    public user findByUsername(String username);

	public List<user> findUser(String userName, String password);
}

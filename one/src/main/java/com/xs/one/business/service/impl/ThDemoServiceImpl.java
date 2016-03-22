package com.xs.one.business.service.impl;

import com.xs.one.business.dao.service.TUserDao;
import com.xs.one.business.domain.entity.TUser;
import com.xs.one.business.service.ThDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2015/10/21.
 */
@Service
public class ThDemoServiceImpl implements ThDemoService {
    /*@Autowired
    private TUserDao userDao;
    public TUser getUserById(String id) {
        return userDao.selectByPrimaryKey(id);
    }*/
    public TUser getUserById(String id) {
        TUser s = new TUser();
        s.setId("1");
        s.setName("xusen");
        return s;
    }
}

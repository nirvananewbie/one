package com.xs.one.business.domain.entity;

import com.xs.one.core.utils.StringAndEqualsObject;

import java.io.Serializable;

/**
 * @ClassName: TUser
* @Description: t_user���Ӧ��java bean��
* @author: peiyu
 */
public class TUser extends StringAndEqualsObject implements Serializable {
    /**
     * @Fields serialVersionUID : �Զ�����Ĭ�����л�ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * @Fields t_user.id :
     */
    private String id;

    /**
     * @Fields t_user.name :
     */
    private String name;

    /**
     * @return t_user.id : ���� 
     */
    public String getId() {
        return id;
    }

    /**
     * @param id of t_user : ���� 
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * @return t_user.name : ���� 
     */
    public String getName() {
        return name;
    }

    /**
     * @param name of t_user : ���� 
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}
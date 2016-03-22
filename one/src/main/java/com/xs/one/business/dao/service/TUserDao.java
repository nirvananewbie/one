package com.xs.one.business.dao.service;

import com.xs.one.business.dao.persistence.TUserMapper;
import com.xs.one.business.domain.entity.TUser;
import com.xs.one.core.persistence.Criteria;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: TUserDao
* @Description: t_user���Ӧdao�����ӿ�ʵ����
* @author: peiyu
 */
@Repository
public class TUserDao {
    /**
     * @Fields LOGGER : ��־������
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TUserDao.class);

    /**
     * @Fields TUser���Mybatis Mapper����ӳ����
     */
    @Resource
    private TUserMapper tUserMapper;

    /**
    * @Title TUserDao.countByExample
    * @Description: ���ݲ�ѯ����������t_user����
    * @param example ͨ�ò�ѯ������
    * @return int �������
     */
    public int countByExample(Criteria example) {
        int count = this.tUserMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title TUserDao.selectByPrimaryKey
    * @Description: ���������࣬����t_user
    * @param id id
    * @return TUser bean����
     */
    public TUser selectByPrimaryKey(String id) {
        return this.tUserMapper.selectByPrimaryKey(id);
    }

    /**
    * @Title TUserDao.selectByExample
    * @Description: ���ݲ�ѯ�����࣬����t_user�����
    * @param example ͨ�ò�ѯ������
    * @return List<TUser>t_user�����
     */
    public List<TUser> selectByExample(Criteria example) {
        return this.tUserMapper.selectByExample(example);
    }

    /**
    * @Title TUserDao.deleteByPrimaryKey
    * @Description: �����������ƣ�ɾ��t_user
    * @param id id
    * @return int  ɾ������
     */
    public int deleteByPrimaryKey(String id) {
        return this.tUserMapper.deleteByPrimaryKey(id);
    }

    /**
    * @Title TUserDao.updateByPrimaryKeySelective
    * @Description: ������������t_user�����ֶ�
    * @param record Ҫ���³�Ϊ��TUser����
    * @return int ���¼�¼��
     */
    public int updateByPrimaryKeySelective(TUser record) {
        return this.tUserMapper.updateByPrimaryKeySelective(record);
    }

    /**
    * @Title TUserDao.updateByPrimaryKey
    * @Description: ������������t_userȫ���ֶ�
    * @param record Ҫ���³�Ϊ��TUser����
    * @return int ���¼�¼��
     */
    public int updateByPrimaryKey(TUser record) {
        return this.tUserMapper.updateByPrimaryKey(record);
    }

    /**
    * @Title TUserDao.deleteByExample
    * @Description: ���ݲ�ѯ������ɾ��t_user
    * @param example ͨ�ò�ѯ������
    * @return int  ɾ������
     */
    public int deleteByExample(Criteria example) {
        return this.tUserMapper.deleteByExample(example);
    }

    /**
    * @Title TUserDao.updateByExampleSelective
    * @Description: ���ݲ�ѯ��������t_user�����ֶ�
    * @param record Ҫ���³�Ϊ��TUser����
    * @param example ���¼�¼�Ĳ�ѯ����
    * @return int ���¼�¼��
     */
    public int updateByExampleSelective(TUser record, Criteria example) {
        return this.tUserMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title TUserDao.updateByExample
    * @Description: ���ݲ�ѯ��������t_userȫ���ֶ�
    * @param record Ҫ���³�Ϊ��TUser����
    * @param example ���¼�¼�Ĳ�ѯ����
    * @return int ���¼�¼��
     */
    public int updateByExample(TUser record, Criteria example) {
        return this.tUserMapper.updateByExample(record, example);
    }

    /**
    * @Title TUserDao.insert
    * @Description: ����һ��t_user
    * @param record t_user��bean����
    * @return int  �������
     */
    public int insert(TUser record) {
        return this.tUserMapper.insert(record);
    }

    /**
    * @Title TUserDao.insertSelective
    * @Description: ����һ��ֻ�в����ֶε�t_user
    * @param record ֻ�������ֶε�t_user��bean����
    * @return int  �������
     */
    public int insertSelective(TUser record) {
        return this.tUserMapper.insertSelective(record);
    }
}
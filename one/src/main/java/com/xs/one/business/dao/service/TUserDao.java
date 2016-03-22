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
* @Description: t_user表对应dao操作接口实现类
* @author: peiyu
 */
@Repository
public class TUserDao {
    /**
     * @Fields LOGGER : 日志操作类
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(TUserDao.class);

    /**
     * @Fields TUser表的Mybatis Mapper操作映射类
     */
    @Resource
    private TUserMapper tUserMapper;

    /**
    * @Title TUserDao.countByExample
    * @Description: 根据查询条件，计算t_user个数
    * @param example 通用查询条件类
    * @return int 结果个数
     */
    public int countByExample(Criteria example) {
        int count = this.tUserMapper.countByExample(example);
        LOGGER.debug("count: {}", count);
        return count;
    }

    /**
    * @Title TUserDao.selectByPrimaryKey
    * @Description: 根据主键类，返回t_user
    * @param id id
    * @return TUser bean对象
     */
    public TUser selectByPrimaryKey(String id) {
        return this.tUserMapper.selectByPrimaryKey(id);
    }

    /**
    * @Title TUserDao.selectByExample
    * @Description: 根据查询条件类，返回t_user结果集
    * @param example 通用查询条件类
    * @return List<TUser>t_user结果集
     */
    public List<TUser> selectByExample(Criteria example) {
        return this.tUserMapper.selectByExample(example);
    }

    /**
    * @Title TUserDao.deleteByPrimaryKey
    * @Description: 根据属性名称，删除t_user
    * @param id id
    * @return int  删除个数
     */
    public int deleteByPrimaryKey(String id) {
        return this.tUserMapper.deleteByPrimaryKey(id);
    }

    /**
    * @Title TUserDao.updateByPrimaryKeySelective
    * @Description: 根据主键更新t_user部分字段
    * @param record 要更新成为的TUser对象
    * @return int 更新记录数
     */
    public int updateByPrimaryKeySelective(TUser record) {
        return this.tUserMapper.updateByPrimaryKeySelective(record);
    }

    /**
    * @Title TUserDao.updateByPrimaryKey
    * @Description: 根据主键更新t_user全部字段
    * @param record 要更新成为的TUser对象
    * @return int 更新记录数
     */
    public int updateByPrimaryKey(TUser record) {
        return this.tUserMapper.updateByPrimaryKey(record);
    }

    /**
    * @Title TUserDao.deleteByExample
    * @Description: 根据查询条件，删除t_user
    * @param example 通用查询条件类
    * @return int  删除个数
     */
    public int deleteByExample(Criteria example) {
        return this.tUserMapper.deleteByExample(example);
    }

    /**
    * @Title TUserDao.updateByExampleSelective
    * @Description: 根据查询条件更新t_user部分字段
    * @param record 要更新成为的TUser对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExampleSelective(TUser record, Criteria example) {
        return this.tUserMapper.updateByExampleSelective(record, example);
    }

    /**
    * @Title TUserDao.updateByExample
    * @Description: 根据查询条件更新t_user全表字段
    * @param record 要更新成为的TUser对象
    * @param example 更新记录的查询条件
    * @return int 更新记录数
     */
    public int updateByExample(TUser record, Criteria example) {
        return this.tUserMapper.updateByExample(record, example);
    }

    /**
    * @Title TUserDao.insert
    * @Description: 插入一个t_user
    * @param record t_user的bean对象
    * @return int  插入个数
     */
    public int insert(TUser record) {
        return this.tUserMapper.insert(record);
    }

    /**
    * @Title TUserDao.insertSelective
    * @Description: 插入一个只有部分字段的t_user
    * @param record 只含部分字段的t_user的bean对象
    * @return int  插入个数
     */
    public int insertSelective(TUser record) {
        return this.tUserMapper.insertSelective(record);
    }
}
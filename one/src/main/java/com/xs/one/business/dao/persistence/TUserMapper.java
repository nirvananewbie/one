package com.xs.one.business.dao.persistence;

import com.xs.one.business.domain.entity.TUser;
import com.xs.one.core.persistence.Criteria;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName: TUserMapper
* @Description: t_user���Ӧ��dao����Mapperӳ����
* @author: peiyu
 */
public interface TUserMapper {
    /**
    * @Title TUserMapper.countByExample
    * @Description: ���ݲ�ѯ����������t_user����
    * @param example ͨ�ò�ѯ������
    * @return int �������
     */
    int countByExample(Criteria example);

    /**
    * @Title TUserMapper.deleteByExample
    * @Description: ���ݲ�ѯ������ɾ��t_user
    * @param example ͨ�ò�ѯ������
    * @return int  ɾ������
     */
    int deleteByExample(Criteria example);

    /**
    * @Title TUserMapper.deleteByPrimaryKey
    * @Description: �����������ƣ�ɾ��t_user
    * @param id id
    * @return int  ɾ������
     */
    int deleteByPrimaryKey(String id);

    /**
    * @Title TUserMapper.insert
    * @Description: ����һ��t_user
    * @param record t_user��bean����
    * @return int  �������
     */
    int insert(TUser record);

    /**
    * @Title TUserMapper.insertSelective
    * @Description: ����һ��ֻ�в����ֶε�t_user
    * @param record ֻ�������ֶε�t_user��bean����
    * @return int  �������
     */
    int insertSelective(TUser record);

    /**
    * @Title TUserMapper.selectByExample
    * @Description: ���ݲ�ѯ�����࣬����t_user�����
    * @param example ͨ�ò�ѯ������
    * @return List<TUser>t_user�����
     */
    List<TUser> selectByExample(Criteria example);

    /**
    * @Title TUserMapper.selectByPrimaryKey
    * @Description: ���������࣬����t_user
    * @param id id
    * @return TUser bean����
     */
    TUser selectByPrimaryKey(String id);

    /**
    * @Title TUserMapper.updateByExampleSelective
    * @Description: ���ݲ�ѯ��������t_user�����ֶ�
    * @param record Ҫ���³�Ϊ��TUser����
    * @param criteria ���¼�¼�Ĳ�ѯ����
    * @return int ���¼�¼��
     */
    int updateByExampleSelective(@Param("record") TUser record, @Param("example") Criteria criteria);

    /**
    * @Title TUserMapper.updateByExample
    * @Description: ���ݲ�ѯ��������t_userȫ���ֶ�
    * @param record Ҫ���³�Ϊ��TUser����
    * @param criteria ���¼�¼�Ĳ�ѯ����
    * @return int ���¼�¼��
     */
    int updateByExample(@Param("record") TUser record, @Param("example") Criteria criteria);

    /**
    * @Title TUserMapper.updateByPrimaryKeySelective
    * @Description: ������������t_user�����ֶ�
    * @param record Ҫ���³�Ϊ��TUser����
    * @return int ���¼�¼��
     */
    int updateByPrimaryKeySelective(TUser record);

    /**
    * @Title TUserMapper.updateByPrimaryKey
    * @Description: ������������t_userȫ���ֶ�
    * @param record Ҫ���³�Ϊ��TUser����
    * @return int ���¼�¼��
     */
    int updateByPrimaryKey(TUser record);
}
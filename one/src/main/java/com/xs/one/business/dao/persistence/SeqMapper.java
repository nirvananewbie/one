package com.xs.one.business.dao.persistence;

import org.apache.ibatis.annotations.Param;

/**
 * @Title: 序列适配器
 * @Description:
 * @Copyright: Copyright (c) 2015-2-4
 * @Author: shenjun
 */
public interface SeqMapper {

    /**根据传入在进行查询
     * @param selecStr
     * @return
     */
    public String queryBySelectStr(@Param("selecStr")String selecStr);
}

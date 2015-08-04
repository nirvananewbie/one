package com.xs.one.core.interceptor;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import com.xs.one.core.persistence.PageBck;

/**
 * @ClassName: OraclePaginationPlugin
 * @Description: Oracle的分页插件
 * @author linyl linyuliang.85@gmail.com
 */
@Intercepts({ @Signature(type = Executor.class, method = "query",
    args = { MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class }) })
public class OraclePaginationPlugin extends PaginationBasePlugin {
    @Override
    protected String paginationSql(String sql, PageBck page) {
        StringBuilder pageSql = new StringBuilder();
        pageSql.append("select * from (select t.*, ROWNUM num from (").append(sql).append(") t where ROWNUM <= ").append(page.getEnd())
            .append(") where num > ").append(page.getBegin());
        return pageSql.toString();
    }

    @Override
    protected String totalCountSql(String sql) {
        return "select count(1) from (" + sql + ") t";
    }

    @Override
    protected String orderbySql(String sql, String orderByClause) {
        if (StringUtils.isNotBlank(orderByClause)) {
            return sql + " order by " + orderByClause;
        } else {
            return sql;
        }
    }
}

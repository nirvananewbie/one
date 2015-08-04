package com.xs.one.core.utils;

import java.util.Date;
import java.util.Random;

import org.springframework.jdbc.core.JdbcTemplate;

import com.xs.one.business.dao.persistence.SeqMapper;

/**
 * @author shaoxy UUID生成工具类
 */
public class UUIDUtils {

	private static JdbcTemplate jdbcTemplate;

	private static SeqMapper seqMapper;

	/**
	 * 生成去除-的UUID
	 * 
	 * @return UUID
	 */
	public static String getUUID() {
		// String uuid = UUID.randomUUID().toString();
		// return uuid.substring(0, 8) + uuid.substring(9, 13)
		// + uuid.substring(14, 18) + uuid.substring(19, 23)
		// + uuid.substring(24);
		return Utility.uuid();
	}

	/**
	 * 根据序列名称获取序列下个值(jdbc实现)
	 * 
	 * @param seq
	 *            序列名称
	 * @param type
	 *            数据类型
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getNextValueBySeqName(String seq, Class<T> type) {
		Object id = jdbcTemplate.queryForObject("select " + seq
				+ ".nextval from dual", type);

		return (T) id;
	}

	/**
	 * 根据序列名称获取序列下个值(mybatis实现)
	 * 
	 * @param seq
	 *            序列名称
	 * @param type
	 *            数据类型
	 * @return
	 */
	public static String getNextValueBySeqName(String seq) {

		return seqMapper.queryBySelectStr("select " + seq
				+ ".nextval from dual");
	}

	/**
	 * 获取数据服务器时间
	 * 
	 * @return
	 */
	public static String getDBServerTime(String timeType) {

		return seqMapper.queryBySelectStr("select DATE_FORMAT(sysdate(),'" + timeType
				+ "');");
	}

	/**
	 * 获取系统时间 格式 yyyy-MM-dd HH:mm:ss
	 */
	public static String getDBServerTime() {

		return getDBServerTime(DateUtils.FULL_DATE_FORMAT);
	}

	public static SeqMapper getSeqMapper() {
		return seqMapper;
	}

	public static boolean setSeqMapper(SeqMapper seqMapper,
			JdbcTemplate jdbcTemplate) {
		UUIDUtils.seqMapper = seqMapper;

		UUIDUtils.jdbcTemplate = jdbcTemplate;

		return true;
	}

	public static JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	
	/**
	 * 设置20位的ID
	 * @return
	 */
	public static String getKey() {
		StringBuilder sb = new StringBuilder();
		sb.append(DateUtils.date2String1(new Date()));
		sb.append(new Random().nextInt(999999));
		return sb.toString();
	} 

	public static void main(String args[]) {
		System.out.println(getUUID());
	}
}

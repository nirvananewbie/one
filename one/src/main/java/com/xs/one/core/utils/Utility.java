package com.xs.one.core.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.primitives.Ints;

/**
 * <p>
 * 参照了org.nutz.lang 的实现 这些帮助函数让 Java 的某些常用功能变得更简单<br>
 * 就字符操作,推荐使用 org.apache.commons.lang3.StringUtils 里面的方法
 * </p>
 * org.apache.commons.lang3.StringUtils
 * 
 * @Description <pre>
 * 推荐使用    commons-lang3-3x 版本
 * org.apache.commons.lang3.StringUtils
 * 
 * 不推荐使用commons-lang-2x 版本
 * org.apache.commons.lang.StringUtils
 * 
 * Apache Commons 团队发布了 Commons Lang3.0 ，该版本完全支持 Java 5 的特性，例如泛型和可变参数，删除了废弃的 API 
 * 因此该版本无法兼容以前的版本，包名也做了更改 org.apache.commons.lang3
 * 
 * 
 * </pre>
 * 
 * @author shaoxy
 * @author shenyg
 * @author peiyu
 * @author chengj
 * 
 * @date 2014-08-06
 * 
 */

public final class Utility extends org.nutz.lang.Lang {
	// 注意查看 org.nutz.lang.Lang 方法实现
	private static final Logger logger = LoggerFactory.getLogger(Utility.class);
	private static Utility utility;

	public static void main(String[] args) {
		String[] test = { "33", "ddffd" };
		String[] test1 = { "ddffd", "33" };
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("1", "1");
		map.put("2", "2");
		map.put("3", "3");
		str2number("2222");	
		
		/**
		 * ----------------------google guava 工具包  com.google.common.collect里的常用方法 ----------------------------
		 */

		
		
		/**
		 * 集合的创建和初始化 
		 */
		
		//简化集合创建
		Map<String, Map<String, String>> map1 = Maps.newHashMap();
		List<List<Map<String, String>>> list1 = Lists.newArrayList();
		System.out.println("Maps.newHashMap()：");
		System.out.println("简化集合的创建 。 ");
		System.out.println("Map<String, Map<String, String>> map1 = new HashMap<String, Map<String,String>>() 可简化为：");
		System.out.println("Map<String, Map<String, String>> map1 = Maps.newHashMap()");
		System.out.println("Set,List也类似: Sets.newHashSet(); Lists.newArrayList()");
		
		//集合初始化
		System.out.println();
		System.out.println("Lists.newArrayList(E... elements)：");
		System.out.println("简化集合的初始化 。 ");
		System.out.println("List list2 = Lists.newArrayList(1,2,3,4,5,6,7)；list2 =" +  Lists.newArrayList(1,2,3,4,5,6,7) );
		System.out.println("Set,List也类似，但是Map没有");
		
		/**
		 * 集合筛选
		 */
		
		
		/*
		   Collection集合筛选
		   Collections2.filter(Collection<E> unfiltered, Predicate<? super E> predicate)方法
		          谓词（Predicate）是用来筛选集合的；
		          谓词是一个简单的接口，只有一个方法返回布尔值，当你结合collections2.filter方法使用，这个筛选方法返回原来的集合中满足这个谓词接口的元素；
      	          举个例子来说：过滤一个 List<Integer> 里面小于 10 的元素 :
		  
		   Collection<Integer>  filterCollection = Collections2.filter(list, new Predicate<Integer>()
		  { 
    		@Override 
    		public boolean apply(Integer input) { 
        	return input >= 10; 
 				}});
		  }
		 * 结果为包含元素全部小于10的集合
		 */
		System.out.println();
		System.out.println("Collections2.filter(Collection<E> unfiltered, Predicate<? super E> predicate):");
		System.out.println("谓词(Predicate)是一个简单的接口，只有一个方法返回布尔值，当你结合collections2.filter方法使用，这个筛选方法返回原来的集合中满足这个谓词接口的元素；");
		System.out.println("具体用法请参照注释");

		
		/*
			Map集合筛选
			Maps.uniqueIndex(Iterable,Function)通常针对的场景是：有一组对象，它们在某个属性上分别有独一无二的值，而我们希望能够按照这个属性值查找对象
			这个方法返回一个Map，键为Function返回的属性值，值为Iterable中相应的元素，因此我们可以反复用这个Map进行查找操作。
			比方说，我们有一堆字符串，这些字符串的长度都是独一无二的，而我们希望能够按照特定长度查找字符串：
			ImmutableMap<Integer, String> stringsByIndex = Maps.uniqueIndex(strings,new Function<String, Integer> () 
				{
        		public Integer apply(String string) {
            	return string.length();
        		}
6
    		});

		 * 注意 ,返回的是ImmutableMap,guava里的不可变集合类型
		 */
		System.out.println();
		System.out.println("Maps.uniqueIndex(Iterable,Function)");
		System.out.println("通常针对的场景是：有一组对象，它们在某个属性上分别有独一无二的值，而我们希望能够按照这个属性值查找对象.这个方法返回一个Map，键为Function返回的属性值，值为Iterable中相应的元素，因此我们可以反复用这个Map进行查找操作。");
		System.out.println("使用场合请参照注释");
		
		
		/**
		 * 把List按指定大小分割
		 */
		List<Integer> countUp = Ints.asList(1, 2, 3, 4, 5);
		System.out.println();
		System.out.println("Lists.partition(List, int)");
		System.out.println("把List按指定大小分割");
		System.out.println("List countUp = Ints.asList(1, 2, 3, 4, 5); List<List> parts = Lists.partition(countUp, 2); " +
				"parts ={{1,2}, {3,4}, {5}}");
		
		
		/**
		 * 返回给定List的反转视图(倒序)
		 */
		System.out.println();
		System.out.println("Lists.reverse(List list)");
		System.out.println("返回给定List的反转视图。注: 如果List是不可变的，考虑改用ImmutableList.reverse()。");
		System.out.println("List countUp = Ints.asList(1, 2, 3, 4, 5); Lists.reverse(countUp) = ");
		System.out.println(Lists.reverse(countUp));
		
		
		
		
		
		/**
		 * 
		 * ----------------------------------- org.nutz.lang.Lang 常用方法--------------------------------------------
		 * 
		 */
		
		
		/**
		 * 通用方法
		 * 
		 */
		System.out.println("Lang.equals(Object a0, Object a1): ");  
		System.out.println("判断两个对象是否相等。 这个函数用处是:可以容忍 null,可以容忍不同类型的 Number,对数组，集合， Map 会深层比较。 eg:equals(3.0,3)=" + 
							equals(3.0,3));
		
		System.out.println();
		System.out.println("Lang.contains(T[] array, T ele):");
		System.out.println("判断一个数组内是否包括某一个对象。 它的比较将通过 equals(Object,Object)方法。 eg:contains(array,3.0)=" + 
							contains(array(1,2,3,4),3.0));
		
		System.out.println();
		System.out.println("Lang.readAll(Reader reader):");
		System.out.println("从一个文本输入流读取所有内容，并将该流关闭 。readAll(reader)");
		
		System.out.println();
		System.out.println("Lang.writeAll(Writer writer, String str):");
		System.out.println("将一段字符串写入一个文本输出流，并将该流关闭 。writeAll(writer,str)");
		
		
		
		/**
		 * 数组有关方法
		 */
		//Lang.concat(Object c, T[] objs)
		//将一个数组转换成字符串每个元素之间，都会用一个给定的字符分隔   
		System.out.println();
		System.out.println("Lang.concat(Object c, T[] objs):");
		System.out.println("将一个数组转换成字符串每个元素之间，都会用一个给定的字符分隔" + 
						   "比如：concat(\",\", array((\"A\", \"B\", \"A\"))=" + concat(",", array("A","B","A")));
		
		//Lang.array(T... eles)
		//较方便的创建一个数组
		System.out.println();
		System.out.println("Lang.array(T... eles):");
		System.out.println("较方便的创建一个数组，比如：String[] strs = Lang.array(\"A\", \"B\", \"A\"); strs =" 
						   + concat(",", array("A","B","A"))); 
		
		System.out.println();
		System.out.println("Lang.arrayUniq(T... eles):");
		System.out.println("较方便的创建一个没有重复的数组,比如String[] strs = Lang.arrayUniq(\"A\",\"B\",\"A\"); strs =" + 
							concat(",",arrayUniq("A","B","A")));
		
		
		String[] s = {"s"}; String[] s1 ={"b","c"}; String[] s2 ={"d","e"};
		System.out.println();
		System.out.println("Lang.isEmptyArray(T[] ary):");
		System.out.println("判断一个数组是否为空 ;String[] s = {\"s\"}; isEmptyArray(s)=" + isEmptyArray(s));
		
		System.out.println();
		System.out.println("Lang.merge(T[]... arys):");
		System.out.println("将多个数组，合并成一个数组。如果这些数组为空，则返回 null ; merge(s,s1,s2)=" + concat(",",merge(s,s1,s2)));
		
		System.out.println();
		System.out.println("arrayFirst(T e, T[] eles):");
		System.out.println("将一个对象添加成为一个数组的第一个元素，从而生成一个新的数组 ; arrayFirst(\"第一个元素\",s) = " + concat(",",arrayFirst("第一个元素",s)));
		
		System.out.println();
		System.out.println("arrayLast(T e, T[] eles):");
		System.out.println("将一个对象添加成为一个数组的最后一个元素，从而生成一个新的数组 ; arrayLast(\"最后一个元素\",s) = " + concat(",",arrayLast(s,"最后一个元素")));
		
		System.out.println();
		System.out.println("concat(int offset,int len,Object c,T[] objs):");
		System.out.println("将一个数组的部分元素转换成字符串; arrayLast(\"最后一个元素\",s) = " + concat(",",arrayLast(s,"最后一个元素")));
		
		
		/**
		 * 集合有关方法
		 */
		//快速创建一个HashSet集合
		System.out.println();
		System.out.println("set(T... eles)");
		System.out.println("快速创建一个HashSet; set(1,2,3,4,5) = " + set(1,2,3,4,5));	
		
		//快速创建一个ArrayList集合
		System.out.println();
		System.out.println("list(T... eles)");
		System.out.println("快速创建一个ArrayList; list(1,2,3,4,5) = " + list(1,2,3,4,5));	
	   
	     // 将一个集合变成 Map。
	     // @param mapClass Map 的类型
	     // @param coll 集合对象
	     // @param keyFieldName 采用集合中元素的哪个一个字段为键。
	     // @return Map 对象
		//System.out.println("collection2map(Class<T> mapClass,Collection<?> coll,String keyFieldName)," +
		//"将一个集合变成 Map;  collection2map(HashMap.class, list(1,2,3,3,4,5), \"number\") = " + collection2map(HashMap.class, list(1,2,3,3,4,5), "number"));
		
		//将集合变成 ArrayList
		System.out.println();
		System.out.println("collection2list(Collection<E> col):");
		System.out.println("将集合变成 ArrayList; collection2list(set(1,2,3,3,3,4,5))" + collection2list(set(1,2,3,3,3,4,5)));
		//将集合转换成指定类型的List
		System.out.println();
		System.out.println("collection2list(Collection<?> col,Class<E> eleType):");
		System.out.println("将集合转换成指定类型的List; collection2list(set(1,2,3,4,5,6), ArrayList.class) =" + 
							collection2list(set(1,2,3,4,5,6), ArrayList.class));
		//将集合变成数组，数组的类型为集合的第一个元素的类型。如果集合为空，则返回 null
		System.out.println();
		System.out.println("collection2array(Collection<E> coll)");
		System.out.println("将集合变成数组，数组的类型为集合的第一个元素的类型。如果集合为空，则返回 null;collection2array(set(1,2,3,3,3,4,5))" + 
							collection2array(set(1,2,3,3,3,4,5)));
		//将集合编程变成指定类型的列表
		System.out.println();
		System.out.println("collection2list(Collection<?> col,Class<E> eleType)");
		System.out.println("将集合编程变成指定类型的列表 ; collection2list(set(1,2,3,3,3,4,5), Integer.class) = " + 
							collection2list(set(1,2,3,3,3,4,5), Integer.class));
		
		
		/**
		 * ------------------------------------ org.apache.commons.lang3.StringUtils --------------------------------
		 */
		
		/**
		 *   通用方法
		 */
		// 将数组中的内容以,分隔,返回字符串
		System.out.println(StringUtils.join(test, ","));
		// 在右边加下字符,使之总长度为6
		System.out.println(StringUtils.rightPad("abc", 6, 'T'));
		// 表示左边两个字符
		System.out.println(StringUtils.left("abc", 2));
		System.out.println(StringUtils.right("abcd", 3));
		// 首字母大写
		System.out.println(StringUtils.capitalize("abc"));

		/**
		 * 判断
		 */
		// 判断2个字符串是否相等相等,Null也相等
		System.out.println(StringUtils.equals(null, null));
		// 不区分大小写比较
		System.out.println(StringUtils.equalsIgnoreCase("abc", "ABc"));
		// 判断是否Null 或者 ""
		System.out.println(StringUtils.isEmpty(null));
		// 判断是否是空格字符
		System.out.println(StringUtils.isBlank(" "));
		// 判断是否包含这个字符
		System.out.println(StringUtils.contains("abc", "ba"));
	

		/**
		 * 移除
		 * 去符合条件的字符 
		 */
		// 删除所有空格
		System.out.println(StringUtils.deleteWhitespace("   ab  c  "));
		// 去空格. Null返回null
		System.out.println(StringUtils.trim(" ss  "));
		// 去空格，将Null和"" 转换为Null
		System.out.println(StringUtils.trimToNull(""));
		// 去空格，将NULL 和 "" 转换为""
		System.out.println(StringUtils.trimToEmpty(null));
		// 去头尾字符 ，去掉的字符符合第二个参数要求
		System.out.println(StringUtils.strip("abc", "ac")); // ="  b  "
		System.out.println(StringUtils.strip("abcxyzd", "adz")); // ="bcxy"
		System.out.println(StringUtils.strip("  abcxyzd  ", null)); // ="abcxyzd"
		// 如果第二个参数为null只去前面空格(否则去掉字符串前面一样的字符，到不一样为止)
		System.out.println(StringUtils.stripStart("ddsuuu ", "d")); // ="suuu "
		// 如果第二个参数为null只去后面空格，(否则去掉字符串后面一样的字符，到不一样为止)
		System.out.println(StringUtils.stripEnd("dabads", "das")); // ="dab"

		/**
		 * 检查字符串内容
		 */
		// 检查是否只包含数值。
		System.out.println(StringUtils.isNumeric("NBA直播"));
		// 检查是否只包含数值或者空格
		System.out.println(StringUtils.isNumericSpace("33 545"));
		// 检查是否只是空格或""。
		System.out.println(StringUtils.isWhitespace(" "));
		// 检查是否全是英文小写。
		System.out.println(StringUtils.isAllLowerCase("kjk33"));
		// 检查是否全是英文大写。
		System.out.println(StringUtils.isAllUpperCase("KJKJ"));
		
		/**
		 * 交集操作
		 */
		// 去掉参数2字符串中在参数一中开头部分共有的部分，结果为:人民共和加油
		System.out.println(StringUtils.difference("中国加油", "中国人民共和加油"));
		// 统计2个字符串开始部分共有的字符个数
		System.out.println(StringUtils.indexOfDifference("ww.taobao", "www.taobao.com"));
		// 统计数组中各个元素的字符串开始都一样的字符个数
		System.out.println(StringUtils.indexOfDifference(new String[] { "中国加油", "中国共和", "中国人民" }));
		// 取数组每个元素共同的部分字符串
		System.out.println(StringUtils.getCommonPrefix(new String[] { "中国加油", "中国共和", "中国人民" }));
		// 统计参数一中每个字符与参数二中每个字符不同部分的字符个数
		System.out.println(StringUtils.getLevenshteinDistance("中国共和发国人民", "共和国"));
		// 判断开始部分是否与二参数相同
		System.out.println(StringUtils.startsWith("中国共和国人民", "中国"));
		// 判断开始部分是否与二参数相同。不区分大小写
		System.out.println(StringUtils.startsWithIgnoreCase("中国共和国人民", "中国"));
		// 判断字符串开始部分是否与数组中的某一元素相同
		System.out.println(StringUtils.startsWithAny("abef", new String[] { "ge", "af", "ab" }));
		// 判断结尾是否相同
		System.out.println(StringUtils.endsWith("abcdef", "def"));
		// 判断结尾是否相同，不区分大小写
		System.out.println(StringUtils.endsWithIgnoreCase("abcdef", "Def"));

		/**
		 * 分割,截取
		 */
		// 用空格分割成数组，null为null
		System.out.println(StringUtils.split("中华 人民  共和"));
		// 以指定字符分割成数组
		System.out.println(StringUtils.split("中华 ,人民,共和", ","));
		// 以指定字符分割成数组，第三个参数表示分隔成数组的长度，如果为0全体分割
		System.out.println(StringUtils.split("中华 ：人民：共和", "：", 2));
		// 未发现不同的地方,指定字符分割成数组
		System.out.println(StringUtils.splitByWholeSeparator("ab-!-cd-!-ef", "-!-"));
		// 未发现不同的地方,以指定字符分割成数组，第三个参数表示分隔成数组的长度
		System.out.println(StringUtils.splitByWholeSeparator("ab-!-cd-!-ef", "-!-", 2));
		// 分割，但" "不会被忽略算一个元素,二参数为null默认为空格分隔
		System.out.println(StringUtils.splitByWholeSeparatorPreserveAllTokens(" ab   de fg ", null));
		// 同上，分割," "不会被忽略算一个元素。第三个参数代表分割的数组长度。
		System.out.println(StringUtils.splitByWholeSeparatorPreserveAllTokens("ab   de fg", null, 3));
		// 未发现不同地方,分割
		System.out.println(StringUtils.splitPreserveAllTokens(" ab   de fg "));
		// 未发现不同地方,指定字符分割成数组
		System.out.println(StringUtils.splitPreserveAllTokens(" ab   de fg ", null));
		// 未发现不同地方,以指定字符分割成数组，第三个参数表示分隔成数组的长度
		System.out.println(StringUtils.splitPreserveAllTokens(" ab   de fg ", null, 2));
	}

	private static SecureRandom random = new SecureRandom();

	public static Utility getInstance() {

		if (utility == null)
			utility = new Utility();

		return utility;
	}

	/**
	 * 封装JDK自带的UUID, 通过Random数字生成, 中间无-分割.
	 */
	public static String uuid_p() {
		return UUID.randomUUID().toString();
	}

	/**
	 * 封装JDK自带的UUID, 通过Random数字生成, 中间无-分割.
	 */
	public static String uuid() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	/**
	 * 使用SecureRandom随机生成Long.
	 */
	public static long randomLong() {
		return Math.abs(random.nextLong());
	}

	/**
	 * 根据bit值，获取bit位随机数
	 */
	public static String getRandomNum(int bit) {
		String tmp = "";
		for (int i = 0; i < bit; i++) {
			int j = (int) Math.round((Math.random() * 5));
			tmp = tmp + Integer.toString(j);
		}
		return tmp;
	}

	/**
	 * 校验是否是否为null或空。
	 * 
	 * @author shenyg
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		return (str == null) || str.isEmpty();
	}

	/**
	 * 用来List判空。
	 * 
	 * @author shenyg
	 * @param list
	 * @return
	 */
	public static <T> boolean isEmpty(List<T> list) {
		return (list == null) || list.isEmpty();
	}

	/**
	 * 用来MAP判空。
	 * 
	 * @author shenyg
	 * @param map
	 * @return
	 */
	public static <K, V> boolean isEmpty(Map<K, V> map) {
		return (map == null) || map.isEmpty();
	}

	/**
	 * 用来byte判空。
	 * 
	 * @author shenyg
	 * @param bt
	 * @return
	 */
	public static <T> boolean isEmpty(byte[] bt) {
		return bt == null || bt.length == 0;
	}

	/**
	 * 关闭一切可以关闭的资源，如各种数据流
	 * 
	 * @param closeable
	 *            可关闭的资源对象
	 */
	public static void close(Closeable closeable) {
		try {
			closeable.close();
			closeable = null;
		} catch (IOException e) {
			logger.error("关闭资源出现异常 IOException :", e);
		}
	}

	/**
	 * 将CheckedException转换为UncheckedException. 简化代码。
	 * 
	 * <pre>
	 * public void error(Exception e) throws RuntimeException {
	 * 	RuntimeException exception = new RuntimeException(e);
	 * 	log.error(e.getMessage(), exception);
	 * 	throw exception;
	 * }
	 * </pre>
	 */
	public static RuntimeException unchecked(Exception e) {
		logger.error("", e);
		if (e instanceof RuntimeException) {
			return (RuntimeException) e;
		} else {
			return new RuntimeException(e);
		}
	}

	/**
	 * 将ErrorStack转化为String.
	 */
	public static String getStackTraceAsString(Exception e) {
		StringWriter stringWriter = new StringWriter();
		e.printStackTrace(new PrintWriter(stringWriter));
		return stringWriter.toString();
	}

	/**
	 * 判断异常是否由某些底层的异常引起.
	 */
	public static boolean isCausedBy(Exception ex, Class<? extends Exception>... causeExceptionClasses) {
		Throwable cause = ex.getCause();
		while (cause != null) {
			for (Class<? extends Exception> causeClass : causeExceptionClasses) {
				if (causeClass.isInstance(cause)) {
					return true;
				}
			}
			cause = cause.getCause();
		}
		return false;
	}

	/**
	 * 首字母小写
	 */
	public static String lowerFirst(String str) {
		if (StringUtils.isBlank(str)) {
			return "";
		} else {
			return str.substring(0, 1).toLowerCase() + str.substring(1);
		}
	}

	/**
	 * 首字母大写
	 */
	public static String upperFirst(String str) {
		if (StringUtils.isBlank(str)) {
			return "";
		} else {
			return str.substring(0, 1).toUpperCase() + str.substring(1);
		}
	}

	/**
	 * 替换掉HTML标签方法
	 */
	public static String replaceHtml(String html) {
		if (org.apache.commons.lang3.StringUtils.isBlank(html)) {
			return "";
		}
		String regEx = "<.+?>";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(html);
		String s = m.replaceAll("");
		return s;
	}

	/**
	 * 缩略字符串（不区分中英文字符）
	 * 
	 * @param str
	 *            目标字符串
	 * @param length
	 *            截取长度
	 * @return
	 */
	public static String abbr(String str, int length) {
		if (str == null) {
			return "";
		}
		try {
			StringBuilder sb = new StringBuilder();
			int currentLength = 0;
			for (char c : replaceHtml(StringEscapeUtils.unescapeHtml4(str)).toCharArray()) {
				currentLength += String.valueOf(c).getBytes("GBK").length;
				if (currentLength <= length - 3) {
					sb.append(c);
				} else {
					sb.append("...");
					break;
				}
			}
			return sb.toString();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 缩略字符串（替换html）
	 * 
	 * @param str
	 *            目标字符串
	 * @param length
	 *            截取长度
	 * @return
	 */
	public static String rabbr(String str, int length) {
		return abbr(replaceHtml(str), length);
	}

	/**
	 * 转换为Double类型
	 */
	public static Double toDouble(Object val) {
		if (val == null) {
			return 0D;
		}
		try {
			return Double.valueOf(org.apache.commons.lang3.StringUtils.trim(val.toString()));
		} catch (Exception e) {
			return 0D;
		}
	}

	/**
	 * 转换为Float类型
	 */
	public static Float toFloat(Object val) {
		return toFloat(val,2);
	}
	/**
	 * 
	 * @param val
	 * @param v   小数点保留几位。
	 * @return
	 */
	public static Float toFloat(Object val,int v) {
		float a= toDouble(val).floatValue();
		int c = (int)(Math.pow(10, v));
		if(c != 0) return (float)(Math.round(a*c))/c;
		else return a;
	}

	/**
	 * 转换为Long类型
	 */
	public static Long toLong(Object val) {
		return toDouble(val).longValue();
	}

	/**
	 * 转换为Integer类型
	 */
	public static Integer toInteger(Object val) {
		return toLong(val).intValue();
	}

	/**
	 * 获得用户远程地址
	 */
	public static String getRemoteAddr(HttpServletRequest request) {
		String remoteAddr = request.getHeader("X-Real-IP");
		if (org.apache.commons.lang3.StringUtils.isNotBlank(remoteAddr)) {
			remoteAddr = request.getHeader("X-Forwarded-For");
		} else if (org.apache.commons.lang3.StringUtils.isNotBlank(remoteAddr)) {
			remoteAddr = request.getHeader("Proxy-Client-IP");
		} else if (org.apache.commons.lang3.StringUtils.isNotBlank(remoteAddr)) {
			remoteAddr = request.getHeader("WL-Proxy-Client-IP");
		}
		return remoteAddr != null ? remoteAddr : request.getRemoteAddr();
	}

	/**
	 * Java去除字符串中的空格,回车,换行符,制表符
	 */
	public String replaceBlank(String str) {
		Pattern p = Pattern.compile("\\s*|\t|\r|\n");
		Matcher m = p.matcher(str);
		return m.replaceAll("");
	}

	/**
	 * 将map转换成url
	 * 
	 * @param map
	 * @return
	 */
	public static String getUrlParamsByMap(Map<String, Object> map) {
		if (map == null) {
			return "";
		}
		StringBuffer sb = new StringBuffer();
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			sb.append(entry.getKey() + "=" + entry.getValue());
			sb.append("&");
		}
		String s = sb.toString();
		if (s.endsWith("&")) {
			s = org.apache.commons.lang3.StringUtils.substringBeforeLast(s, "&");
		}
		return s;
	}

	/**
	 * 深度克隆
	 * 
	 * @param obj
	 * @return
	 * @throws Exception
	 * @author chengyj2
	 */
	public static Object clone(Object obj) throws Exception {
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		ObjectOutputStream oout = new ObjectOutputStream(bout);
		oout.writeObject(obj);
		oout.flush();
		ObjectInputStream oin = new ObjectInputStream(new ByteArrayInputStream(bout.toByteArray()));
		return oin.readObject();
	}
	
	
	//==================================================================================================================
	//@2015-03-31 @chengj
	
	
	/**
	 * 对List结果集 添加属性值
	 * @Description 举例    Utility.addParamValue(inputSet, "X_TAG", "1");
	 */
	
    @SuppressWarnings("rawtypes")
	public static void addParamValue(List<Map> inputSet,String fieldNames, String fieldValues)
    {        
    	String[] fieldName=fieldNames.split(",");
    	String[] fieldValue=fieldValues.split(",");
    	addParamValue(inputSet, fieldName, fieldValue);    	
    } 
    
    /**
     * 给List数据集添加多字段值
     * @param inputSet
     * @param key
     * @Description 举例       Utility.addParamValue(inputSet,  new String[] {key}, new String[] {value});
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public static void addParamValue(List<Map> inputSet,String[] fieldName, String[] fieldValue)
    {        
        if (fieldName.length != fieldValue.length) {
            throw new NullPointerException("参数个数不正确！");
        }
        int length = fieldValue.length;
        if (length==0) return;
    	for(int i=0; i<inputSet.size(); ++i){
    		for(int j=0; j<length; j++){
    			((Map)inputSet.get(i)).put(fieldName[j], fieldValue[j]);	
    		} 
        }
    }    
 
    
	 /**
     * 筛选未窄化(保留 等于Key的对象结果返回, List)
     * @param source
     * @param key
     * @param value
     * @Description  举例   	Utility.filter(commpara, "PARA_CODE2", "网别")
     */
    @SuppressWarnings("rawtypes")
	public static List<Map> filter(List<Map> source, String key, String value) {
    	
        return filter(source, new String[] {key}, new String[] {value});
        
    }
    
    /**
     * 筛选未窄化 (保留 等于Key的记录返回)
     * @param source
     * @param key[]
     * @param value[]
     * @Description 举例       Utility.filter(dsUUInfo,  new String[] {key}, new String[] {value} );
     */

	@SuppressWarnings("rawtypes")
	public static List<Map> filter(List<Map> source, String[] keys, String[] values) {
		if (keys.length != values.length) {
			throw new NullPointerException("参数个数不正确！");
		}

		int length = keys.length;
		if (length == 0) {
			return source;
		}
		List<Map> result = Lists.newArrayList();
		Iterator it = source.iterator();

		while (it.hasNext()) {
			Map one = (Map) it.next();
			int j = 0;
			for (int i = 0; i < length; i++) {
				if ((StringUtils.isBlank(values[i]) && one.containsKey(keys[i]) && (one.get(keys[i])) != null)
						|| (StringUtils.isNotBlank(values[i]) && values[i].equals(one.get(keys[i]))))
					j++;
			}
			if (j == length) {
				result.add(one);
			}
		}

		return result;
	}
    
   
    
    /**
     * 筛选(保留 等于Key的记录返回)
     * @param source
     * @param keys
     * @param values
     * @Description 举例     Utility.filter(dsUUInfo, "RELATION_TYPE_CODE",new String[]{"211","214","216","217","6C"});
     */
	@SuppressWarnings("rawtypes")
	public static List<Map> filter(List<Map> source, String key, String[] value) {
		List<Map> result = Lists.newArrayList();
		Map data = Maps.newHashMap();
		for (int i = source.size() - 1; i >= 0; --i) {
			data = (Map) source.get(i);
			for (int j = 0; j < value.length; ++j) {
				if (data.containsKey(key) && data.get(key).equals(value[j])) {
					result.add(0, data);
					break;
				}
			}
		}
		return result;
	}
    
    
    /**
     * 筛选(保留  不等于 Key的记录返回)
     * @param source
     * @param key
     * @param value
     * @return
     * @Description 举例    Utility.unequalsFilter(source, "NEXT_DEAL_TAG", "Z")
     */
    public static List<Map> unequalsFilter(List<Map> source, String key, String value) {
        return unequalsFilter(source, new String[] {key}, new String[] {value});
    }
    
    /**
     * 筛选(保留  不等于 Key的记录返回)
     * @param source
     * @param keys
     * @param values
     * @return
     * @Description 举例   	Utility.unequalsFilter(source, new String[] {key}, new String[] {value})
     */
    @SuppressWarnings("rawtypes")
	public static List<Map> unequalsFilter(List<Map> source, String[] keys, String[] values) {
		if (keys.length != values.length) {
			throw new NullPointerException("参数个数不正确！");
		}

		int length = keys.length;

		if (length == 0) {
			return source;
		}
		List<Map> result = Lists.newArrayList();
		Iterator it = source.iterator();
		while (it.hasNext()) {
			Map one = (Map) it.next();

			int j = 0;
			for (int i = 0; i < length; i++) {
				if (!values[i].equals(one.get(keys[i])))
					j++;
			}

			if (j == length) {
				result.add(one);
			}
		}

		return result;
	}
    
    /**
     * 查找.从 List 中过滤掉字段名为key，其值为values(过滤掉很多种情况)的 Map
     * @param source
     * @param key
     * @param value
     * @return
     * @Description举例         Utility.unequalsFilter(source, "NEXT_DEAL_TAG", new String[]{ "Z","0" })
     *              			Utility.unequalsFilter(source, "NEXT_DEAL_TAG", Lang.array( "Z","0" ))
     */   
    @SuppressWarnings("rawtypes")
	public static List<Map> unequalsFilter(List<Map> source, String key, String[] values) {
    	List<Map> result = Lists.newArrayList();
        Map data = Maps.newHashMap();
        for(int i=source.size()-1;i>=0;--i)
        {
            data =(Map)source.get(i);
            for(int j=0;j<values.length;++j)
            {
                if(data.containsKey(key)&&data.get(key).equals(values[j]))
                {
                    result.add(0,data);
                    break;
                }
            }
        }
        source.removeAll(result);
        return source;   	
    }
 
  
    
	/**
	 * 窄化，仅仅返回指定的列，可指定别名。
	 * @param source
	 * @param keys
	 * @return
	 * @Description 举例  	Utility.narrow( source,  Lang.array("A", "B", "C:cc"))
	 */

	@SuppressWarnings("rawtypes")
	public static List<Map> narrow(List<Map> source, String[] key) {
		List<Map> result = Lists.newArrayList();
		Map data = Maps.newHashMap();
		Map<String,Object> narrow = null;
		for (int i = 0; i < source.size(); i++) {
			data = (Map) source.get(i);
			narrow = Maps.newHashMap();
			for (int j = 0; j < key.length; j++) {
				String[] s = key[j].split(":");
				if (s.length > 1) {
					String code = s[0];
					String alias = s[1];
					narrow.put(alias, data.get(code));
				} else {
					narrow.put(key[j], data.get(key[j]));
				}
			}
			result.add(narrow);
		}

		return result;
	}
	
	
	/**
	 * 名称带下划线转换为驼峰式
	 * @param String 
	 * @return String
	 * @Description 
	 */

	public static final char UNDERLINE='_';
	public static String underlineToCamel(String param){ 
	       if (param==null||"".equals(param.trim())){  
	           return "";  
	       }  
	       int len=param.length();  
	       StringBuilder sb=new StringBuilder(len);  
	       for (int i = 0; i < len; i++) {  
	           char c=param.charAt(i);  
	           if (c==UNDERLINE){  
	              if (++i<len){  
	                  sb.append(Character.toUpperCase(param.charAt(i)));  
	              }  
	           }else{  
	               sb.append(c);  
	           }  
	       }  
	       return sb.toString();  
	   } 
	
	/**
	 * 驼峰式命名转为带下划线命名
	 * @param String
	 * @return String
	 * @Description 
	 */
	
	   public static String camelToUnderline(String param){  
	       if (param==null||"".equals(param.trim())){  
	           return "";  
	       }  
	       int len=param.length();  
	       StringBuilder sb=new StringBuilder(len);  
	       for (int i = 0; i < len; i++) {  
	           char c=param.charAt(i);  
	           if (Character.isUpperCase(c)){  
	               sb.append(UNDERLINE);  
	               sb.append(Character.toLowerCase(c));  
	           }else{  
	               sb.append(c);  
	           }  
	       }  
	       return sb.toString();  
	   } 
	
	
	/**
	 * 名称带下划线转换为驼峰式
	 * @param list
	 * @return list
	 * @Description 
	 */
	
	public static List<Map<String, Object>> underLineToCamel(List<Map<String, Object>> list) {
		// 用于返回结果
		List<Map<String, Object>> repListA = new ArrayList<Map<String, Object>>();

		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> maptempC = new HashMap<String, Object>();
			Map<String, Object> maptemp = list.get(i);
			Set<String> settemp = maptemp.keySet();
			Iterator<String> ittemp = (Iterator<String>) settemp.iterator();
			while (ittemp.hasNext()) {
				Object key = ittemp.next();
				Object value = maptemp.get(key);
				String keyCamel = Utility.underlineToCamel((String) key);
				maptempC.put(keyCamel, value);
			}
			repListA.add(i, maptempC);
		}
		return repListA;
	}
	
	
	/**
	 * 驼峰式命名转为带下划线命名
	 * @param list
	 * @return list
	 * @Description 
	 */
	
	public static List<Map<String, Object>> camelToUnderline(List<Map<String, Object>> list) {
		// 用于返回结果
		List<Map<String, Object>> repListA = new ArrayList<Map<String, Object>>();

		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> maptempC = new HashMap<String, Object>();
			Map<String, Object> maptemp = list.get(i);
			Set<String> settemp = maptemp.keySet();
			Iterator<String> ittemp = (Iterator<String>) settemp.iterator();
			while (ittemp.hasNext()) {
				Object key = ittemp.next();
				Object value = maptemp.get(key);
				String keyUnderline = Utility.camelToUnderline((String) key);
				maptempC.put(keyUnderline, value);
			}
			repListA.add(i, maptempC);
		}

		return repListA;
	}

}
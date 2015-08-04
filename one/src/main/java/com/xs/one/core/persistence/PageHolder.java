package com.xs.one.core.persistence;

/** 
 * DataSourceHolder上下文
 * 
 */
public class PageHolder {

    private static final ThreadLocal<PageBck> pageHolder = new ThreadLocal<PageBck>();
    
    public static void setPage(PageBck page) {
        if(!page.equals(pageHolder.get())){
            pageHolder.set(page);
        }
    }

    public static PageBck getPage() {
        return pageHolder.get();
    }

    public static void clearContext() {
        pageHolder.remove();
    }
}

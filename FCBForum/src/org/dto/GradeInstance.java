package org.dto;

import java.util.HashMap;
import java.util.Map;

/*
 * 等级转换单例
 */
public class GradeInstance {
	
	private static GradeInstance instance = null;
	
	private static Map<String,String> gradeMap = new HashMap<String,String>();

	public static synchronized GradeInstance getInstance(){
	    if (instance==null){	    	
	        instance = new GradeInstance();
	        instance.init();
	        }    
	     return instance;
    }
	
	//初始化map
	public void init(){
		gradeMap.put("0", "普通用户");
		gradeMap.put("1", "版主");
		gradeMap.put("2", "管理员");
	}
	
	/**
	 * 按key转出等级名称
	 * @param key
	 * @return
	 */
	public String getByKey(String key){
		return (String)gradeMap.get(key);
	}
}

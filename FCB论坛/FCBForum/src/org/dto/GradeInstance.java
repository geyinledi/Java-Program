package org.dto;

import java.util.HashMap;
import java.util.Map;

/*
 * �ȼ�ת������
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
	
	//��ʼ��map
	public void init(){
		gradeMap.put("0", "��ͨ�û�");
		gradeMap.put("1", "����");
		gradeMap.put("2", "����Ա");
	}
	
	/**
	 * ��keyת���ȼ�����
	 * @param key
	 * @return
	 */
	public String getByKey(String key){
		return (String)gradeMap.get(key);
	}
}

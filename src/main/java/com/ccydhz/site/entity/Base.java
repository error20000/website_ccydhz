package com.ccydhz.site.entity;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.jian.tools.core.JsonTools;
import com.jian.tools.core.Tools;

public class Base<T> implements Cloneable{

	
	public String serialize() {
		return JsonTools.toJsonString(this);
	}
	
	@SuppressWarnings("unchecked")
	public void unserialize(String str) {
		T base = (T) JsonTools.jsonToObj(str, this.getClass());
		Field[] fs = Tools.getFields(this.getClass());
		for (Field field : fs) {
			Method[] setMethods = Tools.getMethods(this.getClass(), "set"+field.getName().substring(0, 1).toUpperCase()+field.getName().substring(1));
			Method[] getMethods = Tools.getMethods(this.getClass(), "get"+field.getName().substring(0, 1).toUpperCase()+field.getName().substring(1));
			if(setMethods.length > 0 && getMethods.length > 0){
				try {
					setMethods[0].invoke(this, getMethods[0].invoke(base));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public T clone() {
		T base = null;  
        try{  
        	base = (T)super.clone();  
        }catch(CloneNotSupportedException e) {  
            e.printStackTrace();  
        }  
        return base;
	}
	
}

package com.entity.view;

import com.entity.MeishifenxiangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 美食分享
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2022-03-30 10:53:47
 */
@TableName("meishifenxiang")
public class MeishifenxiangView  extends MeishifenxiangEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public MeishifenxiangView(){
	}
 
 	public MeishifenxiangView(MeishifenxiangEntity meishifenxiangEntity){
 	try {
			BeanUtils.copyProperties(this, meishifenxiangEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}

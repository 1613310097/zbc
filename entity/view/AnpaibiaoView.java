package com.entity.view;

import com.entity.AnpaibiaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 安排表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-01-15 18:16:18
 */
@TableName("anpaibiao")
public class AnpaibiaoView  extends AnpaibiaoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public AnpaibiaoView(){
	}
 
 	public AnpaibiaoView(AnpaibiaoEntity anpaibiaoEntity){
 	try {
			BeanUtils.copyProperties(this, anpaibiaoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}

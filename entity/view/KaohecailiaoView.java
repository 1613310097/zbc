package com.entity.view;

import com.entity.KaohecailiaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 考核材料
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-01-15 18:16:18
 */
@TableName("kaohecailiao")
public class KaohecailiaoView  extends KaohecailiaoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public KaohecailiaoView(){
	}
 
 	public KaohecailiaoView(KaohecailiaoEntity kaohecailiaoEntity){
 	try {
			BeanUtils.copyProperties(this, kaohecailiaoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}

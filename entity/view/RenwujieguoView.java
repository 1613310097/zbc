package com.entity.view;

import com.entity.RenwujieguoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 任务结果
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-01-15 18:16:18
 */
@TableName("renwujieguo")
public class RenwujieguoView  extends RenwujieguoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public RenwujieguoView(){
	}
 
 	public RenwujieguoView(RenwujieguoEntity renwujieguoEntity){
 	try {
			BeanUtils.copyProperties(this, renwujieguoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}

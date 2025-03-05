package com.entity.model;

import com.entity.DianziqianzhangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 电子签章
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2025-01-15 18:16:18
 */
public class DianziqianzhangModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 预览
	 */
	
	private String yulan;
		
	/**
	 * 文件
	 */
	
	private String wenjian;
		
	/**
	 * 盖章时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date gaizhangshijian;
		
	/**
	 * 操作人
	 */
	
	private String caozuoren;
		
	/**
	 * 用户id
	 */
	
	private Long userid;
				
	
	/**
	 * 设置：预览
	 */
	 
	public void setYulan(String yulan) {
		this.yulan = yulan;
	}
	
	/**
	 * 获取：预览
	 */
	public String getYulan() {
		return yulan;
	}
				
	
	/**
	 * 设置：文件
	 */
	 
	public void setWenjian(String wenjian) {
		this.wenjian = wenjian;
	}
	
	/**
	 * 获取：文件
	 */
	public String getWenjian() {
		return wenjian;
	}
				
	
	/**
	 * 设置：盖章时间
	 */
	 
	public void setGaizhangshijian(Date gaizhangshijian) {
		this.gaizhangshijian = gaizhangshijian;
	}
	
	/**
	 * 获取：盖章时间
	 */
	public Date getGaizhangshijian() {
		return gaizhangshijian;
	}
				
	
	/**
	 * 设置：操作人
	 */
	 
	public void setCaozuoren(String caozuoren) {
		this.caozuoren = caozuoren;
	}
	
	/**
	 * 获取：操作人
	 */
	public String getCaozuoren() {
		return caozuoren;
	}
				
	
	/**
	 * 设置：用户id
	 */
	 
	public void setUserid(Long userid) {
		this.userid = userid;
	}
	
	/**
	 * 获取：用户id
	 */
	public Long getUserid() {
		return userid;
	}
			
}

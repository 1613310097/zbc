package com.entity.model;

import com.entity.KaohecailiaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 考核材料
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2025-01-15 18:16:18
 */
public class KaohecailiaoModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 材料封面
	 */
	
	private String cailiaofengmian;
		
	/**
	 * 类型
	 */
	
	private String leixing;
		
	/**
	 * 材料附件
	 */
	
	private String cailiaofujian;
		
	/**
	 * 检查对象
	 */
	
	private String jianchaduixiang;
		
	/**
	 * 材料简介
	 */
	
	private String cailiaojianjie;
		
	/**
	 * 材料内容
	 */
	
	private String cailiaoneirong;
		
	/**
	 * 教师工号
	 */
	
	private String jiaoshigonghao;
		
	/**
	 * 批改老师
	 */
	
	private String jiaoshixingming;
		
	/**
	 * 上传日期
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date shangchuanriqi;
		
	/**
	 * 是否审核
	 */
	
	private String sfsh;
		
	/**
	 * 审核回复
	 */
	
	private String shhf;
		
	/**
	 * 收藏数
	 */
	
	private Integer storeupnum;
				
	
	/**
	 * 设置：材料封面
	 */
	 
	public void setCailiaofengmian(String cailiaofengmian) {
		this.cailiaofengmian = cailiaofengmian;
	}
	
	/**
	 * 获取：材料封面
	 */
	public String getCailiaofengmian() {
		return cailiaofengmian;
	}
				
	
	/**
	 * 设置：类型
	 */
	 
	public void setLeixing(String leixing) {
		this.leixing = leixing;
	}
	
	/**
	 * 获取：类型
	 */
	public String getLeixing() {
		return leixing;
	}
				
	
	/**
	 * 设置：材料附件
	 */
	 
	public void setCailiaofujian(String cailiaofujian) {
		this.cailiaofujian = cailiaofujian;
	}
	
	/**
	 * 获取：材料附件
	 */
	public String getCailiaofujian() {
		return cailiaofujian;
	}
				
	
	/**
	 * 设置：检查对象
	 */
	 
	public void setJianchaduixiang(String jianchaduixiang) {
		this.jianchaduixiang = jianchaduixiang;
	}
	
	/**
	 * 获取：检查对象
	 */
	public String getJianchaduixiang() {
		return jianchaduixiang;
	}
				
	
	/**
	 * 设置：材料简介
	 */
	 
	public void setCailiaojianjie(String cailiaojianjie) {
		this.cailiaojianjie = cailiaojianjie;
	}
	
	/**
	 * 获取：材料简介
	 */
	public String getCailiaojianjie() {
		return cailiaojianjie;
	}
				
	
	/**
	 * 设置：材料内容
	 */
	 
	public void setCailiaoneirong(String cailiaoneirong) {
		this.cailiaoneirong = cailiaoneirong;
	}
	
	/**
	 * 获取：材料内容
	 */
	public String getCailiaoneirong() {
		return cailiaoneirong;
	}
				
	
	/**
	 * 设置：教师工号
	 */
	 
	public void setJiaoshigonghao(String jiaoshigonghao) {
		this.jiaoshigonghao = jiaoshigonghao;
	}
	
	/**
	 * 获取：教师工号
	 */
	public String getJiaoshigonghao() {
		return jiaoshigonghao;
	}
				
	
	/**
	 * 设置：批改老师
	 */
	 
	public void setJiaoshixingming(String jiaoshixingming) {
		this.jiaoshixingming = jiaoshixingming;
	}
	
	/**
	 * 获取：批改老师
	 */
	public String getJiaoshixingming() {
		return jiaoshixingming;
	}
				
	
	/**
	 * 设置：上传日期
	 */
	 
	public void setShangchuanriqi(Date shangchuanriqi) {
		this.shangchuanriqi = shangchuanriqi;
	}
	
	/**
	 * 获取：上传日期
	 */
	public Date getShangchuanriqi() {
		return shangchuanriqi;
	}
				
	
	/**
	 * 设置：是否审核
	 */
	 
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
				
	
	/**
	 * 设置：审核回复
	 */
	 
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	
	/**
	 * 获取：审核回复
	 */
	public String getShhf() {
		return shhf;
	}
				
	
	/**
	 * 设置：收藏数
	 */
	 
	public void setStoreupnum(Integer storeupnum) {
		this.storeupnum = storeupnum;
	}
	
	/**
	 * 获取：收藏数
	 */
	public Integer getStoreupnum() {
		return storeupnum;
	}
			
}

package com.entity.model;

import com.entity.LunwenxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 论文信息
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2025-01-15 18:16:18
 */
public class LunwenxinxiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 封面
	 */
	
	private String fengmian;
		
	/**
	 * 论文类型
	 */
	
	private String lunwenleixing;
		
	/**
	 * 研究背景
	 */
	
	private String yanjiubeijing;
		
	/**
	 * 检查对象
	 */
	
	private String jianchaduixiang;
		
	/**
	 * 目的和意义
	 */
	
	private String mudeheyiyi;
		
	/**
	 * 研究结果
	 */
	
	private String yanjiujieguo;
		
	/**
	 * 论文附件
	 */
	
	private String lunwenfujian;
		
	/**
	 * 教师工号
	 */
	
	private String jiaoshigonghao;
		
	/**
	 * 批改老师
	 */
	
	private String jiaoshixingming;
		
	/**
	 * 联系手机
	 */
	
	private String lianxishouji;
		
	/**
	 * 是否审核
	 */
	
	private String sfsh;
		
	/**
	 * 审核回复
	 */
	
	private String shhf;
				
	
	/**
	 * 设置：封面
	 */
	 
	public void setFengmian(String fengmian) {
		this.fengmian = fengmian;
	}
	
	/**
	 * 获取：封面
	 */
	public String getFengmian() {
		return fengmian;
	}
				
	
	/**
	 * 设置：论文类型
	 */
	 
	public void setLunwenleixing(String lunwenleixing) {
		this.lunwenleixing = lunwenleixing;
	}
	
	/**
	 * 获取：论文类型
	 */
	public String getLunwenleixing() {
		return lunwenleixing;
	}
				
	
	/**
	 * 设置：研究背景
	 */
	 
	public void setYanjiubeijing(String yanjiubeijing) {
		this.yanjiubeijing = yanjiubeijing;
	}
	
	/**
	 * 获取：研究背景
	 */
	public String getYanjiubeijing() {
		return yanjiubeijing;
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
	 * 设置：目的和意义
	 */
	 
	public void setMudeheyiyi(String mudeheyiyi) {
		this.mudeheyiyi = mudeheyiyi;
	}
	
	/**
	 * 获取：目的和意义
	 */
	public String getMudeheyiyi() {
		return mudeheyiyi;
	}
				
	
	/**
	 * 设置：研究结果
	 */
	 
	public void setYanjiujieguo(String yanjiujieguo) {
		this.yanjiujieguo = yanjiujieguo;
	}
	
	/**
	 * 获取：研究结果
	 */
	public String getYanjiujieguo() {
		return yanjiujieguo;
	}
				
	
	/**
	 * 设置：论文附件
	 */
	 
	public void setLunwenfujian(String lunwenfujian) {
		this.lunwenfujian = lunwenfujian;
	}
	
	/**
	 * 获取：论文附件
	 */
	public String getLunwenfujian() {
		return lunwenfujian;
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
	 * 设置：联系手机
	 */
	 
	public void setLianxishouji(String lianxishouji) {
		this.lianxishouji = lianxishouji;
	}
	
	/**
	 * 获取：联系手机
	 */
	public String getLianxishouji() {
		return lianxishouji;
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
			
}

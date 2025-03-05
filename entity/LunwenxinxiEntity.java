package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 论文信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2025-01-15 18:16:18
 */
@TableName("lunwenxinxi")
public class LunwenxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public LunwenxinxiEntity() {
		
	}
	
	public LunwenxinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
    @TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * 论文名称
	 */
					
	private String lunwenmingcheng;
	
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
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：论文名称
	 */
	public void setLunwenmingcheng(String lunwenmingcheng) {
		this.lunwenmingcheng = lunwenmingcheng;
	}
	/**
	 * 获取：论文名称
	 */
	public String getLunwenmingcheng() {
		return lunwenmingcheng;
	}
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

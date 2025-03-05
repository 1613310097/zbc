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
 * 安排表
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2025-01-15 18:16:18
 */
@TableName("anpaibiao")
public class AnpaibiaoEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public AnpaibiaoEntity() {
		
	}
	
	public AnpaibiaoEntity(T t) {
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
	 * 检查项目
	 */
					
	private String jianchaxiangmu;
	
	/**
	 * 封面
	 */
					
	private String fengmian;
	
	/**
	 * 类型
	 */
					
	private String leixing;
	
	/**
	 * 检查对象
	 */
					
	private String jianchaduixiang;
	
	/**
	 * 项目要求
	 */
					
	private String xiangmuyaoqiu;
	
	/**
	 * 文件
	 */
					
	private String wenjian;
	
	/**
	 * 完成状态
	 */
					
	private String wanchengzhuangtai;
	
	/**
	 * 任务内容
	 */
					
	private String renwuneirong;
	
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
	 * 专业
	 */
					
	private String zhuanye;
	
	
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
	 * 设置：检查项目
	 */
	public void setJianchaxiangmu(String jianchaxiangmu) {
		this.jianchaxiangmu = jianchaxiangmu;
	}
	/**
	 * 获取：检查项目
	 */
	public String getJianchaxiangmu() {
		return jianchaxiangmu;
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
	 * 设置：项目要求
	 */
	public void setXiangmuyaoqiu(String xiangmuyaoqiu) {
		this.xiangmuyaoqiu = xiangmuyaoqiu;
	}
	/**
	 * 获取：项目要求
	 */
	public String getXiangmuyaoqiu() {
		return xiangmuyaoqiu;
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
	 * 设置：完成状态
	 */
	public void setWanchengzhuangtai(String wanchengzhuangtai) {
		this.wanchengzhuangtai = wanchengzhuangtai;
	}
	/**
	 * 获取：完成状态
	 */
	public String getWanchengzhuangtai() {
		return wanchengzhuangtai;
	}
	/**
	 * 设置：任务内容
	 */
	public void setRenwuneirong(String renwuneirong) {
		this.renwuneirong = renwuneirong;
	}
	/**
	 * 获取：任务内容
	 */
	public String getRenwuneirong() {
		return renwuneirong;
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
	 * 设置：专业
	 */
	public void setZhuanye(String zhuanye) {
		this.zhuanye = zhuanye;
	}
	/**
	 * 获取：专业
	 */
	public String getZhuanye() {
		return zhuanye;
	}

}

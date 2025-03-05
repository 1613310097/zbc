package com.dao;

import com.entity.AnpaibiaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.AnpaibiaoVO;
import com.entity.view.AnpaibiaoView;


/**
 * 安排表
 * 
 * @author 
 * @email 
 * @date 2025-01-15 18:16:18
 */
public interface AnpaibiaoDao extends BaseMapper<AnpaibiaoEntity> {
	
	List<AnpaibiaoVO> selectListVO(@Param("ew") Wrapper<AnpaibiaoEntity> wrapper);
	
	AnpaibiaoVO selectVO(@Param("ew") Wrapper<AnpaibiaoEntity> wrapper);
	
	List<AnpaibiaoView> selectListView(@Param("ew") Wrapper<AnpaibiaoEntity> wrapper);

	List<AnpaibiaoView> selectListView(Pagination page,@Param("ew") Wrapper<AnpaibiaoEntity> wrapper);

	
	AnpaibiaoView selectView(@Param("ew") Wrapper<AnpaibiaoEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<AnpaibiaoEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<AnpaibiaoEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<AnpaibiaoEntity> wrapper);


    List<Map<String, Object>> jiaoshixingmingwanchengzhuangtaiTypeStat(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<AnpaibiaoEntity> wrapper);

}

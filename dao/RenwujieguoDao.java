package com.dao;

import com.entity.RenwujieguoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.RenwujieguoVO;
import com.entity.view.RenwujieguoView;


/**
 * 任务结果
 * 
 * @author 
 * @email 
 * @date 2025-01-15 18:16:18
 */
public interface RenwujieguoDao extends BaseMapper<RenwujieguoEntity> {
	
	List<RenwujieguoVO> selectListVO(@Param("ew") Wrapper<RenwujieguoEntity> wrapper);
	
	RenwujieguoVO selectVO(@Param("ew") Wrapper<RenwujieguoEntity> wrapper);
	
	List<RenwujieguoView> selectListView(@Param("ew") Wrapper<RenwujieguoEntity> wrapper);

	List<RenwujieguoView> selectListView(Pagination page,@Param("ew") Wrapper<RenwujieguoEntity> wrapper);

	
	RenwujieguoView selectView(@Param("ew") Wrapper<RenwujieguoEntity> wrapper);
	

}

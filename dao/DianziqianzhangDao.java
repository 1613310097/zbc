package com.dao;

import com.entity.DianziqianzhangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DianziqianzhangVO;
import com.entity.view.DianziqianzhangView;


/**
 * 电子签章
 * 
 * @author 
 * @email 
 * @date 2025-01-15 18:16:18
 */
public interface DianziqianzhangDao extends BaseMapper<DianziqianzhangEntity> {
	
	List<DianziqianzhangVO> selectListVO(@Param("ew") Wrapper<DianziqianzhangEntity> wrapper);
	
	DianziqianzhangVO selectVO(@Param("ew") Wrapper<DianziqianzhangEntity> wrapper);
	
	List<DianziqianzhangView> selectListView(@Param("ew") Wrapper<DianziqianzhangEntity> wrapper);

	List<DianziqianzhangView> selectListView(Pagination page,@Param("ew") Wrapper<DianziqianzhangEntity> wrapper);

	
	DianziqianzhangView selectView(@Param("ew") Wrapper<DianziqianzhangEntity> wrapper);
	

}

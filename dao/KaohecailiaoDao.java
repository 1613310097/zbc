package com.dao;

import com.entity.KaohecailiaoEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.KaohecailiaoVO;
import com.entity.view.KaohecailiaoView;


/**
 * 考核材料
 * 
 * @author 
 * @email 
 * @date 2025-01-15 18:16:18
 */
public interface KaohecailiaoDao extends BaseMapper<KaohecailiaoEntity> {
	
	List<KaohecailiaoVO> selectListVO(@Param("ew") Wrapper<KaohecailiaoEntity> wrapper);
	
	KaohecailiaoVO selectVO(@Param("ew") Wrapper<KaohecailiaoEntity> wrapper);
	
	List<KaohecailiaoView> selectListView(@Param("ew") Wrapper<KaohecailiaoEntity> wrapper);

	List<KaohecailiaoView> selectListView(Pagination page,@Param("ew") Wrapper<KaohecailiaoEntity> wrapper);

	
	KaohecailiaoView selectView(@Param("ew") Wrapper<KaohecailiaoEntity> wrapper);
	

}

package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import java.util.Collections;

import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import com.utils.ValidatorUtils;
import com.utils.DeSensUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.RenwujieguoEntity;
import com.entity.view.RenwujieguoView;

import com.service.RenwujieguoService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 任务结果
 * 后端接口
 * @author 
 * @email 
 * @date 2025-01-15 18:16:18
 */
@RestController
@RequestMapping("/renwujieguo")
public class RenwujieguoController {
    @Autowired
    private RenwujieguoService renwujieguoService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,RenwujieguoEntity renwujieguo,
		HttpServletRequest request){
        EntityWrapper<RenwujieguoEntity> ew = new EntityWrapper<RenwujieguoEntity>();

        String tableName = request.getSession().getAttribute("tableName").toString();
        ew.andNew();
        if(tableName.equals("jiaoshi")) {
            ew.eq("jianchaduixiang", (String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("jiaoshi")) {
            ew.or();
            ew.eq("jiaoshigonghao", (String)request.getSession().getAttribute("username"));
        }
        ew.andNew("1=1");


		PageUtils page = renwujieguoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, renwujieguo), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,RenwujieguoEntity renwujieguo, 
		HttpServletRequest request){
        EntityWrapper<RenwujieguoEntity> ew = new EntityWrapper<RenwujieguoEntity>();

		PageUtils page = renwujieguoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, renwujieguo), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( RenwujieguoEntity renwujieguo){
       	EntityWrapper<RenwujieguoEntity> ew = new EntityWrapper<RenwujieguoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( renwujieguo, "renwujieguo")); 
        return R.ok().put("data", renwujieguoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(RenwujieguoEntity renwujieguo){
        EntityWrapper< RenwujieguoEntity> ew = new EntityWrapper< RenwujieguoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( renwujieguo, "renwujieguo")); 
		RenwujieguoView renwujieguoView =  renwujieguoService.selectView(ew);
		return R.ok("查询任务结果成功").put("data", renwujieguoView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        RenwujieguoEntity renwujieguo = renwujieguoService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(renwujieguo,deSens);
        return R.ok().put("data", renwujieguo);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        RenwujieguoEntity renwujieguo = renwujieguoService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(renwujieguo,deSens);
        return R.ok().put("data", renwujieguo);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody RenwujieguoEntity renwujieguo, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(renwujieguo);
        renwujieguoService.insert(renwujieguo);
        return R.ok().put("data",renwujieguo.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody RenwujieguoEntity renwujieguo, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(renwujieguo);
        renwujieguoService.insert(renwujieguo);
        return R.ok().put("data",renwujieguo.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody RenwujieguoEntity renwujieguo, HttpServletRequest request){
        //ValidatorUtils.validateEntity(renwujieguo);
        //全部更新
        renwujieguoService.updateById(renwujieguo);

        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        renwujieguoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	












}

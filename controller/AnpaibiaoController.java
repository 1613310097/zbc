package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.Random;
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

import com.entity.AnpaibiaoEntity;
import com.entity.view.AnpaibiaoView;

import com.service.AnpaibiaoService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 安排表
 * 后端接口
 * @author 
 * @email 
 * @date 2025-01-15 18:16:18
 */
@RestController
@RequestMapping("/anpaibiao")
public class AnpaibiaoController {
    @Autowired
    private AnpaibiaoService anpaibiaoService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,AnpaibiaoEntity anpaibiao,
		HttpServletRequest request){
        EntityWrapper<AnpaibiaoEntity> ew = new EntityWrapper<AnpaibiaoEntity>();

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


		PageUtils page = anpaibiaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, anpaibiao), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,AnpaibiaoEntity anpaibiao, 
		HttpServletRequest request){
        EntityWrapper<AnpaibiaoEntity> ew = new EntityWrapper<AnpaibiaoEntity>();

		PageUtils page = anpaibiaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, anpaibiao), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( AnpaibiaoEntity anpaibiao){
       	EntityWrapper<AnpaibiaoEntity> ew = new EntityWrapper<AnpaibiaoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( anpaibiao, "anpaibiao")); 
        return R.ok().put("data", anpaibiaoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(AnpaibiaoEntity anpaibiao){
        EntityWrapper< AnpaibiaoEntity> ew = new EntityWrapper< AnpaibiaoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( anpaibiao, "anpaibiao")); 
		AnpaibiaoView anpaibiaoView =  anpaibiaoService.selectView(ew);
		return R.ok("查询安排表成功").put("data", anpaibiaoView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        AnpaibiaoEntity anpaibiao = anpaibiaoService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(anpaibiao,deSens);
        return R.ok().put("data", anpaibiao);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        AnpaibiaoEntity anpaibiao = anpaibiaoService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(anpaibiao,deSens);
        return R.ok().put("data", anpaibiao);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody AnpaibiaoEntity anpaibiao, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(anpaibiao);
        anpaibiaoService.insert(anpaibiao);
        return R.ok().put("data",anpaibiao.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody AnpaibiaoEntity anpaibiao, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(anpaibiao);
        anpaibiaoService.insert(anpaibiao);
        return R.ok().put("data",anpaibiao.getId());
    }

    /**
     * 批量生成数据
     */
    @RequestMapping("/batch/gen")
    public R batch(int recordNum){
        List<AnpaibiaoEntity> list = anpaibiaoService.selectList(new EntityWrapper<AnpaibiaoEntity>().last("order by rand() limit 50"));
        if(list!=null && list.size()>0 && recordNum>0) {
            List<AnpaibiaoEntity> batchList = new ArrayList<AnpaibiaoEntity>(recordNum);
            int max = list.size();
            Random random = new Random();
            for(int i=0;i<recordNum;i++) {
                AnpaibiaoEntity anpaibiao = new AnpaibiaoEntity();
               anpaibiao.setJianchaxiangmu(list.get(random.nextInt(max)).getJianchaxiangmu());
               anpaibiao.setFengmian(list.get(random.nextInt(max)).getFengmian());
               anpaibiao.setLeixing(list.get(random.nextInt(max)).getLeixing());
               anpaibiao.setJianchaduixiang(list.get(random.nextInt(max)).getJianchaduixiang());
               anpaibiao.setXiangmuyaoqiu(list.get(random.nextInt(max)).getXiangmuyaoqiu());
               anpaibiao.setWenjian(list.get(random.nextInt(max)).getWenjian());
               anpaibiao.setWanchengzhuangtai(list.get(random.nextInt(max)).getWanchengzhuangtai());
               anpaibiao.setRenwuneirong(list.get(random.nextInt(max)).getRenwuneirong());
               anpaibiao.setJiaoshigonghao(list.get(random.nextInt(max)).getJiaoshigonghao());
               anpaibiao.setJiaoshixingming(list.get(random.nextInt(max)).getJiaoshixingming());
               anpaibiao.setLianxishouji(list.get(random.nextInt(max)).getLianxishouji());
               anpaibiao.setZhuanye(list.get(random.nextInt(max)).getZhuanye());
                batchList.add(anpaibiao);
            }
            anpaibiaoService.insertBatch(batchList);
        }
        return R.ok();
    }




    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody AnpaibiaoEntity anpaibiao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(anpaibiao);
        //全部更新
        anpaibiaoService.updateById(anpaibiao);

        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        anpaibiaoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








        /**
     * （按值统计）
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}")
    public R value(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName,HttpServletRequest request) throws IOException {
        java.nio.file.Path path = java.nio.file.Paths.get("value_anpaibiao_" + xColumnName + "_" + yColumnName + "_timeType.json");
        if(java.nio.file.Files.exists(path)) {
            String content = new String(java.nio.file.Files.readAllBytes(path), java.nio.charset.StandardCharsets.UTF_8);
            return R.ok().put("data", (new org.json.JSONArray(content)).toList());
        }else{
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        EntityWrapper<AnpaibiaoEntity> ew = new EntityWrapper<AnpaibiaoEntity>();
            List<Map<String, Object>> result = anpaibiaoService.selectValue(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        Collections.sort(result, (map1, map2) -> {
            // 假设 total 总是存在并且是数值类型
            Number total1 = (Number) map1.get("total");
            Number total2 = (Number) map2.get("total");
            if(total1==null)
            {
                total1 = 0;
            }
            if(total2==null)
            {
                total2 = 0;
            }
            return Double.compare(total2.doubleValue(), total1.doubleValue());
        });
        return R.ok().put("data", result);
        }
    }
    
    /**
     * （按值统计(多)）
     */
    @RequestMapping("/valueMul/{xColumnName}")
    public R valueMul(@PathVariable("xColumnName") String xColumnName,@RequestParam String yColumnNameMul,HttpServletRequest request)  throws IOException {
        java.nio.file.Path path = java.nio.file.Paths.get("value_anpaibiao_" + xColumnName + "_" + yColumnNameMul + "_timeType.json");
        if(java.nio.file.Files.exists(path)) {
            String content = new String(java.nio.file.Files.readAllBytes(path), java.nio.charset.StandardCharsets.UTF_8);
            return R.ok().put("data", (new org.json.JSONArray(content)).toList());
        }else{
        String[] yColumnNames = yColumnNameMul.split(",");
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("xColumn", xColumnName);
        List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        EntityWrapper<AnpaibiaoEntity> ew = new EntityWrapper<AnpaibiaoEntity>();
        for(int i=0;i<yColumnNames.length;i++) {
            params.put("yColumn", yColumnNames[i]);
            List<Map<String, Object>> result = anpaibiaoService.selectValue(params, ew);
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            result2.add(result);
        }
        return R.ok().put("data", result2);
    }
}
    
    /**
     * （按值统计）时间统计类型
     */
    @RequestMapping("/value/{xColumnName}/{yColumnName}/{timeStatType}")
    public R valueDay(@PathVariable("yColumnName") String yColumnName, @PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,HttpServletRequest request) throws IOException {
        java.nio.file.Path path = java.nio.file.Paths.get("value_anpaibiao_" + xColumnName + "_" + yColumnName + "_"+timeStatType+".json");
        if(java.nio.file.Files.exists(path)) {
            String content = new String(java.nio.file.Files.readAllBytes(path), java.nio.charset.StandardCharsets.UTF_8);
            return R.ok().put("data", (new org.json.JSONArray(content)).toList());
        }else{
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("xColumn", xColumnName);
            params.put("yColumn", yColumnName);
            params.put("timeStatType", timeStatType);
            EntityWrapper<AnpaibiaoEntity> ew = new EntityWrapper<AnpaibiaoEntity>();
                    List<Map<String, Object>> result = anpaibiaoService.selectTimeStatValue(params, ew);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            for(Map<String, Object> m : result) {
                for(String k : m.keySet()) {
                    if(m.get(k) instanceof Date) {
                        m.put(k, sdf.format((Date)m.get(k)));
                    }
                }
            }
            return R.ok().put("data", result);
        }
    }
    
        /**
     * （按值统计）时间统计类型(多)
     */
    @RequestMapping("/valueMul/{xColumnName}/{timeStatType}")
    public R valueMulDay(@PathVariable("xColumnName") String xColumnName, @PathVariable("timeStatType") String timeStatType,@RequestParam String yColumnNameMul,HttpServletRequest request) throws IOException
    {
        java.nio.file.Path path = java.nio.file.Paths.get("value_anpaibiao_" + xColumnName + "_" + yColumnNameMul + "_" + timeStatType + ".json");
        if (java.nio.file.Files.exists(path)) {
            String content = new String(java.nio.file.Files.readAllBytes(path), java.nio.charset.StandardCharsets.UTF_8);
            return R.ok().put("data", (new org.json.JSONArray(content)).toList());
        }else{
            String[] yColumnNames = yColumnNameMul.split(",");
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("xColumn", xColumnName);
            params.put("timeStatType", timeStatType);
            List<List<Map<String, Object>>> result2 = new ArrayList<List<Map<String,Object>>>();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            EntityWrapper<AnpaibiaoEntity> ew = new EntityWrapper<AnpaibiaoEntity>();
            for(int i=0;i<yColumnNames.length;i++) {
                params.put("yColumn", yColumnNames[i]);
                List<Map<String, Object>> result = anpaibiaoService.selectTimeStatValue(params, ew);
                for(Map<String, Object> m : result) {
                    for(String k : m.keySet()) {
                        if(m.get(k) instanceof Date) {
                            m.put(k, sdf.format((Date)m.get(k)));
                        }
                    }
                }
                result2.add(result);
            }
            return R.ok().put("data", result2);
        }
    }
    
        /**
     * 分组统计
     */
    @RequestMapping("/group/{columnName}")
    public R group(@PathVariable("columnName") String columnName,HttpServletRequest request) throws IOException {
        java.nio.file.Path path = java.nio.file.Paths.get("group_anpaibiao_" + columnName + "_timeType.json");
        if(java.nio.file.Files.exists(path)){
            String content = new String(java.nio.file.Files.readAllBytes(path), java.nio.charset.StandardCharsets.UTF_8);
            return R.ok().put("data", (new org.json.JSONArray(content)).toList());
        }else{
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("column", columnName);
        EntityWrapper<AnpaibiaoEntity> ew = new EntityWrapper<AnpaibiaoEntity>();
            List<Map<String, Object>> result = anpaibiaoService.selectGroup(params, ew);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for(Map<String, Object> m : result) {
            for(String k : m.keySet()) {
                if(m.get(k) instanceof Date) {
                    m.put(k, sdf.format((Date)m.get(k)));
                }
            }
        }
        return R.ok().put("data", result);
        }
    }    
    
    


    /**
     * 分组统计
     */
    @RequestMapping("/typeStat/wanchengzhuangtai/jiaoshixingming")
    @IgnoreAuth
    public R jiaoshixingmingwanchengzhuangtaiTypeStat(HttpServletRequest request) {
        Map<String, Object> params = new HashMap<String, Object>();
        EntityWrapper<AnpaibiaoEntity> ew = new EntityWrapper<AnpaibiaoEntity>();
        List<Map<String, Object>> result = anpaibiaoService.jiaoshixingmingwanchengzhuangtaiTypeStat(params, ew);
        return R.ok().put("data", result);
    }


    /**
     * 总数量
     */
    @RequestMapping("/count")
    public R count(@RequestParam Map<String, Object> params,AnpaibiaoEntity anpaibiao, HttpServletRequest request){
        EntityWrapper<AnpaibiaoEntity> ew = new EntityWrapper<AnpaibiaoEntity>();
        int count = anpaibiaoService.selectCount(MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, anpaibiao), params), params));
        return R.ok().put("data", count);
    }




}

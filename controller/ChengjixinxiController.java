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

import com.entity.ChengjixinxiEntity;
import com.entity.view.ChengjixinxiView;

import com.service.ChengjixinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;
import java.io.InputStream;
import org.springframework.web.multipart.MultipartFile;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 成绩信息
 * 后端接口
 * @author 
 * @email 
 * @date 2025-01-15 18:16:18
 */
@RestController
@RequestMapping("/chengjixinxi")
public class ChengjixinxiController {
    @Autowired
    private ChengjixinxiService chengjixinxiService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ChengjixinxiEntity chengjixinxi,
		HttpServletRequest request){
        EntityWrapper<ChengjixinxiEntity> ew = new EntityWrapper<ChengjixinxiEntity>();

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


		PageUtils page = chengjixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chengjixinxi), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ChengjixinxiEntity chengjixinxi, 
		HttpServletRequest request){
        EntityWrapper<ChengjixinxiEntity> ew = new EntityWrapper<ChengjixinxiEntity>();

		PageUtils page = chengjixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, chengjixinxi), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ChengjixinxiEntity chengjixinxi){
       	EntityWrapper<ChengjixinxiEntity> ew = new EntityWrapper<ChengjixinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( chengjixinxi, "chengjixinxi")); 
        return R.ok().put("data", chengjixinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ChengjixinxiEntity chengjixinxi){
        EntityWrapper< ChengjixinxiEntity> ew = new EntityWrapper< ChengjixinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( chengjixinxi, "chengjixinxi")); 
		ChengjixinxiView chengjixinxiView =  chengjixinxiService.selectView(ew);
		return R.ok("查询成绩信息成功").put("data", chengjixinxiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ChengjixinxiEntity chengjixinxi = chengjixinxiService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(chengjixinxi,deSens);
        return R.ok().put("data", chengjixinxi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ChengjixinxiEntity chengjixinxi = chengjixinxiService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(chengjixinxi,deSens);
        return R.ok().put("data", chengjixinxi);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ChengjixinxiEntity chengjixinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(chengjixinxi);
        chengjixinxiService.insert(chengjixinxi);
        return R.ok().put("data",chengjixinxi.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ChengjixinxiEntity chengjixinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(chengjixinxi);
        chengjixinxiService.insert(chengjixinxi);
        return R.ok().put("data",chengjixinxi.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ChengjixinxiEntity chengjixinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(chengjixinxi);
        //全部更新
        chengjixinxiService.updateById(chengjixinxi);

        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<ChengjixinxiEntity> list = new ArrayList<ChengjixinxiEntity>();
        for(Long id : ids) {
            ChengjixinxiEntity chengjixinxi = chengjixinxiService.selectById(id);
            chengjixinxi.setSfsh(sfsh);
            chengjixinxi.setShhf(shhf);
            list.add(chengjixinxi);
        }
        chengjixinxiService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        chengjixinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	





    @RequestMapping("/importExcel")
    public R importExcel(@RequestParam("file") MultipartFile file){
        try {
            //获取输入流
            InputStream inputStream = file.getInputStream();
            //创建读取工作簿
            Workbook workbook = WorkbookFactory.create(inputStream);
            //获取工作表
            Sheet sheet = workbook.getSheetAt(0);
            //获取总行
            int rows=sheet.getPhysicalNumberOfRows();
            if(rows>1){
                //获取单元格
                for (int i = 1; i < rows; i++) {
                    Row row = sheet.getRow(i);
                    ChengjixinxiEntity chengjixinxiEntity =new ChengjixinxiEntity();
                    chengjixinxiEntity.setId(new Date().getTime());
                    String chengjimingcheng = CommonUtil.getCellValue(row.getCell(0));
                    chengjixinxiEntity.setChengjimingcheng(chengjimingcheng);
                    String banjimingcheng = CommonUtil.getCellValue(row.getCell(1));
                    chengjixinxiEntity.setBanjimingcheng(banjimingcheng);
                    String jianchaduixiang = CommonUtil.getCellValue(row.getCell(2));
                    chengjixinxiEntity.setJianchaduixiang(jianchaduixiang);
                    String jiaoshigonghao = CommonUtil.getCellValue(row.getCell(3));
                    chengjixinxiEntity.setJiaoshigonghao(jiaoshigonghao);
                    String jiaoshixingming = CommonUtil.getCellValue(row.getCell(4));
                    chengjixinxiEntity.setJiaoshixingming(jiaoshixingming);
                    String lianxishouji = CommonUtil.getCellValue(row.getCell(5));
                    chengjixinxiEntity.setLianxishouji(lianxishouji);
                     
                    //想数据库中添加新对象
                    chengjixinxiService.insert(chengjixinxiEntity);//方法
                }
            }
            inputStream.close();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return R.ok("导入成功");
    }







}

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

import com.entity.LunwenxinxiEntity;
import com.entity.view.LunwenxinxiView;

import com.service.LunwenxinxiService;
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
 * 论文信息
 * 后端接口
 * @author 
 * @email 
 * @date 2025-01-15 18:16:18
 */
@RestController
@RequestMapping("/lunwenxinxi")
public class LunwenxinxiController {
    @Autowired
    private LunwenxinxiService lunwenxinxiService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,LunwenxinxiEntity lunwenxinxi,
		HttpServletRequest request){
        EntityWrapper<LunwenxinxiEntity> ew = new EntityWrapper<LunwenxinxiEntity>();

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


		PageUtils page = lunwenxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, lunwenxinxi), params), params));
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,LunwenxinxiEntity lunwenxinxi, 
		HttpServletRequest request){
        EntityWrapper<LunwenxinxiEntity> ew = new EntityWrapper<LunwenxinxiEntity>();

		PageUtils page = lunwenxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, lunwenxinxi), params), params));
		
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( LunwenxinxiEntity lunwenxinxi){
       	EntityWrapper<LunwenxinxiEntity> ew = new EntityWrapper<LunwenxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( lunwenxinxi, "lunwenxinxi")); 
        return R.ok().put("data", lunwenxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(LunwenxinxiEntity lunwenxinxi){
        EntityWrapper< LunwenxinxiEntity> ew = new EntityWrapper< LunwenxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( lunwenxinxi, "lunwenxinxi")); 
		LunwenxinxiView lunwenxinxiView =  lunwenxinxiService.selectView(ew);
		return R.ok("查询论文信息成功").put("data", lunwenxinxiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        LunwenxinxiEntity lunwenxinxi = lunwenxinxiService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(lunwenxinxi,deSens);
        return R.ok().put("data", lunwenxinxi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        LunwenxinxiEntity lunwenxinxi = lunwenxinxiService.selectById(id);
				Map<String, String> deSens = new HashMap<>();
				DeSensUtil.desensitize(lunwenxinxi,deSens);
        return R.ok().put("data", lunwenxinxi);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody LunwenxinxiEntity lunwenxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(lunwenxinxi);
        lunwenxinxiService.insert(lunwenxinxi);
        return R.ok().put("data",lunwenxinxi.getId());
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody LunwenxinxiEntity lunwenxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(lunwenxinxi);
        lunwenxinxiService.insert(lunwenxinxi);
        return R.ok().put("data",lunwenxinxi.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody LunwenxinxiEntity lunwenxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(lunwenxinxi);
        //全部更新
        lunwenxinxiService.updateById(lunwenxinxi);

        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<LunwenxinxiEntity> list = new ArrayList<LunwenxinxiEntity>();
        for(Long id : ids) {
            LunwenxinxiEntity lunwenxinxi = lunwenxinxiService.selectById(id);
            lunwenxinxi.setSfsh(sfsh);
            lunwenxinxi.setShhf(shhf);
            list.add(lunwenxinxi);
        }
        lunwenxinxiService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        lunwenxinxiService.deleteBatchIds(Arrays.asList(ids));
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
                    LunwenxinxiEntity lunwenxinxiEntity =new LunwenxinxiEntity();
                    lunwenxinxiEntity.setId(new Date().getTime());
                    String lunwenmingcheng = CommonUtil.getCellValue(row.getCell(0));
                    lunwenxinxiEntity.setLunwenmingcheng(lunwenmingcheng);
                    String lunwenleixing = CommonUtil.getCellValue(row.getCell(1));
                    lunwenxinxiEntity.setLunwenleixing(lunwenleixing);
                    String yanjiubeijing = CommonUtil.getCellValue(row.getCell(2));
                    lunwenxinxiEntity.setYanjiubeijing(yanjiubeijing);
                    String jianchaduixiang = CommonUtil.getCellValue(row.getCell(3));
                    lunwenxinxiEntity.setJianchaduixiang(jianchaduixiang);
                    String mudeheyiyi = CommonUtil.getCellValue(row.getCell(4));
                    lunwenxinxiEntity.setMudeheyiyi(mudeheyiyi);
                    String yanjiujieguo = CommonUtil.getCellValue(row.getCell(5));
                    lunwenxinxiEntity.setYanjiujieguo(yanjiujieguo);
                    String jiaoshigonghao = CommonUtil.getCellValue(row.getCell(6));
                    lunwenxinxiEntity.setJiaoshigonghao(jiaoshigonghao);
                    String jiaoshixingming = CommonUtil.getCellValue(row.getCell(7));
                    lunwenxinxiEntity.setJiaoshixingming(jiaoshixingming);
                    String lianxishouji = CommonUtil.getCellValue(row.getCell(8));
                    lunwenxinxiEntity.setLianxishouji(lianxishouji);
                     
                    //想数据库中添加新对象
                    lunwenxinxiService.insert(lunwenxinxiEntity);//方法
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

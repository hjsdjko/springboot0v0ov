package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.MeishifenxiangEntity;
import com.entity.view.MeishifenxiangView;

import com.service.MeishifenxiangService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 美食分享
 * 后端接口
 * @author 
 * @email 
 * @date 2022-03-30 10:53:47
 */
@RestController
@RequestMapping("/meishifenxiang")
public class MeishifenxiangController {
    @Autowired
    private MeishifenxiangService meishifenxiangService;


    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,MeishifenxiangEntity meishifenxiang,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			meishifenxiang.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<MeishifenxiangEntity> ew = new EntityWrapper<MeishifenxiangEntity>();
		PageUtils page = meishifenxiangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, meishifenxiang), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,MeishifenxiangEntity meishifenxiang, 
		HttpServletRequest request){
        EntityWrapper<MeishifenxiangEntity> ew = new EntityWrapper<MeishifenxiangEntity>();
		PageUtils page = meishifenxiangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, meishifenxiang), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( MeishifenxiangEntity meishifenxiang){
       	EntityWrapper<MeishifenxiangEntity> ew = new EntityWrapper<MeishifenxiangEntity>();
      	ew.allEq(MPUtil.allEQMapPre( meishifenxiang, "meishifenxiang")); 
        return R.ok().put("data", meishifenxiangService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(MeishifenxiangEntity meishifenxiang){
        EntityWrapper< MeishifenxiangEntity> ew = new EntityWrapper< MeishifenxiangEntity>();
 		ew.allEq(MPUtil.allEQMapPre( meishifenxiang, "meishifenxiang")); 
		MeishifenxiangView meishifenxiangView =  meishifenxiangService.selectView(ew);
		return R.ok("查询美食分享成功").put("data", meishifenxiangView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        MeishifenxiangEntity meishifenxiang = meishifenxiangService.selectById(id);
        return R.ok().put("data", meishifenxiang);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        MeishifenxiangEntity meishifenxiang = meishifenxiangService.selectById(id);
        return R.ok().put("data", meishifenxiang);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        MeishifenxiangEntity meishifenxiang = meishifenxiangService.selectById(id);
        if(type.equals("1")) {
        	meishifenxiang.setThumbsupnum(meishifenxiang.getThumbsupnum()+1);
        } else {
        	meishifenxiang.setCrazilynum(meishifenxiang.getCrazilynum()+1);
        }
        meishifenxiangService.updateById(meishifenxiang);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody MeishifenxiangEntity meishifenxiang, HttpServletRequest request){
    	meishifenxiang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(meishifenxiang);
        meishifenxiangService.insert(meishifenxiang);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody MeishifenxiangEntity meishifenxiang, HttpServletRequest request){
    	meishifenxiang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(meishifenxiang);
        meishifenxiangService.insert(meishifenxiang);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody MeishifenxiangEntity meishifenxiang, HttpServletRequest request){
        //ValidatorUtils.validateEntity(meishifenxiang);
        meishifenxiangService.updateById(meishifenxiang);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        meishifenxiangService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<MeishifenxiangEntity> wrapper = new EntityWrapper<MeishifenxiangEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			wrapper.eq("yonghuzhanghao", (String)request.getSession().getAttribute("username"));
		}

		int count = meishifenxiangService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	







}

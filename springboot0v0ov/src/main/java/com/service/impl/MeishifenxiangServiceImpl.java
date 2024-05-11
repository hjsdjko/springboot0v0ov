package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.MeishifenxiangDao;
import com.entity.MeishifenxiangEntity;
import com.service.MeishifenxiangService;
import com.entity.vo.MeishifenxiangVO;
import com.entity.view.MeishifenxiangView;

@Service("meishifenxiangService")
public class MeishifenxiangServiceImpl extends ServiceImpl<MeishifenxiangDao, MeishifenxiangEntity> implements MeishifenxiangService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MeishifenxiangEntity> page = this.selectPage(
                new Query<MeishifenxiangEntity>(params).getPage(),
                new EntityWrapper<MeishifenxiangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<MeishifenxiangEntity> wrapper) {
		  Page<MeishifenxiangView> page =new Query<MeishifenxiangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<MeishifenxiangVO> selectListVO(Wrapper<MeishifenxiangEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public MeishifenxiangVO selectVO(Wrapper<MeishifenxiangEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<MeishifenxiangView> selectListView(Wrapper<MeishifenxiangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public MeishifenxiangView selectView(Wrapper<MeishifenxiangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}

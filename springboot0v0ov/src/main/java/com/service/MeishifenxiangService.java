package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.MeishifenxiangEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.MeishifenxiangVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.MeishifenxiangView;


/**
 * 美食分享
 *
 * @author 
 * @email 
 * @date 2022-03-30 10:53:47
 */
public interface MeishifenxiangService extends IService<MeishifenxiangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<MeishifenxiangVO> selectListVO(Wrapper<MeishifenxiangEntity> wrapper);
   	
   	MeishifenxiangVO selectVO(@Param("ew") Wrapper<MeishifenxiangEntity> wrapper);
   	
   	List<MeishifenxiangView> selectListView(Wrapper<MeishifenxiangEntity> wrapper);
   	
   	MeishifenxiangView selectView(@Param("ew") Wrapper<MeishifenxiangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<MeishifenxiangEntity> wrapper);
   	

}


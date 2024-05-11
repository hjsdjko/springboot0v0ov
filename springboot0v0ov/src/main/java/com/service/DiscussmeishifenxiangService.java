package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussmeishifenxiangEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussmeishifenxiangVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussmeishifenxiangView;


/**
 * 美食分享评论表
 *
 * @author 
 * @email 
 * @date 2022-03-30 10:53:47
 */
public interface DiscussmeishifenxiangService extends IService<DiscussmeishifenxiangEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussmeishifenxiangVO> selectListVO(Wrapper<DiscussmeishifenxiangEntity> wrapper);
   	
   	DiscussmeishifenxiangVO selectVO(@Param("ew") Wrapper<DiscussmeishifenxiangEntity> wrapper);
   	
   	List<DiscussmeishifenxiangView> selectListView(Wrapper<DiscussmeishifenxiangEntity> wrapper);
   	
   	DiscussmeishifenxiangView selectView(@Param("ew") Wrapper<DiscussmeishifenxiangEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussmeishifenxiangEntity> wrapper);
   	

}


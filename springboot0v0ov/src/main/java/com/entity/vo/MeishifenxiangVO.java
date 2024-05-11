package com.entity.vo;

import com.entity.MeishifenxiangEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 美食分享
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2022-03-30 10:53:47
 */
public class MeishifenxiangVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 图片
	 */
	
	private String tupian;
		
	/**
	 * 美食类型
	 */
	
	private String meishileixing;
		
	/**
	 * 推荐指数
	 */
	
	private String tuijianzhishu;
		
	/**
	 * 美食特色
	 */
	
	private String meishitese;
		
	/**
	 * 人均消费
	 */
	
	private String renjunxiaofei;
		
	/**
	 * 打卡地点
	 */
	
	private String dakadidian;
		
	/**
	 * 美食详情
	 */
	
	private String meishixiangqing;
		
	/**
	 * 用户账号
	 */
	
	private String yonghuzhanghao;
		
	/**
	 * 用户姓名
	 */
	
	private String yonghuxingming;
		
	/**
	 * 是否审核
	 */
	
	private String sfsh;
		
	/**
	 * 审核回复
	 */
	
	private String shhf;
		
	/**
	 * 赞
	 */
	
	private Integer thumbsupnum;
		
	/**
	 * 踩
	 */
	
	private Integer crazilynum;
				
	
	/**
	 * 设置：图片
	 */
	 
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
				
	
	/**
	 * 设置：美食类型
	 */
	 
	public void setMeishileixing(String meishileixing) {
		this.meishileixing = meishileixing;
	}
	
	/**
	 * 获取：美食类型
	 */
	public String getMeishileixing() {
		return meishileixing;
	}
				
	
	/**
	 * 设置：推荐指数
	 */
	 
	public void setTuijianzhishu(String tuijianzhishu) {
		this.tuijianzhishu = tuijianzhishu;
	}
	
	/**
	 * 获取：推荐指数
	 */
	public String getTuijianzhishu() {
		return tuijianzhishu;
	}
				
	
	/**
	 * 设置：美食特色
	 */
	 
	public void setMeishitese(String meishitese) {
		this.meishitese = meishitese;
	}
	
	/**
	 * 获取：美食特色
	 */
	public String getMeishitese() {
		return meishitese;
	}
				
	
	/**
	 * 设置：人均消费
	 */
	 
	public void setRenjunxiaofei(String renjunxiaofei) {
		this.renjunxiaofei = renjunxiaofei;
	}
	
	/**
	 * 获取：人均消费
	 */
	public String getRenjunxiaofei() {
		return renjunxiaofei;
	}
				
	
	/**
	 * 设置：打卡地点
	 */
	 
	public void setDakadidian(String dakadidian) {
		this.dakadidian = dakadidian;
	}
	
	/**
	 * 获取：打卡地点
	 */
	public String getDakadidian() {
		return dakadidian;
	}
				
	
	/**
	 * 设置：美食详情
	 */
	 
	public void setMeishixiangqing(String meishixiangqing) {
		this.meishixiangqing = meishixiangqing;
	}
	
	/**
	 * 获取：美食详情
	 */
	public String getMeishixiangqing() {
		return meishixiangqing;
	}
				
	
	/**
	 * 设置：用户账号
	 */
	 
	public void setYonghuzhanghao(String yonghuzhanghao) {
		this.yonghuzhanghao = yonghuzhanghao;
	}
	
	/**
	 * 获取：用户账号
	 */
	public String getYonghuzhanghao() {
		return yonghuzhanghao;
	}
				
	
	/**
	 * 设置：用户姓名
	 */
	 
	public void setYonghuxingming(String yonghuxingming) {
		this.yonghuxingming = yonghuxingming;
	}
	
	/**
	 * 获取：用户姓名
	 */
	public String getYonghuxingming() {
		return yonghuxingming;
	}
				
	
	/**
	 * 设置：是否审核
	 */
	 
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
				
	
	/**
	 * 设置：审核回复
	 */
	 
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	
	/**
	 * 获取：审核回复
	 */
	public String getShhf() {
		return shhf;
	}
				
	
	/**
	 * 设置：赞
	 */
	 
	public void setThumbsupnum(Integer thumbsupnum) {
		this.thumbsupnum = thumbsupnum;
	}
	
	/**
	 * 获取：赞
	 */
	public Integer getThumbsupnum() {
		return thumbsupnum;
	}
				
	
	/**
	 * 设置：踩
	 */
	 
	public void setCrazilynum(Integer crazilynum) {
		this.crazilynum = crazilynum;
	}
	
	/**
	 * 获取：踩
	 */
	public Integer getCrazilynum() {
		return crazilynum;
	}
			
}

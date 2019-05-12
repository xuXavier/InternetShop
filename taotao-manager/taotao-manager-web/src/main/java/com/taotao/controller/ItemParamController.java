/**
 * 
 */
package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.filter.AutoLoad;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItemParam;
import com.taotao.service.ItemParamService;

/**
 * @ClassName: ItemParamController
 * @Description: 
 * @author Xavier Xu
 * @date 2019年5月
 *
 */
@Controller
@RequestMapping("/item/param")
public class ItemParamController {
	
	@Autowired
	private ItemParamService itemParamService;
@RequestMapping("/query/itemcatid/{itemCatId}")
@ResponseBody
	public TaotaoResult getItemParamByCid(@PathVariable long itemCatId) {
		TaotaoResult result=itemParamService.getItemParamByCid(itemCatId);
		return result;
	
}
	@RequestMapping("/save/{cid}")
	@ResponseBody
	public TaotaoResult insertItemParam(@PathVariable Long cid,String paramData) {
		//创建pojo对象
		TbItemParam itemParam=new TbItemParam();
		itemParam.setItemCatId(cid);
		itemParam.setParamData(paramData);
		
		TaotaoResult result=itemParamService.insertItemParam(itemParam);
		return result;
		
	}
}

/**
 * 
 */
package com.taotao.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.mapper.TbItemParamMapper;
import com.taotao.pojo.TbItemParam;
import com.taotao.pojo.TbItemParamExample;
import com.taotao.pojo.TbItemParamExample.Criteria;
import com.taotao.service.ItemParamService;

/**
 * @ClassName: ItemParamServiceImple
 * @Description: 
 * @author Xavier Xu
 * @date 2019年4月
 *
 */
@Service
public class ItemParamServiceImple implements ItemParamService{

	/* (non-Javadoc)
	 * @see com.taotao.service.ItemParamService#getItemParamByCid(long)
	 */
	@Autowired
	TbItemParamMapper tbItemParamMapper;
	@Override
	public TaotaoResult getItemParamByCid(long Cid) {
		TbItemParamExample example=new TbItemParamExample();
		Criteria criteria=example.createCriteria();
		criteria.andItemCatIdEqualTo(Cid);
		List<TbItemParam> list=tbItemParamMapper.selectByExampleWithBLOBs(example);
		if(list!=null&&list.size()>0) {
			return TaotaoResult.ok(list.get(0));
		}else {
			return TaotaoResult.ok();
		}
	}
	/* (non-Javadoc)
	 * @see com.taotao.service.ItemParamService#insertItemParam(com.taotao.pojo.TbItemParam)
	 */
	@Override
	public TaotaoResult insertItemParam(TbItemParam itemParam) {
		//补全pojo
		itemParam.setCreated(new Date());
		itemParam.setUpdated(new Date());
		tbItemParamMapper.insert(itemParam);
		return TaotaoResult.ok();
	}
	
}

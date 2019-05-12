/**
 * 
 */
package com.taotao.service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItemParam;

/**
 * @ClassName: ItemParamService
 * @Description: 
 * @author Xavier Xu
 * @date 2019年4月
 *
 */
public interface ItemParamService {
	TaotaoResult getItemParamByCid(long Cid);
	TaotaoResult insertItemParam(TbItemParam itemParam);
}

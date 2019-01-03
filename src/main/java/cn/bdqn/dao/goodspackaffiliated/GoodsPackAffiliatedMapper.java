package cn.bdqn.dao.goodspackaffiliated;


import cn.bdqn.pojo.GoodsPackAffiliated;

import java.util.List;

public interface GoodsPackAffiliatedMapper {
	/**
	 * getGoodsPackAffiliatedListById
	 * @return
	 */
	public List<GoodsPackAffiliated> getGoodsPackAffiliatedListById(GoodsPackAffiliated goodsPackAffiliated) throws Exception;
	
	
	/**
	 * addGoodsPackAffiliated
	 * @param goodsPackAffiliated
	 * @return
	 */
	public int addGoodsPackAffiliated(GoodsPackAffiliated goodsPackAffiliated) throws Exception;
	
	/**
	 * modifyGoodsPackAffiliated
	 * @param goodsPackAffiliated
	 * @return
	 */
	public int modifyGoodsPackAffiliated(GoodsPackAffiliated goodsPackAffiliated);
	
	/**
	 * deleteGoodsPackAffiliated
	 * @param goodsPackAffiliated
	 * @return
	 */
	public int deleteGoodsPackAffiliated(GoodsPackAffiliated goodsPackAffiliated);
}

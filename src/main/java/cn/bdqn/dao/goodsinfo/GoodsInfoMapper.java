package cn.bdqn.dao.goodsinfo;

import cn.bdqn.pojo.GoodsInfo;

import java.util.List;

public interface GoodsInfoMapper {
	/**
	 * getGoodsInfoList
	 * @return
	 */
	public List<GoodsInfo> getGoodsInfoList(GoodsInfo goodsInfo) throws Exception;
	
	/**
	 * count
	 * @param goodsInfo
	 * @return
	 * @throws Exception
	 */
	public int count(GoodsInfo goodsInfo) throws Exception;
	/**
	 * isExitInPack
	 * @param goodsInfo
	 * @return
	 * @throws Exception
	 */
	public int isExitInPack(GoodsInfo goodsInfo) throws Exception;
	
	/**
	 * addGoodsInfo
	 * @param goodsInfo
	 * @return
	 */
	public int addGoodsInfo(GoodsInfo goodsInfo) throws Exception;
	
	/**
	 * goodsSNIsExit
	 * @param goodsInfo
	 * @return
	 * @throws Exception
	 */
	public int goodsSNIsExit(GoodsInfo goodsInfo) throws Exception;
	
	/**
	 * getGoodsInfoById
	 * @param goodsInfo
	 * @return
	 */
	public GoodsInfo getGoodsInfoById(GoodsInfo goodsInfo) throws Exception;
	
	
	/**
	 * modifyGoodsInfo
	 * @param goodsInfo
	 * @return
	 */
	public int modifyGoodsInfo(GoodsInfo goodsInfo) throws Exception;
	
	/**
	 * deleteGoodsInfo
	 * @param goodsInfo
	 * @return
	 */
	public int deleteGoodsInfo(GoodsInfo goodsInfo) throws Exception;
}

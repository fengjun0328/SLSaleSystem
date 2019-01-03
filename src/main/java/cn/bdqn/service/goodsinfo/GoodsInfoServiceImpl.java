package cn.bdqn.service.goodsinfo;


import cn.bdqn.dao.goodsinfo.GoodsInfoMapper;
import cn.bdqn.pojo.GoodsInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsInfoServiceImpl implements GoodsInfoService{
	@Resource
	private GoodsInfoMapper mapper;

	public List<GoodsInfo> getGoodsInfoList(GoodsInfo goodsInfo)
			throws Exception {
		return mapper.getGoodsInfoList(goodsInfo);
	}

	public int count(GoodsInfo goodsInfo) throws Exception {
		return mapper.count(goodsInfo);
	}

	public int addGoodsInfo(GoodsInfo goodsInfo) throws Exception {
		return mapper.addGoodsInfo(goodsInfo);
	}

	public int goodsSNIsExit(GoodsInfo goodsInfo) throws Exception {
		return mapper.goodsSNIsExit(goodsInfo);
	}

	public GoodsInfo getGoodsInfoById(GoodsInfo goodsInfo) throws Exception {
		return mapper.getGoodsInfoById(goodsInfo);
	}

	public int modifyGoodsInfo(GoodsInfo goodsInfo) throws Exception{
		return mapper.modifyGoodsInfo(goodsInfo);
	}

	public int deleteGoodsInfo(GoodsInfo goodsInfo) throws Exception{
		return mapper.deleteGoodsInfo(goodsInfo);
	}

	public int isExitInPack(GoodsInfo goodsInfo) throws Exception {
		return mapper.isExitInPack(goodsInfo);
	}
	
	
}

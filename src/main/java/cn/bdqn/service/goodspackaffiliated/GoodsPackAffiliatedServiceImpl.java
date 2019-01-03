package cn.bdqn.service.goodspackaffiliated;


import cn.bdqn.dao.goodspackaffiliated.GoodsPackAffiliatedMapper;
import cn.bdqn.pojo.GoodsPackAffiliated;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsPackAffiliatedServiceImpl implements GoodsPackAffiliatedService{
	
	@Resource
	private GoodsPackAffiliatedMapper mapper;

	public List<GoodsPackAffiliated> getGoodsPackAffiliatedListById(
			GoodsPackAffiliated goodsPackAffiliated) throws Exception {
		// TODO Auto-generated method stub
		return mapper.getGoodsPackAffiliatedListById(goodsPackAffiliated);
	}

	public int addGoodsPackAffiliated(GoodsPackAffiliated goodsPackAffiliated)
			throws Exception {
		// TODO Auto-generated method stub
		return mapper.addGoodsPackAffiliated(goodsPackAffiliated);
	}

	public int modifyGoodsPackAffiliated(GoodsPackAffiliated goodsPackAffiliated) {
		// TODO Auto-generated method stub
		return mapper.modifyGoodsPackAffiliated(goodsPackAffiliated);
	}

	public int deleteGoodsPackAffiliated(GoodsPackAffiliated goodsPackAffiliated) {
		// TODO Auto-generated method stub
		return mapper.deleteGoodsPackAffiliated(goodsPackAffiliated);
	}


}

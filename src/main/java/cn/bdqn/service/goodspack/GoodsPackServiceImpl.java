package cn.bdqn.service.goodspack;


import cn.bdqn.dao.goodspack.GoodsPackMapper;
import cn.bdqn.dao.goodspackaffiliated.GoodsPackAffiliatedMapper;
import cn.bdqn.pojo.GoodsPack;
import cn.bdqn.pojo.GoodsPackAffiliated;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsPackServiceImpl implements GoodsPackService{
	@Resource
	private GoodsPackMapper mapper;
	@Resource
	private GoodsPackAffiliatedMapper gpaMapper;

	public List<GoodsPack> getGoodsPackList(GoodsPack goodsPack)
			throws Exception {
		return mapper.getGoodsPackList(goodsPack);
	}

	public int count(GoodsPack goodsPack) throws Exception {
		return mapper.count(goodsPack);
	}

	public int addGoodsPack(GoodsPack goodsPack) throws Exception {
		return mapper.addGoodsPack(goodsPack);
	}

	public int goodsPackCodeIsExit(GoodsPack goodsPack) throws Exception {
		return mapper.goodsPackCodeIsExit(goodsPack);
	}

	public GoodsPack getGoodsPackById(GoodsPack goodsPack) throws Exception {
		return mapper.getGoodsPackById(goodsPack);
	}

	public int modifyGoodsPack(GoodsPack goodsPack) {
		return mapper.modifyGoodsPack(goodsPack);
	}

	public int deleteGoodsPack(GoodsPack goodsPack) {
		return mapper.deleteGoodsPack(goodsPack);
	}

	public boolean hl_addGoodsPack(GoodsPack goodsPack,List<GoodsPackAffiliated> apaList) throws Exception {
		int addGoodsPackId = 0;
		mapper.addGoodsPack(goodsPack);
		addGoodsPackId = mapper.getAddGoodsPackId();
		if(null != apaList && apaList.size() > 0 && addGoodsPackId != 0){
			for(int i = 0; i <  apaList.size(); i++){
				if(null != apaList.get(i)){
					apaList.get(i).setGoodsPackId(addGoodsPackId);
					gpaMapper.addGoodsPackAffiliated(apaList.get(i));
				}
			}
		}
		return true;
	}

	public boolean hl_modifyGoodsPack(GoodsPack goodsPack,List<GoodsPackAffiliated> apaList) throws Exception {
		mapper.modifyGoodsPack(goodsPack);
		int goodsPackId = goodsPack.getId();
		GoodsPackAffiliated goodsPackAffiliated = new GoodsPackAffiliated();
		goodsPackAffiliated.setGoodsPackId(goodsPackId);
		gpaMapper.deleteGoodsPackAffiliated(goodsPackAffiliated);
		if(null != apaList){
			for(int i = 0; i < apaList.size(); i++){
				if(null != apaList.get(i)){
					apaList.get(i).setGoodsPackId(goodsPackId);
					gpaMapper.addGoodsPackAffiliated(apaList.get(i));
				}
			}
		}
		return true;
	}

}

package cn.bdqn.service.uploadtemp;


import cn.bdqn.dao.uploadtemp.UploadTempMapper;
import cn.bdqn.pojo.UploadTemp;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UploadTempServiceImpl implements UploadTempService {

	@Resource
	private UploadTempMapper mapper;
	public List<UploadTemp> getList(UploadTemp uploadTemp) throws Exception {
		// TODO Auto-generated method stub
		return mapper.getList(uploadTemp);
	}

	public int add(UploadTemp uploadTemp) throws Exception {
		// TODO Auto-generated method stub
		return mapper.add(uploadTemp);
	}

	public int delete(UploadTemp uploadTemp) throws Exception {
		// TODO Auto-generated method stub
		return mapper.delete(uploadTemp);
	}

}

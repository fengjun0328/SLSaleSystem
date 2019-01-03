package cn.bdqn.service.information;


import cn.bdqn.dao.information.InformationMapper;
import cn.bdqn.pojo.Information;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class InformationServiceImpl implements InformationService {

	@Resource
	private InformationMapper mapper;
	
	public List<Information> getList(Information information) throws Exception {
		return mapper.getList(information);
	}

	public List<Information> getInformationList(Information information)
			throws Exception {
		return mapper.getInformationList(information);
	}

	public Information getInformation(Information information) throws Exception {
		return mapper.getInformation(information);
	}

	public int addInformation(Information information) throws Exception {
		return mapper.addInformation(information);
	}

	public int modifyInformation(Information information) throws Exception {
		return mapper.modifyInformation(information);
	}

	public int deleteInformation(Information information) throws Exception {
		return mapper.deleteInformation(information);
	}

	public int count(Information information) throws Exception {
		return mapper.count(information);
	}

	public int modifyInformationFileInfo(Information information)
			throws Exception {
		return mapper.modifyInformationFileInfo(information);
	}
}

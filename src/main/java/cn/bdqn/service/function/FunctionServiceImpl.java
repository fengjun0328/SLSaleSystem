package cn.bdqn.service.function;


import cn.bdqn.dao.function.FunctionMapper;
import cn.bdqn.pojo.Authority;
import cn.bdqn.pojo.Function;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FunctionServiceImpl  implements FunctionService {
	
	@Resource
	private FunctionMapper mapper;
	
	public List<Function> getSubFunctionList(Function function)  throws Exception{
		// TODO Auto-generated method stub
		return mapper.getSubFunctionList(function);
	}
	
	public Function getFunctionById(Function function) throws Exception {
		// TODO Auto-generated method stub
		return mapper.getFunctionById(function);
	}
	
	public List<Function> getMainFunctionList(Authority authority) throws Exception {
		// TODO Auto-generated method stub
		return mapper.getMainFunctionList(authority);
	}

	public List<Function> getSubFuncList(Function function) throws Exception {
		// TODO Auto-generated method stub
		return mapper.getSubFuncList(function);
	}

	@Override
	public List<Function> getFunctionListByIn(String sqlInString) throws Exception {
		// TODO Auto-generated method stub
		return mapper.getFunctionListByIn(sqlInString);
	}
	
	@Override
	public List<Function> getFunctionListByRoId(Authority authority) throws Exception {
		// TODO Auto-generated method stub
		return mapper.getFunctionListByRoId(authority);
	}

}

package cn.bdqn.dao.function;

import java.util.List;

import cn.bdqn.pojo.Authority;
import cn.bdqn.pojo.Function;
import org.apache.ibatis.annotations.Param;


public interface FunctionMapper {
	
	public List<Function> getSubFunctionList(Function function) throws Exception;
	
	public List<Function> getSubFuncList(Function function) throws Exception;
	/**
	 * getMainFunctionList
	 * @return
	 * @throws Exception
	 */
	public List<Function> getMainFunctionList(Authority authority) throws Exception;
	
	/**
	 * getFunctionById
	 * @return
	 * @throws Exception
	 */
	public Function getFunctionById(Function function) throws Exception;
	/**
	 * getFunctionListByIn
	 * @param sqlInString
	 * @return
	 * @throws Exception
	 */
	public List<Function> getFunctionListByIn(@Param(value = "sqlInString") String sqlInString) throws Exception;
	/**
	 * getFunctionListByRoId
	 * @return
	 * @throws Exception
	 */
	public List<Function> getFunctionListByRoId(Authority authority) throws Exception;
	
}

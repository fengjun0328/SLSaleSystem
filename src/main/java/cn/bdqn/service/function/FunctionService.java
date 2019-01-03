package cn.bdqn.service.function;


import cn.bdqn.pojo.Authority;
import cn.bdqn.pojo.Function;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FunctionService {
	/**
     * getFunctionList
     * @param function
     * @return
     */
	public List<Function> getSubFunctionList(Function function) throws Exception;
	
	/**
	 * getSubFuncList
	 * @param function
	 * @return
	 */
	public List<Function> getSubFuncList(Function function) throws Exception;
	/**
	 * getMenuFunction
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
	 * @param authority
	 * @return
	 * @throws Exception
	 */
	public List<Function> getFunctionListByRoId(Authority authority) throws Exception;

}

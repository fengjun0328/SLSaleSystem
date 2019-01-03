package cn.bdqn.service.authority;


import cn.bdqn.pojo.Authority;

import java.util.List;

public interface AuthorityService {
	/**
	 * getList
	 * @return
	 */
	public List<Authority> getList(Authority authority) throws Exception;
	/**
	 * getAuthority
	 * @param authority
	 * @return
	 * @throws Exception
	 */
	public Authority getAuthority(Authority authority) throws Exception;
	/**
	 * addPremission
	 * @param authority
	 * @return
	 */
	public int addAuthority(Authority authority) throws Exception;
	/**
	 * hl_addAuthority
	 * @param ids
	 * @param createdBy
	 * @return
	 * @throws Exception
	 */
	public boolean hl_addAuthority(String[] ids, String createdBy) throws Exception;
	/**
	 * modifyPremission
	 * @param authority
	 * @return
	 */
	public int modifyAuthority(Authority authority) throws Exception;
	/**
	 * deletePremission
	 * @param authority
	 * @return
	 */
	public int deleteAuthority(Authority authority) throws Exception;
	/**
	 * hl_delAddAuthority
	 * @param authority
	 * @return
	 * @throws Exception
	 */
	public boolean hl_delAddAuthority(Authority authority, String checkFuncList) throws Exception;
}

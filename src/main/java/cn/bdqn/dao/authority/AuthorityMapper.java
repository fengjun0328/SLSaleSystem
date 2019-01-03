package cn.bdqn.dao.authority;

import cn.bdqn.pojo.Authority;
import java.util.List;

public interface AuthorityMapper {
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
	 * addAuthority
	 * @param authority
	 * @return
	 */
	public int addAuthority(Authority authority) throws Exception;
	/**
	 * modifyAuthority
	 * @param authority
	 * @return
	 */
	public int modifyAuthority(Authority authority) throws Exception;
	/**
	 * modifyAuthority
	 * @param authority
	 * @return
	 */
	public int deleteAuthority(Authority authority) throws Exception;
}

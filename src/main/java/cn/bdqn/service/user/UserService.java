package cn.bdqn.service.user;

import cn.bdqn.pojo.User;

import java.util.List;

public interface UserService {
	/**
	 * getUserList
	 * @return
	 */
	public List<User> getUserList(User user) throws Exception;

	/**
	 * 登录的方法
	 * @param loginCode
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public User getLoginUser(String loginCode,String password) throws Exception;

    /**
     * 用户名是否存在
     * @param loginCode
     * @return
     * @throws Exception
     */
    public int loginCodeIsExits(String loginCode) throws Exception;
	
	/**
	 * getUserById
	 * @param id
	 * @return
	 */
	public User getUserById(Integer id) throws Exception;
	
	/**
	 * addUser
	 * @param user
	 * @return
	 */
	public int addUser(User user) throws Exception;
	
	/**
	 * modifyUser
	 * @param user
	 * @return
	 */
	public int modifyUser(User user) throws Exception;
	
	/**
	 * delUserPic
	 * @param user
	 * @return
	 */
	public int delUserPic(User user) throws Exception;
	
	/**
	 * deleteUser
	 * @param id
	 * @return
	 */
	public int deleteUser(Integer id) throws Exception;
	
	/**
	 * count
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public int count(User user) throws Exception;
	

}

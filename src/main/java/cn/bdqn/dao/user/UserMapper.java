package cn.bdqn.dao.user;


import cn.bdqn.pojo.User;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface UserMapper {
	
	/**
	 * 根据条件查询用户列表
	 * @return
	 */
	public List<User> getUserList(User user) throws Exception;

	/**
	 * 登录的方法
	 * @param loginCode
	 * @return
	 * @throws Exception
	 */
	public User getLoginUser(@Param("loginCode") String loginCode) throws Exception;
	/**
	 * getUserById
	 * @param id
	 * @return
	 */
	public User getUserById(@Param("id") Integer id) throws Exception;
	/**
	 * addUser
	 * @param user
	 * @return
	 */
	public int addUser(User user) throws Exception;
	/**
	 * 修改的方法
	 * @param user
	 * @return
	 */
	public int modifyUser(User user);
	/**
	 * delUserPic
	 * @param user
	 * @return
	 */
	public int delUserPic(User user );
	/**
	 * deleteUser
	 * @param id
	 * @return
	 */
	public int deleteUser(@Param("id") Integer id);

	/**
	 * 根据角色id修改角色名称
	 * @param roleName
	 * @param roleId
	 * @return
	 */
	public int modifyUserRole(@Param("roleName") String roleName,@Param("roleId") Integer roleId);


}

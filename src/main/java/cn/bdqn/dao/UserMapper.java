package cn.bdqn.dao;

import cn.bdqn.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    /**
     * getUserList
     * @return
     */
    public List<User> getUserList(User user) throws Exception;

    /**
     * getUserListBySearch
     * @param user
     * @return
     */
    public List<User> getUserListBySearch(User user) throws Exception;

    /**
     * getLoginUser
     * @param user
     * @return
     */
    public User getLoginUser(User user) throws Exception;

    /**
     * getUserById
     * @param user
     * @return
     */
    public User getUserById(User user) throws Exception;

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
    public int modifyUser(User user);

    /**
     * modifyUserRole
     * @param user
     * @return
     */
    public int modifyUserRole(User user);

    /**
     * delUserPic
     * @param user
     * @return
     */
    public int delUserPic(User user);

    /**
     * deleteUser
     * @param user
     * @return
     */
    public int deleteUser(User user);

    /**
     * count
     * @param user
     * @return
     * @throws Exception
     */
    public int count(User user) throws Exception;

    /**
     * loginCodeIsExit
     * @param user
     * @return
     * @throws Exception
     */
    public int loginCodeIsExit(User user) throws Exception;

}

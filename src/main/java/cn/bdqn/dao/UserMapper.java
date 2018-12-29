package cn.bdqn.dao;

import cn.bdqn.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    /**
     * 登录的方法
     * @param loginCode
     * @return
     */
    public User getUser(String loginCode);

    public int updateUser(User user);

}

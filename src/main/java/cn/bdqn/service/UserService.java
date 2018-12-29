package cn.bdqn.service;

import cn.bdqn.pojo.User;

public interface UserService {
    /**
     * 根据用户名和密码查找用户
     * @param loginCode
     * @param password
     * @return
     */
    public int getUser(String loginCode,String password);

}

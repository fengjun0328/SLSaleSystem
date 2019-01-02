package cn.bdqn.service.impl;

import cn.bdqn.dao.UserMapper;
import cn.bdqn.pojo.User;
import cn.bdqn.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service("userService")
public class UserServiceImpl implements UserService {
   @Resource
   private UserMapper userMapper;
    public List<User> getUserList(User user) throws Exception{
        return userMapper.getUserList(user);
    }

    public User getLoginUser(User user) throws Exception{
        return userMapper.getLoginUser(user);
    }

    public int addUser(User user) throws Exception{
        return userMapper.addUser(user);
    }

    public int deleteUser(User user) throws Exception{
        return userMapper.deleteUser(user);
    }

    public int modifyUser(User user) throws Exception{
        return userMapper.modifyUser(user);
    }

    public int count(User user) throws Exception {
        return userMapper.count(user);
    }

    public User getUserById(User user) throws Exception {
        return userMapper.getUserById(user);
    }

    public int delUserPic(User user) throws Exception {
        return userMapper.delUserPic(user);
    }

    public int loginCodeIsExit(User user) throws Exception {
        return userMapper.loginCodeIsExit(user);
    }

    public List<User> getUserListBySearch(User user) throws Exception {
        return userMapper.getUserListBySearch(user);
    }

}

package cn.bdqn.service.impl;

import cn.bdqn.dao.UserMapper;
import cn.bdqn.pojo.User;
import cn.bdqn.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service("userService")
public class UserServiceImpl implements UserService {
   @Resource
   private UserMapper userMapper;

    /**
     * 登录的方法
     * @param loginCode
     * @param password
     * @return -1 没有用户
     * 1 登录成功
     * 0 密码不对
     * -2 异常
     */
    @Override
    public int getUser(String loginCode, String password) {
       User user=userMapper.getUser(loginCode);
       try{
           if(user==null){
               return  -1;
           }else{
               if(user.getPassword().equals(password)){
                   return 1;
               }else{
                   return 0;
               }
           }
       }catch (Exception e){
           e.printStackTrace();
           return -2;
       }

    }
}

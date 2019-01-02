import cn.bdqn.pojo.User;
import cn.bdqn.service.UserService;
import cn.bdqn.util.RedisAPI;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"classpath:applicationContext-mybatis.xml"} )
public class UserTest {
    @Resource
    private UserService userService;
    @Resource
    private RedisAPI redisAPI;
    @Test
    public void getUser(){
        User user=new User();
        user.setLoginCode("admin");
        user.setPassword("123456");
        redisAPI.set("user",user.toString());
        try {
            User loginUser=userService.getLoginUser(user);
            System.out.println(loginUser.getBankName());
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}

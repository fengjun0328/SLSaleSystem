package cn.bdqn.service.user;


import cn.bdqn.dao.user.UserMapper;
import cn.bdqn.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

	@Resource
	private UserMapper mapper;


	@Override
	public List<User> getUserList(User user) throws Exception {
		return mapper.getUserList(user);
	}

	@Override
	public User getLoginUser(String loginCode, String password) throws Exception {
		User user=mapper.getLoginUser(loginCode);
		if(user!=null){
			if(user.getPassword().equals(password)){
				return  user;
			}
		}
		return null;
	}

    @Override
    public int loginCodeIsExits(String loginCode) throws Exception {
        User user=mapper.getLoginUser(loginCode);
        if(user!=null){
            return 1;
        }
        return 0;
    }

    @Override
	public User getUserById(Integer id) throws Exception {
		return mapper.getUserById(id);
	}

	@Override
	public int addUser(User user) throws Exception {
		return mapper.addUser(user);
	}

	@Override
	public int modifyUser(User user) throws Exception {
		return mapper.modifyUser(user);
	}

	@Override
	public int delUserPic(User user) throws Exception {
		return mapper.delUserPic(user);
	}

	@Override
	public int deleteUser(Integer id) throws Exception {
		return mapper.deleteUser(id);
	}

	@Override
	public int count(User user) throws Exception {
		return mapper.getUserList(user).size();
	}
}

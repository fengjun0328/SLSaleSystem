package cn.bdqn.service.role;

import cn.bdqn.dao.role.RoleMapper;
import cn.bdqn.dao.user.UserMapper;
import cn.bdqn.pojo.Role;
import cn.bdqn.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

import javax.annotation.Resource;


@Service
public class RoleServiceImpl implements RoleService{
	@Autowired
	private RoleMapper mapper;
	@Resource
	private UserMapper userMapper;
	
	public List<Role> getRoleList() throws Exception {
		return mapper.getRoleList();
	}

	public Role getRole(Role role) throws Exception {
		return mapper.getRole(role);
	}

	public int addRole(Role role) throws Exception {
		return mapper.addRole(role);
	}

	public int modifyRole(Role role) throws Exception {
		return mapper.modifyRole(role);
	}

	public int deleteRole(Role role) throws Exception {
		return mapper.deleteRole(role);
	}

	public List<Role> getRoleIdAndNameList() throws Exception {
		return mapper.getRoleIdAndNameList();
	}

	public Role getRoleR(Role role) throws Exception {
		return mapper.getRoleR(role);
	}

	public boolean hl_modifyRole(Role role) throws Exception {
		mapper.modifyRole(role);
		int roleId = role.getId();
		String roleName = role.getRoleName();
		if(null != roleName && !"".equals(roleName)){
			userMapper.modifyUserRole(roleName,roleId);
		}
		return true;
	}

}

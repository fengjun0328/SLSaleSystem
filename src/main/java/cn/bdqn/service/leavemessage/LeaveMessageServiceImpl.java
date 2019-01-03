package cn.bdqn.service.leavemessage;


import cn.bdqn.dao.leavemessage.LeaveMessageMapper;
import cn.bdqn.pojo.LeaveMessage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class LeaveMessageServiceImpl implements LeaveMessageService{
	
	@Resource
	private LeaveMessageMapper mapper;
	
	public List<LeaveMessage> getLeaveMessageList(LeaveMessage leaveMessage)
			throws Exception {
		return mapper.getLeaveMessageList(leaveMessage);
	}

	public int count(LeaveMessage leaveMessage) throws Exception {
		return mapper.count(leaveMessage);
	}

	public int addLeaveMessage(LeaveMessage leaveMessage) throws Exception {
		return mapper.addLeaveMessage(leaveMessage);
	}

	public int modifyLeaveMessage(LeaveMessage leaveMessage) {
		return mapper.modifyLeaveMessage(leaveMessage);
	}

	public int deleteLeaveMessage(LeaveMessage deleteLeaveMessage) {
		return mapper.deleteLeaveMessage(deleteLeaveMessage);
	}

	public LeaveMessage getLeaveMessage(LeaveMessage leaveMessage)
			throws Exception {
		return mapper.getLeaveMessage(leaveMessage);
	}

}

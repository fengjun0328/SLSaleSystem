package cn.bdqn.service.reply;


import cn.bdqn.dao.reply.ReplyMapper;
import cn.bdqn.pojo.Reply;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ReplyServiceImpl implements ReplyService{

	@Resource
	private ReplyMapper mapper;
	public List<Reply> getReplyList(Reply replay) throws Exception {
		// TODO Auto-generated method stub
		return mapper.getReplyList(replay);
	}

	public int count(Reply replay) throws Exception {
		// TODO Auto-generated method stub
		return mapper.count(replay);
	}

	public int delete(Reply replay) throws Exception {
		// TODO Auto-generated method stub
		return mapper.delete(replay);
	}

	public int addReply(Reply reply) throws Exception {
		// TODO Auto-generated method stub
		return mapper.addReply(reply);
	}

}

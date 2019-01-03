package cn.bdqn.service.reply;


import cn.bdqn.pojo.Reply;

import java.util.List;

public interface ReplyService {
	/**
	 * getReplyList
	 * @return
	 * @throws Exception
	 */
	public List<Reply> getReplyList(Reply replay) throws Exception;
	/**
	 * count
	 * @return
	 */
	public int count(Reply replay) throws Exception;
	/**
	 * delete
	 * @param replay
	 * @return
	 * @throws Exception
	 */
	public int delete(Reply replay) throws Exception;
	
	/**
	 * addReply
	 * @param reply
	 * @return
	 */
	public int addReply(Reply reply) throws Exception;
}

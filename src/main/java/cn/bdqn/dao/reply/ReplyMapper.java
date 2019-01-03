package cn.bdqn.dao.reply;


import cn.bdqn.pojo.Reply;

import java.util.List;

public interface ReplyMapper {
	/**
	 * getReplyList
	 * @return
	 * @throws Exception
	 */
	public List<Reply> getReplyList(Reply reply) throws Exception;
	/**
	 * count
	 * @return
	 */
	public int count(Reply reply) throws Exception;
	/**
	 * delete
	 * @param reply
	 * @return
	 * @throws Exception
	 */
	public int delete(Reply reply) throws Exception;
	
	/**
	 * addReply
	 * @param reply
	 * @return
	 */
	public int addReply(Reply reply) throws Exception;
}

package cn.bdqn.dao.uploadtemp;


import cn.bdqn.pojo.UploadTemp;

import java.util.List;

public interface UploadTempMapper {
	/**
	 * getList
	 * @param uploadTemp
	 * @return
	 * @throws Exception
	 */
	public List<UploadTemp> getList(UploadTemp uploadTemp) throws Exception;
	/**
	 * add
	 * @param uploadTemp
	 * @return
	 * @throws Exception
	 */
	public int add(UploadTemp uploadTemp) throws Exception;
	/**
	 * delete
	 * @param uploadTemp
	 * @return
	 * @throws Exception
	 */
	public int delete(UploadTemp uploadTemp) throws Exception;
}

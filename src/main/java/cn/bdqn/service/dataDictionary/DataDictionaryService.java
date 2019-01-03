package cn.bdqn.service.dataDictionary;


import cn.bdqn.pojo.DataDictionary;

import java.util.List;

public interface DataDictionaryService {
	/**
	 * getDataDictionaries
	 * @return dataDictionary
	 */
	public List<DataDictionary> getDataDictionaries(DataDictionary dataDictionary) throws Exception;
	/**
	 * getDataDictionariesCategory
	 * @return
	 * @throws Exception
	 */
	public List<DataDictionary> getDataDictionariesCategory() throws Exception;
	/**
	 * getDataDictionariesNotIn
	 * @param dataDictionary
	 * @return
	 * @throws Exception
	 */
	public List<DataDictionary> getDataDictionariesNotIn(DataDictionary dataDictionary) throws Exception;
	/**
	 * addDataDictionary
	 * @param dataDictionary
	 * @return int
	 */
	public int addDataDictionary(DataDictionary dataDictionary) throws Exception;
	/**
	 * modifyDataDictionary
	 * @param dataDictionary
	 * @return int
	 */
	public int modifyDataDictionary(DataDictionary dataDictionary) throws Exception;
	/**
	 * deleteDataDictionary
	 * @param dataDictionary
	 * @return
	 */
	public int deleteDataDictionary(DataDictionary dataDictionary) throws Exception;
	
	/**
	 * modifyDataDictionarys
	 * @param dataDictionary
	 * @return
	 * @throws Exception
	 */
	public int modifyDataDictionarys(DataDictionary dataDictionary) throws Exception;
	
	/**
	 * typeCodeIsExit
	 * @param dataDictionary
	 * @return
	 * @throws Exception
	 */
	public int typeCodeOrValueIdIsExit(DataDictionary dataDictionary) throws Exception;
	/**
	 * maxValueId
	 * @param dataDictionary
	 * @return
	 * @throws Exception
	*/ 
	public int maxValueId(DataDictionary dataDictionary) throws Exception;
}

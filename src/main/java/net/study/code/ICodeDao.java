package net.study.code;

import java.util.List;
import java.util.Map;

public interface ICodeDao {

	public int selectListCount(Map condition);
	
	/**
	 * <pre>
	 * List 반환
	 * </pre>
	 * 
	 * @param condition
	 * @return
	 */
	List selectListAll(Map condition);

	/**
	 * <pre>
	 * 상세 조회
	 * </pre>
	 *
	 * @param condition
	 * @return CodeVo
	 */
	CodeVo selectDetail(Map condition) throws Exception;

}

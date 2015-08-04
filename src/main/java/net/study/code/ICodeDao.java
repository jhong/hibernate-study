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

	/**
	 * <pre>
	 * 코드 등록
	 * </pre>
	 *
	 * @param codeVo
	 * @return int
	 * @throws Exception
	 */
	int insert(CodeVo codeVo) throws Exception;

	/**
	 * <pre>
	 * 코드 수정
	 * </pre>
	 *
	 * @param codeVo
	 * @return int
	 * @throws Exception
	 */
	int update(CodeVo codeVo) throws Exception;

	/**
	 * <pre>
	 * 코드 삭제
	 * </pre>
	 *
	 * @param codeVo
	 * @return int
	 * @throws Exception
	 */
	int delete(CodeVo codeVo) throws Exception;

}

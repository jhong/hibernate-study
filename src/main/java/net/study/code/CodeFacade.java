package net.study.code;

import java.util.List;
import java.util.Map;

public interface CodeFacade {

	/**
	 * <pre>
	 * 목록 조회
	 * </pre>
	 *
	 * @param condition
	 * @return result
	 * @throws Exception
	 */
	Map findList(Map condition) throws Exception;

	/**
	 * <pre>
	 * 상세조회
	 * </pre>
	 *
	 * @param condition
	 * @return CodeVo
	 * @throws Exception
	 */
	CodeVo findDetail(Map condition) throws Exception;

	/**
	 * <pre>
	 * 코드 등록화면
	 * </pre>
	 *
	 * @param condition
	 * @return BizResult
	 * @throws Exception
	 */
	CodeVo entry(Map condition) throws Exception;

	/**
	 * <pre>
	 * 코드 등록
	 * </pre>
	 *
	 * @param codeVo
	 * @param condition
	 * @return BizResult
	 * @throws Exception
	 */
	CodeVo regist(CodeVo codeVo, Map condition) throws Exception;

	/**
	 * <pre>
	 * 코드 수정
	 * </pre>
	 *
	 * @param codeVo
	 * @param condition
	 * @return BizResult
	 * @throws Exception
	 */
	CodeVo modify(CodeVo codeVo, Map condition) throws Exception;

	/**
	 * <pre>
	 * 코드 삭제
	 * </pre>
	 *
	 * @param selList
	 * @param condition
	 * @return BizResult
	 * @throws Exception
	 */
	int delete(List selList, Map condition) throws Exception;

}

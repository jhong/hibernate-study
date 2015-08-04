package net.study.code;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository("codeDao")
@Transactional
public class CodeDao implements ICodeDao {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private HibernateTemplate  hibernateTemplate;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * <pre>
	 * List Count 반환
	 * </pre>
	 * 
	 * @param condition
	 * @return
	 */
	public int selectListCount(Map condition) {
		Integer count = DataAccessUtils.intResult(hibernateTemplate.find("select count(*) from CodeVo where codecategorykey='"+condition.get("codecategorykey")+"'"));
		return count.intValue();
	}
	
	/**
	 * <pre>
	 * List 반환
	 * </pre>
	 * 
	 * @param condition
	 * @return
	 */
	public List selectListAll(Map condition) {
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "from CodeVo where codecategorykey='" + condition.get("codecategorykey")+"'";
		logger.info("selectListAll() hql={}", hql);
		Query query = session.createQuery(hql);
		List<CodeVo> list = (List<CodeVo>)query.list();
		return list;
	}
	
	/**
	 * <pre>
	 * 상세 조회
	 * </pre>
	 *
	 * @param condition
	 * @return CodeVo
	 */
	public CodeVo selectDetail(Map condition) throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		CodeVo data = (CodeVo)session.get(CodeVo.class, condition.get("code")+"");
		return data;
	}

	/**
	 * <pre>
	 * 코드 등록
	 * </pre>
	 *
	 * @param codeVo
	 * @return int
	 * @throws Exception
	 */
	public int insert(CodeVo codeVo) throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		Object result = session.save(codeVo);
		logger.info("insert() end... result={}", result);
		
		if (result == null) return 0;
		else return 1;
	}

	/**
	 * <pre>
	 * 코드 수정
	 * </pre>
	 *
	 * @param codeVo
	 * @return int
	 * @throws Exception
	 */
	public int update(CodeVo codeVo) throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(codeVo);
		return 1;
	}

	/**
	 * <pre>
	 * 코드 삭제
	 * </pre>
	 *
	 * @param codeVo
	 * @return int
	 * @throws Exception
	 */
	public int delete(CodeVo codeVo) throws Exception {
		Session session = this.sessionFactory.getCurrentSession();
		session.delete(codeVo);
		return 1;
	}

}

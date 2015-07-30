package net.study.code;

import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository("codeDao")
@Transactional
public class CodeDao implements ICodeDao {

	@Autowired
	private HibernateTemplate  hibernateTemplate;
	
	/**
	 * <pre>
	 * List Count 반환
	 * </pre>
	 * 
	 * @param condition
	 * @return
	 */
	public int selectListCount(Map condition) {
		Integer count = DataAccessUtils.intResult(hibernateTemplate.find("select count(*) from CodeVo"));
		return count.intValue();
	}

}

package net.study.code;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import net.study.config.AppConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = AppConfig.class)
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class CodeDaoTest {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ICodeDao dao;

	/**
	 * selectListCount() test
	 * @throws Exception
	 */
	@Test
	public void selectListCount() throws Exception {
//		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
//		ctx.register(AppConfig.class);
//		ctx.refresh();
//		ICodeDao dao = ctx.getBean(ICodeDao.class);
  
		// parameters
		Map condition = new HashMap();
		condition.put("codecategorykey", "3039A");

		int result = dao.selectListCount(condition);
		logger.info("selectListCount() result={}", result);
	}
	
	/**
	 * selectListAll() test
	 * @throws Exception
	 */
	@Test
	public void selectListAll() throws Exception {
		// parameters
		Map condition = new HashMap();
		condition.put("codecategorykey", "3039A");

		List result = dao.selectListAll(condition);
		logger.info("selectListAll() result={}", result);
		assertNotNull(result); // smoke test
	}

	/**
	 * selectDetail() test
	 * @throws Exception
	 */
	@Test
	public void selectDetail() throws Exception {
		// parameters
		Map condition = new HashMap();
		condition.put("codecategorykey", "3039A");
		condition.put("code", "ANLU");
	
		CodeVo result = dao.selectDetail(condition);
		logger.info("selectDetail() result={}", result);
	}
}

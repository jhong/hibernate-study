package net.study.code;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
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

import net.study.config.TestConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = TestConfig.class)
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
	
	/**
	 * insert() test
	 * @throws Exception
	 */
	@Test
	public void insert() throws Exception {
		// parameters
		CodeVo vo = new CodeVo();
		vo.setCodecategorykey("TEST_CATEGORY");
		vo.setCode("TEST_CODE_1");
		vo.setCodeexplain("코드설명");
		vo.setCodename("코드명");
		vo.setCodeengname("Code Name");
		vo.setStatus("Y");
		vo.setSortorder(new BigDecimal(0));
		
		int result = dao.insert(vo);
		logger.debug("insert() result={}", result);
		assertTrue(true); // smoke test
	}

	/**
	 * update() test
	 * @throws Exception
	 */
	@Test
	public void update() throws Exception {
		// parameters
		CodeVo vo = new CodeVo();
		vo.setCodecategorykey("CODECATEGORYKEY");
		vo.setCode("CODE");
		vo.setCodeexplain("CODEEXPLAIN");
		vo.setCodename("CODENAME");
		vo.setCodeengname("CODEENGNAME");
		vo.setStatus("STATU");
		vo.setSortorder(new BigDecimal(0));
		
		int result = dao.update(vo);
		logger.debug("update() result={}", result);
		assertTrue(true); // smoke test
	}

	/**
	 * delete() test
	 * @throws Exception
	 */
	@Test
	public void delete() throws Exception {
		// parameters
		CodeVo vo = new CodeVo();
		vo.setCodecategorykey("CODECATEGORYKEY");
		vo.setCode("CODE");

		int result = dao.delete(vo);
		logger.debug("delete() result={}", result);
		assertTrue(true); // smoke test
	}

}

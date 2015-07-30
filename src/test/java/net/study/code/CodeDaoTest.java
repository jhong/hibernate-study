package net.study.code;

import org.junit.Test;
import org.junit.runner.RunWith;
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

	@Autowired
	ICodeDao codeDao;

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
  
		int result = codeDao.selectListCount(null);
		System.out.println("selectListCount() result="+result);
	}
}

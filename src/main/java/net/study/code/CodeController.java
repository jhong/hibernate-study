package net.study.code;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CodeController {

	@Autowired
	private ICodeDao codeDao;
	
    /**
	 * <pre>
	 * 목록 페이지 조회
 	 * </pre>
	 *
     * @param model
     * @return 
     * @throws Exception
     */
    @RequestMapping("/code")
	public String viewList (ModelMap model) throws Exception {
    	
    	Map condition = new HashMap();
    	int totalRow = codeDao.selectListCount(condition);

    	model.addAttribute("codeName", "abcde");
    	model.addAttribute("totalRow", totalRow);
		return "code/code_list";
	}

}

package net.study.code;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CodeController {

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
    	model.addAttribute("codeName", "abcde");
    	
    	// /WEB-INF/jsp/code/code_list.jsp
		return "code/code_list";
	}

}

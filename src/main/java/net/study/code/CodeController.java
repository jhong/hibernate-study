package net.study.code;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CodeController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Resource(name = "codeFacade")
    private CodeFacade facade;
	
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
	public String viewList (ModelMap model
			, @RequestParam(value="codecategorykey",required=false) String codecategorykey
			, @RequestParam(value="code",required=false) String code
			) throws Exception {
    	
    	Map condition = new HashMap();
    	condition.put("codecategorykey", codecategorykey);
    	condition.put("code", code);
    	logger.info("viewList() condition={}", condition);

    	Map result = facade.findList(condition);
    	logger.info("viewList() totalRow={}", result.get("totalRow"));

    	model.addAttribute("codeName", "abcde");
    	model.addAttribute("totalRow", result.get("totalRow"));
    	model.addAttribute("bizList", result.get("bizList"));
		return "code/code_list";
	}

	/**
	 * <pre>
	 * 상세조회
 	 * </pre>
	 *
	 * @param request
	 * @param model
	 * @return 
	 * @throws Exception
	 */
    @RequestMapping("/code/{code}")
 	public String findDetail (
 			ModelMap model
 			, @PathVariable("code") String code
 			) throws Exception {
 		
    	Map condition = new HashMap();
    	condition.put("code", code);

    	CodeVo codeVo = facade.findDetail(condition);
		model.put("codeVo", codeVo);
		
		return "code/code_edit";
	}

}

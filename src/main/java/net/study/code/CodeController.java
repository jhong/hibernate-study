package net.study.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
    @RequestMapping("/codes")
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
    @RequestMapping("/codes/{code}")
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

	/**
	 * <pre>
	 * 코드 등록화면
 	 * </pre>
	 *
	 * @param request
	 * @param codeVo
	 * @param model
	 * @return 
	 * @throws Exception
	 */
    @RequestMapping(value="/codes/new")
 	public String entry (
 			@ModelAttribute("codeVo") CodeVo codeVo
 			, ModelMap model
 			) throws Exception {
 			
		CodeVo result = facade.entry(null);
		model.addAttribute("codeVo", result);
		model.addAttribute("dbmode", "C"); // 등록
		
		return "code/code_edit";
	}

	/**
	 * <pre>
	 * 코드 등록
 	 * </pre>
	 *
	 * @param request
	 * @param codeVo
	 * @param bindingResult
	 * @return 
	 * @throws Exception
	 */
    @RequestMapping(value="/codes", method=RequestMethod.POST)
	public String regist (
			@ModelAttribute("codeVo") CodeVo codeVo
			, ModelMap model
			) throws Exception {    

		
		// 정보 등록
		CodeVo bizResult = facade.regist(codeVo, null);
		model.addAttribute("codeVo", bizResult);
		
		return "code/code_edit";
    }

	/**
	 * <pre>
	 * 코드 수정
 	 * </pre>
	 *
	 * @param request
	 * @param codeVo
	 * @param bindingResult
	 * @param model
	 * @return 
	 * @throws Exception
	 */
    @RequestMapping(value="/codes/{code}", method=RequestMethod.PUT)
	public String modify (
			@ModelAttribute("codeVo") CodeVo codeVo
 			, @PathVariable("code") String code
			, ModelMap model
			) throws Exception {
		
		// 정보 수정
    	CodeVo bizResult = facade.modify(codeVo, null);

		return "code/code_edit";
    }
    
	/**
	 * <pre>
	 * 코드 삭제
 	 * </pre>
	 *
	 * @param request
	 * @param model
	 * @return 
	 * @throws Exception
	 */
    @RequestMapping(value="/codes/{code}", method=RequestMethod.DELETE)
	public String delete (
			ModelMap model
			, @RequestParam(value="codecategorykey",required=false) String codecategorykey
 			, @PathVariable("code") String code
			) throws Exception {

    	Map bizData = new HashMap();
    	bizData.put("codecategorykey", codecategorykey);
    	bizData.put("code", code);
    	
    	List selList = new ArrayList();
    	selList.add(bizData);

		// 정보 삭제
		int count = facade.delete(selList, null);
		
		// 리턴할 목록 조회
    	Map result = facade.findList(bizData);
    	
    	model.addAttribute("totalRow", result.get("totalRow"));
    	model.addAttribute("bizList", result.get("bizList"));

		return "code/code_list";
	}

}

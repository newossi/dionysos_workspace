package org.nulljump.dionysos.winedictionary.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.nulljump.dionysos.winedictionary.model.service.WineDictionaryService;
import org.nulljump.dionysos.winedictionary.model.vo.WineDictionary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WineDictionaryController {

	public static final Logger logger = LoggerFactory.getLogger(WineDictionaryController.class);

	@Autowired
	private WineDictionaryService wineDictionaryService;

	// 와인사전 전체 목록보기 요청 처리용
	@RequestMapping("wdlist.do")
	public String wineDictionaryListMethod(Model model) {
		ArrayList<WineDictionary> list = wineDictionaryService.selectList();

		if (list != null && list.size() > 0) {
			model.addAttribute("list", list);
			return "wineDictionary/wineDictionaryListView";
		} else {
			model.addAttribute("message", "등록된 와인품종 정보가 없습니다.");
			return "common/error";
		}
	}

	// 와인사전 품종 검색용
	@RequestMapping(value = "wdsearchTitle.do", method = RequestMethod.POST)
	public String wineDictionarySearchTitleMethod(@RequestParam("keyword") String keyword, Model model) {

		ArrayList<WineDictionary> list = wineDictionaryService.selectSearchTitle(keyword);
		logger.info(keyword);

		if (list != null && list.size() > 0) {
			model.addAttribute("list", list);
			return "wineDictionary/wineDictionaryListView";
		} else {
			model.addAttribute("message", keyword + "으로 검색된 와인품종 정보가 없습니다.");
			return "common/error";
		}
	}

	// 와인사전 상세보기
	@RequestMapping("wddetail.do")
	public String wineDictionaryDetailMethod(@RequestParam("wine") String wine, Model model, HttpSession session) {

		WineDictionary wineDictionary = wineDictionaryService.selectWineDictionary(wine);
		logger.info(wine);

		if (wineDictionary != null) {
			model.addAttribute("wineDictionary", wineDictionary);
			return "wineDictionary/wineDictionaryDetailView";
		} else {
			model.addAttribute("message", "해당 데이터가 존재하지 않습니다.");
			return "common/error";
		}

	}
	
}

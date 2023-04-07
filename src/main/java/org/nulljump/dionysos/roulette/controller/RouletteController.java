package org.nulljump.dionysos.roulette.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RouletteController {
//	+moveRoulettePage
//	+createRouletteWheel()
//	+rouletteStart()
//	+rouletteStop()
//	+makeRouletteResult()
//	+resetRoulette()
	
	//miniGameView 이동처리용
	@RequestMapping(value="moveRouletteGame.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String moveRouletteGameView() {  
		return "minigame/rouletteGameView";
	} 
}

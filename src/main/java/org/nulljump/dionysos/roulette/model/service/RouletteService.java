package org.nulljump.dionysos.roulette.model.service;

import java.util.ArrayList;

import org.nulljump.dionysos.roulette.model.vo.Roulette;

public interface RouletteService {
	public ArrayList<Roulette> selectRouletteList();
	public String createRouletteWheel();
	public String rouletteSpinning();
	public String rouletteResult();
	public String insertRoulette();
	public String updateRoulette();
	public String resetRoulette();
}

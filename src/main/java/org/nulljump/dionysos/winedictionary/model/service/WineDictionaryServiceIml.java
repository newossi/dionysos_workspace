package org.nulljump.dionysos.winedictionary.model.service;

import java.util.ArrayList;

import org.nulljump.dionysos.winedictionary.model.dao.WineDictionaryDao;
import org.nulljump.dionysos.winedictionary.model.vo.WineDictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("wineDictionaryService")
public class WineDictionaryServiceIml implements WineDictionaryService{

	//DAO 와 연결 처리
	@Autowired
	WineDictionaryDao wineDictionaryDao;
	
	@Override
	public ArrayList<WineDictionary> selectList() {
		// TODO Auto-generated method stub
		return wineDictionaryDao.selectList();
	}

	@Override
	public WineDictionary selectWineDictionary(String grape_type) {
		// TODO Auto-generated method stub
		return wineDictionaryDao.selectWineDictionary(grape_type);
	}

	@Override
	public int insertWineDictionary(WineDictionary wineDictionary) {
		// TODO Auto-generated method stub
		return wineDictionaryDao.insertWineDictionary(wineDictionary);
	}

	@Override
	public int updateWineDictionary(WineDictionary wineDictionary) {
		// TODO Auto-generated method stub
		return wineDictionaryDao.updateWineDictionary(wineDictionary);
	}

	@Override
	public int deleteWineDictionary(WineDictionary wineDictionary) {
		// TODO Auto-generated method stub
		return wineDictionaryDao.deleteWineDictionary(wineDictionary);
	}

	@Override
	public ArrayList<WineDictionary> selectSearchTitle(String keyword) {
		// TODO Auto-generated method stub
		return wineDictionaryDao.selectSearchTitle(keyword);
	}

}

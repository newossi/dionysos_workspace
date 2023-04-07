package org.nulljump.dionysos.winedictionary.model.service;

import java.util.ArrayList;
import java.util.List;

import org.nulljump.dionysos.common.Paging;
import org.nulljump.dionysos.winedictionary.model.vo.WineDictionary;

public interface WineDictionaryService {
	public ArrayList<WineDictionary> selectList();
	public WineDictionary selectWineDictionary(String grape_type);
	public int insertWineDictionary(WineDictionary wineDictionary);
	public int updateWineDictionary(WineDictionary wineDictionary);
	public int deleteWineDictionary(WineDictionary wineDictionary);
	public ArrayList<WineDictionary> selectSearchTitle(String keyword);

}

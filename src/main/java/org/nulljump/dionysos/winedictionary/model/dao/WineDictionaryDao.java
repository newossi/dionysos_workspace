package org.nulljump.dionysos.winedictionary.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.nulljump.dionysos.winedictionary.model.vo.WineDictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("wineDictionaryDao")
public class WineDictionaryDao {
	@Autowired
	private SqlSessionTemplate session;

	public ArrayList<WineDictionary> selectList() {
		List<WineDictionary> list = session.selectList("wineDictionaryMapper.selectList");
		return (ArrayList<WineDictionary>) list;
	}

	public WineDictionary selectWineDictionary(String grape_type) {
		// TODO Auto-generated method stub
		return session.selectOne("wineDictionaryMapper.selectWineDictionary", grape_type);
	}

	public int insertWineDictionary(WineDictionary wineDictionary) {
		// TODO Auto-generated method stub
		return session.insert("wineDictionaryMapper.insertWineDictionary", wineDictionary);
	}

	public int updateWineDictionary(WineDictionary wineDictionary) {
		// TODO Auto-generated method stub
		return session.update("wineDictionaryMapper.updateWineDictionary", wineDictionary);
	}

	public int deleteWineDictionary(WineDictionary wineDictionary) {
		// TODO Auto-generated method stub
		return session.delete("wineDictionaryMapper.deleteWineDictionary", wineDictionary);
	}
	
	public ArrayList<WineDictionary> selectSearchTitle(String keyword) {
		List<WineDictionary> list = session.selectList("wineDictionaryMapper.selectSearchTitle", keyword);
		return (ArrayList<WineDictionary>) list;
	}
}

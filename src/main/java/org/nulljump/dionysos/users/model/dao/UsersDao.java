package org.nulljump.dionysos.users.model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.mybatis.spring.SqlSessionTemplate;
import org.nulljump.dionysos.common.SearchDate;
import org.nulljump.dionysos.common.Searchs;
import org.nulljump.dionysos.users.model.vo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("usersDao")
public class UsersDao {

	@Autowired
	private SqlSessionTemplate session;

	public Users selectLogin(Users users) {
		Users loginUser = session.selectOne("usersMapper.selectLogin", users);
		if (loginUser != null && loginUser.getEmail() == null) {
			// 예외 처리
			loginUser = null;
		}
		return loginUser;
	}

	public int selectDupCheckId(String user_id) {
		return session.selectOne("usersMapper.selectDupCheckId", user_id);

	}

	public int deleteUsers(String user_id) {
		return session.delete("usersMapper.deleteUsers", user_id);
	}

	public ArrayList<Users> selectList() {
		List<Users> list = session.selectList("usersMapper.selectList");
		return (ArrayList<Users>) list;
	}

	public int insertUsers(Users users) {
		return session.insert("usersMapper.insertUsers", users);

	}

	public int updateUsers(Users users) {
		return session.update("usersMapper.updateUsers", users);
	}

	public Users selectUsers(String user_id) {
		return session.selectOne("usersMapper.selectUsers", user_id);

	}

	public ArrayList<Users> selectSearchUserid(Searchs searchs) {
		List<Users> list = session.selectList("usersMapper.selectSearchUserid", searchs);
		return (ArrayList<Users>)list;
	}
	
	public int evictionUsers(String user_id) {
		return session.selectOne("usersMapper.evictionUsers", user_id);
		
	}

	// 비밀번호 찾기용
	public int find_pwd(Users user) {
		return session.selectOne("usersMapper.pwdsearch", user);
	}

	// 비밀번호 변경
	@Transactional
	public int update_pw(Users users) {
		return session.update("usersMapper.update_pw", users);

	}

	// 아이디 찾기
	public String find_id(String email){
		return session.selectOne("usersMapper.find_id", email);
	}

	public ArrayList<Users> selectSearchEmail(Searchs searchs) {
		List<Users> list = session.selectList("usersMapper.selectEmail", searchs);
		return (ArrayList<Users>)list;
	}

	public ArrayList<Users> selectSearchBirthday(SearchDate searchDate) {
		List<Users> list = session.selectList("usersMapper.selectBirthday", searchDate);
		return (ArrayList<Users>)list;
	}
}

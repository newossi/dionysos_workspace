package org.nulljump.dionysos.users.model.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.nulljump.dionysos.common.SearchDate;
import org.nulljump.dionysos.common.Searchs;
import org.nulljump.dionysos.users.model.vo.Users;

public interface UsersService {
	Users selectLogin(Users users);
	int selectDupCheckId(String user_id);
	Users selectUsers(String user_id);
	ArrayList<Users> selectList();
	int insertUsers(Users users);
	int updateUsers(Users users);
	int evictionUsers(String user_id);
	int deleteUsers(String user_id);
	String find_id(String email);// 아이디 찾기
	int update_pw(Users users);// 비밀번호 찾기 2
	int pwdsearch(Users user); // 비밀번호 찾기
	// 검색
	ArrayList<Users> selectSearchUserid(Searchs searchs); // 아이디로
	ArrayList<Users> selectSearchEmail(Searchs searchs); // 이메일로
	ArrayList<Users> selectSearchBirthday(SearchDate searchDate); // 생년월일로
	
}

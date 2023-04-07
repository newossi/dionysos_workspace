package org.nulljump.dionysos.users.model.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.HtmlEmail;
import org.codehaus.plexus.logging.Logger;
import org.nulljump.dionysos.common.SearchDate;
import org.nulljump.dionysos.common.Searchs;
import org.nulljump.dionysos.users.model.dao.UsersDao;
import org.nulljump.dionysos.users.model.vo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service("usersService")
public class UsersServiceImpl implements UsersService {

	@Autowired
	UsersDao usersDao;

	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;

	@Override
	public Users selectLogin(Users users) {
		return usersDao.selectLogin(users);
	}

	@Override
	public int selectDupCheckId(String user_id) {
		return usersDao.selectDupCheckId(user_id);

	}

	@Override
	public Users selectUsers(String user_id) {
		return usersDao.selectUsers(user_id);

	}

	@Override
	public ArrayList<Users> selectList() {
		return usersDao.selectList();

	}

	@Override
	public int insertUsers(Users users) {
		return usersDao.insertUsers(users);

	}

	@Override
	public int updateUsers(Users users) {
		return usersDao.updateUsers(users);

	}

	@Override
	public int deleteUsers(String user_id) {
		return usersDao.deleteUsers(user_id);

	}

	@Override
	public ArrayList<Users> selectSearchUserid(Searchs searchs) {
		return usersDao.selectSearchUserid(searchs);

	}

	// 아이디 찾기
	@Override
	public String find_id(String email){
		return usersDao.find_id(email);
	}

		
	@Override
	public int update_pw(Users users) {
		return usersDao.update_pw(users);
	}

	@Override
	public int pwdsearch(Users user) {
		return usersDao.find_pwd(user);
	}

	@Override
	public ArrayList<Users> selectSearchEmail(Searchs searchs) {
		return usersDao.selectSearchEmail(searchs);
	}

	@Override
	public ArrayList<Users> selectSearchBirthday(SearchDate searchDate) {
		return usersDao.selectSearchBirthday(searchDate);
	}

	@Override
	public int evictionUsers(String user_id) {
		return usersDao.deleteUsers(user_id);

	}

}

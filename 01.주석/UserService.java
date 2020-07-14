package com.itwill.user;
/*
 * - 회원관리 비즈니스로직(예외처리,트랜젝션,보안,로깅)을 수행하는 클래스
 * - 웹컴퍼넌트(서블릿,JSP)에서 직접접근(메쏘드호출)하는 클래스
 * - Dao를 이용해서 데이타베이스를 조작작업하는 클래스
 */

import java.util.ArrayList;

import com.itwill.user.exception.ExistedUserException;
import com.itwill.user.exception.PasswordMismatchException;
import com.itwill.user.exception.UserNotFoundException;

public class UserService {
	private UserDao userDao;
	private static UserService _instance;
	public UserService() throws Exception{
		userDao=new UserDao();
		System.out.println("UserService()생성자:"+this);
	}
	public static UserService getInstance() throws Exception {
		if(UserService._instance==null) {
			UserService._instance=new UserService();
		}
		return UserService._instance;
	}
	
	/*
	 * 회원가입
	 */
	public int create(User user) throws Exception,ExistedUserException{
		//1. 아이디중복체크
		if(userDao.existedUser(user.getUserId())) {
			throw new ExistedUserException(user.getUserId()+" 는 이미존재하는 아이디입니다.");
		}
		return userDao.create(user);
	}
	/*
	 * 회원 로그인
	 */
	public User login(String userId,String password)
				throws Exception,UserNotFoundException,PasswordMismatchException{
		//1.아이디존재여부
		User user = userDao.findUser(userId);
		if(user==null) {
			throw new UserNotFoundException(userId+" 는 존재하지않는 아이디입니다.");
		}
		//2.패쓰워드일치여부
		if(!user.isMatchPassword(password)) {
			throw new PasswordMismatchException("패쓰워드가 일치하지않습니다.");
		}
		return user;
		
	}
	/*
	 * 회원1명보기
	 */
	public User findUser(String userId)throws Exception,UserNotFoundException{
		User user=userDao.findUser(userId);
		if(user==null) {
			throw new UserNotFoundException(userId+" 존재하지않는 아이디입니다.");
		}
		return user;
	}
	/*
	 * 회원리스트
	 */
	public ArrayList<User> findUserList() throws Exception{
		return userDao.findUserList();
	}
	/*
	 * 아이디중복체크
	 * 
	 */
	/*
	 * 아이디중복체크
	 * 
	 */
	public boolean isDuplcateUserId(String userId) throws Exception{
		boolean isExist = userDao.existedUser(userId);
		if(isExist) {
			return true;
		}else {
			return false;
		}
	}
	
	
	
	/*
	 * 회원탈퇴
	 */
	public int remove(String userId) throws Exception{
		return userDao.remove(userId);
	}
	/*
	 * 회원수정
	 */
	public int update(User user)throws Exception{
		return userDao.update(user);
	}
}





package com.shinhan.service;

import java.sql.SQLException;

import com.shinhan.dao.MemberDAO;
import com.shinhan.dto.MemberDTO;

public class MemberService {
	MemberDAO memberDAO = new MemberDAO();

	public MemberDTO selectMem(int member_code) throws SQLException {
		return memberDAO.selectMem(member_code);
	}

////로그인하기
	public MemberDTO loginChk(String id, String pw) {
		return memberDAO.loginChk(id, pw);
	}

	// 회원 가입
	public int memberInsert(MemberDTO member) {
		return memberDAO.memberInsert(member);
	}

	// 특정직원의 상세보기
	public MemberDTO selectById(String memid) {
		return memberDAO.selectById(memid);
	}

	// 회원 탈퇴
	public int memberDelete(MemberDTO member) {
		return memberDAO.memberDelete(member);
	}

	// 회원 탈퇴2
	public int memberDeleteByCode(int member_code) {
		return memberDAO.memberDeleteByCode(member_code);
	}

	// 회원 정보 수정
	public int memberUpdate(MemberDTO member) {
		return memberDAO.memberUpdate(member);
	}
}

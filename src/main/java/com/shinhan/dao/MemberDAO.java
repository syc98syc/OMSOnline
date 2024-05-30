package com.shinhan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.shinhan.dto.MemberDTO;
import com.shinhan.util.DBUtil;

public class MemberDAO {
	Connection conn;
	Statement st;
	PreparedStatement pst;

	ResultSet rs;

	// 로그인하기
	public MemberDTO loginChk(String id, String pw) {
		MemberDTO mem = null;
		String sql = "select member_code, authority, name, pw, contact, join_date " + " from member where id =?";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, id);
			rs = pst.executeQuery();

			if (rs.next()) {
				if (rs.getString("pw").equals(pw)) {
					mem = new MemberDTO();
					mem.setAuthority(rs.getString("authority"));
					mem.setContact(rs.getString("contact"));
					mem.setJoin_date(rs.getDate("join_date"));
					mem.setMember_code(rs.getInt("member_code"));
					mem.setName(rs.getString("name"));
					mem.setId(id);
					mem.setPw(pw);
				} else {
					mem = new MemberDTO();
					mem.setMember_code(-2);// 비밀번호 오류
				}
			} else {
				mem = new MemberDTO();
				mem.setMember_code(-1);// 존재하지 않는 직원
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mem;
	}

	// 회원 가입
	public int memberInsert(MemberDTO member) {
		int result = 0;
		String sql = "insert into member values(MEMBER_CODE_SEQ.nextval,'N',?,?,?,?,sysdate)";
		conn = DBUtil.dbConnection();
		try {

			pst = conn.prepareStatement(sql);
			pst.setString(1, member.getName());
			pst.setString(2, member.getId());
			pst.setString(3, member.getPw());
			pst.setString(4, member.getContact());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}

	// 멤버 로그인
	public MemberDTO selectById(String memid) {
		MemberDTO member = null;
		String sql = "select * from member where id = '" + memid + "'";
		conn = DBUtil.dbConnection();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				member = makeMem(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return member;
	}

	// 특정멤버 1명 조회
	private MemberDTO makeMem(ResultSet rs) throws SQLException {
		MemberDTO member = new MemberDTO();

		member.setId(rs.getString("id"));
		member.setPw(rs.getString("pw"));
		member.setMember_code(rs.getInt("member_code"));
		member.setAuthority(rs.getString("authority"));
		member.setContact(rs.getString("contact"));
		member.setJoin_date(rs.getDate("join_date"));
		member.setName(rs.getString("name"));

		return member;
	}

	// 특정멤버 1명 조회2
	public MemberDTO selectMem(int member_code) throws SQLException {
		MemberDTO member = null;
		String sql = "select * from member where member_code= " + member_code;
		conn = DBUtil.dbConnection();

		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				member = makeMem(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return member;
	}

	// 회원 탈퇴
	public int memberDelete(MemberDTO member) {
		int result = 0;
		String sql = "delete from member where id = ?";
		conn = DBUtil.dbConnection();
		try {

			pst = conn.prepareStatement(sql);
			pst.setString(1, member.getId());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}
	// 회원 탈퇴2
	public int memberDeleteByCode(int member_code) {
		int result = 0;
		String sql = "delete from member where member_code = ?";
		conn = DBUtil.dbConnection();
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, member_code);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}

	// 멤버 정보 수정
	public int memberUpdate(MemberDTO member) {
		int result = 0;
		String sql = "update member set name = ?, pw = ?, contact = ? where id = ?";
		conn = DBUtil.dbConnection();
		try {

			pst = conn.prepareStatement(sql);
			pst.setString(1, member.getName());
			pst.setString(2, member.getPw());
			pst.setString(3, member.getContact());
			pst.setString(4, member.getId());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, pst, rs);
		}
		return result;
	}
}

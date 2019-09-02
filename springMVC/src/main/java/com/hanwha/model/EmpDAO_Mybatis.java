package com.hanwha.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDAO_Mybatis {

	@Autowired
	SqlSession session;
	
	String ns = "com.hanwha.emp.";
	public List<Integer> selectAllManager() {
		return session.selectList(ns + "selectallmanager");
	}
	
	public List<String> selectAllJob() {
		return session.selectList(ns + "selectalljob");
	}

	public List<EmpVO> selectAll() {
		return session.selectList(ns + "selectall");
	}
	
	public EmpVO selectById(int empid) {
		return session.selectOne(ns + "selectbyid", empid);
	}
	
	public int insertEmp(EmpVO emp) {
		return session.insert(ns + "insert", emp);
	}
	
	public int updateEmp(EmpVO emp) {
		return session.update(ns + "update", emp);
	}

	public int deleteEmp(int empid) {
		return session.delete(ns + "delete", empid);
	}
	
}

package com.hanwha.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpService { // Controller가 요청하면 EmpService를 통해서 EmpDAO에 접근한다. 
	
	@Autowired
	EmpDAO_Mybatis dao;
	
	public List<Integer> selectAllManager() {
		return dao.selectAllManager();
	}
	
	public List<String> selectAllJob() {
		return dao.selectAllJob();
	}
	
	/*
	 * public List<EmpVO> selectByJob(String job, int sal) { return
	 * dao.selectByJob(job, sal); }
	 * 
	 * public List<EmpVO> selectByDept(int deptid) { return
	 * dao.selectByDept(deptid); }
	 */
	
	public List<EmpVO> selectAll() {
		return dao.selectAll();
	}
	
	public EmpVO selectById(int empid) {
		return dao.selectById(empid);
	}
	
	public int insertEmp(EmpVO emp) {
		return dao.insertEmp(emp);
	}
	
	public int updateEmp(EmpVO emp) {
		return dao.updateEmp(emp);
	}

	public int deleteEmp(int empid) {
		return dao.deleteEmp(empid);
	}

	/*
	 * public EmpDAO getDao() { return dao; }
	 * 
	 * public void setDao(EmpDAO dao) { this.dao = dao; }
	 */

	public void setDao(EmpDAO_Mybatis dao) {
		this.dao = dao;
	}
	
	

}

package com.hanwha.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.hanwha.model.DeptDAO_Mybatis;
import com.hanwha.model.DeptDTO;
import com.hanwha.model.EmpService;
import com.hanwha.model.EmpVO;

@Controller
public class MyController {

	/*
	 * DeptDAO dao = new DeptDAO(); <bean id="dap"
	 * class="com.hanwha.model.DeptDAO"/> <bean id="myController"
	 * class="com.hanwha.controller.Mycontroller">
	 * 
	 * </bean>
	 */

	/*
	 * @Autowired DeptDAO dao;
	 */

	@Autowired
	DeptDAO_Mybatis dao;

	@Autowired
	EmpService service;

	@RequestMapping("/404")
	public String error404(Model model) {
		model.addAttribute("company", "한화시스템ICT");
		model.addAttribute("manager", "홈페이지 관리자");
		return "error404"; // error404.jsp로 return
	}

	/*
	 * @RequestMapping("/500") public String error500(Model model) {
	 * model.addAttribute("company", "한화시스템ICT"); model.addAttribute("manager",
	 * "홈페이지 관리자"); model.addAttribute("phone", "010-0000-0000"); return "error500";
	 * }
	 */

	@ExceptionHandler(Exception.class)
	public String error500(Exception e, Model model) {
		model.addAttribute("company", "한화시스템ICT");
		model.addAttribute("manager", "홈페이지 관리자");
		model.addAttribute("phone", "010-0000-0000");
		model.addAttribute("errormessage", e.getMessage());
		return "error500";
	}

	@RequestMapping("/dept/deptlist") /* 유저가 주소창에 요청 */
	public String deptlist1(Model model) {
		model.addAttribute("deptlist", dao.selectAll());
		return "dept/deptlist"; /* 웹페이지 이름 */
	}

	@RequestMapping(value = "/dept/deptdetail", method = RequestMethod.GET)
	public String deptdetail(int deptid, Model model) {
		model.addAttribute("dept", dao.selectById(deptid));
		return "dept/deptdetail";
	}

	@RequestMapping(value = "/dept/deptdetail", method = RequestMethod.POST)
	public String deptdetail2(DeptDTO dept, Model model) {
		dao.updateDept(dept);
		return "redirect:/dept/deptlist";
	}

	@RequestMapping(value = "/dept/deptinsert", method = RequestMethod.GET)
	public String deptInsertGet() {
		return "dept/deptinsert";
	}

	@RequestMapping(value = "/dept/deptinsert", method = RequestMethod.POST)
	public String deptInsertPost(DeptDTO dept, HttpServletRequest request) {
		MultipartFile uploadfile = dept.getUploadfile();
		if (uploadfile == null) {
			return "redirect:deptinsert";
		}
		String path = request.getSession().getServletContext().getRealPath("/resources");
		System.out.println("웹 서버 실제 경로 " + path);
		String fileName = uploadfile.getOriginalFilename();
		String fpath = path + "\\" + fileName;
		dept.setFileName(fileName);
		try { // File 사용
			File file = new File(fpath);  
			uploadfile.transferTo(file);
		} catch (IOException e) {
			e.printStackTrace();
		}

		dao.insertDept(dept);
		return "redirect:deptlist";
	}

	@RequestMapping(value = "/dept/deptdownload")
	public void download(String folder, String file, HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setHeader("Content-Disposition", "attachment;filename=" + file);
		String fullPath = request.getSession().getServletContext().getRealPath(folder + "/" + file);
		FileInputStream fi = new FileInputStream(fullPath);
		ServletOutputStream sout = response.getOutputStream();
		byte[] buf = new byte[1024];
		int size = 0;
		while ((size = fi.read(buf, 0, 1024)) != -1) {
			sout.write(buf, 0, size);
		}
		fi.close();
		sout.close();
	}

	@RequestMapping(value = "/dept/deptdelete", method = RequestMethod.GET)
	public String deptDelete(int deptid, Model model) {
		dao.deleteDept(deptid);
		return "redirect:/dept/deptlist";
	}

	@RequestMapping(value = "emp/emplist")
	public ModelAndView selectAll() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("emplist", service.selectAll());
		mv.setViewName("emp/empAll");
		return mv;
	}

	@RequestMapping(value = "/emp/empdetail", method = RequestMethod.GET)
	public ModelAndView detail(int empid) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("emp", service.selectById(empid));
		mv.addObject("managerlist", service.selectAllManager());
		mv.addObject("joblist", service.selectAllJob());
		mv.addObject("deptlist", dao.selectAll());
		mv.setViewName("emp/empdetail");
		return mv;
	}

	@RequestMapping(value = "/emp/empdetail", method = RequestMethod.POST)
	public String update(EmpVO emp) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("emp", service.updateEmp(emp));
		return "redirect:/emp/emplist";
	}

	@RequestMapping(value = "/emp/empdelete", method = RequestMethod.GET)
	public String delete(int empid) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("emp", service.deleteEmp(empid));
		return "redirect:/emp/emplist";
	}

	@RequestMapping(value = "/emp/empinsert", method = RequestMethod.GET)
	public ModelAndView insert(EmpVO emp) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("joblist", service.selectAllJob());
		mv.addObject("managerlist", service.selectAllManager());
		mv.addObject("deptlist", dao.selectAll());
		mv.setViewName("emp/empinsert");
		return mv;
	}

	@RequestMapping(value = "/emp/empinsert", method = RequestMethod.POST)
	public String insertEmp(EmpVO emp) {
		service.insertEmp(emp);
		return "redirect:/emp/emplist";
	}
}

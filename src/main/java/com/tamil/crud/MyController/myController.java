package com.tamil.crud.MyController;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.tamil.crud.Entity.IncomeExpense;
import com.tamil.crud.Service.MyService;

import jakarta.servlet.http.HttpSession;

@Controller
public class myController {
	@Autowired
	MyService serv;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
//	@PostMapping("/inc")
//	public IncomeExpense incInsert(@RequestBody IncomeExpense obj) {
//		//serv.insert(obj);
//		return serv.insert(obj);
//	}
	@PostMapping("/inc")
	public String incInsert2(IncomeExpense obj) {
		serv.insert(obj);
		return "index";
	}
	
	@PostMapping("/exp")
	public String expInsert(IncomeExpense obj) {
		serv.insert(obj);
		return "index";
	}
	@RequestMapping("/rep/{uid}")
	public String report(@PathVariable int uid,Model m) {
		m.addAttribute("list",serv.selectByUid(uid));
		
		return "report";
	}
	@GetMapping("/update")
	public String update(@RequestParam int id, @RequestParam int uid,Model m) {
		//System.out.println(id+" "+uid);
		
		m.addAttribute("obj",serv.selectByIdAndUid(id, uid));
		return "update";
		
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id,IncomeExpense obj,Model m) {
		System.out.println(id+" "+obj.toString());
		
		int uid=obj.getUid();
		IncomeExpense existobj=serv.selectByIdAndUid(id, uid);
		existobj.setId(obj.getId());
		existobj.setUid(obj.getUid());
		existobj.setDate(obj.getDate());
		existobj.setDesc(obj.getDesc());
		existobj.setIncAmt(obj.getIncAmt());
		existobj.setExpAmt(obj.getExpAmt());
		serv.insert(existobj);
		
		ModelAndView mv=new ModelAndView();
		mv.setViewName("report");
		return "redirect:/rep/"+uid;
	}
	@GetMapping("/delete")
	public String delete(@RequestParam int id, @RequestParam int uid) {
		System.out.println(id+" "+uid+" in delete");
		serv.delete(id, uid);
		return "redirect:/rep/"+uid;
	}
	
	@RequestMapping("/serach/{uid}")
	public String search(@PathVariable int uid,Model m,HttpSession ses) {
		m.addAttribute("uid",uid);
		ses.setAttribute("uid", uid);
		return "search";
	}
	
	@RequestMapping("/btwDate")
	public String selectBtw(@RequestParam Date date,@RequestParam Date date2, @RequestParam int uid , Model m) {
		m.addAttribute("list",serv.selectBetweenDates(date, date2,uid));
		m.addAttribute("IncSum",serv.sumOfIncome(date, date2, uid));
		m.addAttribute("ExpSum",serv.sumOfExpense(date, date2, uid));
		System.out.println(serv.sumOfIncome(date, date2, uid));
		System.out.println(serv.sumOfExpense(date, date2, uid));
		return "search";
	}
}

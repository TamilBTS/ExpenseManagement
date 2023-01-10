package com.tamil.crud.Service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tamil.crud.Entity.IncomeExpense;
import com.tamil.crud.repository.crudRepo;

import jakarta.transaction.Transactional;
@Service
public class MyService {
	@Autowired
	crudRepo rep;
	public IncomeExpense insert(IncomeExpense obj) {
		return rep.save(obj);
	}
	
	public List<IncomeExpense> selectByUid(int uid){
		List<IncomeExpense> list=rep.getItemByUid(uid);
		return list;
	}
	
	public IncomeExpense selectByIdAndUid(int id,int uid) {
		//IncomeExpense exist=rep.getByIdAndUid(id, uid);
	
		return rep.getByIdAndUid(id,uid);
	}
	
	public void update(IncomeExpense obj) {
		rep.save(obj);
	}
	@Transactional
	public void delete(int id,int uid) {
		rep.deleteByIdAndUid(id, uid);
	}
	
	public List<IncomeExpense> selectBetweenDates(Date date,Date date2,int uid){
		return rep.getBetweenDate(date,date2,uid);
	}
	
	public Double sumOfIncome(Date d1,Date d2,int uid){
		return rep.sumOfIncome(d1, d2, uid);
	}
	
	public Double sumOfExpense(Date d1,Date d2,int uid) {
		return rep.sumOfExpense(d1, d2, uid);
	}
}

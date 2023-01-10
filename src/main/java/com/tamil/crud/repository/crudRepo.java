package com.tamil.crud.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.tamil.crud.Entity.IncomeExpense;


public interface crudRepo extends JpaRepository<IncomeExpense,Integer>{
	@Query(value="select * from income_expense where uid=?1 order by id DESC",nativeQuery = true)
	public List<IncomeExpense> getItemByUid(int uid);
	
	@Query(value = "select * from income_expense where id=?1 and uid=?2",nativeQuery = true)
	public IncomeExpense getByIdAndUid(int id,int uid);
	
	@Modifying
	@Query(value = "delete from income_expense where id=?1 and uid=?2",nativeQuery = true)
	public void deleteByIdAndUid(int id,int uid);
	
	@Query(value = "select * from income_expense where date between ?1 and ?2 and uid=?3 order by date asc", nativeQuery = true)
	public List<IncomeExpense> getBetweenDate(Date d1,Date d2,int uid);
	
	@Query(value = "select sum(inc_amt) from income_expense where date between ?1 and ?2 and uid=?3",nativeQuery = true)
	public Double sumOfIncome(Date d1,Date d2,int uid);
	
	@Query(value= "select sum(exp_amt) from income_expense where date between ?1 and ?2 and uid=?3",nativeQuery = true)
	public Double sumOfExpense(Date d1,Date d2,int uid);
}

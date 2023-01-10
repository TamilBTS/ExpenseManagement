package com.tamil.crud.Entity;



import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class IncomeExpense {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private int uid;
	@Column
	private Date date;
	@Column
	private String des;
	@Column
	private double incAmt;
	@Column
	private double expAmt;
	
	public IncomeExpense(int uid, Date date, String desc, double incAmt, double expAmt) {
		super();
		this.uid = uid;
		this.date = date;
		this.des = desc;
		this.incAmt = incAmt;
		this.expAmt = expAmt;
	}
	public IncomeExpense() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "IncomeExpense [id=" + id + ", uid=" + uid + ", date=" + date + ", desc=" + des + ", incAmt=" + incAmt
				+ ", expAmt=" + expAmt + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDesc() {
		return des;
	}
	public void setDesc(String desc) {
		this.des = desc;
	}
	public double getIncAmt() {
		return incAmt;
	}
	public void setIncAmt(double incAmt) {
		this.incAmt = incAmt;
	}
	public double getExpAmt() {
		return expAmt;
	}
	public void setExpAmt(double expAmt) {
		this.expAmt = expAmt;
	}
	
	
}

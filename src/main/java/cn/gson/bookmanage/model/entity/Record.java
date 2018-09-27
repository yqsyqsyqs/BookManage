package cn.gson.bookmanage.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="b_record")
public class Record {

	@Id
	@GeneratedValue(generator="record",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(sequenceName = "sqrecord", allocationSize = 1, initialValue = 1, name = "record")
	@Column(name="record_id")
	private Long recordId;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	private Double money;
	
	private Date chongzhidate;

	public Long getRecordId() {
		return recordId;
	}

	public void setRecordId(Long recordId) {
		this.recordId = recordId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public Date getChongzhidate() {
		return chongzhidate;
	}

	public void setChongzhidate(Date chongzhidate) {
		this.chongzhidate = chongzhidate;
	}
	

	@Override
	public String toString() {
		return "Record [recordId=" + recordId + ", money=" + money + ", chongzhidate=" + chongzhidate + "]";
	}

	public Record(Long recordId, User user, Double money, Date chongzhidate) {
		super();
		this.recordId = recordId;
		this.user = user;
		this.money = money;
		this.chongzhidate = chongzhidate;
	}

	public Record() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}

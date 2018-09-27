package cn.gson.bookmanage.model.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import org.apache.commons.logging.Log;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

@Entity
@Table(name="b_user")
public class User {

	@Id
	@GeneratedValue(generator="yonghu",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(sequenceName = "squser", allocationSize = 1, initialValue = 1, name = "yonghu")
	@Column(name="user_id")
	private Long userId;
	
	@OneToMany(mappedBy="user")
	private Set<Share> shares;
	
	@OneToMany(mappedBy="user")
	private Set<Borrow> borrows;
	
	@OneToMany(mappedBy="user")
	private Set<Back> backs;
	
	@OneToMany(mappedBy="user")
	private Set<Oldbook> Oldbooks;
	
	@OneToMany(mappedBy="user")
	private Set<Collect> Collects;
	
	@OneToMany(mappedBy="user")
	private Set<Record> Records;
	
	//用户名
	@Column(name="user_name")
	@NotEmpty(message="用户名不能为空")
	@Length(min=0,max=12,message="最大12")
	private String userName;
	
	//学号
	@NotEmpty(message="学号不能为空")
	@Length(min=6,max=12,message="最小6最大12")
	@Column(name="user_number")
	private String userNumber;
	
	//电话
	@NotEmpty(message="电话不能为空")
	@Pattern(regexp="^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$",message="请填写正确手机号")
	private String userTel;
	
	//密码
	@NotEmpty(message="密码不能为空")
	@Length(min=6,max=10,message="最小6最大10")
	private String password;
	
	//余额
	private Double money;
	
	//图片
	@Column(name="user_imgid")
	private Long userImgid;
	
	//是否为管理员 0是管理员 1是用户
	private Integer ismanage;

	
	
	

	public Set<Share> getShares() {
		return shares;
	}

	public void setShares(Set<Share> shares) {
		this.shares = shares;
	}

	public Integer getIsmanage() {
		return ismanage;
	}

	public void setIsmanage(Integer ismanage) {
		this.ismanage = ismanage;
	}

	public Set<Oldbook> getOldbooks() {
		return Oldbooks;
	}

	public void setOldbooks(Set<Oldbook> oldbooks) {
		Oldbooks = oldbooks;
	}

	public Set<Collect> getCollects() {
		return Collects;
	}

	public void setCollects(Set<Collect> collects) {
		Collects = collects;
	}

	public Set<Record> getRecords() {
		return Records;
	}

	public void setRecords(Set<Record> records) {
		Records = records;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Set<Borrow> getBorrows() {
		return borrows;
	}

	public void setBorrows(Set<Borrow> borrows) {
		this.borrows = borrows;
	}

	public Set<Back> getBacks() {
		return backs;
	}

	public void setBacks(Set<Back> backs) {
		this.backs = backs;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public Long getUserImgid() {
		return userImgid;
	}

	public void setUserImgid(Long userImgid) {
		this.userImgid = userImgid;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userNumber=" + userNumber + ", userTel="
				+ userTel + ", password=" + password + ", money=" + money + ", userImgid=" + userImgid + ", ismanage="
				+ ismanage + "]";
	}

	public User(Long userId, Set<Borrow> borrows, Set<Back> backs, String userName, String userNumber, String userTel,
			String password, Double money, Long userImgid) {
		super();
		this.userId = userId;
		this.borrows = borrows;
		this.backs = backs;
		this.userName = userName;
		this.userNumber = userNumber;
		this.userTel = userTel;
		this.password = password;
		this.money = money;
		this.userImgid = userImgid;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

	
	
	
}

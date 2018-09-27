package cn.gson.bookmanage.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="b_back")
public class Back {

	@Id
	@GeneratedValue(generator="back",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(sequenceName = "sqback", allocationSize = 1, initialValue = 1, name = "back")
	@Column(name="back_id")
	private Long backId;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="book_id")
	private Book book;
	
	
	//归还数量
	@Column(name="bcak_number")
	private Long bcakNumber;
	
	//归还日期
	@Column(name="bcak_date")
	private Date bcakDate;
	
	

	public Long getBackId() {
		return backId;
	}

	public void setBackId(Long backId) {
		this.backId = backId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Long getBcakNumber() {
		return bcakNumber;
	}

	public void setBcakNumber(Long bcakNumber) {
		this.bcakNumber = bcakNumber;
	}

	public Date getBcakDate() {
		return bcakDate;
	}

	public void setBcakDate(Date bcakDate) {
		this.bcakDate = bcakDate;
	}

	public Back(Long backId, User user, Book book, Long bcakNumber, Date bcakDate) {
		super();
		this.backId = backId;
		this.user = user;
		this.book = book;
		this.bcakNumber = bcakNumber;
		this.bcakDate = bcakDate;
	}
	
	

	@Override
	public String toString() {
		return "Back [backId=" + backId + ", user=" + user + ", book=" + book + ", bcakNumber=" + bcakNumber
				+ ", bcakDate=" + bcakDate + "]";
	}

	public Back() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
	
	
	
	
	
}

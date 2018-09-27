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

import org.hibernate.annotations.ColumnDefault;
import org.springframework.beans.factory.annotation.Value;

@Entity
@Table(name="b_borrow")
public class Borrow {

	@Id
	@GeneratedValue(generator="borrow",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(sequenceName = "sqborrow", allocationSize = 1, initialValue = 1, name = "borrow")
	@Column(name="borrow_id")
	private Long borrowId;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="book_id")
	private Book book;
	
	//借书数量
		@Column(name="borrow_number")
		private Long borrowNumber;
	
	//借书日期
	@Column(name="borrow_date")
	private Date borrowDate;

	public Long getBorrowId() {
		return borrowId;
	}

	public void setBorrowId(Long borrowId) {
		this.borrowId = borrowId;
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

	public Long getBorrowNumber() {
		return borrowNumber;
	}

	public void setBorrowNumber(Long borrowNumber) {
		this.borrowNumber = borrowNumber;
	}

	public Date getBorrowDate() {
		return borrowDate;
	}

	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}

	public Borrow(Long borrowId, User user, Book book, Long borrowNumber, Date borrowDate) {
		super();
		this.borrowId = borrowId;
		this.user = user;
		this.book = book;
		this.borrowNumber = borrowNumber;
		this.borrowDate = borrowDate;
	}

	public Borrow() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Borrow [borrowId=" + borrowId + ", book=" + book + ", borrowNumber=" + borrowNumber + ", borrowDate="
				+ borrowDate + "]";
	}
	
	

	

	
	
	
	
}

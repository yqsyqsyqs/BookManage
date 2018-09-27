package cn.gson.bookmanage.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="B_Type")
public class Type {
	
	@Id
	@GeneratedValue(generator="type",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(sequenceName = "booktype", allocationSize = 1, initialValue = 1, name = "type")
	@Column(name="book_id")
	private Long bookId;
	
	@Column(name="book_name")
	private String bookName;

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	
	@Override
	public String toString() {
		return "Type [bookName=" + bookName + "]";
	}

	public Type() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}

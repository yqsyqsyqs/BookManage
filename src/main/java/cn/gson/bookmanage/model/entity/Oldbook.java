package cn.gson.bookmanage.model.entity;

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
@Table(name="b_oldbook")
public class Oldbook {

	@Id
	@GeneratedValue(generator="oldbook",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(sequenceName = "sqoldbook", allocationSize = 1, initialValue = 1, name = "oldbook")
	@Column(name="oldbook_id")
	private Long oldbookId;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@Column(name="book_id")
	private Long bookId;

	public Long getOldbookId() {
		return oldbookId;
	}

	public void setOldbookId(Long oldbookId) {
		this.oldbookId = oldbookId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public Oldbook(Long oldbookId, User user, Long bookId) {
		super();
		this.oldbookId = oldbookId;
		this.user = user;
		this.bookId = bookId;
	}
	
	



	@Override
	public String toString() {
		return "Oldbook [oldbookId=" + oldbookId + ", bookId=" + bookId + "]";
	}

	public Oldbook() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}

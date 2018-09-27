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
@Table(name="b_Share")
public class Share {

	@Id
	@GeneratedValue(generator="share",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(sequenceName = "sqshare", allocationSize = 1, initialValue = 1, name = "share")
	@Column(name="share_id")
	private Long shareId;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="book_id")
	private Book book;
	
	//is_read为0表示未阅读 为1表示已经阅读
	@Column(name="is_read")
	private int isRead;
	
	
	
	
	public int getIs_read() {
		return isRead;
	}

	public void setIs_read(int isRead) {
		this.isRead = isRead;
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
	
	@Override
	public String toString() {
		return "Share [shareId=" + shareId +  ", book=" + book + ", isRead=" + isRead + "]";
	}

	public Share() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	
	
	
	
	
	
}

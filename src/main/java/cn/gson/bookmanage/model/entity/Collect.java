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
@Table(name="b_collect")
public class Collect {

	@Id
	@GeneratedValue(generator="collect",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(sequenceName = "sqcollect", allocationSize = 1, initialValue = 1, name = "collect")
	@Column(name="collect_id")
	private Long collectId;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@Column(name="book_id")
	private Long bookId;
	
	@Column(name="collect_date")
	private Date collectDate;

	public Long getCollectId() {
		return collectId;
	}

	public void setCollectId(Long collectId) {
		this.collectId = collectId;
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

	public Date getCollectDate() {
		return collectDate;
	}

	public void setCollectDate(Date collectDate) {
		this.collectDate = collectDate;
	}
	
	


	@Override
	public String toString() {
		return "Collect [collectId=" + collectId + ", bookId=" + bookId + ", collectDate=" + collectDate + "]";
	}


	public Collect() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}

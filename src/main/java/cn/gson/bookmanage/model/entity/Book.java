package cn.gson.bookmanage.model.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="b_book")
public class Book {

	@Id
	@GeneratedValue(generator="book",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(sequenceName = "sqbook", allocationSize = 1, initialValue = 1, name = "book")
	@Column(name="book_id")
	private Long bookId;
	
//	@OneToMany(mappedBy="book")
//	private Set<Share> shares;
//	
//	@OneToMany(mappedBy="book")
//	private Set<Borrow> borrows;
//	
//	@OneToMany(mappedBy="book")
//	private  Set<Back> backs;
//	
	//书名
	@NotEmpty
	@Column(name="book_name")
	private String bookName;
	
	//出版社
	@NotEmpty
	private String rebulisher;
	
	//作者
	@NotEmpty
	private String author;
	
	//出版时间
	private String putDate;
	
	//价格
	private Double price;
	
	//库存数量
	private Long storenumber;
	
	//图片
	@Column(name="book_imgid")
	private Long bookImgid;
	
	//是否放入回收注销
	private Integer isuse;
	
	//拼音
	private String pinyin;
	
	//类型
	@Column(name="type_id")
	private Integer typeId;
	
	
	

//	public Set<Share> getShares() {
//		return shares;
//	}
//
//	public void setShares(Set<Share> shares) {
//		this.shares = shares;
//	}

	public String getPinyin() {
		return pinyin;
	}

	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	
	
//	public Set<Borrow> getBorrows() {
//		return borrows;
//	}
//
//	public void setBorrows(Set<Borrow> borrows) {
//		this.borrows = borrows;
//	}
//
//	public Set<Back> getBacks() {
//		return backs;
//	}
//
//	public void setBacks(Set<Back> backs) {
//		this.backs = backs;
//	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getRebulisher() {
		return rebulisher;
	}

	public void setRebulisher(String rebulisher) {
		this.rebulisher = rebulisher;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPutDate() {
		return putDate;
	}

	public void setPutDate(String putDate) {
		this.putDate = putDate;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Long getStorenumber() {
		return storenumber;
	}

	public void setStorenumber(Long storenumber) {
		this.storenumber = storenumber;
	}

	public Long getBookImgid() {
		return bookImgid;
	}

	public void setBookImgid(Long bookImgid) {
		this.bookImgid = bookImgid;
	}

	public Integer getIsuse() {
		return isuse;
	}

	public void setIsuse(Integer isuse) {
		this.isuse = isuse;
	}
		
	
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", rebulisher=" + rebulisher + ", author=" + author
				+ ", putDate=" + putDate + ", price=" + price + ", storenumber=" + storenumber + ", bookImgid="
				+ bookImgid + ", isuse=" + isuse + ", pinyin=" + pinyin + ", typeId=" + typeId + "]";
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}

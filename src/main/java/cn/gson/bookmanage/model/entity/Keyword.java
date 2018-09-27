package cn.gson.bookmanage.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;


@Entity
@Table(name="b_keyword")
public class Keyword {

	@Id
	@Column(name="keyword_id")
	@GeneratedValue(generator="keyword",strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(sequenceName="seqkeyword",allocationSize=1,initialValue=1,name="keyword")
	private Long keywordId; //关键字id
	
	@Column(name="create_time")
	private Date createTime; //创建时间
	
	private String rkeyword; //关键字
	
	@Column(name="keyWordNumber",columnDefinition="number(10) DEFAULT 0")
	private int keyWordNumber;//热度

	




	@Override
	public String toString() {
		return "Keyword [keyword_id=" + keywordId + ", createTime=" + createTime + ", rkeyword=" + rkeyword
				+ ", keyWordNumber=" + keyWordNumber + "]";
	}



	



	public Date getCreateTime() {
		return createTime;
	}



	public void setCreateTime(Date date) {
		this.createTime = date;
	}
	
	public Long getKeywordId() {
		return keywordId;
	}



	public void setKeywordId(Long keywordId) {
		this.keywordId = keywordId;
	}



	public String getRkeyword() {
		return rkeyword;
	}



	public void setRkeyword(String rkeyword) {
		this.rkeyword = rkeyword;
	}



	public int getKeyWordNumber() {
		return keyWordNumber;
	}



	public void setKeyWordNumber(int keyWordNumber) {
		this.keyWordNumber = keyWordNumber;
	}



	public Keyword() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}

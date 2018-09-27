package cn.gson.bookmanage.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * 附件表
 * @author admin
 *
 */
@Entity
@Table(name="b_attachment")
public class Attachment {

	
	
	@Id
	@Column(name="attachment_id")
	@GeneratedValue(generator="attachment",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(sequenceName = "sqattachment", allocationSize = 1, initialValue = 1, name = "attachment")
	private Long attachmentId; //附件id
	
	@Column(name="user_id")
	private Long userId;  //用户id 没有外键
	
	@Column(name="book_id")
	private Long bookId;  //用户id 没有外键
	
	@Column(name="attachment_name")
	private String attachmentName;  //附件名字
	
	@Column(name="attachment_path")
	private String attachmentPath;  //附件存储路径
	
	
	@Column(name="attachment_size")
	private Long attachmentSize; //附件大小
	
	@Column(name="attachment_type")
	private String attachmentType;  //附件类型
	
	@Column(name="upload_time")
	private Date uploadTime;     //附件上传时间
	
	private String model;          //所属模块
	
	@Column(name="attachment_shuffix")
	private String attachmentShuffix; //附件后缀

	public Long getAttachmentId() {
		return attachmentId;
	}

	public void setAttachmentId(Long attachmentId) {
		this.attachmentId = attachmentId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getAttachmentName() {
		return attachmentName;
	}

	public void setAttachmentName(String attachmentName) {
		this.attachmentName = attachmentName;
	}

	public String getAttachmentPath() {
		return attachmentPath;
	}

	public void setAttachmentPath(String attachmentPath) {
		this.attachmentPath = attachmentPath;
	}

	public Long getAttachmentSize() {
		return attachmentSize;
	}

	public void setAttachmentSize(Long attachmentSize) {
		this.attachmentSize = attachmentSize;
	}

	public String getAttachmentType() {
		return attachmentType;
	}

	public void setAttachmentType(String attachmentType) {
		this.attachmentType = attachmentType;
	}

	public Date getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getAttachmentShuffix() {
		return attachmentShuffix;
	}

	public void setAttachmentShuffix(String attachmentShuffix) {
		this.attachmentShuffix = attachmentShuffix;
	}

	@Override
	public String toString() {
		return "Attachment [attachmentId=" + attachmentId + ", userId=" + userId + ", bookId=" + bookId
				+ ", attachmentName=" + attachmentName + ", attachmentPath=" + attachmentPath + ", attachmentSize="
				+ attachmentSize + ", attachmentType=" + attachmentType + ", uploadTime=" + uploadTime + ", model="
				+ model + ", attachmentShuffix=" + attachmentShuffix + "]";
	}

	public Attachment(Long attachmentId, Long userId, Long bookId, String attachmentName, String attachmentPath,
			Long attachmentSize, String attachmentType, Date uploadTime, String model, String attachmentShuffix) {
		super();
		this.attachmentId = attachmentId;
		this.userId = userId;
		this.bookId = bookId;
		this.attachmentName = attachmentName;
		this.attachmentPath = attachmentPath;
		this.attachmentSize = attachmentSize;
		this.attachmentType = attachmentType;
		this.uploadTime = uploadTime;
		this.model = model;
		this.attachmentShuffix = attachmentShuffix;
	}

	public Attachment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	
	
	
}

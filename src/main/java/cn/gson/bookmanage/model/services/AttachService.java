package cn.gson.bookmanage.model.services;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cn.gson.bookmanage.model.dao.AttachDao;
import cn.gson.bookmanage.model.entity.Attachment;
import cn.gson.bookmanage.model.entity.Book;
import cn.gson.bookmanage.model.entity.User;

@Service
public class AttachService {

	@Autowired
	AttachDao attachDao;
	
	@Value("${file.root.path}")
	private String rootpath;
	
	public Attachment saveAttachment(MultipartFile file,Object obj) throws IllegalStateException, IOException{
		//处理文件信息
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy/MM");
		File root =new File(this.rootpath,simpleDateFormat.format(new Date()));
		if(!root.exists()){
			root.mkdirs();
		}
		String shuffix=FilenameUtils.getExtension(file.getOriginalFilename());
		String filenewname=UUID.randomUUID().toString().toLowerCase()+"."+shuffix;
		File targetFile=new File(root,filenewname);
		file.transferTo(targetFile);
		//封装
		Attachment att=new Attachment();
		att.setAttachmentName(file.getOriginalFilename());
		att.setAttachmentPath(targetFile.getAbsolutePath().replace("\\", "/").replace(this.rootpath, ""));
		att.setAttachmentShuffix(shuffix);
		att.setAttachmentSize(file.getSize());
		att.setAttachmentType(file.getContentType());
		att.setUploadTime(new Date());
		if(obj instanceof User){
			User user=(User) obj;
			att.setUserId(user.getUserId());
		}if(obj instanceof Book){
			Book book=(Book) obj;
			att.setBookId(book.getBookId());
		}
		attachDao.save(att);
		return att;
		
	}
	
	public File get(Attachment att) {
		return new File(this.rootpath+att.getAttachmentPath());
		
	}

	
}

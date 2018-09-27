package cn.gson.bookmanage.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.gson.bookmanage.model.entity.Attachment;

public interface AttachDao extends JpaRepository<Attachment, Long>{
	
		

}

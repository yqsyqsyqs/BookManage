package cn.gson.bookmanage.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cn.gson.bookmanage.model.entity.Back;
import cn.gson.bookmanage.model.entity.Borrow;

public interface BackDao extends JpaRepository<Back, Long>{

	@Query("from Back b where b.book.bookId=?1 and b.user.userId=?2")
	Back findBackByBook(Long bookid,Long userid);
	
	@Query("from Back b where b.user.userId=?1")
	List<Back> findBacksByuserId(Long userid);
	
}

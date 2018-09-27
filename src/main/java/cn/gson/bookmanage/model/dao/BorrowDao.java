package cn.gson.bookmanage.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cn.gson.bookmanage.model.entity.Book;
import cn.gson.bookmanage.model.entity.Borrow;

public interface BorrowDao extends JpaRepository<Borrow, Long>{

	@Query("from Borrow b where b.book.bookId=?1 and b.user.userId=?2")
	Borrow findBorrowByBook(Long bookid,Long userid);
	
	@Query("from Borrow b where b.user.userId=?1")
	List<Borrow> findBorrowsByuserId(Long userid);
}

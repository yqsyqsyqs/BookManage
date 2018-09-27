package cn.gson.bookmanage.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cn.gson.bookmanage.model.entity.Book;

public interface BookDao extends JpaRepository<Book, Long>{

	@Query("from Book b where b.bookName like %?1% or (b.rebulisher like %?1% or b.author like %?1%)")
	List<Book> findByBookNameOrRebulisherOrAuthor(String research);
	
	@Query("from Book b where b.isuse=?1")
	List<Book> findBookByIsuse(Integer isuse);
	
	
	
	Book findBookByBookName(String bookname);
}

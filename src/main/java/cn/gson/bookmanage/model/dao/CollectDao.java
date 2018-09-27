package cn.gson.bookmanage.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cn.gson.bookmanage.model.entity.Book;
import cn.gson.bookmanage.model.entity.Collect;

public interface CollectDao extends JpaRepository<Collect, Long>{

	@Query("select b from Book b where  bookId in (select c.bookId from Collect c where c.user.userId=?1 )")
	List<Book> findBookByUser(Long userId);
}

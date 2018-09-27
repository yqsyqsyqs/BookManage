package cn.gson.bookmanage.model.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cn.gson.bookmanage.model.entity.Book;
import cn.gson.bookmanage.model.entity.Share;
import cn.gson.bookmanage.model.entity.User;

public interface ShareDao extends JpaRepository<Share, Long>{
	
	@Query(value="SELECT COUNT(*) from B_SHARE s WHERE  s.USER_ID=?1 and s.IS_READ=0",nativeQuery=true)
	Integer countnotread(Long userId);
	
	List<Share> findSharesByUserAndIsRead(User user,int is_read);
	
	Share findShareByUserAndBook(User user,Book book);
}

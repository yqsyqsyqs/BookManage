package cn.gson.bookmanage.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.gson.bookmanage.model.entity.Book;


@Mapper
public interface BookMapper {
	List<Book> findallbook();
	
	List<Book> mohufind(@Param("bookName")String bookName);
	
	List<Book> mohufind2(@Param("bookName")String bookName);
	
	List<Book> mohufind3(Book book);
	
}

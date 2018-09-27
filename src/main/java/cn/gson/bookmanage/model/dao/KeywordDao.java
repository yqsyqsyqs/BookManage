package cn.gson.bookmanage.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.gson.bookmanage.model.entity.Keyword;
import java.lang.String;
import java.util.List;

public interface KeywordDao extends JpaRepository<Keyword,Long>{
	 
	 
}

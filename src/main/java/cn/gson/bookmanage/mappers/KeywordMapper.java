package cn.gson.bookmanage.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.gson.bookmanage.model.entity.Keyword;

@Mapper
public interface KeywordMapper {
	List<Keyword>  findhotthree();
	
	Keyword findKeywordByRkeyword(@Param("keyword")  String kString);
}

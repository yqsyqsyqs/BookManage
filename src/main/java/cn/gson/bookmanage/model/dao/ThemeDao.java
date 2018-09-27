package cn.gson.bookmanage.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.gson.bookmanage.model.entity.Theme;

public interface ThemeDao extends JpaRepository<Theme, Long>{

}

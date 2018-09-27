package cn.gson.bookmanage.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.gson.bookmanage.model.entity.Oldbook;

public interface OldbookDao extends JpaRepository<Oldbook, Long>{

}

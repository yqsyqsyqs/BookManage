package cn.gson.bookmanage.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import cn.gson.bookmanage.model.entity.Record;

public interface RecordDao extends JpaRepository<Record, Long>{
}

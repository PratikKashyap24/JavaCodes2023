package com.url.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.url.entity.Url;



@Repository

public interface UrlHandleRepo extends CrudRepository<Url, Integer>{
	@Query(value = "select originalurl from Url u where shorturl = ?1", nativeQuery = true)
	String findByShortUrl(String id);
}

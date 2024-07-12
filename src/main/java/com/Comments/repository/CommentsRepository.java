package com.Comments.repository;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Comments.model.Comments;

@Repository
public interface CommentsRepository extends JpaRepository<Comments, BigInteger> {

	List<Comments> findByDateOfComment(Date date);

	List<Comments> findByName(String name);

	@Query("SELECT c FROM Comments c WHERE c.dateOfComment = :date_of_comment AND c.name = :name")
	List<Comments> findByDateAndName(@Param("date_of_comment") Date date, @Param("name") String name);

}

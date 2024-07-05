package com.Comments.repository;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Comments.model.Comments;

@Repository
public interface CommentsRepository extends JpaRepository<Comments, BigInteger> {

	List<Comments> findByDateOfComment(Date date);

	List<Comments> findByName(String name);
}

package com.Comments.service;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Comments.exception.CommentsNotFoundException;
import com.Comments.exception.DuplicateEntityException;
import com.Comments.exception.NoDataException;
import com.Comments.model.Comments;

@Service
public interface CommentsService {

	public List<Comments> getByName(String name);

	public List<Comments> getByDate(Date date);

	public Optional<Comments> getById(BigInteger id) throws CommentsNotFoundException;

	public List<Comments> getAllByIdComments() throws NoDataException;

	public Comments save(Comments comments) throws DuplicateEntityException;

	public Comments update(BigInteger id, Comments comments);

	public void delete(BigInteger id);

	public List<Comments> findByDateAndName(Date date, String name);
}

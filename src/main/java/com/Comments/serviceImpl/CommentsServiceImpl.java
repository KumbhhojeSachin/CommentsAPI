package com.Comments.serviceImpl;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Comments.exception.CommentsNotFoundException;
import com.Comments.exception.DuplicateEntityException;
import com.Comments.exception.NoDataException;
import com.Comments.model.Comments;
import com.Comments.repository.CommentsRepository;
import com.Comments.service.CommentsService;

/**
 * 
 * @author skumbhoj
 *
 */
@Service
public class CommentsServiceImpl implements CommentsService {

	public final static Logger logger = LoggerFactory.getLogger(CommentsServiceImpl.class);
	@Autowired
	private CommentsRepository commentsRepository;

	@Override
	public Comments save(Comments comments) throws DuplicateEntityException {
		logger.info("CommentsServiceImpl -> save Method is START");
		return commentsRepository.save(comments);
	}

	@Override
	public List<Comments> getAllByIdComments() throws NoDataException {
		logger.info("CommentsServiceImpl -> getAllByIdComments Method is START");
		return commentsRepository.findAll();
	}

	@Override
	public Comments update(BigInteger id, Comments comments) {
		logger.info("CommentsServiceImpl -> update Method is START");
		return commentsRepository.findById(id).map(existingComments -> {
			existingComments.setId(comments.getId());
			existingComments.setName(comments.getName());
			existingComments.setText(comments.getText());
			existingComments.setDateOfComment(comments.getDateOfComment());
			return commentsRepository.save(existingComments);
		}).orElseThrow(() -> new RuntimeException("Comments Details not found"));

	}

	@Override
	public void delete(BigInteger id) {
		logger.info("CommentsServiceImpl -> delete Method is START");
		commentsRepository.deleteById(id);
		logger.info("CommentsServiceImpl -> delete Method is END");
	}

	@Override
	public Optional<Comments> getById(BigInteger id) throws CommentsNotFoundException {
		logger.info("CommentsServiceImpl -> getById Method is START");
		return commentsRepository.findById(id);
	}

	@Override
	public List<Comments> getByName(String name) {
		logger.info("CommentsServiceImpl -> getByName Method is START");
		return commentsRepository.findByName(name);
	}

	@Override
	public List<Comments> getByDate(Date date) {
		logger.info("CommentsServiceImpl -> getByDate Method is START");
		return commentsRepository.findByDateOfComment(date);
	}

}
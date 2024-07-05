package com.Comments.controller;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Comments.model.Comments;
import com.Comments.service.CommentsService;
/**
 * 
 * @author skumbhoj
 *
 */
@RestController
@RequestMapping("/api")
public class CommentsController {

	public final static Logger logger = LoggerFactory.getLogger(CommentsController.class);

	@Autowired
	private CommentsService commentsService;

	@GetMapping("/search/name")
	public List<Comments> getByNames(@RequestParam String name) {
		logger.info("CommentsController -> getByNames Method START");
		return commentsService.getByName(name);
		
	}

	@GetMapping("/search/date")
	public List<Comments> getByDates(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date date) {
		logger.info("CommentsController -> getByDates Method START");
		return commentsService.getByDate(date);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Comments> getCommentsById(@PathVariable("id") BigInteger id) {
		logger.info("CommentsController -> getCommentsById Method START");
		return commentsService.getById(id).map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	}

	@GetMapping
	public ResponseEntity<List<Comments>> getAllComments() {
		logger.info("CommentsController -> getAllComments Method START");
		return ResponseEntity.ok(commentsService.getAllByIdComments());
	}

	@PostMapping
	public ResponseEntity<Comments> createComments(@RequestBody Comments comments) {
		logger.info("CommentsController -> createComments Method START");
		return ResponseEntity.ok(commentsService.save(comments));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Comments> updateCommnets(@PathVariable("id") BigInteger id, @RequestBody Comments comments) {
		logger.info("CommentsController -> updateCommnets Method START");
		return ResponseEntity.ok(commentsService.update(id, comments));
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Comments> deleteComments(@PathVariable("id") BigInteger id) {
		logger.info("CommentsController -> deleteComments Method START");
		commentsService.delete(id);
		logger.info("CommentsController -> deleteComments Method END");
		return ResponseEntity.noContent().build();
	}

}

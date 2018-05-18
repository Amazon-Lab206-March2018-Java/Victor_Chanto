package com.umanav.dojooverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.umanav.dojooverflow.models.Question;
import com.umanav.dojooverflow.models.Tag;
import com.umanav.dojooverflow.repositories.TagRepository;

@Service
public class TagService {
	private TagRepository tagRepo;
	public TagService(TagRepository tagRepo) {
		this.tagRepo = tagRepo;
	}
	public List<Tag> getAll() {
		return tagRepo.findAll();
	}
	public long length() {
		return tagRepo.count();
	}
	public void save(Tag tag) {
		tagRepo.save(tag);
	}
	public void newTag(String subject) {
		Tag add = new Tag(subject);
		tagRepo.save(add);
	}
	public Tag findTag(String subject) {
		return tagRepo.findBySubject(subject);
		
	}
	public Optional<Tag> findById(Long id) {
		return tagRepo.findById(id);
	}
	public List<Tag> findByQues(Optional<Question> question){
		return tagRepo.findByQuestions(question);
	}
}

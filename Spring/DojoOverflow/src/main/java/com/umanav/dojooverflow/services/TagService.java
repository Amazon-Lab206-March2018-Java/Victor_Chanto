package com.umanav.dojooverflow.services;

import org.springframework.stereotype.Service;

import com.umanav.dojooverflow.repositories.TagRepository;

@Service
public class TagService {
	private TagRepository tagRepo;
	public TagService(TagRepository tagRepo) {
		this.tagRepo = tagRepo;
	}

}

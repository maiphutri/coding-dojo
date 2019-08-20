package com.trimai.dojooverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trimai.dojooverflow.models.Tag;
import com.trimai.dojooverflow.repositories.TagRepo;

@Service
public class TagService {
	@Autowired
	private TagRepo tR;
	
	public Tag createOrUpdateTag(Tag tag) {
		return tR.save(tag);
	}
	
	public List<Tag> getAllTags() {
		return tR.findAll();
	}
	
	public Tag findTag(String name) {
		Optional<Tag> tag = tR.findBySubject(name);
		if (tag.isPresent()) {
			return tag.get();
		}
		return null;
	}
	
}

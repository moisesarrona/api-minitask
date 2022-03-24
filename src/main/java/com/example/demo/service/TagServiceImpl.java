package com.example.demo.service;

import com.example.demo.entity.Tag;
import com.example.demo.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author moisesarrona
 * @version 0.1
 */
@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private TagRepository tagRepository;

    @Override
    public List<Tag> getAllTag() {
        return tagRepository.findAll();
    }

    @Override
    public Tag findTag(Long id) {
        return tagRepository.findById(id).orElse(null);
    }

    @Override
    public Tag createdTag(Tag tag) {
        Tag tagDB = tagRepository.searchTagByName(tag.getName());
        if (tagDB == null)
            return tagRepository.save(tag);
        return tagDB;
    }

    @Override
    public Tag updatedTag(Tag tag) {
        Tag tagDB = findTag(tag.getId());
        if (tagDB == null)
            return null;
        if (!tag.getName().equals(tagDB.getName()))
            tagDB.setName(tag.getName());
        tagDB.setDescription(tag.getDescription());
        return tagRepository.save(tagDB);
    }

    @Override
    public void deletedTag(Long id) {
        tagRepository.deleteById(id);
    }

    /*
     * @desc Custom methods for queries
     */
    @Override
    public List<Tag> findTagByName(String tagName) {
        return tagRepository.findTagByName(tagName);
    }
}

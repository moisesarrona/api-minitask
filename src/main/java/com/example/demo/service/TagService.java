package com.example.demo.service;

import com.example.demo.entity.Tag;

import java.util.List;

/**
 * @author moisesarrona
 * @version 0.1
 */
public interface TagService {
    public List<Tag> getAllTag();

    public Tag findTag(Long id);

    public Tag createdTag(Tag tag);

    public Tag updatedTag(Tag tag);

    public void deletedTag(Long id);

    /*
     * @desc Custom methods for queries
     */
    public List<Tag> findTagByName(String tagName);
}

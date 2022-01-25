package com.example.demo.service;

import com.example.demo.entity.Tag;

import java.util.List;

public interface TagService {
    public List<Tag> getAllTag();
    public Tag findTag(Long id);
    public Tag createdTag(Tag tag);
    public Tag updatedTag(Tag tag);
    public void deletedTag(Long id);
}

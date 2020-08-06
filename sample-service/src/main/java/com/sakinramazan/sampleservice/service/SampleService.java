package com.sakinramazan.sampleservice.service;

import com.sakinramazan.sampleservice.entity.Sample;

import java.util.List;

public interface SampleService {
    List<Sample> getAll();

    Sample getOne(Integer id);

    Sample addOne(Sample sample);

    Sample updateOne(Sample sample);

    boolean deleteOne(Integer id);

    List<Sample> getAllBySampleStr2(String sampleStr2);
}

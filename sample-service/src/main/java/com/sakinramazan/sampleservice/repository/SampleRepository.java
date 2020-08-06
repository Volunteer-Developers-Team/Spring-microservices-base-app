package com.sakinramazan.sampleservice.repository;

import com.sakinramazan.sampleservice.entity.Sample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SampleRepository extends JpaRepository<Sample, Integer> {

    List<Sample> getAllBySampleStr2(String sampleStr2);

}

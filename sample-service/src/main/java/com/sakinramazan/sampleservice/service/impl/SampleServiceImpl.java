package com.sakinramazan.sampleservice.service.impl;

import com.sakinramazan.sampleservice.entity.Sample;
import com.sakinramazan.sampleservice.repository.SampleRepository;
import com.sakinramazan.sampleservice.service.SampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SampleServiceImpl implements SampleService {

    private final SampleRepository sampleRepository;

    @Override
    public List<Sample> getAll() {
        return sampleRepository.findAll();
    }

    @Override
    public Sample getOne(Integer id) {
        Optional<Sample> byId = sampleRepository.findById(id);
        return byId.orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Sample addOne(Sample sample) {
        return sampleRepository.save(sample);
    }

    @Override
    public Sample updateOne(Sample sample) {
        if (sample.getId() == null)
            throw new EntityNotFoundException("Sample entity must include id field");
        getOne(sample.getId());
        return sampleRepository.save(sample);
    }

    @Override
    public boolean deleteOne(Integer id) {
        sampleRepository.delete(getOne(id));
        return true;
    }

    @Override
    public List<Sample> getAllBySampleStr2(String sampleStr2) {
        return sampleRepository.getAllBySampleStr2(sampleStr2);
    }

}

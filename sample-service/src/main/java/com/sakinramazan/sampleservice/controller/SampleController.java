package com.sakinramazan.sampleservice.controller;

import com.sakinramazan.sampleservice.entity.Sample;
import com.sakinramazan.sampleservice.service.SampleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RefreshScope
@CrossOrigin(origins = "http://localhost:9090/gateway-uri-base-path/sample-service")   // allow all requests from anywhere
@Slf4j
public class SampleController {

    // you can use app props variables like this
    @Value("${server.port}")
    private int port;

    // you can use app props variables like this
    @Value("${sample.message}")
    private String sampleMessage;

    private final SampleService sampleService;

    @GetMapping("test")
    public ResponseEntity<String> getCenteralizedConfigServerMessageTest() {
        return new ResponseEntity<>("Hello from Git server - message: " + sampleMessage + " - port: " + port, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Sample>> getAllSamples() {
        log.info("All Sample response via server port : " + port);
        List<Sample> all = sampleService.getAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sample> getSample(@PathVariable @Range(min = 1, max = 200) Integer id) {
        Sample one = sampleService.getOne(id);
        return new ResponseEntity<>(one, HttpStatus.OK);
    }

    @PostMapping("/new-sample")
    public ResponseEntity<Sample> saveSample(@RequestBody @Valid Sample sample) {
        Sample sample1 = sampleService.addOne(sample);
        return new ResponseEntity<>(sample1, HttpStatus.CREATED);
    }

    @PutMapping("/update-sample")
    public ResponseEntity<Sample> updateSample(@RequestBody @Valid Sample sample) {
        Sample sample1 = sampleService.updateOne(sample);
        return new ResponseEntity<>(sample1, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteSample(@PathVariable @Range(min = 1, max = 200) Integer id) {
        Boolean status = sampleService.deleteOne(id);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @GetMapping("/str2/{str2}")
    public ResponseEntity<List<Sample>> getSampleByStr2(@PathVariable String str2) {
        List<Sample> allBySampleStr2 = sampleService.getAllBySampleStr2(str2);
        return new ResponseEntity<>(allBySampleStr2, HttpStatus.OK);
    }
}

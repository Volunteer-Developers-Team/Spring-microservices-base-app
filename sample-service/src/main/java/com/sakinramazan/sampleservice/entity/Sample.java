package com.sakinramazan.sampleservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sample")
public class Sample {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "sample_str_1")
    @NotEmpty(message = "Sample String 1 can not be empty!")
    private String sampleStr1;

    @Column(name = "sample_str_2")
    private String sampleStr2;
}

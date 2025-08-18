package com.hashedin.huspark.service;


import com.hashedin.huspark.model.Metrics;
import com.hashedin.huspark.repository.CourseRepository;
import com.hashedin.huspark.repository.DocumentRepository;
import com.hashedin.huspark.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DashboardService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private DocumentRepository documentRepository;


    public Metrics getMetrics() {
        long userCount = userRepository.count();
        long courseCount = courseRepository.count();
        long documentCount = documentRepository.count();


        return new Metrics(userCount, courseCount, documentCount);
    }
}

package com.hashedin.huspark.service;


import com.hashedin.huspark.Exception.NotFoundException;
import com.hashedin.huspark.dao.CourseDto;
import com.hashedin.huspark.model.Course;
import com.hashedin.huspark.model.Instructor;
import com.hashedin.huspark.model.User;
import com.hashedin.huspark.repository.CourseRepository;
import com.hashedin.huspark.repository.InstructorRepository;
import com.hashedin.huspark.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;


    @Autowired
    private InstructorRepository instructorRepository;


    @Autowired
    private ModelMapper modelMapper;


    @Autowired
    private UserRepository userRepository;


    public Course addCourse(Course course , int instructorId) {
        Instructor instructor = instructorRepository.findById(instructorId)
                .orElseThrow(()-> new NotFoundException("Instructor not Found Exception."));
        course.setInstructor(instructor);
        Course savedCourse = courseRepository.save(course);
        return  savedCourse;
    }


    public CourseDto editCourse(int id, Course updatedCourse) {
        Course course = courseRepository.findById(id).orElseThrow(()-> new NotFoundException("Resource  with " + id + "not Found"));
        course.setTitle(updatedCourse.getTitle());
        Course savedCourse = courseRepository.save(course);
        return modelMapper.map(savedCourse,CourseDto.class);
    }


    public void deleteCourse(int id) {
        if(courseRepository.existsById(id)){
            courseRepository.deleteById(id);
        }
    }


    public Page<Course> getCourses(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return courseRepository.findAll(pageable);
    }


    public Course getCourse(Integer id){
        return courseRepository.findById(id).orElseThrow(()-> new NotFoundException("Resource with" + id + "Not Found")) ;
    }


    public CourseDto assignCourse(Integer courseId, Integer userId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(()-> new NotFoundException("Course Assigned"));
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new NotFoundException("Course Assigned"));
        course.setUser(user);
        Course savedCourse = courseRepository.save(course);
        return  modelMapper.map(savedCourse,CourseDto.class);
    }
}

package com.hashedin.huspark.service;


import com.hashedin.huspark.model.Log;
import com.hashedin.huspark.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class LogService {
    @Autowired
    private LogRepository logRepository;


    public Page<Log> getAllLogs(Pageable pageable) {
        return logRepository.findAll(pageable);
    }


    public Optional<Log> getLogById(int id) {
        return logRepository.findById(id);
    }


    public Log saveLog(Log log) {
        Log log1 = logRepository.save(log);
        return log1;


    }


    public void deleteLogById(int id) {
        logRepository.deleteById(id);
    }


}

package com.hashedin.huspark.controller;




import com.hashedin.huspark.model.Metrics;
import com.hashedin.huspark.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/admin")
public class DashboardController {
    @Autowired
    private DashboardService adminDashboardService;


    @GetMapping("/metrics")
    public Metrics getMetrics() {
        return adminDashboardService.getMetrics();
    }
}

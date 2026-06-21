package com.example.springlearning.controller;

import com.example.springlearning.dto.MovieDto;
import com.example.springlearning.dto.SiteDto;
import com.example.springlearning.service.CommonService;
import com.example.springlearning.service.MovieService;
import com.example.springlearning.service.RestTemplateService;
import com.example.springlearning.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("api")
public class CommonController {

    @Autowired
    private CommonService commonService;

    @Autowired
    private MovieService movieService;

    @Autowired
    private SiteService siteService;

    @Autowired
    private RestTemplateService restTemplateService;

    @GetMapping("/message")
    public String getMessage() {
        System.out.println("Current Thead " + Thread.currentThread().getName());
        return "Hello World!";
    }

    @GetMapping("/greet")
    public String greet(@RequestParam String date){
        return "Hello! Today is " + date;
    }

    @GetMapping("/service")
    public void callServiceMethod() {
        commonService.method();
    }

    @GetMapping("/service2")
    public void callServiceMethod2(){
         commonService.method2();
    }
    @GetMapping("/transaction")
    public void callTransactionMethod() {
        commonService.transactionMethod();
    }
    @GetMapping("/movies")
    public List<MovieDto> getAllMovies() throws InterruptedException {
        return movieService.getMovies();
    }
    @GetMapping("/sleep")
    public void testSleep(){
        movieService.sleep();
    }
    @GetMapping("/hikaricp")
    public ResponseEntity<Map<String, Object>> testHikariCp() {
        return commonService.getDataSourceInfo();
    }

    @GetMapping("/sites")
    public List<SiteDto> getSites() {

        return siteService.getSites(1000);
    }


    @GetMapping("/sites2")
    public List<SiteDto> getSites2() {

        return siteService.getSites2(1000);
    }

    @GetMapping("/external")
    public void externalApi() {
        restTemplateService.callExternalApi();
    }

}

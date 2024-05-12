package com.ssafy.web.home.controller;

import com.ssafy.web.global.dto.ApiResponse;
import com.ssafy.web.home.model.Home;
import com.ssafy.web.home.service.HomeService.HomeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/homes")
public class HomeController {

    private final HomeService homeService;

    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping
    public List<Home> home() {
        return homeService.listHome();

    }

    @PostMapping("/regist")
    public String home(@RequestBody Home home) {
        boolean isSuccess = homeService.saveHome(home);
        if(isSuccess) {
            return "success";
        }
        else{
            return "fail";
        }
    }



}

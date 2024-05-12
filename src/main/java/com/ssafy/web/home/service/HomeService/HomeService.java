package com.ssafy.web.home.service.HomeService;

import com.ssafy.web.home.model.Home;
import com.ssafy.web.home.model.mapper.HomeMapper;
import com.ssafy.web.home.repository.HomeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeService {

    private final HomeRepository homeRepository;

    public HomeService(HomeRepository homeRepository) {
        this.homeRepository = homeRepository;
    }

    public boolean saveHome(Home home) {
        try{
            homeRepository.save(home);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public List<Home> listHome(){
        try{
            return homeRepository.findAll();
        }
        catch(Exception e){
            return null;
        }

    }


}

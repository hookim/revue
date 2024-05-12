package com.ssafy.web.home.model.mapper;

import java.util.List;

import com.ssafy.web.home.model.Home;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HomeMapper {

    public List<Home> listHome() throws Exception;

}


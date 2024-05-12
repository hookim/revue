package com.ssafy.web.home.repository;

import com.ssafy.web.home.model.Home;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeRepository extends JpaRepository<Home, Long> {
}

package com.userservice.userservice.repo;

import com.userservice.userservice.entity.AdvertisingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdvertisingRepository extends JpaRepository<AdvertisingEntity, Integer> {
    //List<AdvertisingEntity> findByEmail(String email);

}

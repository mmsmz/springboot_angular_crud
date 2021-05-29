package com.userservice.userservice.service;

import com.userservice.userservice.dto.AdvertisingRequestDto;
import com.userservice.userservice.dto.AdvertisingResponseDto;
import com.userservice.userservice.entity.AdvertisingEntity;
import com.userservice.userservice.repo.AdvertisingRepository;
import com.userservice.userservice.util.AdvertisingCommon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertisingServiceImpl implements AdvertisingService {

    @Autowired
    AdvertisingRepository  advertisingRepository;

    @Override
    public AdvertisingResponseDto getAllAdvertisingByUser(Integer userId) {




        return null;
    }


    public String createAdvertising(Integer userId, AdvertisingRequestDto advertisingRequestDto) {

        try {
//            List<AdvertisingEntity> checkEmail = advertisingRepository.findById(advertisingRequestDto.getEmail());
//            if (checkEmail.isEmpty()) {

                AdvertisingEntity advertisingEntity = new AdvertisingEntity();
                advertisingRepository.save(advertisingEntity);
                return AdvertisingCommon.SUCCESSFULLY_REGISTERED;

//            } else {
//                return AdvertisingCommon.USER_ALREADY_EXISTS;
//            }
        }
        catch (Exception e){
            return e.getMessage();
        }

    }

    @Override
    public String updateAdvertising(Integer userId, Integer advertisingId) {
        return null;
    }

    @Override
    public String deleteAdvertising(Integer userId, Integer advertisingId) {
        return null;
    }


}

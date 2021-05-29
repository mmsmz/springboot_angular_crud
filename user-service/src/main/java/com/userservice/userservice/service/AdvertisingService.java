package com.userservice.userservice.service;

import com.userservice.userservice.dto.AdvertisingRequestDto;
import com.userservice.userservice.dto.AdvertisingResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface AdvertisingService {

    AdvertisingResponseDto getAllAdvertisingByUser(Integer userId);

    String createAdvertising(Integer userId, AdvertisingRequestDto advertisingRequestDto);

    String updateAdvertising(Integer userId,  Integer advertisingId);

    String deleteAdvertising(Integer userId,  Integer advertisingId);

}

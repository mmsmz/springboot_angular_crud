package com.userservice.userservice.controller;

import com.userservice.userservice.dto.AdvertisingRequestDto;
import com.userservice.userservice.dto.ResposeDto;
import com.userservice.userservice.service.AdvertisingService;
import com.userservice.userservice.util.AdvertisingCommon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user-service")
public class AdvertisingController {

    @Autowired
    private AdvertisingService advertisingService;

    @GetMapping("/")
    public String currentUserName(Authentication authentication) {
        return authentication.getAuthorities().toString();
    }

    /*get // Create // Update // Delete */

    @GetMapping("/getAllAdvertisingByUser")
    public ResponseEntity<ResposeDto> getAllAdvertisingByUser(@RequestParam Integer userId) {
        ResposeDto resposeDto = new ResposeDto();
        resposeDto.setMessage(AdvertisingCommon.SUCCESS);
        resposeDto.setData(advertisingService.getAllAdvertisingByUser(userId));
        return new ResponseEntity<>(resposeDto, HttpStatus.OK);
    }

    @PostMapping("/createAdvertising")
    public ResponseEntity<ResposeDto> createAdvertising(@RequestParam Integer userId, @RequestBody AdvertisingRequestDto advertisingRequestDto) {
        ResposeDto resposeDto = new ResposeDto();
        resposeDto.setMessage(AdvertisingCommon.SUCCESS);
        resposeDto.setData(advertisingService.createAdvertising(userId,advertisingRequestDto));
        return new ResponseEntity<>(resposeDto, HttpStatus.OK);
    }

    @PatchMapping("/updateAdvertising")
    public ResponseEntity<ResposeDto> updateAdvertising(@RequestParam Integer userId, @RequestParam Integer advertisingId) {
        ResposeDto resposeDto = new ResposeDto();
        resposeDto.setMessage(AdvertisingCommon.SUCCESS);
        resposeDto.setData(advertisingService.updateAdvertising(userId, advertisingId));
        return new ResponseEntity<>(resposeDto, HttpStatus.OK);
    }

    @DeleteMapping("/deleteAdvertising")
    public ResponseEntity<ResposeDto> deleteAdvertising(@RequestParam Integer userId, @RequestParam Integer advertisingId) {
        ResposeDto resposeDto = new ResposeDto();
        resposeDto.setMessage(AdvertisingCommon.SUCCESS);
        resposeDto.setData(advertisingService.deleteAdvertising(userId, advertisingId));
        return new ResponseEntity<>(resposeDto, HttpStatus.OK);
    }

}

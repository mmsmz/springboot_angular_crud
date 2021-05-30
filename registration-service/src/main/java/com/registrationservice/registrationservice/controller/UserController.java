package com.registrationservice.registrationservice.controller;

import com.registrationservice.registrationservice.dto.ResposeDto;
import com.registrationservice.registrationservice.dto.UserRequestDto;
import com.registrationservice.registrationservice.service.UserService;
import com.registrationservice.registrationservice.util.UserCommon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("registration-service")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/saveUserRegistrationDetails")
    public ResponseEntity<ResposeDto> saveUserRegistrationDetails(@RequestBody UserRequestDto userRequestDto) {
        ResposeDto resposeDto = new ResposeDto();
        resposeDto.setMessage(UserCommon.SUCCESS);
        resposeDto.setData(userService.saveUserRegistrationDetails(userRequestDto));
        return new ResponseEntity<>(resposeDto, HttpStatus.OK);
    }

    @GetMapping("/test")
    public String test() {
        return "hello world";
    }

}

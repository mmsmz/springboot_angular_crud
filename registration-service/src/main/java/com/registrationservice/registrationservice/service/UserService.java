package com.registrationservice.registrationservice.service;

import com.registrationservice.registrationservice.dto.UserRequestDto;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    String saveUserRegistrationDetails(UserRequestDto userRequestDto);

}

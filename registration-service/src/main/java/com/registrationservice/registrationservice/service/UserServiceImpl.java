package com.registrationservice.registrationservice.service;


import com.registrationservice.registrationservice.dto.UserRequestDto;
import com.registrationservice.registrationservice.entity.UserEntity;
import com.registrationservice.registrationservice.repo.UserRepository;
import com.registrationservice.registrationservice.util.UserCommon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public String saveUserRegistrationDetails(UserRequestDto userRequestDto) {

        try {
            List<UserEntity> checkEmail = userRepository.findByEmail(userRequestDto.getEmail());
            if (checkEmail.isEmpty()) {

                UserEntity userEntity = new UserEntity();
                userEntity.setUserName(userRequestDto.getUserName());
                userEntity.setContactNumber(userRequestDto.getContactNumber());
                userEntity.setEmail(userRequestDto.getEmail());
                userEntity.setPassword(passwordEncoder.encode(userRequestDto.getPassword()));
                userEntity.setRegisteredDate(LocalDate.now());
                userRepository.save(userEntity);
                return UserCommon.SUCCESSFULLY_REGISTERED;

            } else {
                return UserCommon.USER_ALREADY_EXISTS;
            }
        }
        catch (Exception e){
            return e.getMessage();
        }

    }

}

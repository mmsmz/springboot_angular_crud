package com.springsecurityjwt.controller;


import com.springsecurityjwt.MyUserDetailsService;
import com.springsecurityjwt.dto.AdvertisingResponseDto;
import com.springsecurityjwt.dto.ResposeDto;
import com.springsecurityjwt.models.AuthenticationRequest;
import com.springsecurityjwt.models.AuthenticationResponse;
import com.springsecurityjwt.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    List<AdvertisingResponseDto> advertisingResponseDtos = new ArrayList<>();



    @GetMapping("/getAllAdvertising")
    public ResponseEntity<ResposeDto> getAllAdvertising() {
        ResposeDto resposeDto = new ResposeDto();
        resposeDto.setMessage("Success");
        resposeDto.setData(advertisingResponseDtos);
        return new ResponseEntity<>(resposeDto, HttpStatus.OK);
    }


    @GetMapping("/getAllAdvertisingByUser")
    public ResponseEntity<ResposeDto> getAllAdvertisingByUser(@RequestParam Integer advertisingId) {
        ResposeDto resposeDto = new ResposeDto();
        resposeDto.setMessage("Success");
        for (AdvertisingResponseDto advertisingResponseDto : advertisingResponseDtos){
            if(advertisingResponseDto.getAdvertisingId()==advertisingId){
                resposeDto.setData(advertisingResponseDto);
                break;
            }

        }
        return new ResponseEntity<>(resposeDto, HttpStatus.OK);
    }

    @PostMapping("/createAdvertising")
    public ResponseEntity<ResposeDto> createAdvertising(@RequestBody AdvertisingResponseDto advertisingResponseDto) {
        advertisingResponseDtos.add(advertisingResponseDto);
        ResposeDto resposeDto = new ResposeDto();
        resposeDto.setMessage("Success");
        resposeDto.setData("Successfully Inserted");
        return new ResponseEntity<>(resposeDto, HttpStatus.OK);
    }


    @PatchMapping("/updateAdvertising")
    public ResponseEntity<ResposeDto> updateAdvertising(@RequestParam Integer advertisingId, @RequestBody AdvertisingResponseDto advertisingResponseDto) {

        for (int i =0 ; i< advertisingResponseDtos.size(); i++){
            if(advertisingResponseDtos.get(i).getAdvertisingId()==advertisingId){
                advertisingResponseDtos.set(i, advertisingResponseDto);

            }
        }
        ResposeDto resposeDto = new ResposeDto();
        resposeDto.setMessage("Success");
        resposeDto.setData("Updated Successfullly");
        return new ResponseEntity<>(resposeDto, HttpStatus.OK);
    }


    @DeleteMapping("/deleteAdvertising")
    public ResponseEntity<ResposeDto> deleteAdvertising(@RequestParam Integer advertisingId) {

        for (int i = 0; i <advertisingResponseDtos.size() ; i++) {
            if (advertisingResponseDtos.get(i).getAdvertisingId()==advertisingId){
                advertisingResponseDtos.remove(i);
            }
        }
        ResposeDto resposeDto = new ResposeDto();
        resposeDto.setMessage("Success");
        resposeDto.setData("Delete");
        return new ResponseEntity<>(resposeDto, HttpStatus.OK);
    }



    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @RequestMapping({ "/hello" })
    public String firstPage() {
        return "Hello World";
    }

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
            );
        }
        catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String jwt = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

}
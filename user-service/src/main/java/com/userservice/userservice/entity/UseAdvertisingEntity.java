package com.userservice.userservice.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_advertising_details")
public class UseAdvertisingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ursadv_id")
    private Integer userAdvertisingId;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "advertising_id")
    private Integer advertisingId;

    public Integer getUserAdvertisingId() {
        return userAdvertisingId;
    }

    public void setUserAdvertisingId(Integer userAdvertisingId) {
        this.userAdvertisingId = userAdvertisingId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAdvertisingId() {
        return advertisingId;
    }

    public void setAdvertisingId(Integer advertisingId) {
        this.advertisingId = advertisingId;
    }
}

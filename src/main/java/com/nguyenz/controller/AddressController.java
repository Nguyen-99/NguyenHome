package com.nguyenz.controller;

import com.nguyenz.entity.District;
import com.nguyenz.entity.Province;
import com.nguyenz.entity.Ward;
import com.nguyenz.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    AddressService addressService;

    @GetMapping("/getAllProvince")
    public List<Province> getAllProvince(){
        return addressService.getAllProvince();
    }

    @GetMapping("/getDistrictByProvinceId/{provinceId}")
    public List<District> getDistrictByProvinceId(@PathVariable String provinceId){
        return addressService.getDistrictByProvinceId(provinceId);
    }

    @GetMapping("/getWardByDistrictId/{wardId}")
    public List<Ward> getWardByDistrictId(@PathVariable(name="wardId") String districtId){
        return addressService.getWardByDistrictId(districtId);
    }
}

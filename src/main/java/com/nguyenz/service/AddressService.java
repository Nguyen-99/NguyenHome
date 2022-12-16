package com.nguyenz.service;

import com.nguyenz.entity.District;
import com.nguyenz.entity.Province;
import com.nguyenz.entity.Ward;

import java.util.List;

public interface AddressService {
    List<Province> getAllProvince();
    List<District> getDistrictByProvinceId(String provinceId);
    List<Ward> getWardByDistrictId(String districtId);
}

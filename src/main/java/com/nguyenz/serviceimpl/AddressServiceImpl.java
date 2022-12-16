package com.nguyenz.serviceimpl;

import com.nguyenz.entity.District;
import com.nguyenz.entity.Province;
import com.nguyenz.entity.Ward;
import com.nguyenz.repository.DistrictRepository;
import com.nguyenz.repository.ProvinceRepository;
import com.nguyenz.repository.WardRepository;
import com.nguyenz.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private ProvinceRepository provinceRepository;
    @Autowired
    private DistrictRepository districtRepository;
    @Autowired
    private WardRepository wardRepository;

    @Override
    public List<Province> getAllProvince() {
        return provinceRepository.findAll();
    }

    @Override
    public List<District> getDistrictByProvinceId(String provinceId) {
        return districtRepository.getDistrictByProvinceId(provinceId);
    }

    @Override
    public List<Ward> getWardByDistrictId(String wardId) {
        return wardRepository.getWardByDistrictId(wardId);
    }
}

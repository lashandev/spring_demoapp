package com.example.demospring.service.impl;

import com.example.demospring.service.CommonService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class CommonServiceImpl implements CommonService {
    private ModelMapper modelMapper;

    public CommonServiceImpl() {
        this.modelMapper = new ModelMapper();
    }

    @Override
    public Object modelConvert(Object source, Class target) {
        return this.modelMapper.map(source,target);
    }
}

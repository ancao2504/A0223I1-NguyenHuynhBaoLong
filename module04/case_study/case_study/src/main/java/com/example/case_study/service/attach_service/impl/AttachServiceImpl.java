package com.example.case_study.service.attach_service.impl;

import com.example.case_study.models.AttachService;
import com.example.case_study.repository.AttachServiceRepository;
import com.example.case_study.service.attach_service.IAttachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachServiceImpl implements IAttachService {
    @Autowired
    private AttachServiceRepository attachServiceRepository;

    @Override
    public List<AttachService> findAll() {
        return attachServiceRepository.findAll();
    }

    @Override
    public AttachService findById(int id) {
        return attachServiceRepository.findById(id).orElse(null);
    }

    @Override
    public void save(AttachService attachService) {
        attachServiceRepository.save(attachService);
    }

    @Override
    public void delete(int id) {
        attachServiceRepository.delete(attachServiceRepository.findById(id).orElse(null));
    }
}

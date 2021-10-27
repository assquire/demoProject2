package com.example.demoproject2.service;

import com.example.demoproject2.model.Type;
import com.example.demoproject2.repo.TypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TypeService {

    Type findTypeById(Long id);

    List<Type> getAllTypes();

}

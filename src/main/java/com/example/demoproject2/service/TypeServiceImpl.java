package com.example.demoproject2.service;

import com.example.demoproject2.model.Type;
import com.example.demoproject2.repo.TypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TypeServiceImpl implements TypeService{

    private final TypeRepository typeRepository;

    @Override
    public Type findTypeById(Long id) {
        return typeRepository.findById(id).get();
    }

    @Override
    public List<Type> getAllTypes() {
        return typeRepository.findAll();
    }
}

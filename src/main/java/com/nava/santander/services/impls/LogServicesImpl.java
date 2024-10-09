package com.nava.santander.services.impls;

import com.nava.santander.domain.entities.LogCep;
import com.nava.santander.repository.LogCepRepository;
import com.nava.santander.services.LogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class LogServicesImpl implements LogService {

    private final LogCepRepository repository;

    @Override
    public List<LogCep> findAll() {
        return repository.findAll();
    }

    @Override
    public LogCep create(LogCep cep) {
        return repository.save(cep);
    }
}

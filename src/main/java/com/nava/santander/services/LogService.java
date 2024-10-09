package com.nava.santander.services;

import com.nava.santander.domain.entities.LogCep;

import java.util.List;

public interface LogService  {

    List<LogCep> findAll();
    LogCep create(LogCep cep);
}

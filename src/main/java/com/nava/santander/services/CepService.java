package com.nava.santander.services;

import com.nava.santander.domain.Addresses;
import com.nava.santander.domain.CepApp;
import com.nava.santander.domain.DistanceApp;

public interface CepService {

    CepApp validateCEP(String cep);
}

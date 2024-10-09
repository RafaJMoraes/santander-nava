package com.nava.santander.services;

import com.nava.santander.domain.Addresses;
import com.nava.santander.domain.DistanceApp;

public interface DistanceService {

    DistanceApp getDistance(Addresses addresses);
}

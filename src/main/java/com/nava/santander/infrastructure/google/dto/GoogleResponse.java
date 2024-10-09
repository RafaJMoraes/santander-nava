
package com.nava.santander.infrastructure.google.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public record GoogleResponse(@JsonProperty("destination_addresses") List<String> destinationAddresses,
                             @JsonProperty("origin_addresses") List<String> originAddresses,
                             List<Row> rows,
                             String status) {

}

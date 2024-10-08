
package com.nava.santander.client.google.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public record GoogleDistanceDto(@JsonProperty("destination_addresses") List<String> destinationAddresses,
                                @JsonProperty("origin_addresses") List<String> originAddresses,
                                List<Row> rows,
                                String status) {

}

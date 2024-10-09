package com.nava.santander.domain.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tb_log_cep")
@Entity
public class LogCep extends AbstractEntity {

    @Lob
    private String data;

}

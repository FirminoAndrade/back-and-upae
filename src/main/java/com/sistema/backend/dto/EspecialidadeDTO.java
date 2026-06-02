package com.sistema.backend.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EspecialidadeDTO {

    private Long id;

    private String nome;

    private Boolean ativo;
}

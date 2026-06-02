package com.sistema.backend.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sistema.backend.dto.RelatorioEspecialidadeDTO;
import com.sistema.backend.entity.RegistroDiario;

public interface RelatorioRepository extends JpaRepository<RegistroDiario, Long> {

	@Query("""

			    SELECT new com.sistema.backend.dto.RelatorioEspecialidadeDTO(

			        e.nome,

			        r.nomeProfissional,

			        COALESCE(SUM(r.totalAgendados), 0),

			        COALESCE(SUM(r.compareceram), 0),

			        COALESCE(SUM(r.faltaram), 0),

			        COALESCE(SUM(r.interno), 0),

			        COALESCE(SUM(r.interconsulta), 0),

			        COALESCE(SUM(r.externo), 0)

			    )

			    FROM RegistroDiario r

			    JOIN r.especialidade e

			    WHERE r.data BETWEEN :dataInicio AND :dataFim

			    GROUP BY e.nome, r.nomeProfissional

			    ORDER BY e.nome ASC, r.nomeProfissional ASC

			""")
	List<RelatorioEspecialidadeDTO> relatorioPorPeriodo(LocalDate dataInicio, LocalDate dataFim);
}

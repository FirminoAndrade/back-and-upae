package com.sistema.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sistema.backend.entity.ListaEspera;

@Repository
public interface ListaEsperaRepository extends JpaRepository<ListaEspera, Long> {

	@Query("""

			SELECT l

			FROM ListaEspera l

			WHERE

			(:especialidade IS NULL
			OR :especialidade = ''
			OR UPPER(l.especialidade)
			LIKE UPPER(CONCAT('%', :especialidade, '%')))

			AND

			(:termo IS NULL
			OR :termo = ''
			OR UPPER(l.nome)
			LIKE UPPER(CONCAT('%', :termo, '%'))

			OR UPPER(l.prontuario)
			LIKE UPPER(CONCAT('%', :termo, '%')))

			ORDER BY

			l.confirmado ASC,

			l.createdAt ASC

			""")
	List<ListaEspera> pesquisar(@Param("especialidade") String especialidade, @Param("termo") String termo);
	Long countByConfirmadoTrue();
}
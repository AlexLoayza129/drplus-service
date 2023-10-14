package com.drplus.drplus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.drplus.drplus.model.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta, Integer>{

    //* De doctores
    @Query(nativeQuery = true, value = "SELECT * FROM consulta WHERE idUsuarioPac = :id")
    List<Consulta>findAllById(@Param("id") int id);
}

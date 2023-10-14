package com.drplus.drplus.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.drplus.drplus.model.UsuarioLogin;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioLogin, Integer>{

    @Query(nativeQuery = true, value= "SELECT * FROM login WHERE idTipoUsuario = 1")
    List<UsuarioLogin> findAllDoctores();

    @Query(nativeQuery = true, value= "SELECT * FROM login WHERE usuario = :user AND contrasenia = :pwd LIMIT 1")
    Optional<UsuarioLogin> getUsuario(@Param("user") String user, @Param("pwd") String pwd);

    @Query(nativeQuery = true, value= "SELECT * FROM login WHERE id = :idpac")
    UsuarioLogin findPacienteById(@Param("idpac") int idpac);

}

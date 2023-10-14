package com.drplus.drplus.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.drplus.drplus.model.Consulta;
import com.drplus.drplus.model.UsuarioLogin;
import com.drplus.drplus.model.json.ConsultResponse;
import com.drplus.drplus.model.json.UsuarioData;
import com.drplus.drplus.repository.ConsultaRepository;
import com.drplus.drplus.repository.UsuarioRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DrPlusMainApi {
    
    @Autowired
    UsuarioRepository usrRepo;

    @Autowired
    ConsultaRepository csltRepo;

    //* Get doctores
    @GetMapping("/getDoctores")
    public List<UsuarioLogin> getDoctore(){
        return usrRepo.findAllDoctores();
    }

    //* Get consultas
    // @GetMapping("/getConsultas")
    // public List<ConsultResponse> getConsultas(@RequestParam("id") int id){
    //     List<Consulta> constlOp = csltRepo.findAllById(id);
    //     List<ConsultResponse> consultas = new ArrayList<>();

    //     for(int i = 0; i < constlOp.size(); i++){
    //         ConsultResponse csltRes = new ConsultResponse();
    //         Consulta consulta = constlOp.get(i);
    //         UsuarioLogin userPac = usrRepo.findPacienteById(consulta.getIdusuariodoc());
    //         UsuarioLogin userPac = usrRepo.findPacienteById(consulta.getIdusuariodoc());
    //     }

    // }

    @GetMapping("/findUser")
    public UsuarioLogin findUser(@RequestParam("id") int id){
        Optional<UsuarioLogin> userOp = usrRepo.findById(id);
        if(userOp.isPresent()){
            System.out.println(userOp.get());
            return userOp.get();
        }else{
            System.out.println("No encontro al usuario");
        }
        return null;
    }

    @PostMapping("/getUser")
    public UsuarioLogin getUserCredentials(@RequestBody UsuarioData data){
        Optional<UsuarioLogin> userOp = usrRepo.getUsuario(data.getUsername(), data.getPassword());
        if(userOp.isPresent()){
            System.out.println(userOp.get());
            return userOp.get();
        }else{
            System.out.println("No encontro al usuario");
        }
        return null;
    }
    
    @PostMapping("/createUser")
    public String createUser(@RequestBody UsuarioData data){
        UsuarioLogin user = new UsuarioLogin();
        user.setNombre(data.getNombre());
        user.setApellido(data.getApellido());
        user.setTelefono(data.getTelefono());        
        user.setIdTipoUsuario(data.getUsertype());
        System.out.println(data.getUsertype());
        user.setUsuario(data.getUsername());       
        user.setContrasenia(data.getPassword());
        usrRepo.save(user);

        return "Usuario creado correctamente!";

    }

}

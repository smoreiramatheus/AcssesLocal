package com.accessLocal.accessLocal.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accessLocal.accessLocal.model.Usuario;
import com.accessLocal.accessLocal.model.usuarLogin;
import com.accessLocal.accessLocal.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class controllerUsuario {
	
	@Autowired
	private UsuarioService userService;
	
	
	@PostMapping("/logar")
	public ResponseEntity<usuarLogin> Autentication(@RequestBody Optional<usuarLogin> user){
		return userService.Logar(user).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<Usuario> post(@RequestBody Usuario usuario){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(userService.CadastrarUsuario(usuario));
	}
	


}

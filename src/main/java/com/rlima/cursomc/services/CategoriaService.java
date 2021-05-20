package com.rlima.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rlima.cursomc.domain.Categoria;
import com.rlima.cursomc.repositories.CategoriaRepository;

//Camada de serviço p/ consultas de categorias - utiliza camada de acesso a dados para realizar regras de negocio
@Service
public class CategoriaService {
	
	@Autowired // Para instanciar automaticamente (injeção de dependencia ou inversao de controle)
	private CategoriaRepository repo; // objeto da camada de acesso a dados
	
	public Categoria buscar (Integer id) { // Busca a categoria pelo Id indicado pelo controlador
		Optional<Categoria> obj = repo.findById(id); //Optional, objeto container
		return obj.orElse(null); // impede a instancia de obj nulo
		
	}
	
	

}
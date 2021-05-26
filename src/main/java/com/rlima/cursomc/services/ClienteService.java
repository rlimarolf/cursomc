package com.rlima.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rlima.cursomc.domain.Cliente;
import com.rlima.cursomc.repositories.ClienteRepository;
import com.rlima.cursomc.services.exceptions.ObjectNotFoundException;

//Camada de serviço p/ consultas de categorias - utiliza camada de acesso a dados(repository) para realizar regras de negocio
@Service
public class ClienteService {
	
	@Autowired // Para instanciar automaticamente (injeção de dependencia ou inversao de controle)
	private ClienteRepository repo; // objeto da camada de acesso a dados
	
	public Cliente buscar (Integer id) { // Busca a categoria pelo Id indicado pelo controlador
		Optional<Cliente> obj = repo.findById(id); //Optional, objeto container
			//return obj.orElse(null); // impede a instancia de obj nulo - se existe ele retorna obj se não retorna o VALOR nulo		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
		
	}
	
	

}

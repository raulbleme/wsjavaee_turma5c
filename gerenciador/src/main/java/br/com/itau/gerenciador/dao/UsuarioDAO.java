package br.com.itau.gerenciador.dao;

import org.springframework.data.repository.CrudRepository;
import br.com.itau.gerenciador.model.Usuario;

public interface UsuarioDAO extends CrudRepository<Usuario, Integer>{
	
	Usuario findByEmailAndSenha(String email, String senha);
}

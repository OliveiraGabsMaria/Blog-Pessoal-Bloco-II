package org.generation.BlogPessoal.Repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import org.generation.BlogPessoal.Model.Usuario;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioRepositoryTest {
    
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@BeforeAll
	void start(){

		usuarioRepository.save(new Usuario(0L, "Gabrielly Oliveira", "gabrielly@email.com.br", "123456","https://i.imgur.com/mQvjGY6.png", "administrador"));
		
		usuarioRepository.save(new Usuario(0L, "Isabela Oliveira", "isabela@email.com.br", "123456","https://i.imgur.com/mQvjGY6.png", "padrão"));
		
		usuarioRepository.save(new Usuario(0L, "Rosilene Oliveira", "rosilene@email.com.br", "123456","https://i.imgur.com/mQvjGY6.png", "padrão"));

        usuarioRepository.save(new Usuario(0L, "Antonio Oliveira", "antonio@email.com.br", "123456","https://i.imgur.com/mQvjGY6.png", "padrão"));

	}

	@Test
	@DisplayName("Retorna 1 usuario")
	public void deveRetornarUmUsuario() {

		Optional<Usuario> usuario = usuarioRepository.findByUsuario("gabrielly@email.com.br");
		assertTrue(usuario.get().getUsuario().equals("gabrielly@email.com.br"));
	}

	@Test
	@DisplayName("Retorna 3 usuarios")
	public void deveRetornarTresUsuarios() {

		List<Usuario> listaDeUsuarios = usuarioRepository.findAllByNomeContainingIgnoreCase("Oliveira");
		assertEquals(3, listaDeUsuarios.size());
		assertTrue(listaDeUsuarios.get(0).getNome().equals("Isabela Oliveira"));
		assertTrue(listaDeUsuarios.get(1).getNome().equals("Gabrielly Oliveira"));
		assertTrue(listaDeUsuarios.get(2).getNome().equals("Rosilene Oliveira"));
		
	}

}
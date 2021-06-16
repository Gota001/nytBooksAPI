package br.com.nytBooks.nytBooks.steps;

import br.com.nytBooks.nytBooks.func.NtyBooksAPI;
import br.com.nytBooks.nytBooks.func.Validacao;
import io.cucumber.java.es.Dado;
import io.cucumber.java.it.Quando;
import io.cucumber.java.pt.Então;
import io.restassured.response.Response;

public class Steps {
	
	NtyBooksAPI api;
	Response response;
	Validacao validacao;
	
	@Dado("que seja consultada a API Nyt Books")
	public void que_seja_consultada_a_api_nyt_books() {
		api = new NtyBooksAPI();
	}

	@Quando("for efetivada a consulta de livros do tipo {string}")
	public void for_efetivada_a_consulta_de_livros_do_tipo(String tipo) {
		response = api.consultarLivroPorTipo(tipo);
	}

	@Então("a API deverá conter o livro {string} na lista apresentada")
	public void a_api_deverá_conter_o_livro_na_lista_apresentada(String livro) throws Exception {
		validacao = new Validacao();
		validacao.validarPresencaLivro(response, livro);
	}

	@Quando("for efetivada a consulta de livros com data {string}")
	public void for_efetivada_a_consulta_de_livros_com_data(String data) {
		response = api.consultarLivroPorData(data);
	}

}

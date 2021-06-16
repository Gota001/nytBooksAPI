package br.com.nytBooks.nytBooks.func;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import io.restassured.response.Response;

public class Validacao {

	ObjectMapper mapper = new ObjectMapper();

	final static Log log = LogFactory.getLog(Validacao.class);

	public void validarPresencaLivro(Response response, String livro) throws Exception {
		try {
			this.validarRetornoApi(response);

			String body = response.getBody().asString();
			JsonNode corpo = mapper.readTree(body);
			corpo = corpo.get("results");
			corpo = corpo.get("books");
			boolean encontrado = false;
			for (JsonNode infoLivro : corpo) {
				if (mapper.readTree(infoLivro.toString()).get("title").toString().contains(livro)) {
					encontrado = true;
				}
			}

			if (encontrado) {
				log.info("Livro encontrado na lista de retorno da APi: " + livro);
			} else {
				log.info("Erro ao encontrar o livro " + livro + "na lista de retorno da API");
				throw new Exception("Erro ao encontrar o livro " + livro + "nna lista de retorno da API");
			}
		} catch (Exception e) {
			log.info("Erro ao encontrar o livro " + livro + "na lista de retorno da API");
			throw new Exception("Erro ao encontrar o livro " + livro + " na lista de retorno da API");
		}
	}

	public void validarRetornoApi(Response response) throws Exception {
		if (response.getStatusCode() == 200) {
			log.info("Consulta efetuada com sucesso! Status code [200]");
		} else {
			log.info("Erro ao efetivar consulta - Status code [" + response.getStatusCode() + "]");
			throw new Exception("Erro ao efetivar consulta - Status code [" + response.getStatusCode() + "]");
		}
	}

}

package br.com.nytBooks.nytBooks.func;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class NtyBooksAPI {

	
	final static Log log = LogFactory.getLog(NtyBooksAPI.class);
	
	
	public Response consultarLivroPorTipo(String tipo){
		try{
			
			String endereco = "https://api.nytimes.com/svc/books/v3/lists/current/"+tipo+".json?api-key=szq2M8XX1oGexHqa59umAFaMUGmbAA6r";
			log.info("Consulta de livros pela lista - "+ tipo);
			RequestSpecification spec = RestAssured.given().relaxedHTTPSValidation();
			
			Response response = spec.get(endereco);
			log.info("Retorno api:");
			log.info(response.getBody().asString());
			return response;
			
		}catch(Exception e){
			return null;
		}
	}
	
	public Response consultarLivroPorData(String data){
		try{
			
			String endereco = "https://api.nytimes.com/svc/books/v3/lists/"+data+"/hardcover-fiction.json?api-key=szq2M8XX1oGexHqa59umAFaMUGmbAA6r";
			log.info("Consulta de livros pela data - "+ data);
			RequestSpecification spec = RestAssured.given().relaxedHTTPSValidation();
			
			Response response = spec.get(endereco);
			log.info("Retorno api:");
			log.info(response.getBody().asString());
			return response;
			
		}catch(Exception e){
			return null;
		}
	}
}

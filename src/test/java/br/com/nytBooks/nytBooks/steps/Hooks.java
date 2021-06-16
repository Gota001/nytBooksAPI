package br.com.nytBooks.nytBooks.steps;


import org.apache.log4j.PropertyConfigurator;

import br.com.nytBooks.nytBooks.apoio.DataFormater;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	
	Scenario scenario;
	
	@Before
	public void inicializarTeste(Scenario scenario){
		try{
			String ct = scenario.toString() + DataFormater.data();
			System.setProperty("log4jFileName", ct);
			PropertyConfigurator.configure("log4j.properties");

			
		}catch(Exception e){
			System.out.println("Erro ao inserir nome no log.");
		}
	}
	

}

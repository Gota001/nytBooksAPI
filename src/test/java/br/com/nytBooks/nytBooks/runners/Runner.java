package br.com.nytBooks.nytBooks.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features",
		glue = "br/com/nytBooks/nytBooks/steps",
		plugin = {"pretty","html:target/cucumber-reports"},
		tags = "@ConsultaLivroData",
		monochrome = true	
)

public class Runner {

}

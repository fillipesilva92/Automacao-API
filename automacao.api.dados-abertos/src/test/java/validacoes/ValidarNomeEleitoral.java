package validacoes;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ValidarNomeEleitoral {

	Response response;

	@Test
	public void validarNome() {
		response = RestAssured.get("https://dadosabertos.camara.leg.br/api/v2/deputados/220593");
		String nome = response.getBody().path("dados.ultimoStatus.nomeEleitoral", "nome eleitoral do deputado");
		assertTrue(nome.contains("Abilio Brunini"));
		System.out.println(nome);
	}

}

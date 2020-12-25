package br.com.alura.spring.data;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.alura.spring.data.service.CrudCargoService;
import br.com.alura.spring.data.service.CrudFuncionarioService;
import br.com.alura.spring.data.service.CrudUnidadeTrabalhoService;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	private Boolean system = true;

	@Autowired
	CrudCargoService crudCargoService;
	@Autowired
	CrudFuncionarioService crudFuncionarioService;
	@Autowired
	CrudUnidadeTrabalhoService crudUnidadeTrabalhoService;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		while (system) {
			System.out.println("Qual acao voce quer executar");
			System.out.println("0 - Sair");
			System.out.println("1 - Cargo");
			System.out.println("2 - Funcionario");
			System.out.println("3 - Unidades");

			int action = scanner.nextInt();

			switch (action) {
			case 1:
				crudCargoService.inicial(scanner);
				break;
			case 2:
				crudFuncionarioService.inicial(scanner);
				break;
			case 3:
				crudUnidadeTrabalhoService.inicial(scanner);
				break;
			default:
				system = false;
				break;
			}
		}
	}

}

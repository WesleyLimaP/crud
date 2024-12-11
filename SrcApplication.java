package crud.projeto.master;

import crud.projeto.master.controller.ClientController;
import crud.projeto.master.services.ClientService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SrcApplication {
	ClientService clientService;
	ClientController clientController;

	public static void main(String[] args) {
		SpringApplication.run(SrcApplication.class, args);
	}

}

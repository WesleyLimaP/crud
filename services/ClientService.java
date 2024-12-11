package crud.projeto.master.services;
import crud.projeto.master.dto.ClientDto;
import crud.projeto.master.entities.Client;
import crud.projeto.master.repository.ClientRepository;
import crud.projeto.master.services.exceptions.RessousesNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Transactional(readOnly = true)
    public ClientDto getById(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new RessousesNotFoundException("id não encontrado"));
        return new ClientDto(client);

    }

    @Transactional
    public ClientDto insert(ClientDto clientdto) {
        Client client = new Client();
        client.setBirthDate(clientdto.getBirthDate());
        client.setCpf(clientdto.getCpf());
        client.setChildren(clientdto.getChildren());
        client.setIncome(clientdto.getIncome());
        client.setName(clientdto.getName());
        client = clientRepository.save(client);
        return new ClientDto(client);
    }

    @Transactional
    public ClientDto update(Long id, ClientDto dto){
        try {
            Client client = clientRepository.getReferenceById(id);
            client.setName(dto.getName());
            client.setCpf(dto.getCpf());
            client.setIncome(dto.getIncome());
            client.setChildren(dto.getChildren());
            client.setBirthDate(dto.getBirthDate());
            client =  clientRepository.save(client );
            return new ClientDto(client);
        }catch (EntityNotFoundException e) {
            throw new RessousesNotFoundException("id nao encontrado: " + e.getMessage());
        }

    }
    @Transactional
    public void delete(Long id){
        if(!clientRepository.existsById(id)) {
           throw new RessousesNotFoundException("id nao encontrado");
        }
        clientRepository.deleteById(id);

    }

    @Transactional(readOnly = true)
    public Page<ClientDto> findAll(Pageable pageable){
        Page<Client> page = clientRepository.findAll(pageable);
        return page.map(ClientDto::new);
    }
}


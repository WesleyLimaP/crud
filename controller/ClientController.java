package crud.projeto.master.controller;
import crud.projeto.master.dto.ClientDto;
import crud.projeto.master.services.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientDto> getById(@PathVariable Long id){
        ClientDto dto = clientService.getById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping()
    public ResponseEntity<ClientDto> insert(@Valid @RequestBody ClientDto dto){
        clientService.insert(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ClientDto> update(@PathVariable Long id,@Valid @RequestBody ClientDto dto){
        ClientDto clientDto = clientService.update(id, dto);
       return  ResponseEntity.ok(clientDto);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping
    public ResponseEntity<Page<ClientDto>> findAll(Pageable pageable){
        return ResponseEntity.ok(clientService.findAll(pageable));
    }
}

package br.com.ithilh.bdpedidos.sistemapedidos.controller;


import org.springframework.web.bind.annotation.RestController;
import br.com.ithilh.bdpedidos.sistemapedidos.repository.ClienteRepository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import br.com.ithilh.bdpedidos.sistemapedidos.model.Cliente;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class ClienteController {

private final ClienteRepository repository;

public ClienteController (ClienteRepository repository){
    this.repository = repository;
}

@GetMapping("/clientes")
public List<Cliente> getCliente() {
    return (List<Cliente>) repository.findAll();
}

@GetMapping("/cliente/{id}")
public Cliente getClientePorId(@PathVariable BigInteger id) throws Exception{
   return repository.findById(id)
 .orElseThrow(()-> new Exception("Id não encontrado."));
    
}

@PostMapping("/cliente")
    public Cliente postCliente(@RequestBody Cliente entity) throws Exception {
        try {
      return repository.save(entity);
        }catch (Exception ex) {
      throw new Exception("Não foi possivel criar o cliente.");
      }
    }

    @PutMapping("/cliente{id}")
public Cliente putCliente(@PathVariable BigInteger id, @RequestBody Cliente entity) throws Exception {
    try {
        return repository.save(entity);
          }catch (Exception ex) {
        throw new Exception("Não foi possivel alterar o cliente.");
      }
    }

    @DeleteMapping ("/cliente{id}")
public String deleteCliente(@PathVariable BigInteger id)throws Exception{
try{
    repository.deleteById(id);
    return "Excluído";
      }catch (Exception ex) {
    throw new Exception("Não foi possivel alterar o cliente.");
  }
}

@GetMapping("/cliente/municipio/{id}")
public Optional<Cliente> getClientesPorMunicipioId(@PathVariable BigInteger id ) {
    return repository.findById(id);
}

}


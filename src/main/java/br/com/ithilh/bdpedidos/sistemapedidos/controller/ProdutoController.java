package br.com.ithilh.bdpedidos.sistemapedidos.controller;

import java.math.BigInteger;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import br.com.ithilh.bdpedidos.sistemapedidos.model.Produto;
import br.com.ithilh.bdpedidos.sistemapedidos.repository.ProdutoRepository;



@RestController
public class ProdutoController {

private final ProdutoRepository repository;

public ProdutoController (ProdutoRepository repository){
    this.repository = repository;
}

@GetMapping("/produtos")
public List<Produto> getProduto() {
    return (List<Produto>) repository.findAll();
}

@GetMapping("/produto/{id}")
public Produto getProdutoPOrId(@PathVariable BigInteger id) throws Exception {
    return repository.findById(id)
    .orElseThrow(()-> new Exception ("Id não encontrado"));
}

@PostMapping("/produto")
    public Produto postProduto(@RequestBody Produto entity) throws Exception {
        try {
      return repository.save(entity);
        }catch (Exception ex) {
      throw new Exception("Não foi possivel criar o cliente.");
      }
    }

@PutMapping("/produto{id}")
public Produto putProduto(@PathVariable BigInteger id, @RequestBody Produto entity) throws Exception {
    try {
        return repository.save(entity);
          }catch (Exception ex) {
        throw new Exception("Não foi possivel alterar o cliente.");
      }
    }

@DeleteMapping ("/produto{id}")
public String deleteProduto(@PathVariable BigInteger id)throws Exception{
try{
    repository.deleteById(id);
    return "Excluído";
      }catch (Exception ex) {
    throw new Exception("Não foi possivel alterar o cliente.");
  }
}

}

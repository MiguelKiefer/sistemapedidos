package br.com.ithilh.bdpedidos.sistemapedidos.controller;

import org.springframework.web.bind.annotation.RestController;

import br.com.ithilh.bdpedidos.sistemapedidos.model.Estado;
import br.com.ithilh.bdpedidos.sistemapedidos.repository.EstadoRepository;
import br.com.ithilh.bdpedidos.sistemapedidos.util.ModoBusca;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class EstadoController {

    private final EstadoRepository repository;

    public EstadoController(EstadoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/estados")
    public List<Estado> getTodos() {
        return (List<Estado>) repository.findAll();
        // pedir para o repositorio trazer a lista de estados
    }

    @GetMapping("/estados/nome/{nome}")
    public List<Estado> getEstadosPorNome(@PathVariable String nome,
            @RequestParam(required = true) ModoBusca modoBusca) {
        if (modoBusca.equals(ModoBusca.EXATO)) {
            return repository.findByNome(nome);
        } else if (modoBusca.equals(ModoBusca.INICIADO)) {
            return repository.findByNomeStartingWithIgnoreCase(nome);
        } else if (modoBusca.equals(ModoBusca.FINALIZADO)) {
            return repository.findByNomeEndingWithIgnoreCase(nome);
        } else {
            return repository.findByNomeContainingIgnoreCase(nome);
        }
    }

    @PostMapping("/estado")
    public Estado postEstado(@RequestBody Estado entity) {
        return repository.save(entity);
    }

        @PutMapping("/estado/{id}")
    public Estado alterarEstado(@PathVariable BigInteger id, 
                                @RequestBody Estado novosDados) throws Exception {

        Optional<Estado> estadoAmazenado = repository.findById(id);
        if(estadoAmazenado.isPresent()){
            //Atribuir novo nome ao objeto já existem no banco de dados
            estadoAmazenado.get().setNome(novosDados.getNome());
            //
            return repository.save(estadoAmazenado.get());
        }        
        throw new Exception("Alteração não foi realizada.");
    }

    @DeleteMapping("/estado/{id}")
    public String deletePorId(@PathVariable BigInteger id) throws Exception {

        Optional<Estado> estadoAmazenado = repository.findById(id);
        if(estadoAmazenado.isPresent()){
            repository.delete(estadoAmazenado.get());
            return "Excluído";
        }
        throw new Exception("Id não econtrado para a exclusão");
    }

}

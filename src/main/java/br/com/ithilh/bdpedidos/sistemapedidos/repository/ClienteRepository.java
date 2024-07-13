package br.com.ithilh.bdpedidos.sistemapedidos.repository;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.ithilh.bdpedidos.sistemapedidos.model.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository <Cliente , BigInteger>{
    Optional<Cliente> findById(BigInteger id);

   //List<Cliente> findAll();

}

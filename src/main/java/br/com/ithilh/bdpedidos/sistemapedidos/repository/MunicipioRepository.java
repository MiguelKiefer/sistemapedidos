package br.com.ithilh.bdpedidos.sistemapedidos.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.ithilh.bdpedidos.sistemapedidos.model.Municipio;

@Repository
public interface MunicipioRepository extends CrudRepository<Municipio, BigInteger> {

    List<Municipio>findByEstadoId(BigInteger id);


}

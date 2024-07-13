package br.com.ithilh.bdpedidos.sistemapedidos.model;

import java.math.BigInteger;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "tb_clientes")
public class Cliente {

@Id
    @SequenceGenerator(name = "clientes_id_seq",
        sequenceName ="tb_clientes_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
        generator = "clientes_id_seq")
    private BigInteger id;

@ManyToOne 
@JoinColumn(name = "id_municipio")
private Municipio municipio;

@Column(name = "tx_nome_razao_social")
private String tx_nome_razao_social;

@Column(name = "tx_cpf")
private String tx_cpf;

@Column(name = "tx_cnpj")
private String tx_cnpj;

@Column(name = "tx_telefone")
private String tx_telefone;

@Column(name = "tx_bairro")
private String tx_bairro;

@Column(name = "tx_cep")
private String tx_cep;

@Column(name = "tx_email")
private String tx_email;

@Column(name = "bo_ativo")
private boolean bo_ativo;

@Column(name = "tx_informacoes")
private String tx_informacoes;
}

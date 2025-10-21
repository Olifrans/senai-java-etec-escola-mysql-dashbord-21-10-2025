package com.senai.escola.Interface;


import org.springframework.data.jpa.repository.JpaRepository;

import com.senai.escola.Models.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}

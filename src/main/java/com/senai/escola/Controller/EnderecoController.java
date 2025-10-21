package com.senai.escola.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senai.escola.Models.Endereco;
import com.senai.escola.Service.EnderecoService;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {
    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @GetMapping
    public List<Endereco> buscarEndereco() {
        return enderecoService.buscarEndereco();
    }

    @PostMapping
    public Endereco salvar(@RequestBody Endereco endereco) {
        return enderecoService.salvarEndereco(endereco);
    }

    @DeleteMapping("/{id}")
    public void excluirEndereco(@PathVariable Long id) {
        enderecoService.deletarEndereco(id);
    }

    @GetMapping("/{id}")
    public Endereco buscaEnderecoPorId(@PathVariable Long id) {
        return enderecoService.buscarEnderecoId(id);
    }




    @PutMapping("/{id}")
    public Endereco atualizarEndereco(@PathVariable Long id, @RequestBody Endereco novoEndereco) {

        Endereco verificaEndereco = enderecoService.buscarEnderecoId(id);
        if (verificaEndereco == null)
            return null;

        verificaEndereco.setCep(novoEndereco.getCep());
        verificaEndereco.setLogradouro(novoEndereco.getLogradouro());
        verificaEndereco.setComplemento(novoEndereco.getComplemento());
        verificaEndereco.setUnidade(novoEndereco.getUnidade());
        verificaEndereco.setBairro(novoEndereco.getBairro());
        verificaEndereco.setLocalidade(novoEndereco.getLocalidade());
        verificaEndereco.setUf(novoEndereco.getUf());
        verificaEndereco.setRegiao(novoEndereco.getRegiao());
        verificaEndereco.setIbge(novoEndereco.getIbge());
        verificaEndereco.setGia(novoEndereco.getGia());
        verificaEndereco.setDdd(novoEndereco.getDdd());
        verificaEndereco.setSiafi(novoEndereco.getSiafi());

        return enderecoService.salvarEndereco(verificaEndereco);
    }

}

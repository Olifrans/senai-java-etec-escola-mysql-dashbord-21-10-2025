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

import com.senai.escola.Models.Aluno;
import com.senai.escola.Service.AlunoService;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping
    public List<Aluno> buscarAlunos() {
        return alunoService.buscarTodosAlunos();
    }

    @PostMapping
    public Aluno salvar(@RequestBody Aluno aluno) {
        return alunoService.salvarNovoAluno(aluno);
    }

    @DeleteMapping("/{id}")
    public void excluirAluno(@PathVariable Long id) {
        alunoService.deletarAluno(id);
    }

    @GetMapping("/{id}")
    public Aluno buscaAlunoPorId(@PathVariable Long id) {
        return alunoService.buscarAlunoId(id);
    }

    @PutMapping("/{id}")
    public Aluno atualizarProfessores(@PathVariable Long id, @RequestBody Aluno novoAluno) {

        Aluno verificaAluno = alunoService.buscarAlunoId(id);
        if (verificaAluno == null)
            return null;

        verificaAluno.setNome(novoAluno.getNome());
        verificaAluno.setEmail(novoAluno.getEmail());
        verificaAluno.setTelefone(novoAluno.getTelefone());

        return alunoService.salvarNovoAluno(verificaAluno);
    }

}

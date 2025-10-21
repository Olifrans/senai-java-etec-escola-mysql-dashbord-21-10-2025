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

import com.senai.escola.Models.Professor;
import com.senai.escola.Service.ProfessorService;

@RestController
@RequestMapping("/professores")
public class ProfessorController {
    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping
    public List<Professor> buscarProfessores() {
        return professorService.buscarTodosProfessores();
    }

    @PostMapping
    public Professor salvar(@RequestBody Professor professor) {
        return professorService.salvarNovoProfessor(professor);
    }

    @PutMapping("/{id}")
    public Professor atualizarProfessores(@PathVariable Long id, @RequestBody Professor novoProfessor) {

        Professor verificaProfessor = professorService.buscarProfessorId(id);
        if (verificaProfessor == null)
            return null;

        verificaProfessor.setNome(novoProfessor.getNome());
        verificaProfessor.setEmail(novoProfessor.getEmail());
        verificaProfessor.setTelefone(novoProfessor.getTelefone());

        return professorService.salvarNovoProfessor(verificaProfessor);
    }

    @DeleteMapping("/{id}")
    public void excluirAluno(@PathVariable Long id) {
        professorService.deletarProfessor(id);
    }

    @GetMapping("/{id}")
    public Professor buscaAlunoPorId(@PathVariable Long id) {
        return professorService.buscarProfessorId(id);
    }

}

package br.edu.ifrs.riogrande.tads.ppa.ligaa.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifrs.riogrande.tads.ppa.ligaa.entity.Aluno;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.service.AlunoService;
import br.edu.ifrs.riogrande.tads.ppa.ligaa.service.NovoAluno;

// Rotear tudo "que tem a ver" com Aluno

@RestController
public class AlunoController {

    private final AlunoService alunoService;

    // o AlunoService será "injetado" pelo Spring (framework)
    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }
   
    // rotear
    @PostMapping(path = "/api/v1/alunos", 
                 consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(code = HttpStatus.CREATED)
    public void novoAluno(@RequestBody NovoAluno aluno) {

        System.out.println(aluno);
        alunoService.cadastrarAluno(aluno);
    }
    
    @GetMapping(path = "/api/v1/alunos/{cpf}") // identificador
    public ResponseEntity<Aluno> buscaCpf(@PathVariable("cpf") String cpf) {

        Aluno aluno = alunoService.buscarAluno(cpf);

        return ResponseEntity.ok(aluno); // 200
    }

    // public void novoAlunoV2(NovoAlunoV2 aluno)
}

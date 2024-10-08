package br.edu.ifrs.riogrande.tads.ppa.ligaa.service;
// new AlunoService()

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import br.edu.ifrs.riogrande.tads.ppa.ligaa.entity.Aluno;

@Service // qualificando o objeto
public class AlunoService {

    public void cadastrarAluno(NovoAluno novoAluno) {
        
        Aluno aluno = new Aluno();
        // BeanUtils.copyProperties(novoAluno, aluno);
        // de-para
        aluno.setCpf(novoAluno.getCpf());
        aluno.setNome(novoAluno.getNome());
        aluno.setLogin(novoAluno.getEnderecoEletronico());
        aluno.setEnderecoEletronico(novoAluno.getEnderecoEletronico());

        LocalDateTime agora = LocalDateTime.now();
        aluno.setDataHoraCriacao(agora);
        aluno.setDataHoraAlteracao(agora);

        aluno.setDesativado(false);

        aluno.setId(UUID.randomUUID());

        // Padrões de Abstração da Persistência:
        // - Active Record (Registro Ativo):
        //   o próprio objeto representa um registro e lida com sua persistência.
        // - Repository (Repositório - "daozinho" - Data Access Object)
        //   um container representa o objeto persistente como estivesse em memória

        // Active Record (objeto salva a si mesmo)
        aluno.save();

        // DAO
        // AlunoDAO dao = new AlunoDAO();
        // dao.save(aluno);
        // Aluno a = dao.findByCpf("11122233344");
    }

    public Aluno buscarAluno(@NonNull String cpf) {
        // a:
        return Aluno.buscaCpf(cpf)
                    .orElseThrow(() -> new NullPointerException("Aluno não encontrado"));

        // b:
        // Aluno a = new Aluno();
        // a.setCpf(cpf);
        // a.load();
    }
 
}

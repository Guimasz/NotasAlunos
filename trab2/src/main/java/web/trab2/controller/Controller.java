package web.trab2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import web.trab2.config.Utils;
import web.trab2.model.Aluno;
import web.trab2.model.AlunoDto;
import web.trab2.repository.AlunoRepository;

import java.util.ArrayList;

@RestController
public class Controller {

    @Autowired
    private AlunoRepository repository;

    @GetMapping("/getAll")
    public ResponseEntity<ArrayList<Aluno>> getAll() {
    	      
        try {
        	
        	ArrayList<Aluno> alunos = new ArrayList<Aluno>(this.repository.findAll());
        	return new ResponseEntity<>(alunos, HttpStatus.OK);
        	
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        /*
            Aqui você consulta o Repository para retornar um array list com todos os dados.
            Evidentemente, você deve remover este return null.
         */
    }

    @PostMapping("/updateAluno")
    public ResponseEntity<Object> updateAluno(@RequestBody AlunoDto dto) {
        Aluno aluno = this.repository.findById(Long.parseLong(dto.id)).orElse(null);
        
        try {
        	
        	if (aluno == null)
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não há aluno com este id");

                aluno.setNome(dto.nome);
                aluno.setMatricula(dto.matricula);
                aluno.setTurma(Integer.parseInt(dto.turma));
                aluno.setNota(Double.parseDouble(dto.nota));
                
                double nota = Double.parseDouble(dto.nota);
                if(nota < 0 || nota > 10)
                	throw new IllegalArgumentException("A nota deve estar entre 0 e 10");
                
                
                this.repository.save(aluno);
                return ResponseEntity.status(HttpStatus.OK).body("Aluno atualizado com sucesso");
            /*
                Aqui você atualiza os dados de um aluno. Note que findById te retornará um objeto
                do tipo Optional. Ele poderá indicar se o id do dado realmente existe. Caso exista,
                use o Repository para salvar o objeto Aluno. Se o aluno com o id informado não
                existir, responda status NOT_FOUND como o corpo da mensagem "Não há aluno com este id".
                O último return não pode ser null. Corrija isso.
             */
        	
        }catch (NumberFormatException e) {
         
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Os dados fornecidos são inválidos");
            
        }catch (IllegalArgumentException e) {
        	
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } 
        catch (Exception e) {
        	
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro interno do servidor");
        }
        
    }

    @PostMapping("/novoAluno")
    public ResponseEntity<Object> novoAluno(@RequestBody AlunoDto dto) {

    	
    	try {
    		
    		if (this.repository.countAlunoByTurma(Integer.parseInt(dto.turma)) >= 10)
    			return ResponseEntity.status(HttpStatus.PAYLOAD_TOO_LARGE).body("Dados em excesso");
    		
    		
    		Aluno novoAluno = new Aluno();
    		novoAluno.setNome(dto.nome);
    		novoAluno.setMatricula(dto.matricula);
    		novoAluno.setTurma(Integer.parseInt(dto.turma));
    		novoAluno.setNota(Double.parseDouble(dto.nota));
    		
    		this.repository.save(novoAluno);
    		/*
            Aqui você registra um novo aluno, que você cria a partir do dto.
            PRESTE ATENÇÃO. A turma não pode exceder 10 alunos. A interface AlunoRepository
            contém um recurso para contagem de alunos. Examine e decida como proceder.
            Se o número de alunos exceder o limite, retorne um erro com status PAYLOAD_TOO_LARGE
            e agregue no corpo da mensagem a string "Dados em excesso".
            Evidentemente, remova o null do último return enquanto agrega o status OK.
    		 */
    		return ResponseEntity.status(HttpStatus.OK).body("Aluno adicionado com sucesso");
    		
    	}catch (NumberFormatException e) {
          
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Os dados fornecidos são inválidos");
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro interno do servidor");
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<Object> deleteAluno(@RequestBody String id) {
        /*
            Deixei este código presente por cortesia, assim como os dois métodos abaixo.
         */
    	
    	try {
    		
    		Long alunoId = Long.parseLong(id);
    		this.repository.deleteById(alunoId);
    		return ResponseEntity.status(HttpStatus.OK).body("");
    		
    	}catch (NumberFormatException e) {
            
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("O ID fornecido é inválido");
        } catch (Exception e) {
            
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro interno do servidor");
        }
    }

    @GetMapping("/reset")
    public ResponseEntity<Object> reset() {
        this.repository.deleteAll();
        Utils.startDb(this.repository);
        return ResponseEntity.status(HttpStatus.OK).body("");
    }

    @GetMapping("/zerar")
    public ResponseEntity<Object> zerar() {
        this.repository.deleteAll();
        return ResponseEntity.status(HttpStatus.OK).body("");
    }
}

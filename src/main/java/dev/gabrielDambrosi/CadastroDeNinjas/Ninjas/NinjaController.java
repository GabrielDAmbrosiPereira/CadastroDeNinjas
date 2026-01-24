package dev.gabrielDambrosi.CadastroDeNinjas.Ninjas;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    @Operation(summary = "Mensagem de Boas Vindas", description = "Essa rota  da uma mensagem de boas vindas para quem a acessa")
    public String boasVindas(){
        return "Essa é a minha primeira mensagem nessa rota";
    }


    // TODO ESSE É O CRUD (CREATE, READ, UPDATE, DELETE)

    //ADICIONAR UM NINJA (CREATE)
    @PostMapping("/criar")
    @Operation(summary = "Cria um novo ninja", description = "Rota cria um novo ninja e insere no banco de dados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Ninja Criado com Sucesso!"),
            @ApiResponse(responseCode = "400", description = "Erro na Criação do Ninja")
    })
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja){
        NinjaDTO novoNinja = ninjaService.criarNinja(ninja);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso: " + novoNinja.getNome() + " (ID): " + novoNinja.getId());
    }

    // MOSTRAR NINJA(READ)
    @GetMapping("/listar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas(){
        List<NinjaDTO> ninjas = ninjaService.listarNinjas();
        return ResponseEntity.ok(ninjas);
    }

    // MOSTRAR OS NINJAS POR ID (READ)
    @GetMapping("/listar/{id}")
    @Operation(summary = "Lista os ninjas por Id", description = "Rota lista um ninja pelo seu Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja Encontrado com Sucesso!"),
            @ApiResponse(responseCode = "404", description = "Ninja não Encontrado")
    })
    public ResponseEntity<?> listarTodosNinjasPorId(@PathVariable Long id){
        NinjaDTO ninja = ninjaService.listarNinjasPorId(id);
        if (ninja != null){
            return ResponseEntity.ok(ninja);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o id: " + id + "não existe nos registros");
        }

    }

    // ALTERAR DADOS DOS NINJAS (UPDATE)
    @PutMapping("/alterar/{id}")
    @Operation(summary = "Altera o ninja por Id", description = "Rota altera um ninja pelo seu Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Ninja Alterado com Sucesso!"),
            @ApiResponse(responseCode = "404", description = "Ninja não Encontrado")
    })
    public ResponseEntity<?> alterarNinjasPorId(
            @Parameter(description = "Usuário manda o id no caminho da requisição")
            @PathVariable Long id,
            @Parameter(description = "Usuário manda os dados do ninja a ser atualizado no corpo da requisição")
            @RequestBody NinjaDTO ninjaAtualizado){
        NinjaDTO ninja = ninjaService.atualizarNinja(id,ninjaAtualizado);

        if (ninja != null){
            return ResponseEntity.ok(ninja);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja com o id: " + id + "não encontrado");
        }
    }

    // DELETAR NINJAS (DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinjaPorId(@PathVariable Long id){
        if(ninjaService.listarNinjasPorId(id) != null){
            ninjaService.deletarNinjaPorId(id);
            return ResponseEntity.ok("Ninja com o ID: " + id + "deletado com sucesso");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O ninja com o id" + id + "não foi encontrado");
        }

    }
}

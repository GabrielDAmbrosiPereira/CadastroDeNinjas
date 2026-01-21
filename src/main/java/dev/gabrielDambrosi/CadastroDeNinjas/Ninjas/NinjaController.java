package dev.gabrielDambrosi.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Essa é a minha primeira mensagem nessa rota";
    }


    // TODO ESSE É O CRUD (CREATE, READ, UPDATE, DELETE)

    //ADICIONAR UM NINJA (CREATE)
    @PostMapping("/criar")
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja){
        return ninjaService.criarNinja(ninja);
    }

    // MOSTRAR NINJA(READ)
    @GetMapping("/listar")
    public List<NinjaModel> listarNinjas(){
        return ninjaService.listarNinjas();
    }

    // MOSTRAR OS NINJAS POR ID (READ)
    @GetMapping("/listar/{id}")
    public  NinjaModel listarTodosNinjasPorId(@PathVariable Long id){
        return ninjaService.listarNinjasPorId(id);
    }

    // ALTERAR DADOS DOS NINJAS (UPDATE)
    @PutMapping("/alterar")
    public String alterarNinjasPorId(){
        return ("Alterar Ninja por ID");
    }

    // DELETAR NINJAS (DELETE)
    @DeleteMapping("/deletar/{id}")
    public void deletarNinjaPorId(@PathVariable Long id){
        ninjaService.deletarNinjaPorId(id);
    }
}

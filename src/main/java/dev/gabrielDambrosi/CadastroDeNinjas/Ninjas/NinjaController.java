package dev.gabrielDambrosi.CadastroDeNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Essa é a minha primeira mensagem nessa rota";
    }

    // TODO ESSE É O CRUD (CREATE, READ, UPDATE, DELETE)

    //ADICIONAR UM NINJA (CREATE)
    @PostMapping("/criar")
    public String criarNinja(){
        return "Ninja Criado";
    }
    // MOSTRAR NINJA POR ID (READ)
    @GetMapping("/listar")
    public String mostrarTodosNinjas(){
        return ("Todos os Ninjas");
    }
    // MOSTRAR OS NINJAS (READ)
    @GetMapping("/listarID")
    public String mostrarTodosNinjasPorId(){
        return ("Todos os Ninjas por ID");
    }
    // ALTERAR DADOS DOS NINJAS (UPDATE)
    @PutMapping("/alterar")
    public String alterarNinjasPorId(){
        return ("Alterar Ninja por ID");
    }
    // DELETAR NINJAS (DELETE)
    @DeleteMapping("/deletarId")
    public String deletarNinjaPorId(){
        return ("Ninja Deletado por ID");
    }
}

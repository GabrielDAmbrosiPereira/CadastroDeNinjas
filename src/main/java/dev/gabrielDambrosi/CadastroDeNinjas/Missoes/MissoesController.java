package dev.gabrielDambrosi.CadastroDeNinjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    @PostMapping("/criar")
    public String criarMissao(){
        return "Missao Criada";
    }
    @GetMapping("/listar")
    public String listarMissoes(){
        return "Missoes Listadas";
    }
    @PutMapping("/alterar")
    public String alterarMissao(){
        return "Missao Alterada";
    }
    @DeleteMapping("/deletar")
    public String deletarMissao(){
        return "Missao Deletada";
    }

}

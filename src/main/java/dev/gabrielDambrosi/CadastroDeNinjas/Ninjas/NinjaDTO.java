package dev.gabrielDambrosi.CadastroDeNinjas.Ninjas;

import dev.gabrielDambrosi.CadastroDeNinjas.Missoes.MissoesModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NinjaDTO {

    private Long id;
    private String nome;
    private String email;
    private Integer idade;
    private String imgUrl;
    private MissoesModel missoes;
    private String rank;
}

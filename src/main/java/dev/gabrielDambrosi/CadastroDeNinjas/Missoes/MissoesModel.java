package dev.gabrielDambrosi.CadastroDeNinjas.Missoes;

import dev.gabrielDambrosi.CadastroDeNinjas.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_missoes")
@NoArgsConstructor // CRIA O CONSTRUTOR NO ARGS
@AllArgsConstructor // CRIA O CONSTRUTOR ALL ARGS
@Data // CRIA OS GETTERS E SETTERS
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String dificuldade;

    //  @OneToMany - ONE MISSION TO MANY NINJAS
    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninja;
}

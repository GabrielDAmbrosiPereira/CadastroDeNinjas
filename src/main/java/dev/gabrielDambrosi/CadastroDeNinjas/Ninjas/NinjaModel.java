package dev.gabrielDambrosi.CadastroDeNinjas.Ninjas;

import dev.gabrielDambrosi.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//ENTITY TRANSFORMA UMA CLASSE EM UMA ENTIDADE DO BANCO DE DADOS
@Entity
//TABLE GERA A TABELA DE CADASTRO DE NINJAS
@Table(name = "tb_cadastro")
@NoArgsConstructor // CRIA O CONSTRUTOR NO ARGS
@AllArgsConstructor // CRIA O CONSTRUTOR ALL ARGS
@Data // CRIA OS GETTERS E SETTERS
public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true)
    private String email;

    private int idade;

    // @ManyToOne - um ninja tem uma única missão
    @ManyToOne
    @JoinColumn(name = "missoes_id") // FOREIGN KEY / CHAVE ESTRANGEIRA
    private MissoesModel missoes;

}

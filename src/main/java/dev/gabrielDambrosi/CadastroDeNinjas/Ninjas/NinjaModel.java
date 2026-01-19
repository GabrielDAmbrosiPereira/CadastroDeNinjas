package dev.gabrielDambrosi.CadastroDeNinjas.Ninjas;

import dev.gabrielDambrosi.CadastroDeNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor; // LOMBOK CONSTROI O ALL ARGS CONSTRUCTOR
import lombok.Data; // LOMBOK CRIA GETTERS E SETTERS
import lombok.NoArgsConstructor; // LOMBOK CONSTROI O NO ARGS CONSTRUCTOR


//ENTITY TRANSFORMA UMA CLASSE EM UMA ENTIDADE DO BANCO DE DADOS
@Entity
//TABLE GERA A TABELA DE CADASTRO DE NINJAS
@Table(name = "tb_cadastro")
@NoArgsConstructor // CRIA O CONSTRUTOR NO ARGS
@AllArgsConstructor // CRIA O CONSTRUTOR ALL ARGS
@Data // CRIA OS GETTERS E SETTERS
public class NinjaModel {

    @Id // IDENTIFICA MINHA PK (PRIMARY KEY)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // GERA O VALOR DA ID SEQUENCIAL COM NUMEROS
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;


    @Column(unique = true, name = "email") // ANNOTATION FAZ COM QUE NÃO POSSA TER 2 EMAILS IGUAIS NO BANCO DE DADOS NA MESMA TABELA
    private String email;

    @Column(name = "idade")
    private int idade;

    @Column(name = "img_url")
    private String imgUrl;

    // @ManyToOne - MANY NINJAS TO ONE MISSION
    @ManyToOne
    @JoinColumn(name = "missoes_id") // FOREIGN KEY / CHAVE ESTRANGEIRA - ADICIONA UMA COLUNA NA TABELA CADASTRO COM O MISSOES ID DA CLASSE MISSOESMODEL (FK)
    private MissoesModel missoes;

}

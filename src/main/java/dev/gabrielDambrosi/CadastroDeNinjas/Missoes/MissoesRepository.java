package dev.gabrielDambrosi.CadastroDeNinjas.Missoes;

import org.springframework.data.jpa.repository.JpaRepository;

// TODO EXTENDE A CLASSE JPA REPOSITORY E UTILIZA ORM (OBJECT RELATIONAL MAPPING) PARA CONVERTER A LINGUAGEM DO CÓDIGO PARA LINGUAGEM DO BANCO DE DADOS
/*
* TODO JPA POSSUI METODOS PARA REALIZAR QUERYS NO BANCO DE DADOS, CONVERTE UM METODO JAVA EM UMA QUERY NA LINGUAGEM DO BANCO DE DADOS
* */

public interface MissoesRepository extends JpaRepository<MissoesModel, Long> {

}

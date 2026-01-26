package dev.gabrielDambrosi.CadastroDeNinjas.Ninjas;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository;
    private final NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    //Listar todos os ninjas
    public List<NinjaDTO> listarNinjas(){
        List<NinjaModel> ninjas = ninjaRepository.findAll();
        return ninjas.stream()
                .map(ninjaMapper :: map)
                .collect(Collectors.toList());
    }
    //Listar todos os ninjas por ID
    public NinjaDTO listarNinjasPorId(Long id){
        Optional<NinjaModel> ninjaPorID = ninjaRepository.findById(id);
        return ninjaPorID.map(ninjaMapper ::map).orElse(null);
    }
    //Criar um novo ninja
    public NinjaDTO criarNinja(NinjaDTO ninjaDTO){
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninjaRepository.save(ninja);
        return ninjaMapper.map(ninja);
    }

    //Deletar um ninja tem que ser um void
    public void deletarNinjaPorId(Long id){
        ninjaRepository.deleteById(id);
    }

    //Atulizar ninja
    public NinjaDTO atualizarNinja(Long id, NinjaDTO ninjaDTO){
        Optional<NinjaModel> ninjaExistente = ninjaRepository.findById(id);
        if (ninjaExistente.isPresent()){
            NinjaModel ninjaAtualizado = ninjaExistente.get();
            if (ninjaDTO.getNome() != null)
                ninjaAtualizado.setNome(ninjaDTO.getNome());

            if (ninjaDTO.getEmail() != null)
                ninjaAtualizado.setEmail(ninjaDTO.getEmail());

            if (ninjaDTO.getIdade() != null)
                ninjaAtualizado.setIdade(ninjaDTO.getIdade());

            if (ninjaDTO.getImgUrl() != null)
                ninjaAtualizado.setImgUrl(ninjaDTO.getImgUrl());

            if (ninjaDTO.getRank() != null)
                ninjaAtualizado.setRank(ninjaDTO.getRank());

            if (ninjaDTO.getMissoes() != null)
                ninjaAtualizado.setMissoes(ninjaDTO.getMissoes());

            ninjaAtualizado.setId(id);
            NinjaModel ninjaSalvo = ninjaRepository.save(ninjaAtualizado);
            return ninjaMapper.map(ninjaSalvo);
        }
        return null;
    }
}

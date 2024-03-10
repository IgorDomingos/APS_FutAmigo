package br.ufpe.cin.futebolamigouser.mapper;

import br.ufpe.cin.futebolamigouser.dto.JogadorDTO;
import br.ufpe.cin.futebolamigouser.models.Jogador;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JogadorMapper {

    private final ModelMapper modelMapper;


    public Jogador convertToEntity(JogadorDTO jogadorDTO) {
        return modelMapper.map(jogadorDTO, Jogador.class);
    }

    public JogadorDTO convertToDto(Jogador jogador) {
        return modelMapper.map(jogador, JogadorDTO.class);
    }
}
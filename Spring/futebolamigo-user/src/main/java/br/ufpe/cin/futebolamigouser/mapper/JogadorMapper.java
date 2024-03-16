package br.ufpe.cin.futebolamigo.mapper;

import br.ufpe.cin.futebolamigo.dto.JogadorDTO;
import br.ufpe.cin.futebolamigo.models.Jogador;
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
package br.ufpe.cin.futebolamigo.mapper;

import br.ufpe.cin.futebolamigo.dto.GestorDTO;
import br.ufpe.cin.futebolamigo.models.Gestor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GestorMapper {

    private final ModelMapper modelMapper;

    public Gestor convertToEntity(GestorDTO gestorDTO) {
        return modelMapper.map(gestorDTO, Gestor.class);
    }

    public GestorDTO convertToDto(Gestor gestor) {
        return modelMapper.map(gestor, GestorDTO.class);
    }
}
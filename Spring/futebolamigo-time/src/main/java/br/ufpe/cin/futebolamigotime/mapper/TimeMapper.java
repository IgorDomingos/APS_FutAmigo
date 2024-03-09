package br.ufpe.cin.futebolamigo.mapper;

import br.ufpe.cin.futebolamigo.dto.TimeDTO;
import br.ufpe.cin.futebolamigo.models.Time;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TimeMapper {

    private final ModelMapper modelMapper;

    public Time convertToEntity(TimeDTO timeDTO) {
        return modelMapper.map(timeDTO, Time.class);
    }

    public TimeDTO convertToDto(Time time) {
        return modelMapper.map(time, TimeDTO.class);
    }

}

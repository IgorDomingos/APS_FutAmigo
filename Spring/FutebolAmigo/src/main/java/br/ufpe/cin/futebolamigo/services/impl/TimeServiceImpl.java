package br.ufpe.cin.futebolamigo.services.impl;

import br.ufpe.cin.futebolamigo.dto.TimeDTO;
import br.ufpe.cin.futebolamigo.mapper.TimeMapper;
import br.ufpe.cin.futebolamigo.models.Time;
import br.ufpe.cin.futebolamigo.repositories.TimeRepository;
import br.ufpe.cin.futebolamigo.services.TimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TimeServiceImpl implements TimeService {
    private final TimeRepository timeRepository;
    private final TimeMapper timeMapper;

    @Override
    public TimeDTO createTime(TimeDTO timeDTO) {
        Time timeToSave = timeMapper.convertToEntity(timeDTO);
        Time savedTime = timeRepository.save(timeToSave);
        return timeMapper.convertToDto(savedTime);
    }
    @Override
    public Time findByNome(String nome) {
        return timeRepository.findByNome(nome);
    }

    @Override
    public List<TimeDTO> findAllTimes() {
        List<Time> times = timeRepository.findAll();
        return times.stream()
                .map(timeMapper::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public TimeDTO updateTime(TimeDTO timeDTO) {
        Time timeToUpdate = timeMapper.convertToEntity(timeDTO);
        Time updatedTime = timeRepository.save(timeToUpdate);
        return timeMapper.convertToDto(updatedTime);
    }

    @Override
    public void deleteTime(String nome) {
        timeRepository.deleteByNome(nome);
    }

    @Override
    public void save(Time time) {
        timeRepository.save(time);
    }

}

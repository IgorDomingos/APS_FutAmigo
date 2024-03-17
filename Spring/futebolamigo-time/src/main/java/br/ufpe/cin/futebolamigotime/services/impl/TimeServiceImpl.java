package br.ufpe.cin.futebolamigotime.services.impl;

import br.ufpe.cin.futebolamigotime.dto.TimeDTO;
import br.ufpe.cin.futebolamigotime.mapper.TimeMapper;
import br.ufpe.cin.futebolamigotime.models.Time;
import br.ufpe.cin.futebolamigotime.repositories.TimeRepository;
import br.ufpe.cin.futebolamigotime.services.TimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TimeServiceImpl implements TimeService {
    private final TimeRepository timeRepository;
    private final TimeMapper timeMapper;
//    private TimeClient timeClient;
//
//    public void TimeService(TimeClient timeClient) {
//        this.timeClient = timeClient;
//    }
//
//    public Time getTimeById(Long id) {
//        ResponseEntity<Time> response = timeClient.getTimeById(id);
//        return response.getBody();
//    }

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

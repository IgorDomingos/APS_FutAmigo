package br.ufpe.cin.futebolamigotime.services;

import br.ufpe.cin.futebolamigotime.dto.TimeDTO;
import br.ufpe.cin.futebolamigotime.models.Time;
import br.ufpe.cin.futebolamigotime.repositories.TimeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface TimeService {

    TimeDTO createTime(TimeDTO timeDTO);

    Time findByNome(String nome);

    List<TimeDTO> findAllTimes();

    TimeDTO updateTime(TimeDTO timeDTO);

    void deleteTime(String nome);

    void save(Time time);

}
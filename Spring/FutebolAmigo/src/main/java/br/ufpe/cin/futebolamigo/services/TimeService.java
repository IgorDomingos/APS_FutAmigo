package br.ufpe.cin.futebolamigo.services;

import br.ufpe.cin.futebolamigo.dto.TimeDTO;
import br.ufpe.cin.futebolamigo.models.Time;
import br.ufpe.cin.futebolamigo.repositories.TimeRepository;
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

}
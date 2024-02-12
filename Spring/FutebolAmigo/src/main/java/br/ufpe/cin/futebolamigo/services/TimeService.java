package br.ufpe.cin.futebolamigo.services;

import br.ufpe.cin.futebolamigo.models.Time.Time;
import br.ufpe.cin.futebolamigo.repositories.TimeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TimeService {

    public TimeService(TimeRepository timeRepository) {
        this.timeRepository = timeRepository;
    }

    private TimeRepository timeRepository;

    public Time createTime(Time time) {
        return timeRepository.save(time);
    }

    public Page<Time> getAllTimes(Pageable page) {
        return timeRepository.findAll(page);
    }

    public Optional<Time> getTimeById(Long timeId) {
        return timeRepository.findById(timeId);
    }
    public Optional<Time> getTimeByNome(String timeNome) {
        return timeRepository.findByNome(timeNome);
    }
    public void deleteTime(Long timeId) {
        timeRepository.deleteById(timeId);
    }
}
package br.ufpe.cin.futebolamigo.services;

import br.ufpe.cin.futebolamigo.repositories.TimeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TimeService {
    private TimeRepository timeRepository;
}

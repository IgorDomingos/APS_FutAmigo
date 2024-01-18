package br.ufpe.cin.futebolamigo.services;

import br.ufpe.cin.futebolamigo.repositories.LocalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LocalService {
    private LocalRepository localRepository;
}

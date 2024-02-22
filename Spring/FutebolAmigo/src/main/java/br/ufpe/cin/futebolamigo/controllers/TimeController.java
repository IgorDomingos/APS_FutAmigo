package br.ufpe.cin.futebolamigo.controllers;

import br.ufpe.cin.futebolamigo.models.Time;
import br.ufpe.cin.futebolamigo.services.TimeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("/time")
public class TimeController {

}

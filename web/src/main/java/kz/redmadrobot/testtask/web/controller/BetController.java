package kz.redmadrobot.testtask.web.controller;

import kz.redmadrobot.testtask.business.model.request.CreateBetRequest;
import kz.redmadrobot.testtask.business.service.BetService;
import kz.redmadrobot.testtask.web.assembler.BetAssembler;
import kz.redmadrobot.testtask.web.model.BetResource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/bet")
@RequiredArgsConstructor
public class BetController {

    private final BetService betService;
    private final BetAssembler betAssembler;

    @PostMapping
    public ResponseEntity<BetResource> create(@RequestBody CreateBetRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(betAssembler.toModel(betService.create(request)));
    }

}

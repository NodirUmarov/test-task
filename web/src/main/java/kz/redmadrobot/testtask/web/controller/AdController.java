package kz.redmadrobot.testtask.web.controller;

import kz.redmadrobot.testtask.business.model.dto.ad.AdDto;
import kz.redmadrobot.testtask.business.model.request.CreateAdRequest;
import kz.redmadrobot.testtask.business.service.AdService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/ad")
public class AdController {

    private final AdService adService;

    @PostMapping
    public ResponseEntity<AdDto> create(@RequestBody CreateAdRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(adService.create(request));
    }

}

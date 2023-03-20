package br.org.sesisc.sim.backend.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.sesisc.sim.backend.models.SignalResults;
import br.org.sesisc.sim.backend.repositories.SignalResultsRepository;
import br.org.sesisc.sim.backend.responses.ErrorResponse;
import br.org.sesisc.sim.backend.responses.SuccessResponse;

@RestController
@RequestMapping("/pulse_results")
public class PulseResultsController {

    @Autowired
    private SignalResultsRepository pulseResultsRepository;

    @PostMapping
    @CrossOrigin
    public ResponseEntity<?> pulseResults(@Valid @RequestBody SignalResults signalResults, Errors errors, HttpServletRequest request) {

        SignalResults signR = null;

        try {
            if (errors.hasErrors()) {
                return ErrorResponse.handle(errors, HttpStatus.UNPROCESSABLE_ENTITY);
            }
            signR = pulseResultsRepository.save(signalResults);

            return SuccessResponse.handle(new String[] { "signR" }, new Object[] { signR }, HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return ErrorResponse.handle(new String[] { e.getMessage() }, SignalResults.class, HttpStatus.NOT_FOUND);
        }
    }
}

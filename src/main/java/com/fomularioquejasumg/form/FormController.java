package com.fomularioquejasumg.form;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping( value = "api/quejaumg", produces = MediaType.APPLICATION_JSON_VALUE)
public class FormController {

    @Autowired
    FormService formService;

    @PostMapping("/form")
    public ResponseEntity getFormData(@RequestBody Forma forma) {
        return new ResponseEntity( formService.saveQueja(forma), HttpStatus.OK );
    }

    @GetMapping()
    public ResponseEntity getReportByDates(
            @RequestParam(value = "from", required = true) String from,
            @RequestParam(value = "to", required = true) String to
    ) {
        return new ResponseEntity( formService.getReportOne(from, to), HttpStatus.OK);
    }


}

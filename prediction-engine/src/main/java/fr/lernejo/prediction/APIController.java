package fr.lernejo.prediction;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;

@RestController
public class APIController {

    final TemperatureService temperatureService = new TemperatureService();


    @GetMapping("api/temperature")
    public Object getValues(@RequestParam String country) {
        try {
            Temperature temperature = new Temperature(country, new ArrayList<TemperatureItem>());
            temperature.temperatures().add(new TemperatureItem(LocalDate.now().minusDays(1).toString(), temperatureService.getTemperature(country)));
            temperature.temperatures().add(new TemperatureItem(LocalDate.now().minusDays(2).toString(), temperatureService.getTemperature(country)));
            return temperature;
        } catch (UnknownCountryException unknownCountryException) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Fail");
        }

    }
}


record Temperature(String country, ArrayList<TemperatureItem> temperatures) {
}

record TemperatureItem(String date, Number temperature) {


}

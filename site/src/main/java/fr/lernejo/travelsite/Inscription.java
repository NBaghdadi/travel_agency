package fr.lernejo.travelsite;

public record Inscription(String userEmail, String userName, String userCountry, WeatherExpectation weatherExpectation,
                          int minimumTemperatureDistance) {
    public enum WeatherExpectation {WARMER, COLDER}
}

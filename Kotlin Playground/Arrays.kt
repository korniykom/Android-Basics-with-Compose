fun main() {
    val rockPlanets = arrayOf<String>("Mercury", "Venus", "Earth", "Mars");
    val gasPlanets = arrayOf<String>("Jupiter", "Saturn", "Uranus", "Neptune");
    val solarSystem = rockPlanets + gasPlanets;
    for(planet in solarSystem) {
        println(planet);
    }
    val newSolarSystem = solarSystem + arrayOf<String>("Pluto");
    for(planet in newSolarSystem) {
        println(planet);
    }
}
fun main() {
    val solarSystem = listOf("Mercury",
        "Venus",
        "Earth",
        "Mars",
        "Jupiter",
        "Saturn",
        "Uranus",
        "Neptune");
    for(planet in solarSystem) {
        println(planet);
    }

    print(solarSystem.get(2))
}

package com.juancnuno.adventofcode2023.day05;

import java.util.Arrays;
import java.util.Collection;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import com.juancnuno.adventofcode.Matcher;

public final class Almanac {

    private static final Pattern SEEDS = Pattern.compile("seeds: (.+)");

    private final Stream<String> almanac;
    private Collection<Long> seeds;
    private Map currentMap;
    private final Map seedToSoilMap;
    private final Map soilToFertilizerMap;
    private final Map fertilizerToWaterMap;
    private final Map waterToLightMap;
    private final Map lightToTemperatureMap;
    private final Map temperatureToHumidityMap;
    private final Map humidityToLocationMap;

    public Almanac(Stream<String> almanac) {
        this.almanac = almanac;

        seedToSoilMap = new Map();
        soilToFertilizerMap = new Map();
        fertilizerToWaterMap = new Map();
        waterToLightMap = new Map();
        lightToTemperatureMap = new Map();
        temperatureToHumidityMap = new Map();
        humidityToLocationMap = new Map();
    }

    public long getLowestLocation() {
        almanac.forEach(this::parse);

        return seeds.stream()
                .mapToLong(Number::longValue)
                .map(this::getLocation)
                .min()
                .orElseThrow();
    }

    private void parse(String line) {
        if (line.startsWith("seeds: ")) {
            handleSeeds(line);
        } else if (line.isEmpty()) {
            // Do nothing
        } else if (line.equals("seed-to-soil map:")) {
            currentMap = seedToSoilMap;
        } else if (line.equals("soil-to-fertilizer map:")) {
            currentMap = soilToFertilizerMap;
        } else if (line.equals("fertilizer-to-water map:")) {
            currentMap = fertilizerToWaterMap;
        } else if (line.equals("water-to-light map:")) {
            currentMap = waterToLightMap;
        } else if (line.equals("light-to-temperature map:")) {
            currentMap = lightToTemperatureMap;
        } else if (line.equals("temperature-to-humidity map:")) {
            currentMap = temperatureToHumidityMap;
        } else if (line.equals("humidity-to-location map:")) {
            currentMap = humidityToLocationMap;
        } else {
            currentMap.add(new Ranges(line));
        }
    }

    private void handleSeeds(String seeds) {
        this.seeds = Arrays.stream(new Matcher(SEEDS, seeds).group(1).split(" "))
                .map(Long::parseLong)
                .toList();
    }

    private long getLocation(long seed) {
        var soil = seedToSoilMap.get(seed);
        var fertilizer = soilToFertilizerMap.get(soil);
        var water = fertilizerToWaterMap.get(fertilizer);
        var light = waterToLightMap.get(water);
        var temperature = lightToTemperatureMap.get(light);
        var humidity = temperatureToHumidityMap.get(temperature);
        var location = humidityToLocationMap.get(humidity);

        return location;
    }
}

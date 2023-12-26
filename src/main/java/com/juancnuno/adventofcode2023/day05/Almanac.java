package com.juancnuno.adventofcode2023.day05;

import java.util.Arrays;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import com.juancnuno.adventofcode.Matcher;

public final class Almanac {

    private static final Pattern SEEDS = Pattern.compile("seeds: (.+)");

    private final Stream<String> almanac;
    private final Function<long[], Seeds> newSeeds;
    private final Map seedToSoilMap;
    private final Map soilToFertilizerMap;
    private final Map fertilizerToWaterMap;
    private final Map waterToLightMap;
    private final Map lightToTemperatureMap;
    private final Map temperatureToHumidityMap;
    private final Map humidityToLocationMap;

    private Seeds seeds;
    private Map currentMap;

    public Almanac(Stream<String> almanac, Function<long[], Seeds> newSeeds) {
        this.almanac = almanac;
        this.newSeeds = newSeeds;

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

        seedToSoilMap.initInverse();
        soilToFertilizerMap.initInverse();
        fertilizerToWaterMap.initInverse();
        waterToLightMap.initInverse();
        lightToTemperatureMap.initInverse();
        temperatureToHumidityMap.initInverse();
        humidityToLocationMap.initInverse();

        return LongStream.range(0, Long.MAX_VALUE)
                .filter(location -> seeds.contains(getSeed(location)))
                .findFirst()
                .orElseThrow();
    }

    private void parse(String line) {
        if (line.startsWith("seeds: ")) {
            initSeeds(line);
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

    private void initSeeds(String seeds) {
        var longs = Arrays.stream(new Matcher(SEEDS, seeds).group(1).split(" "))
                .mapToLong(Long::parseLong)
                .toArray();

        this.seeds = newSeeds.apply(longs);
    }

    private long getSeed(long location) {
        var humidity = humidityToLocationMap.get(location);
        var temperature = temperatureToHumidityMap.get(humidity);
        var light = lightToTemperatureMap.get(temperature);
        var water = waterToLightMap.get(light);
        var fertilizer = fertilizerToWaterMap.get(water);
        var soil = soilToFertilizerMap.get(fertilizer);
        var seed = seedToSoilMap.get(soil);

        return seed;
    }
}

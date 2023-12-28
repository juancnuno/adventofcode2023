package com.juancnuno.adventofcode2023.day08;

import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Pattern;

import com.juancnuno.adventofcode.Matcher;

final class Network {

    private final Node start;

    Network(Iterator<String> i) {
        var label = "(\\w\\w\\w)";
        var node = Pattern.compile(label + " = \\(" + label + ", " + label + "\\)");

        var map = new HashMap<String, Node>();

        while (i.hasNext()) {
            var matcher = new Matcher(node, i.next());
            var parent = map.computeIfAbsent(matcher.group(1), Node::new);

            parent.setLeftChild(map.computeIfAbsent(matcher.group(2), Node::new));
            parent.setRightChild(map.computeIfAbsent(matcher.group(3), Node::new));
        }

        start = map.get("AAA");
    }

    Node getStart() {
        return start;
    }
}

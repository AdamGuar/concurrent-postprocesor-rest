package com.postprocesor.rest.model;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Model {

    private List<Node> nodes = new ArrayList<>();
    private List<ElementSolid> elements = new ArrayList<>();


    public Model(InputStream stream) {
        var reader = new BufferedReader(new InputStreamReader(stream));
        reader.lines()
                .map(s -> s.split(","))
                .forEach(parts -> {
                    switch (parts.length) {
                        case 5: {
                            this.nodes.add(new Node(Integer.parseInt(parts[0].replaceAll("\\s+","")),
                                    Float.parseFloat(parts[1].replaceAll("\\s+","")),
                                    Float.parseFloat(parts[2].replaceAll("\\s+","")),
                                    Float.parseFloat(parts[3].replaceAll("\\s+","")),
                                    Double.parseDouble(parts[4].replaceAll("\\s+",""))));
                            break;
                        }
                        case 10:
                            var nodes = new ArrayList<Node>(8);
                            for(String nodeId : Arrays.copyOfRange(parts, 2, parts.length-1)) {
                                nodes.add(this.nodes.get(Integer.parseInt(nodeId.replaceAll("\\s+","")) -1));
                            }
                            this.elements.add(new ElementSolid(Integer.parseInt(parts[0].replaceAll("\\s+","")),
                                    Integer.parseInt(parts[1].replaceAll("\\s+","")),
                                    nodes));
                            break;
                    }
                });
    }

}

class Node {

    private int id;
    private float x, y, z;
    private double value;

    public Node(int id, float x, float y, float z, double value) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.z = z;
        this.value = value;
    }

}


class ElementSolid {

    private int eid;
    private int pid;
    private List<Node> nodes;

    public ElementSolid(int eid, int pid, List<Node> nodes) {
        this.eid = eid;
        this.pid = pid;
        this.nodes = nodes;
    }

}

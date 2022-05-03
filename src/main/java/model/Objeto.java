package model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Objeto {

    private int id;
    private final String name;

    public static final Objeto NINGUNO = new Objeto("NINGUNO");

    public Objeto(String name){
        this.name = name.toUpperCase();
    }
}

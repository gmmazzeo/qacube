/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ucla.cs.scai.linkedspending.model.rdfcube;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;

/**
 *
 * @author Giuseppe M. Mazzeo <mazzeo@cs.ucla.edu>
 */
public class Attribute implements Serializable {

    String uri, label;
    HashSet<Entity> entityValues = new HashSet<>();
    HashSet<String> literalValues = new HashSet<>();

    public Attribute(String uri) {
        this.uri = uri;
    }

    public String getUri() {
        return uri;
    }

    public String getLabel() {
        return label;
    }

    public boolean setLabel(String label) {
        boolean res = this.label == null;
        this.label = label;
        return res;
    }

    public HashSet<String> getLiteralValues() {
        return literalValues;
    }

    public HashSet<Entity> getEntityValues() {
        return entityValues;
    }

    public String getKeyWords() {
        StringBuilder sb = new StringBuilder(label);
        for (Entity e : entityValues) {
            sb.append("|").append(e.getKeyWords());
        }
        for (String l : literalValues) {
            sb.append("|").append(l);
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.uri);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Attribute other = (Attribute) obj;
        if (!Objects.equals(this.uri, other.uri)) {
            return false;
        }
        return true;
    }
    
    
}

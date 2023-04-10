/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atributos;

/**
 *
 * @author A278617
 */
public class AtributoPerro implements Comparable<AtributoPerro> {
        private String raza;

    public AtributoPerro() {
    }

    public AtributoPerro(String raza) {
        this.raza = raza;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    @Override
    public int compareTo(AtributoPerro t) {
       return this.getRaza().compareTo(t.getRaza());
    }
        
        
}

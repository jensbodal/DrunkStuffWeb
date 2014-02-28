package org.mypackage.hello;

/**
 *
 * @author jensb
 */
public class NameHandler {
    private int jens;
    private String name;
    
    public NameHandler() {
        jens = 1;
        name = "second";
    }

    /**
     * @return the jens
     */
    public int getJens() {
        return jens;
    }

    /**
     * @param jens the jens to set
     */
    public void setJens(int jens) {
        this.jens = jens;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}

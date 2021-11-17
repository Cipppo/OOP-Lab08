package it.unibo.oop.lab.mvc;

import java.util.List;

public class controllerImpl implements Controller{
    
    private String current = null;
    private List<String> history;

    @Override
    public void setNext(final String arg) throws IllegalArgumentException {
        this.current = arg;
        if(this.current != null) {
            history.add(current);
        }
    }

    @Override
    public String getNext() {
        return this.current;
    }

    @Override
    public String getHistory() {
        return this.history.toString();
    }

    @Override
    public void printCurrent() throws IllegalStateException{
        if(this.current != null) {
            System.out.println(this.current);
        }else {
            throw new IllegalStateException();
        }
    }

}

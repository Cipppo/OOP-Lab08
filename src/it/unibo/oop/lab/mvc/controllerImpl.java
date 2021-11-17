package it.unibo.oop.lab.mvc;

import java.util.ArrayList;
import java.util.List;

public class controllerImpl implements Controller{
    
    private String current;
    private final List<String> history = new ArrayList<>();

    @Override
    public void setNext(final String arg) throws IllegalArgumentException {
        this.current = arg;
        if(this.current != null) {
            history.add(current);
        }else {
            new IllegalArgumentException();
        }
    }

    @Override
    public String getNext() {
        return this.current;
    }

    @Override
    public String getHistory() {
        if(!history.isEmpty()) {
            return this.history.toString();
        }else {
            return " ";
        }
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

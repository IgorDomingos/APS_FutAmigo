package br.ufpe.cin.futebolamigouser.events;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Subject {
    private final List<Observer> observers = new ArrayList<>();

    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(UserEvent event) {
        for (Observer observer : observers) {
            observer.update(event);
        }
    }
}
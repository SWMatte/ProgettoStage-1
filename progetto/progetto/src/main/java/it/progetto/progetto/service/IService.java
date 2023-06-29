package it.progetto.progetto.service;

import java.text.ParseException;
import java.util.List;

public interface IService<T>{

    public List<T> getAll() throws ParseException;

    public void add(T t);

    public void remove(int id);

    public T update(T t);

}

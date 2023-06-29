package it.progetto.progetto.service;

import java.text.ParseException;
import java.util.List;

public interface IServiceDTO<T>{

    public List<T> getAllDTO() throws ParseException;

}

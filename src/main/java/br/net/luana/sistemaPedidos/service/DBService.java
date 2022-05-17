package br.net.luana.sistemaPedidos.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;

@Transactional
@Service
public class DBService {

    public void instanciateTestDatabase() throws ParseException {
        //adicionar aqui a instaciação da objetos que farão parte do banco de dados teste
    }
}

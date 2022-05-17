package br.net.luana.sistemaPedidos.service;

import br.net.luana.sistemaPedidos.domain.MasterDomain;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MasterService <T extends MasterDomain, ID extends Integer> {

    List<T> findAll();

    Page<T> findPage (Integer page, Integer linesPerPage, String direction, String orderBy);

    T findById (ID entityId);

    T save (T entity);

    T updateById(T entity, ID entityId);

    void deleteById(ID entityId);
}

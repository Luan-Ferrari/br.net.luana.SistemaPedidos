package br.net.luana.sistemaPedidos.dto;

import br.net.luana.sistemaPedidos.domain.MasterDomain;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MasterDTO<T extends MasterDomain, D extends MasterDTOImpl, ID extends Integer> {

    D makeDTO(T entity);

    List<D> makeListDTO(List<T> list);

    Page<D> makePageDTO(Page<T> page);

    T makeEntityFromDTO(D dto);
}

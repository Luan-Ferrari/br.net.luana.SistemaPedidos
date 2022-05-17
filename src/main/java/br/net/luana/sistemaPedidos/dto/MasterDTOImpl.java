package br.net.luana.sistemaPedidos.dto;

import br.net.luana.sistemaPedidos.domain.MasterDomain;
import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public abstract class MasterDTOImpl< T extends MasterDomain, D extends MasterDTOImpl, ID extends Integer>
        implements MasterDTO<T, D, ID> {

    private D dto;

    @Override
    public abstract D makeDTO(T entity);

    @Override
    public List<D> makeListDTO(List<T> list) {
        List<D> listDto = new ArrayList<>();
        for (T entity : list) {
            listDto.add(makeDTO(entity));
        }
        return listDto;
    }

    @Override
    public Page<D> makePageDTO(Page<T> page) {
        Page<D> pageDto = page.map(entity -> makeDTO(entity));
        return pageDto;
    }

    @Override
    public abstract T makeEntityFromDTO(D dto);
}

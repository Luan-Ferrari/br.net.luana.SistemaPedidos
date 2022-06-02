package br.net.luana.sistemaPedidos.service;

import br.net.luana.sistemaPedidos.domain.Item;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl extends MasterServiceImpl<Item, Integer>
        implements ItemService {


    @Override
    protected void updateData(Item updateEntity, Item entity) {

    }
}

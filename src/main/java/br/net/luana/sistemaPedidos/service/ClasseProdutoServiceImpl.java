package br.net.luana.sistemaPedidos.service;

import br.net.luana.sistemaPedidos.domain.ClasseProduto;
import org.springframework.stereotype.Service;

@Service
public class ClasseProdutoServiceImpl extends MasterServiceImpl<ClasseProduto, Integer>
        implements ClasseProdutoService {


    @Override
    protected void updateData(ClasseProduto updateEntity, ClasseProduto entity) {

    }
}

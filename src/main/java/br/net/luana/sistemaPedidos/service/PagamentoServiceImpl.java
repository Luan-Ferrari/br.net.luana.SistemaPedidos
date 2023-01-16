package br.net.luana.sistemaPedidos.service;

import br.net.luana.sistemaPedidos.domain.Pagamento;
import org.springframework.stereotype.Service;

@Service
public class PagamentoServiceImpl extends MasterServiceImpl<Pagamento, Integer>
        implements PagamentoService {


    @Override
    protected boolean updateData(Pagamento updateEntity, Pagamento entity) {
        return false;
    }
}

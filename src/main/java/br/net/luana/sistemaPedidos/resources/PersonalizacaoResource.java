package br.net.luana.sistemaPedidos.resources;

import br.net.luana.sistemaPedidos.domain.Colecao;
import br.net.luana.sistemaPedidos.domain.Personalizacao;
import br.net.luana.sistemaPedidos.dto.ColecaoDTO;
import br.net.luana.sistemaPedidos.dto.PersonalizacaoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface PersonalizacaoResource extends MasterResource<Personalizacao, PersonalizacaoDTO, Integer> {


}

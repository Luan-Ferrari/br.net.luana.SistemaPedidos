package br.net.luana.sistemaPedidos.service.validations;

import br.net.luana.sistemaPedidos.domain.Produto;
import br.net.luana.sistemaPedidos.domain.enums.StatusProduto;
import br.net.luana.sistemaPedidos.dto.ProdutoDTO;
import br.net.luana.sistemaPedidos.repositories.ProdutoRepository;
import br.net.luana.sistemaPedidos.resources.exceptions.FieldMessage;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class ProdutoInsertValidator implements ConstraintValidator<ProdutoInsert, ProdutoDTO> {

    @Autowired
    private ProdutoRepository repository;

    @Override
    public boolean isValid(ProdutoDTO dto, ConstraintValidatorContext context) {
        List<FieldMessage> list = new ArrayList<>();

        if(StatusProduto.toEnum(dto.getStatusProduto().getId()) == StatusProduto.ativo) {
            Produto aux = repository.findByCodigoProdutoAndStatusProduto(dto.getCodigoProduto(), 1);
            if (aux != null) {
                System.out.println(aux.getId());
                System.out.println(dto.getId());
                if(!aux.getId().equals(dto.getId())) {
                    list.add(new FieldMessage("codigoProduto", "Código já cadastrado em produto ativo"));
                }
            }
        }

        for (FieldMessage e: list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(
                    e.getMessage())
                    .addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        }
        return list.isEmpty();
    }
}

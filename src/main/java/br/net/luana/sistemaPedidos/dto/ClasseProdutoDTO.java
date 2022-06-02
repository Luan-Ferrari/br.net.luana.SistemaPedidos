package br.net.luana.sistemaPedidos.dto;

import br.net.luana.sistemaPedidos.domain.ClasseProduto;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Component
public class ClasseProdutoDTO extends MasterDTOImpl<ClasseProduto, ClasseProdutoDTO, Integer>
        implements Serializable {
    private static final long serialVersionUID = 1L;

    private ReferenciaDTO referenciaDTO = new ReferenciaDTO();
    private PersonalizacaoDTO personalizacaoDTO = new PersonalizacaoDTO();

    private Integer id;
    private String nomeClasse;

    private List<ReferenciaDTO> referencias = new ArrayList<>();

    private List<PersonalizacaoDTO> personalizacoes = new ArrayList<>();

    public ClasseProdutoDTO() {
    }

    public ClasseProdutoDTO(ClasseProduto entity) {
        this.id = entity.getId();
        this.nomeClasse = entity.getNomeClasse();
        this.referencias = referenciaDTO.makeListDTO(entity.getReferencias());
        this.personalizacoes = personalizacaoDTO.makeListDTO(entity.getPersonalizacoes());
    }

    @Override
    public ClasseProdutoDTO makeDTO(ClasseProduto entity) {
        return new ClasseProdutoDTO(entity);
    }

    @Override
    public ClasseProduto makeEntityFromDTO(ClasseProdutoDTO dto) {
        ClasseProduto classeProduto = new ClasseProduto();
        classeProduto.setId(dto.getId());
        classeProduto.setNomeClasse(dto.getNomeClasse());
        for (ReferenciaDTO referenciaDTO : dto.getReferencias()) {
            classeProduto.getReferencias().add(referenciaDTO.makeEntityFromDTO(referenciaDTO));
        }
        for (PersonalizacaoDTO personalizacaoDTO : dto.getPersonalizacoes()) {
            classeProduto.getPersonalizacoes().add(personalizacaoDTO.makeEntityFromDTO(personalizacaoDTO));
        }
        return classeProduto;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeClasse() {
        return nomeClasse;
    }

    public void setNomeClasse(String nomeClasse) {
        this.nomeClasse = nomeClasse;
    }

    public List<ReferenciaDTO> getReferencias() {
        return referencias;
    }

    public void setReferencias(List<ReferenciaDTO> referencias) {
        this.referencias = referencias;
    }

    public List<PersonalizacaoDTO> getPersonalizacoes() {
        return personalizacoes;
    }

    public void setPersonalizacoes(List<PersonalizacaoDTO> personalizacoes) {
        this.personalizacoes = personalizacoes;
    }
}

package br.net.luana.sistemaPedidos.resources;

import br.net.luana.sistemaPedidos.domain.MasterDomain;
import br.net.luana.sistemaPedidos.dto.MasterDTO;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public interface MasterResourceAllEndpointsToUser<T extends MasterDomain, D extends MasterDTO, ID extends Integer> {

    @GetMapping
    public abstract ResponseEntity<List<D>> findAll();

    @GetMapping("/page")
    public abstract ResponseEntity<Page<D>> findPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction,
            @RequestParam(value = "orderBy", defaultValue = "id") String orderBy);

    @GetMapping("/{entityId}")
    public abstract ResponseEntity<D> findById(@PathVariable ID entityId);

    @PostMapping
    public abstract ResponseEntity<Void> insert(@Valid @RequestBody D dto);

    @PutMapping("/{entityId}")
    public abstract ResponseEntity<Void> update(@RequestBody D dto, @PathVariable ID entityId);

    @DeleteMapping("/{entityId}")
    public abstract ResponseEntity<Void> delete(@PathVariable ID entityId);
}

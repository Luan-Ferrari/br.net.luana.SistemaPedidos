package br.net.luana.sistemaPedidos.resources;

import br.net.luana.sistemaPedidos.domain.MasterDomain;
import br.net.luana.sistemaPedidos.dto.MasterDTO;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public interface MasterResourceOnlyAdminsEndpoints<T extends MasterDomain, D extends MasterDTO, ID extends Integer> {

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping
    public abstract ResponseEntity<List<D>> findAll();

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/page")
    public abstract ResponseEntity<Page<D>> findPage(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction,
            @RequestParam(value = "orderBy", defaultValue = "id") String orderBy);

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("/{entityId}")
    public abstract ResponseEntity<D> findById(@PathVariable ID entityId);

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping
    public abstract ResponseEntity<Void> insert(@Valid @RequestBody D dto);

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PutMapping("/{entityId}")
    public abstract ResponseEntity<Void> update(@RequestBody D dto, @PathVariable ID entityId);

    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/{entityId}")
    public abstract ResponseEntity<Void> delete(@PathVariable ID entityId);
}

package br.edu.ifg.numbers.produtoapi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.edu.ifg.numbers.produtoapi.model.Produto;
import br.edu.ifg.numbers.produtoapi.service.ProdutoService;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> getAllCarros() {
        return produtoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> getById(@PathVariable Long id) {
        return produtoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Produto create(@RequestBody Produto produto) {
        return produtoService.save(produto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> update(@PathVariable Long id, @RequestBody Produto produto) {
        if (!produtoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        produto.setId(id);
        return ResponseEntity.ok(produtoService.save(produto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!produtoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        produtoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}


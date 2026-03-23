package com.example.atv_eliel.controller;

import com.example.atv_eliel.model.ProdutoModel;
import com.example.atv_eliel.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity <List<ProdutoModel>> findAll() {
        List<ProdutoModel> request = produtoService.listarProdutos();
        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity exibeProduto(@PathVariable Long id) {
        Optional<ProdutoModel> produto = produtoService.listarProduto(id);
        return ResponseEntity.ok().body(produto);
    }

    @PostMapping
    public ResponseEntity <ProdutoModel> create(@RequestBody ProdutoModel produto) {
        ProdutoModel request = produtoService.cadastrarProduto(produto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(request.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @PatchMapping("/{id}")
    public ResponseEntity <ProdutoModel> update(@PathVariable Long id, @RequestBody ProdutoModel produto) {
        ProdutoModel request = produtoService.atualizarProduto(id, produto);
        return ResponseEntity.ok().body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <ProdutoModel> delete(@PathVariable Long id) {
        produtoService.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }
}

package com.example.atv_eliel.service;

import com.example.atv_eliel.model.ProdutoModel;
import com.example.atv_eliel.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;


    public ProdutoModel cadastrarProduto(ProdutoModel produtoModel) {
        return produtoRepository.save(produtoModel);
    }

    public Optional<ProdutoModel> listarProduto(Long id) {
        return produtoRepository.findById(id);
    }

    public List<ProdutoModel> listarProdutos() {
        return produtoRepository.findAll();
    }

    public ProdutoModel atualizarProduto(Long id, ProdutoModel produtoModel) {

        if (produtoModel.getNome() != null) {
            produtoModel.setNome(produtoModel.getNome());
        }

        if (produtoModel.getPreco() != null) {
            produtoModel.setPreco(produtoModel.getPreco());
        }

        if (produtoModel.getQuantidadeEmEstoque() != null) {
            produtoModel.setQuantidadeEmEstoque(produtoModel.getQuantidadeEmEstoque());
        }

        return produtoRepository.save(produtoModel);
    }

    public void deletarProduto(Long id) {
        produtoRepository.deleteById(id);
    }
}

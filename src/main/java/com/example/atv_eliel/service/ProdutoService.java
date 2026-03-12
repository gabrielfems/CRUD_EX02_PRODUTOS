package com.example.atv_eliel.service;

import com.example.atv_eliel.model.ProdutoModel;
import com.example.atv_eliel.model.StatusProduto;
import com.example.atv_eliel.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    private ProdutoModel produtoModel;

    public ProdutoModel cadastrarProduto(ProdutoModel produtoModel) {
        produtoModel.setStatusProduto(StatusProduto.DISPONIVEL);

        return produtoRepository.save(produtoModel);
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

        if (produtoModel.getStatusProduto() != null) {
            produtoModel.setStatusProduto(produtoModel.getStatusProduto());
        }

        return produtoRepository.save(produtoModel);
    }

    public void deletarProduto(ProdutoModel produtoModel) {
        produtoModel.setStatusProduto(StatusProduto.DESCONTINUADO);
        produtoRepository.delete(produtoModel);
    }
}

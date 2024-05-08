package br.ada.caixa.service;

import br.ada.caixa.dto.request.ProdutoRequestDto;
import br.ada.caixa.dto.response.ProdutoResponseDto;
import br.ada.caixa.entity.Produto;
import br.ada.caixa.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional
    public ProdutoResponseDto inserir(ProdutoRequestDto produtoRequestDto) {

        Produto produto = new Produto();
        produto.setNome(produtoRequestDto.getNome());
        produto.setPreco(produtoRequestDto.getPreco());
        produto.setQtdeEstoque(produtoRequestDto.getQtdeEstoque());

        produto = produtoRepository.save(produto);

        ProdutoResponseDto produtoResponseDto = new ProdutoResponseDto();
        produtoResponseDto.setId(produto.getId());
        produtoResponseDto.setNome(produto.getNome());
        produtoResponseDto.setPreco(produto.getPreco());
        produtoResponseDto.setQtdeEstoque(produto.getQtdeEstoque());

        return produtoResponseDto;

    }

}

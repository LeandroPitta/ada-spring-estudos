package br.ada.caixa.service;

import br.ada.caixa.dto.request.ProdutoRequestDto;
import br.ada.caixa.dto.response.ProdutoResponseDto;
import br.ada.caixa.entity.Produto;
import br.ada.caixa.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional
    public ProdutoResponseDto inserir(ProdutoRequestDto produtoRequestDto) {

        ModelMapper modelMapper = new ModelMapper(); //biblioteca externa que mapeia os atributos de um objeto para outro
        Produto produto = modelMapper.map(produtoRequestDto, Produto.class);
//        Produto produto = new Produto();
//        produto.setNome(produtoRequestDto.getNome());
//        produto.setPreco(produtoRequestDto.getPreco());
//        produto.setQtdeEstoque(produtoRequestDto.getQtdeEstoque());

        produto = produtoRepository.save(produto);

        ProdutoResponseDto produtoResponseDto = modelMapper.map(produto, ProdutoResponseDto.class);
//        ProdutoResponseDto produtoResponseDto = new ProdutoResponseDto();
//        produtoResponseDto.setId(produto.getId());
//        produtoResponseDto.setNome(produto.getNome());
//        produtoResponseDto.setPreco(produto.getPreco());
//        produtoResponseDto.setQtdeEstoque(produto.getQtdeEstoque());

        return produtoResponseDto;

    }

    public void excluir(Long id) {
        produtoRepository.deleteById(id);
    }

    public ProdutoResponseDto atualizar(Long id, ProdutoRequestDto produtoRequestDto) {

        ModelMapper modelMapper = new ModelMapper();
        return produtoRepository.findById(id)
                .map(produto -> {
                    produto.setNome(produtoRequestDto.getNome());
                    produto.setPreco(produtoRequestDto.getPreco());
                    produto.setQtdeEstoque(produtoRequestDto.getQtdeEstoque());
                    return produtoRepository.save(produto);
                })
                .map(produto -> modelMapper.map(produto, ProdutoResponseDto.class))
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

    }

}

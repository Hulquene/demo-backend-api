package com.kenny.demo_backend_api.facade;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.kenny.demo_backend_api.dto.PagamentoDTO;
import com.kenny.demo_backend_api.producer.PagamentoRequestProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagamentoFacade {
    @Autowired
    private PagamentoRequestProducer pagamentoRequestProducer;

    public String solicitarPagamento(PagamentoDTO request){
        try {
            pagamentoRequestProducer.integrar(request);
        } catch (JsonProcessingException e) {
            return  "Ocorreu um erro ao solicitar o pagamento";
            //throw new RuntimeException(e);
        }
        return "Pagamento aguardando confirmacao..." + request.getNumeroPedido();
    }
}

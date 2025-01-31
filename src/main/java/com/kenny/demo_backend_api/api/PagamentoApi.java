package com.kenny.demo_backend_api.api;

import com.kenny.demo_backend_api.dto.PagamentoDTO;
import com.kenny.demo_backend_api.facade.PagamentoFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pagamento")
public class PagamentoApi {
    @Autowired
    private PagamentoFacade pagamentoFacade;

    @PostMapping
    public String processar(@RequestBody PagamentoDTO body){
        return pagamentoFacade.solicitarPagamento(body);
    }

}

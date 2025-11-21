package com.Projeto.Tca.prisma20.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class RequisicaoLogin {
    private String emailReq;
    private String senhaReq;
}

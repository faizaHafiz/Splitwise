package com.splitwise.Splitwise.controllers;

import com.splitwise.Splitwise.dtos.SettleUpUserRequestDto;
import com.splitwise.Splitwise.dtos.SettleUpUserResponseDto;
import com.splitwise.Splitwise.services.SettlementService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SettleUpController {
    private SettlementService settlementService;
    public SettleUpUserResponseDto settleUpUser(SettleUpUserRequestDto settleUpUserRequestDto){
        SettleUpUserResponseDto responseDto = new SettleUpUserResponseDto();

        responseDto.setTransactions(settlementService.settleUpUser(settleUpUserRequestDto.getUserId()));

        return responseDto;
    }

    public void settleUpGroup(){

    }
}

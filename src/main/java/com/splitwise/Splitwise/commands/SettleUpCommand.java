package com.splitwise.Splitwise.commands;

import com.splitwise.Splitwise.controllers.SettleUpController;
import com.splitwise.Splitwise.dtos.SettleUpUserRequestDto;
import com.splitwise.Splitwise.dtos.SettleUpUserResponseDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SettleUpCommand implements Command{

    SettleUpController controller;
    @Override
    public Boolean matches(String inp) {
        //u1 settleUpuser
        List<String> words = List.of(inp.split(" "));

        return words.size()==2 &&
                words.get(1).equalsIgnoreCase(CommandKeywords.settleUp);
    }

    @Override
    public void execute(String inp) {
        List<String> words = List.of(inp.split(" "));
        Long userId = Long.valueOf(words.get(0));
        SettleUpUserRequestDto requestDto = new SettleUpUserRequestDto();
        requestDto.setUserId(userId);
        SettleUpUserResponseDto responseDto = controller.settleUpUser(requestDto);

    }
}

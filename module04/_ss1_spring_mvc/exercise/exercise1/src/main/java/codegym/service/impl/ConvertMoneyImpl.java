package codegym.service.impl;

import codegym.service.IConvertMoney;
import org.springframework.stereotype.Service;

@Service
public class ConvertMoneyImpl implements IConvertMoney {
    @Override
    public Double convert(Double usd) {
        return usd/23000;
    }
}

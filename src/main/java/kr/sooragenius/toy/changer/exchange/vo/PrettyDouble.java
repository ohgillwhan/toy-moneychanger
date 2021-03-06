package kr.sooragenius.toy.changer.exchange.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.text.DecimalFormat;

@Data
@AllArgsConstructor
public class PrettyDouble {
    public double value;
    @Override
    public String toString() {
        return getValuePretty();
    }
    public String getValuePretty() {
        DecimalFormat form = new DecimalFormat("#,##0.##");
        return form.format(value);
    }
}

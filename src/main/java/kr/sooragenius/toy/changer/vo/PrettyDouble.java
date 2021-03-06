package kr.sooragenius.toy.changer.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.text.DecimalFormat;

@Data
@AllArgsConstructor
public class PrettyDouble {
    public double value;

    @Override
    public String toString() {
        DecimalFormat form = new DecimalFormat("#,##0.##");
        return form.format(value);
    }
}

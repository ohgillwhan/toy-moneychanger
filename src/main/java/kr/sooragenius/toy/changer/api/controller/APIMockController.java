package kr.sooragenius.toy.changer.api.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Profile("dev")
@Slf4j
public class APIMockController {
    private static String SUCCESS_JSON = "{\n" +
            "  \"success\": true,\n" +
            "  \"terms\": \"https:\\/\\/currencylayer.com\\/terms\",\n" +
            "  \"privacy\": \"https:\\/\\/currencylayer.com\\/privacy\",\n" +
            "  \"timestamp\": 1614823987,\n" +
            "  \"source\": \"USD\",\n" +
            "  \"quotes\": {\n" +
            "    \"USDAED\": 3.673197,\n" +
            "    \"USDAFN\": 78.361628,\n" +
            "    \"USDALL\": 102.469924,\n" +
            "    \"USDAMD\": 525.989911,\n" +
            "    \"USDANG\": 1.795193,\n" +
            "    \"USDAOA\": 624.504127,\n" +
            "    \"USDARS\": 90.227299,\n" +
            "    \"USDAUD\": 1.284406,\n" +
            "    \"USDAWG\": 1.8,\n" +
            "    \"USDAZN\": 1.706597,\n" +
            "    \"USDBAM\": 1.621541,\n" +
            "    \"USDBBD\": 2.019302,\n" +
            "    \"USDBDT\": 84.799217,\n" +
            "    \"USDBGN\": 1.62333,\n" +
            "    \"USDBHD\": 0.376839,\n" +
            "    \"USDBIF\": 1944.833589,\n" +
            "    \"USDBMD\": 1,\n" +
            "    \"USDBND\": 1.330625,\n" +
            "    \"USDBOB\": 6.905331,\n" +
            "    \"USDBRL\": 5.619403,\n" +
            "    \"USDBSD\": 1.000066,\n" +
            "    \"USDBTC\": 1.9353719e-5,\n" +
            "    \"USDBTN\": 72.882838,\n" +
            "    \"USDBWP\": 10.977937,\n" +
            "    \"USDBYN\": 2.612102,\n" +
            "    \"USDBYR\": 19600,\n" +
            "    \"USDBZD\": 2.015836,\n" +
            "    \"USDCAD\": 1.265535,\n" +
            "    \"USDCDF\": 1994.999958,\n" +
            "    \"USDCHF\": 0.91952,\n" +
            "    \"USDCLF\": 0.026369,\n" +
            "    \"USDCLP\": 727.602109,\n" +
            "    \"USDCNY\": 6.469298,\n" +
            "    \"USDCOP\": 3681.09,\n" +
            "    \"USDCRC\": 612.967416,\n" +
            "    \"USDCUC\": 1,\n" +
            "    \"USDCUP\": 26.5,\n" +
            "    \"USDCVE\": 91.418599,\n" +
            "    \"USDCZK\": 21.712999,\n" +
            "    \"USDDJF\": 178.043462,\n" +
            "    \"USDDKK\": 6.166203,\n" +
            "    \"USDDOP\": 57.84584,\n" +
            "    \"USDDZD\": 133.436146,\n" +
            "    \"USDEGP\": 15.669523,\n" +
            "    \"USDERN\": 14.999815,\n" +
            "    \"USDETB\": 40.415057,\n" +
            "    \"USDEUR\": 0.829215,\n" +
            "    \"USDFJD\": 2.030903,\n" +
            "    \"USDFKP\": 0.717362,\n" +
            "    \"USDGBP\": 0.717385,\n" +
            "    \"USDGEL\": 3.319572,\n" +
            "    \"USDGGP\": 0.717362,\n" +
            "    \"USDGHS\": 5.725301,\n" +
            "    \"USDGIP\": 0.717362,\n" +
            "    \"USDGMD\": 51.29996,\n" +
            "    \"USDGNF\": 10138.848593,\n" +
            "    \"USDGTQ\": 7.702907,\n" +
            "    \"USDGYD\": 209.226841,\n" +
            "    \"USDHKD\": 7.757255,\n" +
            "    \"USDHNL\": 24.10165,\n" +
            "    \"USDHRK\": 6.286503,\n" +
            "    \"USDHTG\": 76.836739,\n" +
            "    \"USDHUF\": 302.054969,\n" +
            "    \"USDIDR\": 14360.25,\n" +
            "    \"USDILS\": 3.30602,\n" +
            "    \"USDIMP\": 0.717362,\n" +
            "    \"USDINR\": 72.975499,\n" +
            "    \"USDIQD\": 1459.074497,\n" +
            "    \"USDIRR\": 42105.000072,\n" +
            "    \"USDISK\": 126.640144,\n" +
            "    \"USDJEP\": 0.717362,\n" +
            "    \"USDJMD\": 150.477983,\n" +
            "    \"USDJOD\": 0.708978,\n" +
            "    \"USDJPY\": 107.020974,\n" +
            "    \"USDKES\": 109.660319,\n" +
            "    \"USDKGS\": 84.801678,\n" +
            "    \"USDKHR\": 4085.547312,\n" +
            "    \"USDKMF\": 408.503315,\n" +
            "    \"USDKPW\": 900.011254,\n" +
            "    \"USDKRW\": 1126.245002,\n" +
            "    \"USDKWD\": 0.30278,\n" +
            "    \"USDKYD\": 0.833392,\n" +
            "    \"USDKZT\": 419.713884,\n" +
            "    \"USDLAK\": 9353.441307,\n" +
            "    \"USDLBP\": 1512.077635,\n" +
            "    \"USDLKR\": 195.509698,\n" +
            "    \"USDLRD\": 173.903331,\n" +
            "    \"USDLSL\": 15.0202,\n" +
            "    \"USDLTL\": 2.95274,\n" +
            "    \"USDLVL\": 0.60489,\n" +
            "    \"USDLYD\": 4.43339,\n" +
            "    \"USDMAD\": 8.933678,\n" +
            "    \"USDMDL\": 17.600889,\n" +
            "    \"USDMGA\": 3758.023729,\n" +
            "    \"USDMKD\": 51.083816,\n" +
            "    \"USDMMK\": 1410.122957,\n" +
            "    \"USDMNT\": 2848.97536,\n" +
            "    \"USDMOP\": 7.990349,\n" +
            "    \"USDMRO\": 356.999828,\n" +
            "    \"USDMUR\": 39.845625,\n" +
            "    \"USDMVR\": 15.394394,\n" +
            "    \"USDMWK\": 782.478381,\n" +
            "    \"USDMXN\": 20.92259,\n" +
            "    \"USDMYR\": 4.053802,\n" +
            "    \"USDMZN\": 74.695033,\n" +
            "    \"USDNAD\": 15.019969,\n" +
            "    \"USDNGN\": 381.000049,\n" +
            "    \"USDNIO\": 34.896174,\n" +
            "    \"USDNOK\": 8.500803,\n" +
            "    \"USDNPR\": 116.618992,\n" +
            "    \"USDNZD\": 1.378259,\n" +
            "    \"USDOMR\": 0.384937,\n" +
            "    \"USDPAB\": 1.000037,\n" +
            "    \"USDPEN\": 3.666693,\n" +
            "    \"USDPGK\": 3.5275,\n" +
            "    \"USDPHP\": 48.555023,\n" +
            "    \"USDPKR\": 157.038661,\n" +
            "    \"USDPLN\": 3.76975,\n" +
            "    \"USDPYG\": 6641.544476,\n" +
            "    \"USDQAR\": 3.641009,\n" +
            "    \"USDRON\": 4.043699,\n" +
            "    \"USDRSD\": 97.487471,\n" +
            "    \"USDRUB\": 73.943601,\n" +
            "    \"USDRWF\": 993.582675,\n" +
            "    \"USDSAR\": 3.751073,\n" +
            "    \"USDSBD\": 8.15425,\n" +
            "    \"USDSCR\": 21.202073,\n" +
            "    \"USDSDG\": 379.000142,\n" +
            "    \"USDSEK\": 8.424011,\n" +
            "    \"USDSGD\": 1.33236,\n" +
            "    \"USDSHP\": 0.717362,\n" +
            "    \"USDSLL\": 10204.999953,\n" +
            "    \"USDSOS\": 583.000245,\n" +
            "    \"USDSRD\": 14.153958,\n" +
            "    \"USDSTD\": 20282.133983,\n" +
            "    \"USDSVC\": 8.750119,\n" +
            "    \"USDSYP\": 512.775718,\n" +
            "    \"USDSZL\": 14.914809,\n" +
            "    \"USDTHB\": 30.356955,\n" +
            "    \"USDTJS\": 11.39555,\n" +
            "    \"USDTMT\": 3.51,\n" +
            "    \"USDTND\": 2.724995,\n" +
            "    \"USDTOP\": 2.29815,\n" +
            "    \"USDTRY\": 7.457496,\n" +
            "    \"USDTTD\": 6.785198,\n" +
            "    \"USDTWD\": 27.809202,\n" +
            "    \"USDTZS\": 2318.999979,\n" +
            "    \"USDUAH\": 27.822504,\n" +
            "    \"USDUGX\": 3662.215884,\n" +
            "    \"USDUSD\": 1,\n" +
            "    \"USDUYU\": 43.166923,\n" +
            "    \"USDUZS\": 10488.063309,\n" +
            "    \"USDVEF\": 9.987497,\n" +
            "    \"USDVND\": 23022.340117,\n" +
            "    \"USDVUV\": 107.713809,\n" +
            "    \"USDWST\": 2.502625,\n" +
            "    \"USDXAF\": 543.861671,\n" +
            "    \"USDXAG\": 0.038121,\n" +
            "    \"USDXAU\": 0.000583,\n" +
            "    \"USDXCD\": 2.70255,\n" +
            "    \"USDXDR\": 0.696537,\n" +
            "    \"USDXOF\": 543.857162,\n" +
            "    \"USDXPF\": 99.314208,\n" +
            "    \"USDYER\": 250.350075,\n" +
            "    \"USDZAR\": 15.09285,\n" +
            "    \"USDZMK\": 9001.195489,\n" +
            "    \"USDZMW\": 21.91618,\n" +
            "    \"USDZWL\": 322.000331\n" +
            "  }\n" +
            "}";
    @GetMapping("/live")
    public ResponseEntity<String> live() {
        log.info("Spring Active Profile Is Dev");
        log.info("You called Mocked API");
        return ResponseEntity.ok(SUCCESS_JSON);
    }
}

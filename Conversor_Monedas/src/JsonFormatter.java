import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class JsonFormatter {
    private String result;
    @SerializedName( "supported_codes")
    private Map<String, String> supportedCodesMap;
    @SerializedName("base_code")
    private String baseCode;
    @SerializedName("target_code")
    private String targetCode;
    @SerializedName("conversion_result")
    private String conversionResult;


    public String getResult() {return result;}
    public Map<String, String> getSupportedCodesMap() {return supportedCodesMap;}
    public String getBaseCode() {return baseCode;}
    public String getTargetCode() {return targetCode;}
    public String getConversionResult() {return conversionResult;}
}


import com.google.gson.annotations.SerializedName;

public class DadosMoeda {
    @SerializedName("USD")
    private Double dolar;

    @SerializedName("BRL")
    private Double real;

    @SerializedName("JPY")
    private Double jpy;

    @SerializedName("AUD")
    private Double aud;

    // Getters and setters
    public Double getDolar() {
        return dolar;
    }

    public void setDolar(Double dolar) {
        this.dolar = dolar;
    }

    public Double getReal() {
        return real;
    }

    public void setReal(Double real) {
        this.real = real;
    }

    public Double getJpy() {
        return jpy;
    }

    public void setJpy(Double jpy) {
        this.jpy = jpy;
    }

    public Double getAud() {
        return aud;
    }

    public void setAud(Double aud) {
        this.aud = aud;
    }
}

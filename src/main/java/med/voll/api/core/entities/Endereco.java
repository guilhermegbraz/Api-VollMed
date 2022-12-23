package med.voll.api.core.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Endereco {

    private  String logradouro;
    private  String bairro;
    private  String CEP;
    private  String cidade;
    private  String UF;
    private  String numero;
    private String complemento;

    public Endereco(String logradouro, String bairro, String CEP, String cidade, String UF, String numero) {
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.CEP = CEP;
        this.cidade = cidade;
        this.UF = UF;
        this.numero = numero;
    }

    public Endereco(String logradouro, String bairro, String CEP, String cidade, String UF) {
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.CEP = CEP;
        this.cidade = cidade;
        this.UF = UF;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}

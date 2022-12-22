package med.voll.api.dataprovider.entities;


import jakarta.persistence.*;
import med.voll.api.core.entities.Endereco;

@Entity(name = "Endereco")
@Table(name = "endereco")
public class EnderecoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private  String logradouro;
    private  String bairro;
    private  String CEP;
    private  String cidade;
    private  String UF;
    private  String numero;
    private String complemento;

    public EnderecoEntity( String logradouro,
                          String bairro, String CEP, String cidade, String UF, String numero, String complemento) {

        this.logradouro = logradouro;
        this.bairro = bairro;
        this.CEP = CEP;
        this.cidade = cidade;
        this.UF = UF;
        this.numero = numero;
        this.complemento = complemento;
    }

    public EnderecoEntity(Endereco endereco) {

    }

    public EnderecoEntity() {

    }
}



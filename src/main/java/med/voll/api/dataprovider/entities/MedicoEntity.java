package med.voll.api.dataprovider.entities;


import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.core.entities.Endereco;
import med.voll.api.core.entities.medico.Especialidade;

@Entity(name = "Medico")
@Table(schema = "medico")
@Getter
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor
public class MedicoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String email;
    private  String CRM;
    private String telefone;
    @Column(name = "ativo")
    private boolean flagAtivo;

    @Enumerated
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    public MedicoEntity( String nome, String email, String CRM, String telefone,
                        Especialidade especialidade, Endereco endereco, boolean flagAtivo) {
        this.nome = nome;
        this.email = email;
        this.CRM = CRM;
        this.telefone = telefone;
        this.especialidade = especialidade;
        this.endereco = endereco;
        this.flagAtivo = flagAtivo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "MedicoEntity{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", CRM='" + CRM + '\'' +
                ", telefone='" + telefone + '\'' +
                ", especialidade=" + especialidade +
                ", endereco=" + endereco +
                '}';
    }

    public Boolean getFlagAtivo() {
        return this.flagAtivo;
    }
}

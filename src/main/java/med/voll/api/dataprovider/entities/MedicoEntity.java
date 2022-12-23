package med.voll.api.dataprovider.entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.core.entities.Endereco;
import med.voll.api.core.entities.medico.Especialidade;
import med.voll.api.core.entities.medico.Medico;

@Entity(name = "Medico")
@Table(name = "medico")
@Getter
@NoArgsConstructor
public class MedicoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String email;
    private  String CRM;

    @Enumerated
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;




    public MedicoEntity( String nome, String email, String CRM,
                        Especialidade especialidade, Endereco endereco) {

        this.nome = nome;
        this.email = email;
        this.CRM = CRM;
        this.especialidade = especialidade;
        this.endereco = endereco;
    }

    public MedicoEntity(Medico medico) {

        this.nome = medico.getNome();
        this.email = medico.getEmail().getEndereco();
        this.CRM = medico.getCRM();
        this.especialidade = medico.getEspecialidade();
        this.endereco = medico.getEndereco();
    }


}

package med.voll.api.dataprovider.entities;


import jakarta.persistence.*;
import med.voll.api.core.entities.medico.Medico;

@Entity(name = "Medico")
@Table(name = "medico")
public class MedicoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String email;
    private  String CRM;

    @ManyToOne
    private EspecialidadeEntity especialidade;

    @OneToOne
    private EnderecoEntity endereco;

    public MedicoEntity( String nome, String email, String CRM,
                        EspecialidadeEntity especialidade, EnderecoEntity endereco) {

        this.nome = nome;
        this.email = email;
        this.CRM = CRM;
        //this.especialidade = especialidade;
        //this.endereco = endereco;
    }

    public MedicoEntity(Medico medico) {

        this.nome = medico.getNome();
        this.email = medico.getEmail().getEndereco();
        this.CRM = medico.getCRM();
        //this.especialidade = new EspecialidadeEntity(medico.getEspecialidade());
        //this.endereco = new EnderecoEntity(medico.getEndereco());
    }

    public MedicoEntity() {

    }
}

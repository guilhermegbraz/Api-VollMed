package med.voll.api.dataprovider.entities;

import jakarta.persistence.*;
import med.voll.api.core.entities.medico.Especialidade;

@Entity(name = "Especialidade")
@Table(name = "especialidade")
public class EspecialidadeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private Especialidade esp;

    public EspecialidadeEntity(Especialidade esp) {
        this.esp = esp;
    }


    public EspecialidadeEntity() {

    }
}


package med.voll.api.core.entities.medico;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import med.voll.api.core.entities.Email;
import med.voll.api.core.entities.Endereco;

@Getter
@EqualsAndHashCode(of = {"email", "CRM"})
public class Medico {

    private Long id;
    private String nome;
    private  Email email;
    private  String CRM;
    private String telefone;
    private  Especialidade especialidade;
    private Endereco endereco;
    private boolean ativo;


    public Medico(String nome, Email email, String CRM, String telefone, Especialidade especialidade, Endereco endereco) {
        this.nome = nome;
        this.email = email;
        this.CRM = CRM;
        this.telefone = telefone;
        this.especialidade = especialidade;
        this.endereco = endereco;
        this.ativo = true;
    }

    public Medico(Long id, String nome, Email email, String CRM, String telefone, Especialidade especialidade, Endereco endereco, Boolean ativo) {
        this.nome = nome;
        this.email = email;
        this.CRM = CRM;
        this.telefone = telefone;
        this.especialidade = especialidade;
        this.endereco = endereco;
        this.id = id;
        this.ativo = ativo;
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

    public boolean getAtivo() {
        return this.ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}

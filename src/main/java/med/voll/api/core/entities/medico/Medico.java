package med.voll.api.core.entities.medico;


import lombok.Getter;
import med.voll.api.core.entities.Email;
import med.voll.api.core.entities.Endereco;

@Getter
public class Medico {

    private String nome;
    private Email email;
    private  String CRM;
    private String telefone;
    private Especialidade especialidade;
    private Endereco endereco;


    public Medico(String nome, Email email, String CRM, String telefone, Especialidade especialidade, Endereco endereco) {
        this.nome = nome;
        this.email = email;
        this.CRM = CRM;
        this.telefone = telefone;
        this.especialidade = especialidade;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    protected void setNome(String nome) {
        this.nome = nome;
    }

    public Email getEmail() {
        return email;
    }

    protected void setEmail(Email email) {
        this.email = email;
    }

    public String getCRM() {
        return CRM;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    protected void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    protected void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

}

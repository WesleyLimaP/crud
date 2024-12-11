package crud.projeto.master.dto;
import crud.projeto.master.entities.Client;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public class ClientDto {

    private Long id;
    @NotBlank(message = "nome requerido")
    private String name;
    @NotBlank(message = "cpf vazio")
    @Size(min = 14, max = 14, message = "cpf invalido")
    @NotBlank(message = "campo requqerido")
    private String cpf;
    @Positive
    private Double income;
    @Past(message = "a data nao pode ser futura")
    private LocalDate birthDate;
    private Integer children;

    public ClientDto() {
    }

    public ClientDto(Client client) {
        this.id = client.getId();
        this.name = client.getName();
        this.cpf = client.getCpf();
        this.income = client.getIncome();
        this.birthDate = client.getBirthDate();
        this.children = client.getChildren();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Long getId() {
        return id;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getChildren() {
        return children;
    }

    public void setChildren(Integer children) {
        this.children = children;
    }
}

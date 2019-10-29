package com.multitenancy.example.multitenancy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.eclipse.persistence.annotations.Multitenant;
import org.eclipse.persistence.annotations.TenantDiscriminatorColumn;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.eclipse.persistence.annotations.MultitenantType.VPD;

@Entity
@Table(name = "emoloyee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "empresas-1")
    @Size(min=2, max=200, message = "max-length-200")
    @Column(name = "nome_embarcador")
    private String nomeEmbarcador;

    @CNPJ(message = "empresas-12")
    @NotBlank(message = "empresas-3")
    @Size(min=2, max=18, message = "max-length-18")
    private String cnpj;

    @NotBlank(message = "empresas-4")
    @Size(min=2, max=200, message = "max-length-200")
    private String endereco;

    @NotBlank(message = "empresas-5")
    @Size(min=2, max=25, message = "max-length-25")
    private String telefone;

    @NotBlank(message = "empresas-6")
    @Size(min=2, max=100, message = "max-length-100")
    private String bairro;

    @NotBlank(message = "empresas-7")
    @Size(min=2, max=100, message = "max-length-100")
    private String cidade;

    @NotBlank(message = "empresas-8")
    @Size(min=2, max=100, message = "max-length-10")
    private String uf;

    @NotBlank(message = "empresas-9")
    @Size(min=2, max=30, message = "max-length-30")
    private String cep;

    @NotBlank(message = "empresas-10")
    @Size(min=2, max=200, message = "max-length-200")
    @Email(message = "max-length-200")
    private String email;

    @Size(min=2, max=100, message = "max-length-100")
    private String complemento;

    @Size(min=2, max=7, message = "max-length-30")
    private BigDecimal latitude;

    @Size(min=2, max=7, message = "max-length-30")
    private BigDecimal longitude;

    @NotNull(message = "empresas-11")
    private Boolean status;

    @NotNull
    @ManyToMany(mappedBy = "embarcadores")
    private Set<Customer> customers = new HashSet<>();


    public Employee() {
    }

    public Employee(Long id, String nomeEmbarcador, String cnpj, String endereco, String telefone, String bairro, String cidade, String uf, String cep, String email, String complemento, BigDecimal latitude, BigDecimal longitude, Boolean status, Set<Customer> customers) {
        this.id = id;
        this.nomeEmbarcador = nomeEmbarcador;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.telefone = telefone;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
        this.email = email;
        this.complemento = complemento;
        this.latitude = latitude;
        this.longitude = longitude;
        this.status = status;
        this.customers = customers;
    }

    @PrePersist @PreUpdate
    private void prePersistPreUpdate() {

        if (this.cnpj != null) {
            this.cnpj = removerFormatacao(cnpj);
        }
        if (this.telefone != null) {
            this.telefone = removerFormatacao(telefone);
        }
        if (this.cep != null) {
            this.cep = removerFormatacao(cep);
        }
    }


    @JsonIgnore
    public boolean isNew() {
        return getId() == null;
    }

    public String removerFormatacao(String campo) {
        return campo.replaceAll("[^0-9]", "");
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeEmbarcador() {
        return nomeEmbarcador;
    }

    public void setNomeEmbarcador(String nomeEmbarcador) {
        this.nomeEmbarcador = nomeEmbarcador;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }
}

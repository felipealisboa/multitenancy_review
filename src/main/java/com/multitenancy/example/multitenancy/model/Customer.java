package com.multitenancy.example.multitenancy.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.eclipse.persistence.annotations.Multitenant;
import org.eclipse.persistence.annotations.TenantDiscriminatorColumn;

import static org.eclipse.persistence.annotations.MultitenantType.VPD;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "customer")
@Multitenant(VPD)
@TenantDiscriminatorColumn(name = "TENANT", contextProperty = "tenant.id")
@Cacheable(false)
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min=2, max=200, message = "max-length-200")
    private String nome;

    @NotBlank
    @Size(min=3, max = 50)
    private String username;

    @JsonIgnore
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String senha;

    @NotBlank(message = "usuarios-3")
    @Size(min=2, max=200, message = "max-length-200")
    @Email(message = "max-length-200")
    private String email;

    private String tenant;

    public Customer() {
    }

    public Customer(Long id, String nome, String username, String senha,  String email, String tenant) {
        this.id = id;
        this.nome = nome;
        this.username = username;
        this.senha = senha;
        this.email = email;
        this.tenant = tenant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTenant() {
        return tenant;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }
}

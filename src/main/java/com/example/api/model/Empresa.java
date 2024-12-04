package com.example.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Blob;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "empresas")
public class Empresa {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "direccion", nullable = false, length = 200)
    private String direccion;

    @Column(name = "horario", nullable = false)
    private String horario;

    @Column(name = "puntuaje", nullable = false)
    private Integer puntuaje;

    @JsonIgnoreProperties("idEmpresa")
    @OneToMany(mappedBy = "idEmpresa", fetch = FetchType.EAGER)
    private List<Admin> admins;

    @JsonIgnoreProperties("idEmpresa")
    @OneToMany(mappedBy = "idEmpresa", fetch = FetchType.EAGER)
    private List<Producto> productos;

}
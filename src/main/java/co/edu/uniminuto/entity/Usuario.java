package co.edu.uniminuto.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;

    @Column(nullable = false, unique = true, length = 100)
    private String username;

    @Column(nullable = false, unique = true, length = 150)
    private String email;

    @Column(nullable = false, length = 255)
    private String password;

    @ManyToOne(optional = false)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('activo','inactivo') default 'activo'")
    private Status status = Status.activo;

    public enum Status { activo, inactivo }

    // getters/setters
    public Integer getId(){ return id; }
    public void setId(Integer id){ this.id = id; }
    public String getUsername(){ return username; }
    public void setUsername(String username){ this.username = username; }
    public String getEmail(){ return email; }
    public void setEmail(String email){ this.email = email; }
    public String getPassword(){ return password; }
    public void setPassword(String password){ this.password = password; }
    public Role getRole(){ return role; }
    public void setRole(Role role){ this.role = role; }
    public Status getStatus(){ return status; }
    public void setStatus(Status status){ this.status = status; }
}

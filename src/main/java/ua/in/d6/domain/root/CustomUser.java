package ua.in.d6.domain.root;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

import static ua.in.d6.domain.root.UserRole.USER;

@Entity
@Getter
@Setter
@Table(name = "\"USER\"")
@XmlType(namespace = "http://www.d6.in.ua/schema", name="user")
public class CustomUser {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_RCD", nullable = false, updatable = false)
    @XmlAttribute
    private long id;

    @Column(name = "User_Nm")
    @XmlAttribute
    private String login;

    @Column(name = "User_FIO")
    @XmlAttribute
    private String name;

    @Column(name = "User_Phn")
    @XmlAttribute
    private String phone;

    @OneToOne(cascade = CascadeType.MERGE)
    @PrimaryKeyJoinColumn
    private UserPassword userPassword;

    public CustomUser() {}

    public UserRole getRole() {
        return USER;
    }
}

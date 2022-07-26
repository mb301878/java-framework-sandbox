package jpa.relation;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@ToString
@Table(name = "users")
public class User {

    @Id
    @Column(name = "user_id", nullable = false)
    private Integer userId;
    @ManyToOne
    @JoinColumn(name="bar_id", nullable=false)
    private Bar barId;

}

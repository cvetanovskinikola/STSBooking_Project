package com.getaway.weekend.app.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users",uniqueConstraints = @UniqueConstraint(columnNames = {"email","card_number"}))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(nullable = false)
	private Integer age;
	@Column(nullable = false)
	private Long card_number;
	private Double sufficient_funds;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String password;
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(name = "user_role_id",joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name="role_id",referencedColumnName = "id"))
	private Set<Role> roles;
	@JsonIgnore
    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = CascadeType.ALL)
    @JsonManagedReference	
	private Set<Reservation> reservations = new HashSet<>();
	
	public User(String firstName, String lastName, Integer age,Long card_number,Double sufficient_funds, String email, String password, Set<Role> roles) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.card_number=card_number;
		this.sufficient_funds=sufficient_funds;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}
	public void addReservation(Reservation r) {
    	this.reservations.add(r);
    	r.setUser(this);
    }
   
    public void removeReservation(Reservation r) {
    	r.setUser(null);
    	reservations.remove(r);
    }

	@Override
	public int hashCode() {
		return Objects.hash(age, card_number, email, firstName, id, lastName, password, reservations, roles,
				sufficient_funds);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(age, other.age) && Objects.equals(card_number, other.card_number)
				&& Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(id, other.id) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(password, other.password) && Objects.equals(reservations, other.reservations)
				&& Objects.equals(roles, other.roles) && Objects.equals(sufficient_funds, other.sufficient_funds);
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", card_number=" + card_number + ", sufficient_funds=" + sufficient_funds + ", email=" + email
				+ ", password=" + password + ", roles=" + roles + ", reservations=" + reservations + "]";
	}
	
	

	
	
	
	
}

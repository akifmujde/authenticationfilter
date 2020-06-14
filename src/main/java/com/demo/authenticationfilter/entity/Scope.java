package com.demo.authenticationfilter.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "scope")
@NoArgsConstructor
@Getter
@Setter
public class Scope {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;

   @Column
   private String scopeName;

   @OneToMany(mappedBy = "scope")
   private Set<RoleManagement> roleManagements;

   public static Scope of(String scopeName) {

       Scope scope = new Scope();

       scope.setScopeName(scopeName);

       return scope;
   }
}

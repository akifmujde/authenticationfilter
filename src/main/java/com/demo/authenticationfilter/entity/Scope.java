package com.demo.authenticationfilter.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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

   public static Scope of(String scopeName) {

       Scope scope = new Scope();

       scope.setScopeName(scopeName);

       return scope;
   }
}

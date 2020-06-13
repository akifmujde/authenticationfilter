package com.demo.authenticationfilter.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "database_process")
@NoArgsConstructor
@Getter
@Setter
public class DatabaseProcess {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String processName;

    public static DatabaseProcess of(String processName) {

        DatabaseProcess databaseProcess = new DatabaseProcess();

        databaseProcess.setProcessName(processName);

        return databaseProcess;
    }
}

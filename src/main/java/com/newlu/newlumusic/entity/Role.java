package com.newlu.newlumusic.entity;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Role extends AbstractEntity{

    private String name;

    private String title;
}

package com.alterra.MiniProjectRyanHernawan.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "recipes_ingredients")
public class RecipesIngredients {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "recipes_id", referencedColumnName = "id")
    Recipes recipes;

    @ManyToOne
    @JoinColumn(name = "ingredients_id", referencedColumnName = "id")
    Ingredients ingredients;

    private Long qty_gram;

    @CreatedDate
    private Date created_at;
    @LastModifiedDate
    private Date updated_at;


}

package com.example.webtruyen.Core.Domain.Entity.Truyen;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "Chapter")
@NoArgsConstructor
public class Chapter implements Serializable {
    public String tenChuong;
    @Id
    private int chuongSo;
    @Column(columnDefinition = "LONGTEXT")
    private String noiDungChuong;
    @ManyToOne
    @JoinColumn(name = "truyen_id")
    @JsonBackReference
    private Truyen truyen;
}

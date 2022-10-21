package com.JavaSpring.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "Student")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class Rooms {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
		private String roomnum;
		private String roomtype;
		private String price;
	
	public Rooms(Long id, 
        String roomnum, 
        String roomtype, 
        String price
    ){
    this.id = id;
	this.roomnum = roomnum;
	this.roomtype = roomtype;
	this.price = price;
	}

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    public void setRoomnum(String roomnum){
        this.roomnum = roomnum;
    }
    public String getRoomnum(){
        return this.roomnum;
    }
    public void setRoomtype(String roomtype){
        this.roomtype = roomtype;
    }
    public String getRoomtype(){
        return this.roomtype;
    }
    public void setPrice(String price){
        this.price = price;
    }
    public String getPrice(){
        return this.price;
    }

    public String toString(){
        return "[id = " + this.id +
                "roomnum = " + this.roomnum +
                "roomtype = " + this.roomtype +
                "price = " + this.price +
            "]";
    }

}
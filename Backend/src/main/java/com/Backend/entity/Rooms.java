package com.Backend.entity;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "rooms")
public class Rooms {

	@Id
	private String id;
    private String roomnum;
    private String roomtype;
    private String price;

	public Rooms(String id, 
        String roomnum, 
        String roomtype, 
        String price
    ){
    this.id = id;
	this.roomnum = roomnum;
	this.roomtype = roomtype;
	this.price = price;
	}

    public String getId() {
		return id;
	}

	public void setId(String id) {
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

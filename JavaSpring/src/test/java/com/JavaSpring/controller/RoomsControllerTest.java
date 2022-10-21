package com.JavaSpring.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import com.JavaSpring.controller.RoomsController;
import com.JavaSpring.entity.Rooms;
import com.JavaSpring.service.RoomsService;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
public class RoomsControllerTest {
	@Mock
	private RoomsService service;

	@InjectMocks
	private RoomsController controller;
	
	private List<Rooms> prepareRoomsRecords(){
		List<Rooms> rooms = new ArrayList<Rooms>();
		Rooms rooms1 = new Rooms(5L, "FonqP","BTBsN","I9v5O");
		Rooms rooms2 = new Rooms(4L, "97dAA","nZd5P","KZnU3");
		rooms.add(rooms1);
		rooms.add(rooms2);
		return rooms;
	}
	
	@Test
	public void testFetchAllPass() {
		Mockito
        .when(controller.fetchAll()).thenReturn(prepareRoomsRecords());
		List<Rooms> rooms = prepareRoomsRecords();
		List<Rooms> roomsFromController =  controller.fetchAll();
		for(int i=0; i < rooms.size();i++) { 
			Assertions.assertEquals(rooms.get(i).getId(), roomsFromController.get(i).getId());
            Assertions.assertEquals(rooms.get(i).getRoomnum(), roomsFromController.get(i).getRoomnum());
            Assertions.assertEquals(rooms.get(i).getRoomtype(), roomsFromController.get(i).getRoomtype());
            Assertions.assertEquals(rooms.get(i).getPrice(), roomsFromController.get(i).getPrice());
		}
		
	}

	@Test
	public void testFetchAllFailure() {
		Mockito
        .when(controller.fetchAll()).thenReturn(prepareRoomsRecords());
		List<Rooms> rooms = null; //Intentionally made null to fail the test.
		List<Rooms> roomsFromController =  controller.fetchAll();
		Assertions.assertNotEquals(rooms, roomsFromController);
	}
	
	
	 @Test public void fetchByIdPass() { 
		 Mockito
	        .when(controller.fetchById(5L)).thenReturn(prepareRoomsRecords().get(0));
			Rooms roomsById = prepareRoomsRecords().get(0);
			Rooms roomsByIdFromController = controller.fetchById(5L);
			
			Assertions.assertEquals(roomsById.getId(), roomsByIdFromController.getId());
        Assertions.assertEquals(roomsById.getRoomnum(), roomsByIdFromController.getRoomnum());
        Assertions.assertEquals(roomsById.getRoomtype(), roomsByIdFromController.getRoomtype());
        Assertions.assertEquals(roomsById.getPrice(), roomsByIdFromController.getPrice());
	 }

	 @Test public void fetchByIdFailure() { 
		 Mockito
	        .when(controller.fetchById(5L)).thenReturn(prepareRoomsRecords().get(0));
			Rooms roomsById = prepareRoomsRecords().get(1);
			Rooms roomsByIdFromController = controller.fetchById(5L);
			
			Assertions.assertNotEquals(roomsById.getId(), roomsByIdFromController.getId());
        Assertions.assertNotEquals(roomsById.getRoomnum(), roomsByIdFromController.getRoomnum());
        Assertions.assertNotEquals(roomsById.getRoomtype(), roomsByIdFromController.getRoomtype());
        Assertions.assertNotEquals(roomsById.getPrice(), roomsByIdFromController.getPrice());
	 }
	 
	 @Test
	 public void deletePass() { 
		 controller.delete(5L);
		 Assertions.assertTrue(true); // This line will be executed only if there is no error in calling the controller for delete as there is no return value.
	 }

	@Test
	public void createPass() {
		Rooms roomsToBeCreated 			= prepareRoomsRecords().get(0);
		Rooms roomsReturned = prepareRoomsRecords().get(0);
		roomsReturned.setId(7L); //Changed the ID.
		
		Mockito
			.when(controller.create(roomsToBeCreated)).thenReturn(roomsReturned);
		
        Rooms roomsFromController  = controller.create(roomsToBeCreated);
		Assertions.assertNotEquals(roomsToBeCreated.getId(), roomsFromController.getId()); //Since Id of created one is mocked as changed from within serviceid, it cannot be equal.
        Assertions.assertEquals(roomsToBeCreated.getRoomnum(), roomsFromController.getRoomnum());
        Assertions.assertEquals(roomsToBeCreated.getRoomtype(), roomsFromController.getRoomtype());
        Assertions.assertEquals(roomsToBeCreated.getPrice(), roomsFromController.getPrice());
}
	
	@Test
	public void createFailure() {
		Rooms roomsToBeCreated 			= prepareRoomsRecords().get(0);
		Rooms roomsReturned 			= null; // Intentionally left to null to fail the case. 
				
		Mockito
			.when(controller.create(roomsToBeCreated)).thenReturn(studentReturned);
		
        Rooms roomsFromController  = controller.create(roomsToBeCreated);
		Assertions.assertNull(roomsFromController);
	}
	
	/*
	 * @Test public void update() { ResponseEntity<Object> responseObject = null;
	 * 
	 * Mockito.when(controller.update(studentToBeUpdated,
	 * "")).thenReturn(responseObject); }
	 */	
}
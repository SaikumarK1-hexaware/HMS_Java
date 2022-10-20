package com.Backend.controller;

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

import com.Backend.controller.RoomsController;
import com.Backend.entity.Rooms;
import com.Backend.service.RoomsService;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
public class RoomsControllerTest {
	@Mock
	private RoomsService service;

	@InjectMocks
	private RoomsController controller;
	
	private List<Rooms> prepareRoomsRecords(){
		List<Rooms> roomsList = new ArrayList<Rooms>();
		Rooms rooms1 = new Rooms("62d6b821618d9f7c7024ccc5", "XRgfZ","HgWoP","NVUxA");
		Rooms rooms2 = new Rooms("62d6b821618d9f7c7024ccc4", "CgLMg","ACbP0","lKUFa");
		roomsList.add(rooms1);
		roomsList.add(rooms2);
		return roomsList;
	}
	
	@Test
	public void testFetchAllPass() {
		Mockito
        .when(controller.fetchAll()).thenReturn(prepareRoomsRecords());
		List<Rooms> roomsList = prepareRoomsRecords();
		List<Rooms> roomsListFromController =  controller.fetchAll();
		for(int i=0; i<roomsList.size();i++) {
			Assertions.assertEquals(roomsList.get(i).getId(), roomsListFromController.get(i).getId());
            Assertions.assertEquals(roomsList.get(i).getRoomnum(), roomsListFromController.get(i).getRoomnum());
            Assertions.assertEquals(roomsList.get(i).getRoomtype(), roomsListFromController.get(i).getRoomtype());
            Assertions.assertEquals(roomsList.get(i).getPrice(), roomsListFromController.get(i).getPrice());
		}
		
	}

	@Test
	public void testFetchAllFailure() {
		Mockito
        .when(controller.fetchAll()).thenReturn(prepareRoomsRecords());
		List<Rooms> roomsList = null; //Intentionally made null to fail the test.
		List<Rooms> roomsListFromController =  controller.fetchAll();
		Assertions.assertNotEquals(roomsList, roomsListFromController);
	}
	
	
	 @Test public void fetchByIdPass() { 
		 Mockito
	        .when(controller.fetchById("62d6b821618d9f7c7024ccc5"))
            .thenReturn(prepareRoomsRecords().get(0));

        Rooms roomsById = prepareRoomsRecords().get(0);
        Rooms roomsByIdFromController = controller.fetchById("62d6b821618d9f7c7024ccc5");
        
        Assertions.assertEquals(roomsById.getId(), roomsByIdFromController.getId());
        Assertions.assertEquals(roomsById.getRoomnum(), roomsByIdFromController.getRoomnum());
        Assertions.assertEquals(roomsById.getRoomtype(), roomsByIdFromController.getRoomtype());
        Assertions.assertEquals(roomsById.getPrice(), roomsByIdFromController.getPrice());
		 
	 }

	 @Test public void fetchByIdFailure() { 
		Mockito
	        .when(controller.fetchById("62d6b821618d9f7c7024ccc5"))
            .thenReturn(prepareRoomsRecords().get(0));

        Rooms roomsById = prepareRoomsRecords().get(1);
        Rooms roomsByIdFromController = controller.fetchById("62d6b821618d9f7c7024ccc5");
        
        Assertions.assertNotEquals(roomsById.getId(), roomsByIdFromController.getId());
        Assertions.assertNotEquals(roomsById.getRoomnum(), roomsByIdFromController.getRoomnum());
        Assertions.assertNotEquals(roomsById.getRoomtype(), roomsByIdFromController.getRoomtype());
        Assertions.assertNotEquals(roomsById.getPrice(), roomsByIdFromController.getPrice());
		 
	 }
	 
	 @Test
	 public void deletePass() { 
		 controller.delete("62d6b821618d9f7c7024ccc5");
		 Assertions.assertTrue(true); // This line will be executed only if there is no error in calling the controller for delete as there is no return value.
	 }

	@Test
	public void createPass() {
		Rooms roomsToBeCreated 			= prepareRoomsRecords().get(0);
		Rooms roomsReturned = prepareRoomsRecords().get(0);
		roomsReturned.setId("62d6b821618d9f7c7024ccc9"); //Changed the ID.
		
		Mockito
			.when(controller.create(roomsToBeCreated))
            .thenReturn(roomsReturned);
		
		Rooms roomsFromController  = controller.create(roomsToBeCreated);
		Assertions.assertNotEquals(roomsToBeCreated.getId(), roomsFromController.getId()); //Since Id of created one is mocked as changed from within serviceid, it cannot be equal.
        Assertions.assertEquals(roomsToBeCreated.getRoomnum(), roomsFromController.getRoomnum());
        Assertions.assertEquals(roomsToBeCreated.getRoomtype(), roomsFromController.getRoomtype());
        Assertions.assertEquals(roomsToBeCreated.getPrice(), roomsFromController.getPrice());
	}
	
	@Test
	public void createFailure() {
		Rooms roomsToBeCreated = prepareRoomsRecords().get(0);
		Rooms roomsReturned = null; // Intentionally left to null to fail the case. 
				
		Mockito
			.when(controller.create(roomsToBeCreated))
            .thenReturn(roomsReturned);
		
		Rooms roomsFromController  = controller.create(roomsToBeCreated);
		Assertions.assertNull(roomsFromController);
	}
}

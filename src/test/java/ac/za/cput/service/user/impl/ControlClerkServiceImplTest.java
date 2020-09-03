package ac.za.cput.service.user.impl;
/*
 *@author @amjekula
 * Description: Test Cases for Control Clerk Service Implementation
 * Date: 05 September 2020
 */

import ac.za.cput.entity.user.ControlClerk;
import ac.za.cput.factory.user.ControlClerkFactory;
import ac.za.cput.repository.user.ControlClerkRepository;
import ac.za.cput.repository.user.impl.ControlClerkRepositoryImpl;
import ac.za.cput.service.user.ControlClerkService;
import javafx.scene.effect.SepiaTone;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ControlClerkServiceImplTest {
    private static ControlClerkService clerkService = ControlClerkServiceImpl.getService();
    private static ControlClerk clerkBuilder = ControlClerkFactory.createControlClerk("Mjekuula", "Athi",
            "079 2565 854", "athi@gmail.com");

    @Test
    public void d_getAll() {
        Set<ControlClerk> clerkSet = clerkService.getAll();
        assertEquals(1, clerkSet.size());
        System.out.println("All Users: " + clerkService.getAll() + "\n");
    }

    @Test
    public void a_create() {
        ControlClerk createClerk = clerkService.create(clerkBuilder);
        assertEquals(createClerk.getClerkId(), createClerk.getClerkId());
        System.out.println("Create: " + createClerk + "\n");
    }

    @Test
    public void b_read() {
        ControlClerk readClerk = clerkService.read(clerkBuilder.getClerkId());
        assertNotNull(readClerk);
        System.out.println("Read: " + readClerk + "\n");
    }

    @Test
    public void c_update() {
        ControlClerk updateClerk = new ControlClerk.ControlClerkBuilder().copy(clerkBuilder).setSurname("Mjekula").build();
        updateClerk = clerkService.update(updateClerk);
        assertNotEquals(clerkBuilder.getSurname(), updateClerk.getSurname());
        System.out.println("Update: " + updateClerk + "\n");
    }

    @Test
    public void e_delete() {
        clerkService.delete(clerkBuilder.getClerkId());
        assertEquals(clerkService.getAll().size(), 0);
        System.out.println("Check if Object is deleted: " + clerkService.getAll());
    }
}
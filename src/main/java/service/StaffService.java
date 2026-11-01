package service;

import model.Chef;
import model.Server;
import model.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.StaffInMemoryRepository;

import java.util.List;

@Service
public class StaffService {
    private final StaffInMemoryRepository staffRepository;

    @Autowired
    StaffService(StaffInMemoryRepository staffRepo) {
        this.staffRepository = staffRepo;
    }

    public Staff addNewStaff(Staff s) {
        Staff staff = existingStaff(s.getId());

        return staffRepository.save(staff);
    }



    public List<Staff> getAll() {
        return staffRepository.findAll();
    }


    public Staff getById(String id) {
        return staffRepository.findById(id);
    }


    public Boolean removeStaff(String id) {
        Staff staff = existingStaff(id);
        return staffRepository.delete(staff);
    }

    public Server changeDesignation(String id, String newDesignation) {
        Staff staff = staffRepository.findById(id);

        if (!(staff instanceof Server server)) {
            throw new IllegalArgumentException("Staff " + id + " is not a server");
        }


        server.setDesignation(newDesignation);
        staffRepository.save(server);
        return server;
    }


    public Chef changeSpecialization(String id, String newSpecialization) {
        Staff staff = staffRepository.findById(id);

        if (!(staff instanceof Chef chef)) {
            throw new IllegalArgumentException("Staff " + id + " is not a chef");
        }

        chef.setSpecialization(newSpecialization);
        staffRepository.save(chef);
        return chef;
    }


    public Boolean isBusy(String id) {
        Staff staff = existingStaff(id);
        return (staff.getStatus()).equalsIgnoreCase("Occupied");
    }

    public  Staff changeStatus(String id, String status){
        Staff staff = existingStaff(id);

        if (status == null
                || !(status.equalsIgnoreCase("Occupied") || status.equalsIgnoreCase("Free"))) {
            throw new IllegalArgumentException("Status must be Occupied or Free");
        }

        staff.setStatus(status);
        return staffRepository.save(staff);
    }


    private Staff existingStaff(String id) {
        Staff staff = staffRepository.findById(id);
        if (staff == null) {
            throw new IllegalArgumentException("Id not valid!");
        }
        return staff;
    }

}



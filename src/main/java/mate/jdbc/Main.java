package mate.jdbc;

import java.util.ArrayList;
import java.util.List;
import mate.jdbc.lib.Injector;
import mate.jdbc.model.Car;
import mate.jdbc.model.Driver;
import mate.jdbc.model.Manufacturer;
import mate.jdbc.service.CarService;
import mate.jdbc.service.DriverService;
import mate.jdbc.service.ManufacturerService;

public class Main {
    private static Injector injector = Injector.getInstance("mate.jdbc");

    public static void main(String[] args) {
        // test your code here
        Driver driver1 = new Driver();
        driver1.setName("1");
        driver1.setLicenseNumber("11");

        Driver driver2 = new Driver();
        driver2.setName("2");
        driver2.setLicenseNumber("22");

        Driver driver3 = new Driver();
        driver3.setName("3");
        driver3.setLicenseNumber("33");

        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setCountry("Ukraine");
        manufacturer.setName("AUDI");

        List<Driver> drivers = new ArrayList<>();

        DriverService driverService = (DriverService) injector.getInstance(DriverService.class);

        drivers.add(driverService.get(29L));

        ManufacturerService manufacturerService
                = (ManufacturerService) injector.getInstance(ManufacturerService.class);
        //manufacturerService.create(manufacturer);

        Car car = new Car();
        car.setId(2L);
        car.setModel("R10");
        car.setManufacturer(manufacturerService.get(15L));
        car.setDrivers(drivers);

        CarService carService = (CarService) injector.getInstance(CarService.class);

        carService.addDriverToCar(driverService.get(30L), car);
        carService.addDriverToCar(driverService.get(31L), car);
        System.out.println(carService.get(2L));
        carService.removeDriverFromCar(driverService.get(31L), car);

        System.out.println(carService.get(2L));
    }
}
